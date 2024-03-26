package com.example.inovaassignment.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.inovaassignment.MainActivity;
import com.example.inovaassignment.R;
import com.example.inovaassignment.models.Publication;

public class PublicationDetailActivity extends AppCompatActivity {

    private TextView titleView;
    private TextView publisher;
    private TextView placeOfPublication;
    private TextView subjects;
    private TextView cities;
    private TextView languages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publication_detail);

        titleView=findViewById(R.id.publication_title);
        publisher=findViewById(R.id.publisherName);
        placeOfPublication=findViewById(R.id.place_of_publication);
        subjects=findViewById(R.id.subjects);
        cities=findViewById(R.id.cities);
        languages=findViewById(R.id.languages);

        Bundle data = getIntent().getExtras();
        Publication publication = (Publication) data.getParcelable("publication");


        //        SETTING APPBAR
        ActionBar appBar=getSupportActionBar();
        appBar.setTitle(publication.getTitle()!=null?publication.getTitle():"Publication Details");
        appBar.setDisplayHomeAsUpEnabled(true);

        titleView.setText(publication.getTitle()!=null?publication.getTitle()+"  ( "+publication.getStartYear()+" -"+publication.getEndYear()+" )":"Title Loading...");
        publisher.setText(publication.getPublisherName()!=null?publication.getPublisherName():"Loading...");
        placeOfPublication.setText(publication.getPlaceOfPublication()!=null?publication.getPlaceOfPublication():"Loading...");

//        SET SUBJECTS
        if(publication.getSubjects().size()>0){
            String subject="";
            for(int i=0;i<publication.getSubjects().size();i++){

                subject=publication.getSubjects().get(i)+", "+subject;
            }
            subjects.setText(subject);
        }
        else{
            subjects.setText("Loading...");
        }

//        SET CITIES
        if(publication.getCities().size()>0){
            System.out.print("********"+publication.getCities().get(0)+"**********");
            String city="";
            for(int i=0;i<publication.getCities().size();i++){

                city=publication.getCities().get(i)+", "+city;
            }
            cities.setText(city);
        }
        else{
            cities.setText("Loading...");
        }

//        SET LANGUAGES
        if(publication.getLanguages().size()>0){
            String language="";
            for(int i=0;i<publication.getLanguages().size();i++){

                language=publication.getLanguages().get(i)+", "+language;
            }
            languages.setText(language);
        }
        else{
            languages.setText("Loading...");
        }
    }
}