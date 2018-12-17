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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.student.myapplication.InfoActivity;
import com.example.student.myapplication.Network.RetrofitManager;
import com.example.student.myapplication.R;
import com.example.student.myapplication.listeners.StudentInfoListener;
import com.example.student.myapplication.model.Course;
import com.example.student.myapplication.model.CoursesResponse;
import com.example.student.myapplication.model.Instructor;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentInfoFragment extends Fragment implements Callback<CoursesResponse>, AdapterView.OnItemSelectedListener{
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
    TextView tvPredmet;
    Spinner spinPredmet;
    Spinner spinProfesor;
    ArrayList<String> oPredmeti = new ArrayList<>();
    ArrayList<String> oProfesori = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_info,container,false);
        etGodina = view.findViewById(R.id.editGodina);
        etECTS = view.findViewById(R.id.editECTS);
        etPredavanja = view.findViewById(R.id.editPred);
        etLV = view.findViewById(R.id.editLV);
        spinPredmet = view.findViewById(R.id.predmetSpinner);
        spinProfesor = view.findViewById(R.id.profSpinner);
        oProfesori.add("Odaberi profesora!");
        oPredmeti.add("Odaberi predmet!");

        ArrayAdapter<String> predmetAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, oPredmeti);
        predmetAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinPredmet.setAdapter(predmetAdapter);
        spinPredmet.setOnItemSelectedListener(this);

        ArrayAdapter<String> profAdapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item, oProfesori);
        profAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinProfesor.setAdapter(profAdapter);
        spinProfesor.setOnItemSelectedListener(this);

        Call<CoursesResponse> callResponse = RetrofitManager.getInstance().getService().getCourses();
        callResponse.enqueue(StudentInfoFragment.this);


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

    @Override
    public void onResponse(Call<CoursesResponse> call, Response<CoursesResponse> response) {
        if(response.isSuccessful() && response.body() != null){
            for(Course courses : response.body().getCourses()){
                for(Instructor instructors : courses.getInstructors()){
                    oPredmeti.add(courses.getTitle());
                    oProfesori.add(instructors.getName());
                }
            }
        }else{
        }
    }

    @Override
    public void onFailure(Call<CoursesResponse> call, Throwable t) {
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int spinPredmet = R.id.predmetSpinner;
        int spinProf = R.id.profSpinner;

        if(adapterView.getId()== spinPredmet){
            String sPredmet = adapterView.getItemAtPosition(i).toString();
            if(studentInfoListener != null){
                studentInfoListener.setPredmet(sPredmet);
            }
        }
        else if(adapterView.getId() == spinProf){
            String sProfesor = adapterView.getItemAtPosition(i).toString();
            if(studentInfoListener != null){
                studentInfoListener.setProfesor(sProfesor);
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}