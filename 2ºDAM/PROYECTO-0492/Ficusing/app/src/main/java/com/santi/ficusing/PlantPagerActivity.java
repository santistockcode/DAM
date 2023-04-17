package com.santi.ficusing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.UUID;

//Class for creating and managing the ViewPager
public class PlantPagerActivity extends AppCompatActivity
        implements PlantFragment.Callbacks {

    private static final String EXTRA_PLANT_ID = "plant_id";
    private ViewPager2 mViewPager;
    private List<Plant> mPlants;
    private FloatingActionButton fab_delete_plant;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_pager);
        UUID plantId = (UUID) getIntent().getSerializableExtra(EXTRA_PLANT_ID);
        mPlants = PlantLab.get(this).getPlants();
        //Creamos el objeto mViewPager2 que mostrara las plantas
        mViewPager = (ViewPager2) findViewById(R.id.activity_plant_pager_view_pager);

        //Seteamos el adaptador necesario para leer los objetos Plant de la lista
        mViewPager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                Plant plant = mPlants.get(position);
                return PlantFragment.newInstance(plant.getId());
            }

            @Override
            public int getItemCount() {
                return mPlants.size();
            }

        });
        for (int i = 0; i < mPlants.size(); i++) {
            if (mPlants.get(i).getId().equals(plantId)) {
                mViewPager.setCurrentItem(i);
            }
        }
    }

    //Intent to call this activity with correct plant selected
    public static Intent newIntent(Context packageContext, UUID plantId) {
        Intent intent = new Intent(packageContext, PlantPagerActivity.class);
        intent.putExtra(EXTRA_PLANT_ID, plantId);
        return intent;
    }

    //For Callbacks comunication
    @Override
    public void onPlantUpdated(Plant plant) {
    }

}
