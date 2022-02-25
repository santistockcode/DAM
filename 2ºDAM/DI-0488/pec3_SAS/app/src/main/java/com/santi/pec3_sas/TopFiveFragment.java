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
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class TopFiveFragment extends Fragment {

    public Fragment newInstance() {
        return new TopFiveFragment();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view_fragment, container, false);
        //ArrayList<Place> places = getMyList();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //once written the adapter
        recyclerView.setAdapter(new TopFiveFragment.RecyclerViewAdapter(getMyList()));
        return view;
    }



    private class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private CardView mCardView;
        private TextView mTextView;
        private ImageView mImageView;
        private TextView mRatingText;
        private ImageButton mRateThis;


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
            mRateThis.setVisibility(View.GONE);
            mRateThis.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(),
                    R.string.go_back , Toast.LENGTH_SHORT)
                    .show();
        }
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<TopFiveFragment.RecyclerViewHolder>{

        private ArrayList<Place> mPlaces;
        public RecyclerViewAdapter(ArrayList<Place> places) {
            this.mPlaces=places;
        }

        @NonNull
        @Override
        public TopFiveFragment.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());

            return new TopFiveFragment.RecyclerViewHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull TopFiveFragment.RecyclerViewHolder holder, int position) {
            holder.mTextView.setText(mPlaces.get(position).getName());
            holder.mImageView.setImageResource(mPlaces.get(position).getImageResourceId());
            holder.mRatingText.setText(String.valueOf(mPlaces.get(position).getRatingCount()));

        }
        //only show 5 cards
        @Override
        public int getItemCount() {
            return 5;
        }
    }

    private ArrayList<Place> getMyList(){
        PlaceManager placeManager = PlaceManager.get(getActivity());
        ArrayList<Place> places = (ArrayList<Place>) placeManager.getPlaces();

        //ordenar esos places, van a ser 5 los que se muestren gracias al método getItemCount
        Collections.sort(places, new Comparator<Place>() {
            @Override
            public int compare(Place p1, Place p2) {
                return new Integer(p2.getRatingCount()).compareTo(new Integer(p1.getRatingCount()));
            }
        });

        return places;
    }


}
