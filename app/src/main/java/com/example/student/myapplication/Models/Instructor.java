package com.example.student.myapplication.Models;

import android.support.annotation.NonNull;

import java.util.ArrayList;

public class Instructor {
    private String bio;
    private String image;
    private String name;

    public Instructor(String bio, String image, String name) {
        this.bio = bio;
        this.image = image;
        this.name = name;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {

        return bio;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}