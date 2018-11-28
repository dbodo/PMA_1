package com.example.student.myapplication;

import android.app.Person;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.student.myapplication.adapter.MyAdapter;
import com.example.student.myapplication.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends AppCompatActivity {
    private RecyclerView recView;
    private String sIme;
    private String sPrezime;
    private String sPredmet;
    private Button oBtnNoviStudent;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Bundle oExtras = getIntent().getExtras();
        if(oExtras != null){
            sIme = oExtras.getString("ime");
            sPrezime = oExtras.getString("prezime");
            sPredmet = oExtras.getString("predmet");
        }

        recView = (RecyclerView) findViewById(R.id.my_recycler_view);
        List<Object>studentList = generateList();
        initializeRecyclerView(recView,studentList);

        Spinner spinner = (Spinner) findViewById(R.id.my_spinner);
        ArrayAdapter<CharSequence> oAdapter = ArrayAdapter.createFromResource(this, R.array.my_spinner, android.R.layout.simple_spinner_item);
        oAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(oAdapter);

        oBtnNoviStudent = (Button)findViewById(R.id.button4);
        oBtnNoviStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent oNoviStudent = new Intent(getApplicationContext(), PersonalInfoActivity.class);
                startActivity(oNoviStudent);
            }
        });
    }

    List<Object> generateList()
    {
        List<Object> list = new ArrayList<>();
        list.add("Studenti");
        list.add(new Student(sIme, sPrezime, sPredmet));
        return list;
    }
    void initializeRecyclerView(RecyclerView recyclerView, List<Object> studentList)
    {
        recView.setAdapter(new MyAdapter(studentList));
        recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}

