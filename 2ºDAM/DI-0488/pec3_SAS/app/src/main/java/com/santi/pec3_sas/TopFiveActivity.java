package com.santi.pec3_sas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

public class TopFiveActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return new TopFiveFragment().newInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.outline_travel_explore_20);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(R.string.top_five_title);
        // showing the back button in action bar
        //actionBar.setDisplayHomeAsUpEnabled(true);


    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.action_top5:
                Intent intent = new Intent(getApplicationContext(), TopFiveFragment.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main, menu);
        MenuItem subtitleItem = menu.findItem(R.id.action_top5);
        subtitleItem.setVisible(false);

        return true;
    }
}
