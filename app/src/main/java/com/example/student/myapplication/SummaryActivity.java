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
    private String sPredmet;
    private TextView oImePrezime;
    private TextView oPredmet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        final Bundle oExtras = getIntent().getExtras();
        sIme = oExtras.getString("irezime");
        sPrezime = oExtras.getString("prezime");
        sPredmet = oExtras.getString("predmet");
        oIme = (TextView)findViewById(R.id.tvImeUpis);
        oPrezime = (TextView)findViewById(R.id.tvImeUpis);
        oPredmet = (TextView)findViewById(R.id.tvPredmetUpis);
        oIme.setText(sIme);
        oPrezime.setText(sPrezime);
        oPredmet.setText(sPredmet);
        oVrati = (Button)findViewById(R.id.button3);
        oVrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent oVratiNaPocetnu = new Intent(getApplicationContext(), PersonalInfoActivity.class);
                startActivity(oVratiNaPocetnu);
            }
        });
    }
}
