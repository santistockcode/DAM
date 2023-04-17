package com.santi.ficusing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PlantFragment extends Fragment {

    private Plant mPlant; //Plant object to be displayed
    //Objects to display in fragment_plant
    private EditText mNameField;
    private EditText mAboutField;
    private ImageButton mPhotoButton;
    private NumberPicker nPicker;
    private ImageView mPhotoView;
    //Variable for photo path
    private File mPhotoFile;
    //Variable for implementing interface
    private Callbacks mCallbacks;

    //Required interface for activities that want to host this fragment
    public interface Callbacks {
        void onPlantUpdated(Plant plant);
    }

    //Constant for indicating which plant is selected to PlantFragment via intent
    private static final String ARG_PLANT_ID = "plant_id";
    //Constant for photo petition
    private static final int REQUEST_PHOTO = 0;

    //Asigns PlantPagerActivity implementation of Callbacks to member variable.
    //Activity is a subclass of Context, onAttach passes a Context as a parameter.
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mCallbacks = (Callbacks) context;
    }

    //Interrupts PlantPagerActivity implementation of Callbacks to member variable.
    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    //Returns correct id for de intent to include
    public static PlantFragment newInstance(UUID plantId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_PLANT_ID, plantId);
        PlantFragment fragment = new PlantFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID plantId = (UUID) getArguments().getSerializable(ARG_PLANT_ID);
        mPlant = PlantLab.get(getActivity()).getPlant(plantId);
        //Instanciates variable for the photo's path
        mPhotoFile = PlantLab.get(getActivity()).getPhotoFile(mPlant);
        setHasOptionsMenu(true);
        updatePlant();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plant, container, false);
        //Conectamos las variables de instancia de la camara y de la imagen con sus elementos en el layout
        mPhotoView = (ImageView) view.findViewById(R.id.plant_photo);
        //Invocamos el metodo para cargar la imagen
        updatePhotoView();
        mPhotoButton = (ImageButton) view.findViewById(R.id.plant_camera);
        //Creamos el intent que da tratamiento a la toma de la foto
        final Intent captureImage = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //mPhotoButton --> botón de cámara
        mPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = FileProvider.getUriForFile(getActivity(),
                        "com.santi.ficusing.fileprovider",
                        mPhotoFile);
                captureImage.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                List<ResolveInfo> cameraActivities = getActivity()
                        .getPackageManager().queryIntentActivities(captureImage,
                                PackageManager.MATCH_DEFAULT_ONLY);
                for (ResolveInfo activity : cameraActivities) {
                    getActivity().grantUriPermission(activity.activityInfo.packageName,
                            uri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                }
                startActivityForResult(captureImage, REQUEST_PHOTO);
            }
        });
        //mNameField--> campo nombre de la planta
        mNameField = (EditText) view.findViewById(R.id.plant_title);
        mNameField.setText(mPlant.getName());
        mNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlant.setName(s.toString());
                updatePlant();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //nPicker --> selector de frequencia de riego
        nPicker = (NumberPicker) view.findViewById(R.id.frequency_picker);
        nPicker.setMaxValue(50);
        nPicker.setMinValue(0);
        nPicker.setValue(mPlant.getBackFrequency());
        nPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                mPlant.setFrequency(newVal);
                mPlant.setBackFrequency(newVal);//IterativoHoy
                mPlant.setState(1);
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DATE, newVal);
                mPlant.setAlarm(calendar.getTime());
                updatePlant();
            }
        });
        //mAboutField --> Campo About
        mAboutField = (EditText) view.findViewById(R.id.plant_about);
        mAboutField.setText(mPlant.getAbout());
        mAboutField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlant.setAbout(s.toString());
                updatePlant();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //FloatingActionButton--> fab to confirm the data inserted for this plant
        FloatingActionButton fab = view.findViewById(R.id.fab_confirm_plant);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PlantListActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }


    //method that handles the result from taking the photo
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        } else if (requestCode == REQUEST_PHOTO) {
            Uri uri = FileProvider.getUriForFile(getActivity(),
                    "com.santi.ficusing.fileprovider",
                    mPhotoFile);

            getActivity().revokeUriPermission(uri,
                    Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            updatePlant();
            updatePhotoView();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        PlantLab.get(getActivity())
                .updatePlant(mPlant);
    }

    //Method to load the photo file bitmap in mPhotoView
    private void updatePhotoView() {
        if (mPhotoFile == null || !mPhotoFile.exists()) {
            mPhotoView.setImageDrawable(null);
        } else {
            Bitmap bitmap = PictureUtils.getScaledBitmap(
                    mPhotoFile.getPath(), getActivity());
            mPhotoView.setImageBitmap(bitmap);
        }
    }

    //Live update plants in Cardview from here via interface Callbacks
    private void updatePlant() {
        PlantLab.get(getActivity()).updatePlant(mPlant);
        mCallbacks.onPlantUpdated(mPlant);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_plant_list, menu);
        //Select which icons to show on menu
        MenuItem subtitleItem2 = menu.findItem(R.id.trash_plant);
        //for avoiding two pane duplication of icons in menu
        if (!subtitleItem2.isVisible()) {
            subtitleItem2.setVisible(false);
        } else {
            subtitleItem2.setVisible(true);
        }
        MenuItem alarmItem = menu.findItem(R.id.set_alarm);
        alarmItem.setVisible(false);
    }

    //actions from icons in menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.trash_plant:
                Toast.makeText(getActivity(), getString(R.string.plant_deleted), Toast.LENGTH_LONG).show();
                PlantLab.get(getActivity()).delete(mPlant);
                Intent intent = new Intent(getActivity(), PlantListActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
