package com.example.student.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;


public class SummaryActivity extends AppCompatActivity {
    private Button oVrati;
    private String sIme;
    private String sPrezime;
    private String sDatumRodenja;
    private String sPredmet;
    private String sImeProf;
    private String sPrezimeProf;
    private String sAkGodina;
    private String sSatiPred;
    private String sSatiLab;
    private TextView oIme;
    private TextView oPrezime;
    private TextView oDatumRodenja;
    private TextView oPredmet;
    private TextView oImeProf;
    private TextView oPrezimeProf;
    private TextView oAkGodina;
    private TextView oSatiPred;
    private TextView oSatiLab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        final Bundle oExtras = getIntent().getExtras();

        sIme = oExtras.getString("ime");
        sPrezime = oExtras.getString("prezime");
        sDatumRodenja = oExtras.getString( "datumRodenja");
        sPredmet = oExtras.getString("predmet");
        sImeProf = oExtras.getString("imeProf");
        sPrezimeProf = oExtras.getString("prezimeProf");
        sAkGodina = oExtras.getString("akGodina");
        sSatiPred = oExtras.getString("satiPred");
        sSatiLab = oExtras.getString("satiLab");

        oIme = (TextView)findViewById(R.id.tvImeUpis);
        oPrezime = (TextView)findViewById(R.id.tvPrezimeUpis);
        oDatumRodenja = (TextView)findViewById(R.id.tvDatumRodenjaUpis);
        oPredmet = (TextView)findViewById(R.id.tvPredmetUpis);
        oImeProf = (TextView)findViewById(R.id.tvProfesorImeUpis);
        oPrezimeProf = (TextView)findViewById(R.id.tvProfesorPrezimeUpis);
        oAkGodina = (TextView)findViewById(R.id.tvAkGodinaUpis);
        oSatiPred = (TextView)findViewById(R.id.tvSatiPredavanjaUpis);
        oSatiLab = (TextView)findViewById(R.id.tvSatiLabUpis);

        oIme.setText(sIme);
        oPrezime.setText(sPrezime);
        oDatumRodenja.setText(sDatumRodenja);
        oPredmet.setText(sPredmet);
        oImeProf.setText(sImeProf);
        oPrezimeProf.setText(sPrezimeProf);
        oAkGodina.setText(sAkGodina);
        oSatiPred.setText(sSatiPred);
        oSatiLab.setText(sSatiLab);
        oVrati = (Button)findViewById(R.id.button3);
        oVrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent oVratiNaPocetnu = new Intent(getApplicationContext(), MyActivity.class);
                oVratiNaPocetnu.putExtra("ime", sIme);
                oVratiNaPocetnu.putExtra("prezime", sPrezime);
                startActivity(oVratiNaPocetnu);
            }
        });
    }
}
