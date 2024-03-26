package com.example.inovaassignment.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {
    private int totalItems;

    @SerializedName("items")
    private List<Publication> publications;

    ApiResponse(int totalItems, List<Publication> publications){
        this.totalItems=totalItems;
        this.publications=publications;
    }

    public void setItemsCount(int itemsCount) {
        this.totalItems = itemsCount;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    public int getItemsCount() {
        return totalItems;
    }

    public List<Publication> getPublications() {
        return publications;
    }
}
