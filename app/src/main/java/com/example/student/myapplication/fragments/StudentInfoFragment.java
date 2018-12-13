package com.example.student.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


import com.example.student.myapplication.R;
import com.example.student.myapplication.listeners.StudentInfoListener;

public class StudentInfoFragment extends Fragment {
    public static StudentInfoFragment newInstance(){
        Bundle args = new Bundle();

        StudentInfoFragment fragment = new StudentInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public StudentInfoListener studentInfoListener;

    EditText etPredmet;
    EditText etProfesor;
    EditText etGodina;
    EditText etECTS;
    EditText etPredavanja;
    EditText etLV;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_info,container,false);
        etPredmet=view.findViewById(R.id.textPredmet);
        etProfesor = view.findViewById(R.id.editProfIme);
        etGodina = view.findViewById(R.id.editGodina);
        etECTS = view.findViewById(R.id.editECTS);
        etPredavanja = view.findViewById(R.id.editPred);
        etLV = view.findViewById(R.id.editLV);



        etPredmet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                studentInfoListener.setPredmet(etPredmet.getText().toString());

            }
        });

        etProfesor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                studentInfoListener.setProfesor(etProfesor.getText().toString());

            }
        });

        etECTS.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                studentInfoListener.setECTS(etECTS.getText().toString());

            }
        });

        etGodina.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                studentInfoListener.setGodina(etGodina.getText().toString());

            }
        });

        etPredavanja.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                studentInfoListener.setPredavanja(etPredavanja.getText().toString());

            }
        });

        etLV.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                studentInfoListener.setLV(etLV.getText().toString());

            }
        });
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        studentInfoListener = null;
    }
}