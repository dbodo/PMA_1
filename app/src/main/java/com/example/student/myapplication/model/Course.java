package com.example.student.myapplication.model;

import android.support.annotation.NonNull;

import java.util.ArrayList;

public class Course {
    private ArrayList<Instructor> instructors;
    private String subtitle;
    private String image;

    public Course(ArrayList<Instructor> instructors, String subtitle, String image, String title, Boolean featured) {
        this.instructors = instructors;
        this.subtitle = subtitle;
        this.image = image;
        this.title = title;
        this.featured = featured;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    private String title;
    private Boolean featured;


    public void setInstructors(ArrayList<Instructor> instructors) {
        this.instructors = instructors;
    }

    public ArrayList<Instructor> getInstructors() {

        return instructors;
    }

    @NonNull
    @Override
    public String toString(){
        return "instruktori: " + instructors.toString() + "\n" + "nastlov: " + title + "\n";
    }

}
