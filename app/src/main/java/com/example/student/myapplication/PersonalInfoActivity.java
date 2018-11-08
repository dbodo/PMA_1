package com.example.student.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PersonalInfoActivity extends AppCompatActivity {
    private Button oBtnUpisi;
    private EditText oInputImePrezime;
    private String sImePrezime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        oInputImePrezime = (EditText)findViewById(R.id.etImePrezime);
        oBtnUpisi = (Button)findViewById(R.id.button);
        oBtnUpisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sImePrezime = oInputImePrezime.getText().toString();
                Intent oPosaljiImePrezimeIntent = new Intent(getApplicationContext(), StudentInfoActivity.class);
                oPosaljiImePrezimeIntent.putExtra("imePrezime", sImePrezime);
                startActivity(oPosaljiImePrezimeIntent);
            }
        });
    }
}
