package com.santi.ficusing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

//Class to display list of plants in CardViews
public class PlantListFragment extends Fragment {

    //Tag for log when back from notification
    private static final String TAG = "BackFromNotification";
    //Tag for log when setting alarm
    private static final String HEYREPEATER = "LaunchingAlarmRepeater";


    private RecyclerView mPlantRecyclerView;
    private PlantAdapter mAdapter;

    //Text visible only when there are no plants
    private TextView mNoPlants;
    //object animation only visible when there are no plants
    LottieAnimationView animationView;

    //Constant for time petition
    private static final int REQUEST_TIME = 1;
    //Constant for TimePickerFragment to show
    private static final String DIALOG_TIME = "DialogTime";

    //Callbacks
    private Callbacks mCallbacks;

    public static Intent newIntent(Context context) {
        return new Intent(context, PlantListFragment.class);
    }

    //Definimos la interface requerida para las activity que albergan al fragment
    public interface Callbacks {
        //Metodo que nos va a permitir comunicar la planta seleccionada
        void onPlantSelected(Plant plant);
    }

    //Sobreescribimos los metodos del ciclo de vida de los fragment para la interface
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mCallbacks = (Callbacks) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        Intent mIntent = getActivity().getIntent();
        int valor = mIntent.getIntExtra("extra_key", 3);
        //if intent received does have an extra, it triggers the notification
        if (valor != 3) {
            Log.i(TAG, "Notificacion received on Create code" + valor);
        }
    }

    private class PlantHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        private TextView mNameTextView;
        private TextView mDayFrequencyCount;
        private ImageButton mIconImageButton;
        private LottieAnimationView mAnimationViewIcon;
        private ImageView mPhotoCardView;

        private Plant mPlant;
        private CardView mCardView;
        private File mPhotoCardFile;

        public PlantHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.card_view, parent, false));
            mNameTextView = (TextView) itemView.findViewById(R.id.plant_name);
            mDayFrequencyCount = (TextView) itemView.findViewById(R.id.day_frequency_count);
            mIconImageButton = (ImageButton) itemView.findViewById(R.id.exposed_plant_icon);
            mAnimationViewIcon = (LottieAnimationView) itemView.findViewById(R.id.exposed_plant_animation);
            mCardView = itemView.findViewById(R.id.card_plant_view);
            mPhotoCardView = (ImageView) itemView.findViewById(R.id.plant_image_card);
            itemView.setOnClickListener(this);

        }

        public void bind(Plant plant) {
            mPlant = plant;
            mNameTextView.setText(mPlant.getName());
            mDayFrequencyCount.setText(String.valueOf(mPlant.getFrequency()));
            mPhotoCardFile = PlantLab.get(getActivity()).getPhotoFile(mPlant);
            if (mPhotoCardFile != null) {
                Bitmap bitmap = PictureUtils.getScaledBitmap(
                        mPhotoCardFile.getPath(), getActivity());
                mPhotoCardView.setImageBitmap(bitmap);
            }
            //display icon according to plant state
            if (mPlant.getState() == -1) {
                mIconImageButton.setImageResource(R.drawable.yellow_icon);
                mIconImageButton.setVisibility(View.VISIBLE);
                mAnimationViewIcon.setVisibility(View.GONE);
            } else if (mPlant.getState() == 0) {
                mIconImageButton.setImageResource(R.drawable.red_icon);
                mAnimationViewIcon.setVisibility(View.VISIBLE);
                mIconImageButton.setVisibility(View.VISIBLE);
            } else if (mPlant.getState() >= 1) {
                mIconImageButton.setVisibility(View.VISIBLE);
                mAnimationViewIcon.setVisibility(View.GONE);
                mIconImageButton.setImageResource(R.drawable.green_icon);
            }
            //case PLANT MARKED AS DONE BY THE USER (from s(-1) or s(0)) s(1)-->f(bF)
            mIconImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Nice job", Toast.LENGTH_SHORT).show();
                    mPlant.setState(1);
                    mPlant.setFrequency(mPlant.getBackFrequency());
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.DAY_OF_MONTH, mPlant.getBackFrequency());
                    mPlant.setAlarm(calendar.getTime());
                    PlantLab.get(getActivity()).updatePlant(mPlant);
                    updateUI();
                }
            });
        }

        @Override
        public void onClick(View v) {
            mCallbacks.onPlantSelected(mPlant); //call interface for showing detail of a plant
        }
    }

    //Adapter for plants in recyclerView
    private class PlantAdapter extends RecyclerView.Adapter<PlantHolder> {

        private List<Plant> mPlants;

        public PlantAdapter(List<Plant> plants) {
            mPlants = plants;
        }

        @NonNull
        @Override
        public PlantHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new PlantHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull PlantHolder holder, int position) {
            Plant plant = mPlants.get(position);
            holder.bind(plant);
        }

        @Override
        public int getItemCount() {
            return mPlants.size();
        }

        public void setPlants(List<Plant> plants) {
            mPlants = plants;
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plant_list, container, false);
        mPlantRecyclerView = (RecyclerView) view.findViewById(R.id.plant_recycler_view);
        mPlantRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mNoPlants = (TextView) view.findViewById(R.id.empty_view); //text with initial instructions
        animationView = (LottieAnimationView) view.findViewById(R.id.arrow_start);//animation for introduction to the app
        FloatingActionButton fab_new_plant = (FloatingActionButton) view.findViewById(R.id.fab_new_plant); //new plant

        //Code for showing indications when there are no plants
        PlantLab plantLab = PlantLab.get(getActivity());
        List<Plant> plants = plantLab.getPlants();

        if (plants.isEmpty()) {
            mPlantRecyclerView.setVisibility(View.GONE);
            mNoPlants.setVisibility(View.VISIBLE);
            animationView.setVisibility(View.VISIBLE);
        } else {
            mPlantRecyclerView.setVisibility(View.VISIBLE);
            mNoPlants.setVisibility(View.GONE);
            animationView.setVisibility(View.GONE);
        }
        mAdapter = new PlantAdapter(plants);
        mPlantRecyclerView.setAdapter(mAdapter);

        //floating action button for new plant
        fab_new_plant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Plant plant = new Plant();
                //plant created by default with state 1
                plant.setState(1);
                PlantLab.get(getActivity()).addPlant(plant);
                mCallbacks.onPlantSelected(plant);
            }
        });
        return view;
    }

    public void onResume() {
        super.onResume();
        updateUI();
        Intent mIntent = getActivity().getIntent();
        int valor = mIntent.getIntExtra("extra_key", 3);
        if (valor != 3) {
            Log.i(TAG, "Notificacion received on Resume code" + valor);
            updateDB(valor);
        }
    }

    //method to manage correct action from notification selected by user
    private void updateDB(int valor) {
        Log.i("INTENT", String.valueOf(valor));
        PlantLab plantLab = PlantLab.get(getActivity());
        List<Plant> plants = plantLab.getPlants();

        //case value==0 NOTIFICATION FROM PASS OPTION s(-1)-->s(0)-->f(0)  s(0)-->f(0)
        if (valor == 0) {
            for (int i = 0; i < plants.size(); i++) {
                Plant temporal = plants.get(i);
                int state = plants.get(i).getState();
                if (state == -1 || state == 0) {
                    temporal.setState(0);
                    temporal.setFrequency(0);
                }
                plantLab.updatePlant(temporal);
                updateUI();
            }
        }
        //case value==1 NOTIFICATION FROM SNOOZE OPTION s(0)-->s(-1)-->f(1) s(-1)-->f(1)
        else if (valor == 1) {
            for (int i = 0; i < plants.size(); i++) {
                Plant temporal = plants.get(i);
                int state = plants.get(i).getState();
                if (state == -1 || state == 0) {
                    temporal.setState(-1);
                    temporal.setFrequency(1);
                }
                plantLab.updatePlant(temporal);
                updateUI();
            }

        }
        //case value==2 NOTIFICATION FROM DONE OPTION s(0)-->s(1)-->f(bF) s(-1)-->s(1)-->f(bF)
        else if (valor == 2) {
            for (int i = 0; i < plants.size(); i++) {
                Plant temporal = plants.get(i);
                int state = plants.get(i).getState();
                if (state == 0 || state == -1) {
                    temporal.setState(1);
                    temporal.setFrequency(temporal.getBackFrequency());
                }
                plantLab.updatePlant(temporal);
                updateUI();
            }

        }

    }

    //Update ui to be called from PlantListActivity
    public void updateUI() {
        PlantLab plantLab = PlantLab.get(getActivity());
        List<Plant> plants = plantLab.getPlants();
        if (mAdapter == null) {
            mAdapter = new PlantAdapter(plants);
            mPlantRecyclerView.setAdapter(mAdapter);
        } else {
            //Update Adapter.
            mAdapter.setPlants(plants);
            mAdapter.notifyDataSetChanged();
        }
    }

    //inflate layout for menu fragment_plant_list
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_plant_list, menu);
        MenuItem trashMenuItem = menu.findItem(R.id.trash_plant);
        trashMenuItem.setVisible(false);
        MenuItem alarmItem = menu.findItem(R.id.set_alarm);
        alarmItem.setVisible(true);
    }

    //controls alarm setting icon from action bar.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.set_alarm:
                FragmentManager fm = getParentFragmentManager();
                TimePickerFragment dialog = TimePickerFragment.newInstance(new Date());
                dialog.setTargetFragment(PlantListFragment.this, REQUEST_TIME);
                dialog.show(fm, DIALOG_TIME);
                updateUI();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    //Method that handles the result from TimePicker and sets the alarm at that time.
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (requestCode == REQUEST_TIME) {
            Date date = (Date) data.getSerializableExtra(TimePickerFragment.EXTRA_TIME);
            if (PollService.isServiceAlarmOn(getContext())) {
                PollService.setServiceAlarm(getActivity(), false, date);
            }
            PollService.setServiceAlarm(getActivity(), true, date);
            //message_this to include in the notification
            String message_this = "Time to water your plants!";
            Log.i(HEYREPEATER, "set alarm every day at time :");
        }
    }

}
