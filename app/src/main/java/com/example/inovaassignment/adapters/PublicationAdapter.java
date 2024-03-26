package com.example.inovaassignment.adapters;

import static com.example.inovaassignment.utils.Constants.RANDOM_IMG_URL;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.inovaassignment.R;
import com.example.inovaassignment.interfaces.PublicationClickListener;
import com.example.inovaassignment.models.Publication;
import com.example.inovaassignment.view_holders.PublicationViewHolder;

import java.util.List;

public class PublicationAdapter extends RecyclerView.Adapter<PublicationViewHolder> {

    Context context;
    List<Publication> publications;
    PublicationClickListener listener;


    public PublicationAdapter(Context context, List<Publication> publications, PublicationClickListener listener) {
        this.context = context;
        this.publications = publications;
        this.listener=listener;
    }

    public void setFilteredPublications(List<Publication> filteredPublications){
        this.publications=filteredPublications;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PublicationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PublicationViewHolder(LayoutInflater.from(context).inflate(R.layout.publication_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PublicationViewHolder holder, int position) {
        holder.titleView.setText(publications.get(position).getTitle());
        holder.publisherView.setText(publications.get(position).getPublisherName());
        Glide.with(holder.imageView.getContext())
                .load(RANDOM_IMG_URL)
                .into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(publications.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return publications.size();
    }
}
