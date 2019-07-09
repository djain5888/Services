package com.iniesta.services;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class OffersRecyclerAdapter extends RecyclerView.Adapter<OffersRecyclerAdapter.OffersViewHolder> {

    private Context mContext;
    private ArrayList<Integer> mImagesList;
    private RecyclerViewClickListener mListener;

    public OffersRecyclerAdapter(Context context, ArrayList<Integer> imagesList,RecyclerViewClickListener listener) {
        mContext = context;
        mImagesList = imagesList;
        mListener=listener;
    }

    @NonNull
    @Override
    public OffersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_offers,viewGroup,false);
        OffersViewHolder viewHolder = new OffersViewHolder(view,mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OffersViewHolder offersViewHolder, int i) {
        offersViewHolder.offerImageView.setImageResource(mImagesList.get(i));
    }

    @Override
    public int getItemCount() {
        return mImagesList.size();
    }
    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }


    class OffersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView offerImageView;
        public RecyclerViewClickListener hlistener;

        public OffersViewHolder(@NonNull View itemView,RecyclerViewClickListener listener) {
            super(itemView);
            itemView.setOnClickListener(this);
            hlistener=listener;
            offerImageView = itemView.findViewById(R.id.offersImageView);

        }


        @Override
        public void onClick(View v) {
            hlistener.onClick(v, getAdapterPosition());


        }

    }
}
