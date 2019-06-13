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

    public OffersRecyclerAdapter(Context context, ArrayList<Integer> imagesList) {
        mContext = context;
        mImagesList = imagesList;
    }

    @NonNull
    @Override
    public OffersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_offers,viewGroup,false);
        OffersViewHolder viewHolder = new OffersViewHolder(view);
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

    class OffersViewHolder extends RecyclerView.ViewHolder{

        public ImageView offerImageView;

        public OffersViewHolder(@NonNull View itemView) {
            super(itemView);

            offerImageView = itemView.findViewById(R.id.offersImageView);

        }
    }
}
