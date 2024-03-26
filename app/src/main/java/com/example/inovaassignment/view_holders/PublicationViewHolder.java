package com.example.inovaassignment.view_holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inovaassignment.R;

public class PublicationViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView titleView,publisherView;
    public CardView cardView;


    public PublicationViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.publication_image_view);
        titleView=itemView.findViewById(R.id.publication_title);
        publisherView=itemView.findViewById(R.id.publisher);
        cardView=itemView.findViewById(R.id.main_card);
    }
}
