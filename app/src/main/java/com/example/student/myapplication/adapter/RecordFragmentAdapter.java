package com.example.student.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.student.myapplication.fragments.PersonalInfoFragment;
import com.example.student.myapplication.fragments.StudentInfoFragment;
import com.example.student.myapplication.fragments.SummaryFragment;
import com.example.student.myapplication.listeners.PersonalInfoListener;
import com.example.student.myapplication.listeners.StudentInfoListener;
import com.example.student.myapplication.listeners.SummaryInfoDataSource;
import com.example.student.myapplication.model.Student;

public class RecordFragmentAdapter extends FragmentPagerAdapter implements PersonalInfoListener,StudentInfoListener,SummaryInfoDataSource {
    private String name = "";
    private String lastName = "";
    private String birthDate = "";
    private String predmet = "";
    private String profesor = "";
    private String godina = "";
    private String predavanja = "";
    private String ects = "";
    private String LV = "";


    public RecordFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch(position){
            case 0:
                fragment = PersonalInfoFragment.newInstance();
                ((PersonalInfoFragment)fragment).personalInfoListener = this;

                break;

            case 1:
                fragment = StudentInfoFragment.newInstance();
                ((StudentInfoFragment)fragment).studentInfoListener = this;
                break;
            default:
                fragment = SummaryFragment.newInstance();
                ((SummaryFragment)fragment).dataSource = this;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public void setName(String name) {
        this.name = name;

    }

    @Override
    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    @Override
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;

    }

    @Override
    public void setPredmet(String predmet) {
        this.predmet = predmet;

    }

    @Override
    public void setProfesor(String profesor) {
        this.profesor = profesor;

    }

    @Override
    public void setGodina(String godina) {
        this.godina = godina;

    }

    @Override
    public void setECTS(String ects) {
        this.ects = ects;

    }

    @Override
    public void setPredavanja(String predavanja) {
        this.predavanja = predavanja;

    }

    @Override
    public void setLV(String LV) {
        this.LV = LV;

    }

    @Override
    public Student getStudent() {
        return new Student(name,lastName,birthDate,predmet,profesor,predavanja,godina,ects,LV);

    }
}
