package com.example.inovaassignment.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Publication implements Parcelable {
    @SerializedName("publisher")
    private String publisherName;
    private String title;
    @SerializedName("place_of_publication")
    private String placeOfPublication;
    @SerializedName("start_year")
    private int startYear;
    @SerializedName("end_year")
    private int endYear;
    @SerializedName("subject")
    private ArrayList<String> subjects;
    @SerializedName("city")
    private ArrayList<String> cities;
    @SerializedName("language")
    private ArrayList<String> languages;

    Publication(String title, String publisherName, String placeOfPublication,int startYear,int endYear,ArrayList<String> subjects,ArrayList<String> cities,ArrayList<String> languages){
        this.title = title;
        this.publisherName=publisherName;
        this.placeOfPublication=placeOfPublication;
        this.startYear=startYear;
        this.endYear=endYear;
        this.subjects=subjects;
        this.cities=cities;
        this.languages=languages;
    }

    protected Publication(Parcel in) {
        publisherName = in.readString();
        title = in.readString();
        placeOfPublication = in.readString();
        startYear=in.readInt();
        endYear=in.readInt();
        subjects=  in.readArrayList(ArrayList.class.getClassLoader());
        cities=  in.readArrayList(ArrayList.class.getClassLoader());
        languages=  in.readArrayList(ArrayList.class.getClassLoader());
    }

    public static final Creator<Publication> CREATOR = new Creator<Publication>() {
        @Override
        public Publication createFromParcel(Parcel in) {
            return new Publication(in);
        }

        @Override
        public Publication[] newArray(int size) {
            return new Publication[size];
        }
    };

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPlaceOfPublication(String placeOfPublication) {
        this.placeOfPublication = placeOfPublication;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public String getTitle() {
        return title;
    }

    public String getPlaceOfPublication() {
        return placeOfPublication;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getStartYear() {
        return startYear;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

    public ArrayList<String> getCities() {
        return cities;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setCities(ArrayList<String> cities) {
        this.cities = cities;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(publisherName);
        parcel.writeString(title);
        parcel.writeString(placeOfPublication);
        parcel.writeInt(startYear);
        parcel.writeInt(endYear);
        parcel.writeList(subjects);
        parcel.writeList(cities);
        parcel.writeList(languages);
    }
}
