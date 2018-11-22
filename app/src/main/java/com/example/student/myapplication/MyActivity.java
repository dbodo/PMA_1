package com.example.student.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.student.myapplication.adapter.MyAdapter;
import com.example.student.myapplication.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends AppCompatActivity {
    private RecyclerView recView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        recView = (RecyclerView) findViewById(R.id.my_recycler_view);
        List<Object>studentList = generateList();
        initializeRecyclerView(recView,studentList);
    }
    List<Object> generateList()
    {
        List<Object> list = new ArrayList<>();
        list.add("Studenti");
        list.add(new Student("Ivan", "Ivic"));
        list.add(new Student("Luka", "Lukic"));
        list.add(new Student("Luka", "Modric"));
        list.add(new Student("Ivan", "Horvat"));
        return list;
    }
    void initializeRecyclerView(RecyclerView recyclerView, List<Object> studentList)
    {
        recView.setAdapter(new MyAdapter(studentList));
        recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}

