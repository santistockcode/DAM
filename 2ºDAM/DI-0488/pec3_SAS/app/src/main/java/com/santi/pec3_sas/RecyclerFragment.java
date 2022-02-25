package com.santi.pec3_sas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerFragment extends Fragment {

    private RecyclerViewAdapter mAdapter;
    private RecyclerView mRecyclerView;

    public Fragment newInstance() {
        return new RecyclerFragment();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view_fragment, container, false);
        //asignamos el recycler view a su layout
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //get my list es un método propio , lo he usado para probar el código previo a uusar la base de datos
        mAdapter = new RecyclerViewAdapter(getMyList());
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }



    private class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private CardView mCardView;
        private TextView mTextView;
        private ImageView mImageView;
        private TextView mRatingText;
        private ImageButton mRateThis;
        private Place mPlace;//NUEVO


        //cómo es display el contenido de cada cardview
        public RecyclerViewHolder(View itemView){
            super(itemView);
        }
        public RecyclerViewHolder(LayoutInflater inflater, ViewGroup container){
            super(inflater.inflate(R.layout.card_view, container, false));

            mCardView = itemView.findViewById(R.id.card_container);
            mTextView = itemView.findViewById(R.id.text_holder);
            mImageView = itemView.findViewById(R.id.place_image);
            mRatingText = itemView.findViewById(R.id.place_rating_count);
            mRateThis = itemView.findViewById(R.id.like_button);
            mRateThis.setOnClickListener(this);

        }
        //Asignar la cardview concreta a el objeto place me permite controlar el escuchador de los likes
        public void bind(Place place){
            mPlace = place;
        }

        @Override
        public void onClick(View v) {
            //Toast indicando lo votado
            Toast.makeText(getActivity(),
                    mPlace.getName() + ": one more point", Toast.LENGTH_SHORT)
                    .show();

            //"falso" binding para mostrar el numero de likes
            mPlace.setRatingCount(mPlace.getRatingCount()+1);
            PlaceManager.get(getActivity()).updatePlace(mPlace);
            //REFRESCAR UPDATEUI
            updateUI();
        }
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

       private ArrayList<Place> mPlaces;
        public RecyclerViewAdapter(ArrayList<Place> places) {
            this.mPlaces=places;
        }

        @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());

            return new RecyclerViewHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
                holder.mTextView.setText(mPlaces.get(position).getName());
                holder.mImageView.setImageResource(mPlaces.get(position).getImageResourceId());
                holder.mRatingText.setText(String.valueOf(mPlaces.get(position).getRatingCount()));
                holder.bind(mPlaces.get(position));

        }

        @Override
        public int getItemCount() {
            return mPlaces.size();
        }

        //para el método updateUI
        public void setPlaces(ArrayList<Place> places){
            mPlaces = places;
        }
    }

    private ArrayList<Place> getMyList(){
        PlaceManager placeManager = PlaceManager.get(getActivity());
        ArrayList<Place> places = (ArrayList<Place>) placeManager.getPlaces();

       //previous code before database
        /*
        ArrayList<Place> places = new ArrayList<>();

        Place p = new Place();
        p.setImageResourceId(R.drawable.madrid);
        p.setName("madrid");
        p.setRatingCount(2);
        places.add(p);

        p = new Place();
        p.setImageResourceId(R.drawable.cantabria);
        p.setName("Cantabria");
        p.setRatingCount(5);
        places.add(p);

        return places;

         */
        return places;
    }

    //since ratingCount has changed
    public void updateUI(){

        PlaceManager placeManager = PlaceManager.get(getActivity());
        ArrayList<Place> places = (ArrayList<Place>) placeManager.getPlaces();
        if(mAdapter == null) {
            mAdapter = new RecyclerViewAdapter(places);
            mRecyclerView.setAdapter(mAdapter);
        }else{
            mAdapter.setPlaces(places);
            mAdapter.notifyDataSetChanged();
        }
    }
}
