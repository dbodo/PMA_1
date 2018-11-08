package com.example.student.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StudentInfoActivity extends AppCompatActivity {
    private Button oBtnUpisi;
    private EditText oInputPredmet;
    private String sPredmet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
        oInputPredmet = (EditText)findViewById(R.id.etPredmet);
        oBtnUpisi = (Button)findViewById(R.id.button2);
        oBtnUpisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sPredmet = oInputPredmet.getText().toString();
                Intent oPosaljiPredmetIntent = new Intent(getApplicationContext(), SummaryActivity.class);
                oPosaljiPredmetIntent.putExtra("predmet", sPredmet);
                startActivity(oPosaljiPredmetIntent);
            }
        });
    }
}
