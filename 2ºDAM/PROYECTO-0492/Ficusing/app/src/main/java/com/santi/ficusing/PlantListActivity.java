package com.santi.ficusing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

//Class to host PlantListFragment
public class PlantListActivity extends SingleFragmentActivity
        implements PlantListFragment.Callbacks, PlantFragment.Callbacks {

    @Override
    protected Fragment createFragment() {
        return new PlantListFragment();
    }

    //Override getLayoutResId() for using alias in case of tablet view via refs.xml
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_masterdetail;
    }

    //Intent for returning from notification
    public static Intent newIntent(Context context) {
        return new Intent(context, PlantListActivity.class);
    }

    //PlantListFragment.Callbacks interface implementation
    @Override
    public void onPlantSelected(Plant plant) {
        if (findViewById(R.id.detail_fragment_container) == null) {
            Intent intent = PlantPagerActivity.newIntent(this, plant.getId());
            startActivity(intent);
        } else {
            Fragment newDetail = PlantFragment.newInstance(plant.getId());
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container, newDetail)
                    .commit();
        }
    }

    //PlantFragment.Callbacks interface implementation
    @Override
    public void onPlantUpdated(Plant plant) {
        PlantListFragment listFragment = (PlantListFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_container);
        listFragment.updateUI();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        int resid = R.drawable.ficusing_logo;
        getSupportActionBar().setLogo(getApplicationContext().getResources().getDrawable(resid));
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}

