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
    private EditText oInputImeProf;
    private EditText oInputPrezimeProf;
    private EditText oInputAkGodina;
    private EditText oInputSatiPredavanja;
    private EditText oInputSatiLab;
    private String sIme;
    private String sPrezime;
    private String sDatumRodenja;
    private String sImeProf;
    private String sPrezimeProf;
    private String sPredmet;
    private String sAkGodina;
    private String sSatiPredavanja;
    private String sSatiLab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
        final Bundle oExtras = getIntent().getExtras();
        sIme = oExtras.getString("ime");
        sPrezime = oExtras.getString("prezime");
        sDatumRodenja = oExtras.getString("datumRodenja");
        oInputPredmet = (EditText)findViewById(R.id.etPredmet);
        oInputImeProf = (EditText)findViewById(R.id.etImeProf);
        oInputPrezimeProf = (EditText)findViewById(R.id.etPrezimeProf);
        oInputAkGodina = (EditText)findViewById(R.id.etAkademskaGodina);
        oInputSatiPredavanja = (EditText)findViewById(R.id.etSatiPredavanja);
        oInputSatiLab = (EditText)findViewById(R.id.etSatiLab);
        oBtnUpisi = (Button)findViewById(R.id.button2);
        oBtnUpisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sPredmet = oInputPredmet.getText().toString();
                sImeProf = oInputImeProf.getText().toString();
                sPrezimeProf = oInputPrezimeProf.getText().toString();
                sAkGodina = oInputAkGodina.getText().toString();
                sSatiPredavanja = oInputSatiPredavanja.getText().toString();
                sSatiLab = oInputSatiLab.getText().toString();
                Intent oPosaljiPredmetIntent = new Intent(getApplicationContext(), SummaryActivity.class);
                oPosaljiPredmetIntent.putExtra("ime", sIme);
                oPosaljiPredmetIntent.putExtra("prezime", sPrezime);
                oPosaljiPredmetIntent.putExtra("datumRodenja", sDatumRodenja);
                oPosaljiPredmetIntent.putExtra("imeProf", sImeProf);
                oPosaljiPredmetIntent.putExtra("prezimeProf",  sPrezimeProf);
                oPosaljiPredmetIntent.putExtra("predmet", sPredmet);
                oPosaljiPredmetIntent.putExtra("akGodina", sAkGodina);
                oPosaljiPredmetIntent.putExtra("satiPred", sSatiPredavanja);
                oPosaljiPredmetIntent.putExtra("satiLab", sSatiLab);
                startActivity(oPosaljiPredmetIntent);
            }
        });
    }
}
