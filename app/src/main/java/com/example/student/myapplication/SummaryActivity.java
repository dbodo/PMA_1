package com.example.student.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;


public class SummaryActivity extends AppCompatActivity {
    private Button oVrati;
    private String sImePrezime;
    private String sPredmet;
    private TextView oImePrezime;
    private TextView oPredmet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        final Bundle oExtras = getIntent().getExtras();
        sImePrezime = oExtras.getString("imePrezime");
        sPredmet = oExtras.getString("predmet");
        oImePrezime = (TextView)findViewById(R.id.tvImePrezimeUpis);
        oPredmet = (TextView)findViewById(R.id.tvPredmetUpis);
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
