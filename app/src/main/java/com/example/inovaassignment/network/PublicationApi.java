package com.example.inovaassignment.network;

import com.example.inovaassignment.models.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PublicationApi {

    @GET("search/titles/results/?terms=oakland&format=json&page=1")
    Call<ApiResponse> getPublications();
}
