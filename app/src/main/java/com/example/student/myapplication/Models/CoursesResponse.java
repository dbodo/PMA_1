package com.example.student.myapplication.Models;

import android.support.annotation.NonNull;

import java.util.ArrayList;
public class CoursesResponse {
    ArrayList<Course> courses;
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Course> getCourses() {

        return courses;
    }
    @NonNull
    @Override
    public String toString(){
        return super.toString();
    }
}
