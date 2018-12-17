package com.example.student.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.student.myapplication.Network.RetrofitManager;
import com.example.student.myapplication.model.CoursesResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiActivity extends AppCompatActivity implements Callback<CoursesResponse> {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        textView = findViewById(R.id.textView);
        Call<CoursesResponse> callResponse = RetrofitManager.getInstance().getService().getCourses();
        callResponse.enqueue(ApiActivity.this);

    }

    @Override
    public void onResponse(@NonNull Call<CoursesResponse> call, @NonNull Response<CoursesResponse> response) {
        String text;
        if(response.isSuccessful() && response.body() != null){
            text = response.body().getCourses().toString();
        }else{
            text = "Došlo je do pogreške, podaci nisu dostupni";
        }
        setText(text);
    }

    @Override
    public void onFailure(@NonNull Call<CoursesResponse> call, @NonNull Throwable t) {
        setText("Došlo je do pogreške: " + t.getMessage());
    }

    void setText(String text){
        textView.setText(text);
    }
}
