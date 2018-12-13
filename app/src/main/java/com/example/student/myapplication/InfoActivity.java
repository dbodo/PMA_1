package com.example.student.myapplication;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.student.myapplication.adapter.RecordFragmentAdapter;

public class InfoActivity extends AppCompatActivity {
    private Button oBtnEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new RecordFragmentAdapter(getSupportFragmentManager()));


        /**
         oBtnEnd = findViewById(R.id.btnEnd);
         oBtnEnd.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
        Intent intent = new Intent(InfoActivity.this, MainActivity.class);
        startActivity(intent);
        }
        });
         */


    }


}
