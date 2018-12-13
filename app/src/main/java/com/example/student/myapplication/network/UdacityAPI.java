package com.example.student.myapplication.network;


import com.example.student.myapplication.Models.CoursesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UdacityAPI {
    @GET("public-api/v0/courses")
    Call<CoursesResponse> getCourses();
}
