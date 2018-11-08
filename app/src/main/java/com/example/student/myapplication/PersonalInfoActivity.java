package com.example.student.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PersonalInfoActivity extends AppCompatActivity {
    private Button oBtnUpisi;
    private EditText oInputIme;
    private EditText oInputPrezime;
    private EditText oInputDatumRodenja;
    private String sIme;
    private String sPrezime;
    private String sDatumRodenja;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        oInputIme = (EditText)findViewById(R.id.etIme);
        oInputPrezime = (EditText)findViewById(R.id.etPrezime);
        oInputDatumRodenja = (EditText)findViewById(R.id.etDatumRodenja);

        oBtnUpisi = (Button)findViewById(R.id.button);
        oBtnUpisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sIme = oInputIme.getText().toString();
                sPrezime = oInputPrezime.getText().toString();
                sDatumRodenja = oInputDatumRodenja.getText().toString();
                Intent oPosaljiImePrezimeIntent = new Intent(getApplicationContext(), StudentInfoActivity.class);
                oPosaljiImePrezimeIntent.putExtra("ime", sIme);
                oPosaljiImePrezimeIntent.putExtra("prezime", sPrezime);
                oPosaljiImePrezimeIntent.putExtra("datumRodenja", sDatumRodenja);
                startActivity(oPosaljiImePrezimeIntent);
            }
        });
    }
}
