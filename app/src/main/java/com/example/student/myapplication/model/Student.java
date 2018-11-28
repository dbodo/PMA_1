package com.example.student.myapplication.model;

public class Student {
    private String name;
    private String lastName;
    private String predmet;

    public Student(String name, String lastName, String predmet){
        this.name = name;
        this.lastName = lastName;
        this.predmet = predmet;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
    public String getPredmet(){
        return predmet;
    }

}
