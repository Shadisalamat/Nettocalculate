package com.example.nettotestdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.widget.TextView;

import android.os.Bundle;
import android.widget.TextView;
public class Results extends AppCompatActivity {

  String auszahlung2,netto2,brutto2,Arbeitslosigkeitsteuergel2, Solidiritaetesteuergeld2,Renterversicherungsteuergeld2,Krankenversicherungssteuergeld2,
            KircheSteuerGeld2, PglegeSicherungsgeld2, Lohrsteuergeld2;

    TextView brut ,netto;
    TextView ArbeitslosigkeitsteuergeldTextView ,SolidiritaetesteuergeldTextView, RenterversicherungsteuergeldTextView,
            KrankenversicherungssteuergeldTextView, KircheSteuerGeldTextView,PglegeSicherungsgeldTextView,PglegeSicherungsgeld,LohrsteuergeldTextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        brut=findViewById(R.id.brutto);

        netto=findViewById(R.id.netto_gehalt);
        LohrsteuergeldTextview=findViewById(R.id.lohnsteuer);
        ArbeitslosigkeitsteuergeldTextView=findViewById(R.id.Arbeitslosenversicherung);
        SolidiritaetesteuergeldTextView=findViewById(R.id.solisteuer);
        RenterversicherungsteuergeldTextView=findViewById(R.id.Rentenversicherung);
        KrankenversicherungssteuergeldTextView=findViewById(R.id.Krankenversicherung);
        KircheSteuerGeldTextView=findViewById(R.id.kirchesteuer);
        PglegeSicherungsgeldTextView=findViewById(R.id.Pflegeversicherung);


        Bundle bundle = getIntent().getExtras();

        auszahlung2 = bundle.getString("auszahlung");
        netto2= bundle.getString("netto");
        brutto2= bundle.getString("brutto");
        Lohrsteuergeld2=bundle.getString("Lohnsteuer");
        Arbeitslosigkeitsteuergel2=bundle.getString("Arbeitslosigkeitsteuergel");
        Solidiritaetesteuergeld2=bundle.getString("Solidiritaetesteuergeld");
        Renterversicherungsteuergeld2=bundle.getString("Renterversicherungsteuergeld");
        //Renterversicherungsteuergeld2=bundle.getString();
        Krankenversicherungssteuergeld2=bundle.getString("Krankenversicherungssteuergeld");
        KircheSteuerGeld2=bundle.getString("KircheSteuerGeld");
        PglegeSicherungsgeld2=bundle.getString("PglegeSicherungsgeld");


        ////shadi vergleich


        //------------------


        brut.setText(brutto2);
        netto.setText(netto2);
        LohrsteuergeldTextview.setText(Lohrsteuergeld2);
                 ArbeitslosigkeitsteuergeldTextView.setText(Arbeitslosigkeitsteuergel2);
                SolidiritaetesteuergeldTextView.setText(Solidiritaetesteuergeld2);
                 RenterversicherungsteuergeldTextView.setText(Renterversicherungsteuergeld2);
                KrankenversicherungssteuergeldTextView.setText( Krankenversicherungssteuergeld2);
                 KircheSteuerGeldTextView.setText(KircheSteuerGeld2);

                PglegeSicherungsgeldTextView.setText(PglegeSicherungsgeld2);


    }
}
