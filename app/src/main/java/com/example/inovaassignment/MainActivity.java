package com.example.inovaassignment;

import static com.example.inovaassignment.utils.Constants.BASE_URL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.inovaassignment.activities.PublicationDetailActivity;
import com.example.inovaassignment.adapters.PublicationAdapter;
import com.example.inovaassignment.interfaces.PublicationClickListener;
import com.example.inovaassignment.models.Publication;
import com.example.inovaassignment.network.PublicationApi;
import com.example.inovaassignment.models.ApiResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements PublicationClickListener {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private SearchView searchView;

    private List<Publication> publicationList;
    PublicationAdapter publicationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PublicationClickListener listener=this;

//        SETTING APPBAR TEXT
        getSupportActionBar().setTitle("Publications");

//        GET PROGRESS BAR
        progressBar=findViewById(R.id.progress_bar);

        searchView=findViewById(R.id.search_view);
        searchView.clearFocus();


//        GET RECYCLE VIEW BY ID
        recyclerView=findViewById(R.id.publication_recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


//      GENERATING IMPLEMENTATION OF PublicationApi Interface
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PublicationApi service = retrofit.create(PublicationApi.class);

        Call<ApiResponse> call = service.getPublications();


        call.enqueue(new Callback<ApiResponse>() {

            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                  publicationList=response.body().getPublications();

                  searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                      @Override
                      public boolean onQueryTextSubmit(String query) {
                          return false;
                      }

                      @Override
                      public boolean onQueryTextChange(String newText) {
                          filterPublication(newText);
                          return true;
                      }
                  });

                  publicationAdapter=new PublicationAdapter(getApplicationContext(),publicationList,listener);
                  recyclerView.setAdapter(publicationAdapter);
                  progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error fetching data", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });

    }

    private void filterPublication(String newText) {
        List<Publication> filteredList=new ArrayList<>();
        for(Publication publication: publicationList){
            if(publication.getTitle().toLowerCase().contains(newText.toLowerCase())){
                filteredList.add(publication);
            }
        }

        if(filteredList.isEmpty()){
            Toast.makeText(MainActivity.this, "No Data Found", Toast.LENGTH_LONG).show();
        }else{
            publicationAdapter.setFilteredPublications(filteredList);
        }
    }

    @Override
    public void onItemClicked(Publication publication) {
        Intent i = new Intent(getApplicationContext(), PublicationDetailActivity.class);
        i.putExtra("publication",publication);
        startActivity(i);
    }
}