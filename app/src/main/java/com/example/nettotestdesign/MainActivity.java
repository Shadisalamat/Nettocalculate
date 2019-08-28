package com.example.nettotestdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;




import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    EditText salary,age,Beitragkrankenver,Beitragpflegever,gkv_zuss;


    //RadioButton publicee, privatee ,mitzuschuss,ohnezuschuss,Kinder;
Button Calculate, btn_aboutus;
    RadioGroup kv_radiogroup;
    RadioButton kv_private,kv_gesetzlich;
    boolean kircheisChecked,kinderisChecked,PrivatekrankenkasseisChecked;
    CheckBox kindercheckbox,pkvcheckbox,gkvcheckbox;

    RadioButton chkkirche,chkkinder;
    TextView kindertextview;
    Switch simpleSwitch;
    String  selectedstate,selectedyear,selectedsteuerklasse,selectedtimezone,selectedkinderfreibeitraege,agee;
    Spinner spinner_state,spinner_steuerklasse,spinner_year,spinner_timezone,spinner_kinderfreibeitraege;
    double lohn =0.0 ,b=0.0,kinderbetrig=0.0,gkvzusbetrig=0.0;
    int year=2019,stuklass=1,jahrgang=0 ;

    double auszahlung,netto,brutto,Arbeitslosigkeitsteuergel, Solidiritaetesteuergeld,Renterversicherungsteuergeld,Krankenversicherungssteuergeld,
    KircheSteuerGeld, PglegeSicherungsgeld, Lohrsteuergeld;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

Calculate =findViewById(R.id.calculate_button);
        salary=findViewById(R.id.salary);


        age=findViewById(R.id.age);
       //

        Beitragkrankenver=findViewById(R.id.pkv);
       // Beitragkrankenver.setText("0.0");
        //
        Beitragpflegever=findViewById(R.id.pflege);
       // Beitragpflegever.setText("0.0");
       // gkvcheckbox = (CheckBox) findViewById(R.id.gkv);

                kv_gesetzlich = (RadioButton) findViewById(R.id.Gesetzlich_Krankenkasse_RadioButton);
       kv_private = (RadioButton) findViewById(R.id.Private_Krankenkasse_RadioButton);

        gkv_zuss=findViewById(R.id.gkv_zusatzbeitrag);
         //gkv_zuss.setVisibility(View.GONE);


        kindercheckbox = (CheckBox) findViewById(R.id.Kinder);
       // pkvcheckbox= (CheckBox) findViewById(R.id.privatee);

        spinner_state = findViewById(R.id.spinner_state);
        spinner_steuerklasse = findViewById(R.id.spinner_steuerklasse);
        spinner_year = findViewById(R.id.spinner_year);
        spinner_timezone=findViewById(R.id.spinner_timezone);
        spinner_kinderfreibeitraege=findViewById(R.id.spinner_kinderfreibeitraege);


        spinner_kinderfreibeitraege.setVisibility(View.GONE);
        Beitragkrankenver.setVisibility(View.GONE);
        Beitragpflegever.setVisibility(View.GONE);
       // gkv_zus.setVisibility(View.GONE);
        simpleSwitch = (Switch) findViewById(R.id.simpleSwitch);
        simpleSwitch.setVisibility(View.GONE);
        kv_radiogroup= (RadioGroup) findViewById(R.id.myRadioGroup);
        //Listener RAdioGroupp

        kv_radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if(checkedId == R.id.Gesetzlich_Krankenkasse_RadioButton) {
                    Toast.makeText(getApplicationContext(), "تم اختيار تأمين عام",
                            Toast.LENGTH_SHORT).show();
                    gkv_zuss.setVisibility(View.VISIBLE);
                  //  Beitragkrankenver.setText("0.0");
                  //  Beitragpflegever.setText("0.0");
                    Beitragkrankenver.setVisibility(View.GONE);
                    Beitragpflegever.setVisibility(View.GONE);

                } else if(checkedId == R.id.Private_Krankenkasse_RadioButton) {
                    Toast.makeText(getApplicationContext(), "تم اختيار تأمين خاص ",
                            Toast.LENGTH_SHORT).show();
                    gkv_zuss.setVisibility(View.GONE);
                   // gkv_zuss.setText("0.0");
                    Beitragkrankenver.setVisibility(View.VISIBLE);
                    Beitragpflegever.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(getApplicationContext(), "الخيار الافتراضي التأمين العام",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });
        //--Sahdi Add
// Class Spinner implementing onItemSelectedListener//
        spinner_state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            //  Log.d("myTag", "This is my message");
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                // do something upon option selection
                // Get Selected Class name from the list
                 selectedstate = parent.getItemAtPosition(position).toString();
                Log.d("myTag", "This is my message");
                Log.d("letsee", selectedstate );
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });

        //spinner_steuerklasse = findViewById(R.id.spinner_steuerklasse);
// Class Spinner implementing onItemSelectedListener//
        spinner_steuerklasse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            //  Log.d("myTag", "This is my message");
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                // do something upon option selection
                // Get Selected Class name from the list
                 selectedsteuerklasse = parent.getItemAtPosition(position).toString();
                Log.d("myTag", "This is my steuerklasse");
                Log.d("letsee", selectedsteuerklasse );
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });



        spinner_year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            //  Log.d("myTag", "This is my message");
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                // do something upon option selection
                // Get Selected Class name from the list
                 selectedyear= parent.getItemAtPosition(position).toString();
                 year=Integer.parseInt(selectedyear);
                // year=String.valueOf(selectedyear);
                Log.d("myTag", "This is my year");
                Log.d("letsee", selectedyear );
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });


        spinner_timezone.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            //  Log.d("myTag", "This is my message");
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                // do something upon option selection
                // Get Selected Class name from the list
                 selectedtimezone = parent.getItemAtPosition(position).toString();
                Log.d("myTag", "This is my selctedtimezone ");
                Log.d("letsee", selectedtimezone );
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }
        });


        spinner_kinderfreibeitraege.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            //  Log.d("myTag", "This is my message");
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                // do something upon option selection
                // Get Selected Class name from the list
                 selectedkinderfreibeitraege = parent.getItemAtPosition(position).toString();
                Log.d("myTag", "This is my selctedtimezone ");
                Log.d("letsee",  selectedkinderfreibeitraege );
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }

        });
        kindercheckbox = (CheckBox) findViewById(R.id.Kinder);
        kindercheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    //   kindertextview.setVisibility(View.VISIBLE);
                    spinner_kinderfreibeitraege.setVisibility(View.VISIBLE);
                } else {
                    // System.out.println("Not checked!!!!");
                    spinner_kinderfreibeitraege.setVisibility(View.INVISIBLE);
                }
            }
        });


       /*pkvcheckbox= (CheckBox) findViewById(R.id.privatee);
       // pkvcheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    //   kindertextview.setVisibility(View.VISIBLE);

                    Beitragkrankenver.setVisibility(View.VISIBLE);
                    Beitragpflegever.setVisibility(View.VISIBLE);
                    simpleSwitch.setVisibility(View.VISIBLE);
                } else {

                    Beitragkrankenver.setVisibility(View.GONE);
                    Beitragpflegever.setVisibility(View.GONE);
                    simpleSwitch.setVisibility(View.GONE);
                }
            }
        });

        gkvcheckbox=(CheckBox) findViewById(R.id.gkv);
        gkvcheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    //  kindertextview.setVisibility(View.VISIBLE);

                    gkv_zuss.setVisibility(View.VISIBLE);
                   // Beitragpflegever.setVisibility(View.VISIBLE);
                   // simpleSwitch.setVisibility(View.VISIBLE);
                } else {
                    gkv_zuss.setVisibility(View.GONE);



                }
            }
        });
        */
        // tview.setText(result);

        // Spinner click listener
        //M  spinner_state.setOnItemSelectedListener(this);

        // On selecting a spinner item

        //M    String text = spinner_state.getSelectedItem().toString();


//system.out.println("text");
         /*
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.State_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    }

        */
        // if(chkkirche.isSelected()){
        //   Kirche=true;
        // Log.d("myTag", "Kirchesteuer is true ");

        //}
        //else {
        //  Kirche=false;
        //}
btn_aboutus=(Button) findViewById(R.id.aboutus_button);
btn_aboutus.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(MainActivity.this,aboutus.class));
    }
});
Calculate.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        CheckDataentered();
    }
});

    }

public  void CheckDataentered()
{//salary,age,Beitragkrankenver,Beitragpflegever,gkv_zuss;
    if (isEmpty(salary)) {
        Toast t = Toast.makeText(this, "الرجاء ادخال راتبك باليورو !", Toast.LENGTH_SHORT);
        t.show();
    }
    if (isEmpty(age)) {
        Toast t = Toast.makeText(this, "الرجاء ادخال عمرك !", Toast.LENGTH_SHORT);
        t.show();
    }
   /* if((gkv_zuss.getVisibility() == View.VISIBLE) && (isEmpty(gkv_zuss)))

    {
        // Its visible
        gkvzusbetrig=0.9;
    }
     if ((gkv_zuss.getVisibility() == View.VISIBLE) && !(isEmpty(gkv_zuss))){
        //visible und value

        gkvzusbetrig=Double.parseDouble(gkv_zuss.getText().toString());
         gkvzusbetrig= gkvzusbetrig+0.9;
    }
    if((gkv_zuss.getVisibility() == View.INVISIBLE))

    {
        // Its visible Toast t = Toast.makeText(this, "الرجاء ادخال راتبك باليورو !", Toast.LENGTH_SHORT);
        //        t.show();
        gkvzusbetrig=0.0;




    }
*/
    if((Beitragkrankenver.getVisibility() == View.VISIBLE) && (isEmpty(Beitragkrankenver)))

    {
        // Its visible Toast t = Toast.makeText(this, "الرجاء ادخال راتبك باليورو !", Toast.LENGTH_SHORT);
        //        t.show();
        Toast t = Toast.makeText(this, "الرجاء ادخال مقدار دفعك  للكاسه !", Toast.LENGTH_SHORT);
        t.show();
    }

   /* if((Beitragkrankenver.getVisibility() == View.VISIBLE) && (isEmpty(Beitragkrankenver)))

    {
        // Its visible Toast t = Toast.makeText(this, "الرجاء ادخال راتبك باليورو !", Toast.LENGTH_SHORT);
        //        t.show();
        b=Double.parseDouble(Beitragkrankenver.getText().toString());

    }
    if((Beitragkrankenver.getVisibility() == View.INVISIBLE))

    {
        // Its visible Toast t = Toast.makeText(this, "الرجاء ادخال راتبك باليورو !", Toast.LENGTH_SHORT);
        //        t.show();
        b=0.0;
        Beitragkrankenver.setText("0.0");




    }

    if((Beitragpflegever.getVisibility() == View.VISIBLE) && (isEmpty(Beitragpflegever)))

    {
        // Its visible
        Toast t = Toast.makeText(this, "الرجاء ادخال مقدار دفعك  للعناية !", Toast.LENGTH_SHORT);
        t.show();
    }
*/
/////--------------------Shadi hier add sein Code //-------------------------------------------------


    salary = (EditText)findViewById(R.id.salary);
    //put the result in Textview TextView tview = (TextView)findViewById(R.id.textview1);
    String Salaryinput = salary.getText().toString();
    Log.d("myTag", "This is my salary");
    Log.d("letsee", Salaryinput );
    Log.d("letsee", salary.getText().toString());
    String ageinput = age.getText().toString();
    Log.d("myTag", "This is my age");
    Log.d("letsee", ageinput );
    Log.d("myTag", "This is my salary");
    Log.d("letsee", salary.getText().toString());
    lohn=Double.parseDouble(salary.getText().toString());
    //System.out.println(lohn);
    Log.d("myTag", "lohn");
    Log.d("letsee", String.valueOf(lohn));

    //System.out.print("+++++++++++++++++++++");
    if(isEmpty(Beitragkrankenver))
    b=0.0;
    else
    b=Double.parseDouble(Beitragkrankenver.getText().toString());
    //System.out.println(b);

    Log.d("letsee", String.valueOf(b));
    jahrgang=Integer.parseInt(age.getText().toString());
    //System.out.println(jahrgang);
    Log.d("myTag", "jahreggang");
    Log.d("letsee", String.valueOf(jahrgang));
    if(isEmpty(gkv_zuss))
        gkvzusbetrig=0.9;
    else
    gkvzusbetrig=Double.parseDouble(gkv_zuss.getText().toString());
    // System.out.println(gkvzusbetrig);
    kircheisChecked= ((CheckBox) findViewById(R.id.Kirche)).isChecked();
    if(kircheisChecked)
        Log.d("myTag", "true");
    else
        Log.d("myTag", "false");
    //Intent intent = new Intent(this, Results.class);









    ///MALik
    Log.d("myTag", selectedstate);
    Log.d("myTag",selectedtimezone);

    Log.d("myTag", String.valueOf(year));
    Steuerberechnung st=new Steuerberechnung(selectedtimezone,selectedstate,year);
/*

        st.berechnen(1,
                1000,
                true ,
                false,
                0.0,
                true,
                true,
                false,
                true,
                0.0,
                false,
                0.0,
                false,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                1990,
                0.0,
                0.0,
                0.0
        );
        */
    st.berechnen(
            stuklass,
            lohn,
            PrivatekrankenkasseisChecked,
            false,
            b,
            true,
            true,
            kircheisChecked,
            kinderisChecked,
            kinderbetrig,
            false,
            0.0,
            false,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0,
            jahrgang,
            0.0,
            0.0,
            gkvzusbetrig
    );




   /*
    Log.d("myTag", "This is my salary");
    Log.d("letsee", salary.getText().toString());


    Log.d("myTag", "This is my age");
    Log.d("letsee", age.getText().toString());
kircheisChecked= ((CheckBox) findViewById(R.id.Kirche)).isChecked();

if(kircheisChecked)
    Log.d("myTag", "true");
else
    Log.d("myTag", "false");*/


    auszahlung=st.getAuszahlung();
    brutto= st.getBrutto();
    netto=st.getNetto();
    Lohrsteuergeld=st.getLohnsteuer();
    KircheSteuerGeld=st.getKirchensteuer();
    Arbeitslosigkeitsteuergel=st.getArbeitslosenversicherung();
    Solidiritaetesteuergeld=st.getSoli();
    Renterversicherungsteuergeld=st.getRentenversicherung();
    Krankenversicherungssteuergeld=st.getKrankenversicherung();
    PglegeSicherungsgeld=st.getPflegeversicherung();
   // Lohrsteuergeld=st.getLohnsteuer();


    Log.d("netto after call", String.valueOf(netto));
    Log.d("Kircheafter call ", String.valueOf( KircheSteuerGeld));
    Log.d("Arbfter call ", String.valueOf(Arbeitslosigkeitsteuergel));
    Log.d("soli after", String.valueOf(Solidiritaetesteuergeld));
    Log.d("Renterafter", String.valueOf(Renterversicherungsteuergeld));
    Log.d("Kranken after", String.valueOf(Krankenversicherungssteuergeld));
    Log.d("pflege after ", String.valueOf(PglegeSicherungsgeld));
    Log.d("lohnsteuer after ", String.valueOf( Lohrsteuergeld));


    Intent intent = new Intent(this, Results.class);
    intent.putExtra("auszahlung",String.valueOf(auszahlung));

    intent.putExtra("brutto", String.valueOf(brutto));
    intent.putExtra("netto",String.valueOf( netto));
    intent.putExtra("Lohrsteuergeld",String.valueOf( Lohrsteuergeld));
    intent.putExtra("KircheSteuerGeld",String.valueOf( KircheSteuerGeld));
    intent.putExtra("Arbeitslosigkeitsteuergel",String.valueOf(  Arbeitslosigkeitsteuergel));
    intent.putExtra("Solidiritaetesteuergeld",String.valueOf( Solidiritaetesteuergeld));
    intent.putExtra("Renterversicherungsteuergeld",String.valueOf( Renterversicherungsteuergeld));

    intent.putExtra("Krankenversicherungssteuergeld",String.valueOf( Krankenversicherungssteuergeld));
    intent.putExtra("PglegeSicherungsgeld",String.valueOf( PglegeSicherungsgeld));


    startActivity(intent);
    //MALIK CODE











    ///------------------Shadi has beendet sein Code ---------------

}

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }


    public void btuCal(View view)
    {


        salary = (EditText)findViewById(R.id.salary);
        //put the result in Textview TextView tview = (TextView)findViewById(R.id.textview1);
        String Salaryinput = salary.getText().toString();
        Log.d("myTag", "This is my salary");
        Log.d("letsee", Salaryinput );
        Log.d("letsee", salary.getText().toString());
        String ageinput = age.getText().toString();
        Log.d("myTag", "This is my age");
        Log.d("letsee", ageinput );
        Log.d("myTag", "This is my salary");
        Log.d("letsee", salary.getText().toString());
        lohn=Double.parseDouble(salary.getText().toString());
        //System.out.println(lohn);
        Log.d("myTag", "lohn");
        Log.d("letsee", String.valueOf(lohn));

        //System.out.print("+++++++++++++++++++++");
        b=Double.parseDouble(Beitragkrankenver.getText().toString());
        //System.out.println(b);

        Log.d("letsee", String.valueOf(b));
        jahrgang=Integer.parseInt(age.getText().toString());
        //System.out.println(jahrgang);
        Log.d("myTag", "jahreggang");
        Log.d("letsee", String.valueOf(jahrgang));
        gkvzusbetrig=Double.parseDouble(gkv_zuss.getText().toString());
       // System.out.println(gkvzusbetrig);
        kircheisChecked= ((CheckBox) findViewById(R.id.Kirche)).isChecked();
        if(kircheisChecked)
            Log.d("myTag", "true");
        else
            Log.d("myTag", "false");
        //Intent intent = new Intent(this, Results.class);









        ///MALik
        Log.d("myTag", selectedstate);
        Log.d("myTag",selectedtimezone);

        Log.d("myTag", String.valueOf(year));
        Steuerberechnung st=new Steuerberechnung(selectedtimezone,selectedstate,year);
/*

        st.berechnen(1,
                1000,
                true ,
                false,
                0.0,
                true,
                true,
                false,
                true,
                0.0,
                false,
                0.0,
                false,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                1990,
                0.0,
                0.0,
                0.0
        );
        */
        st.berechnen(
                stuklass,
                lohn,
                PrivatekrankenkasseisChecked,
                false,
                b,
                true,
                true,
                kircheisChecked,
                kinderisChecked,
                kinderbetrig,
                false,
                0.0,
                false,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                jahrgang,
                0.0,
                0.0,
                gkvzusbetrig
        );




   /*
    Log.d("myTag", "This is my salary");
    Log.d("letsee", salary.getText().toString());


    Log.d("myTag", "This is my age");
    Log.d("letsee", age.getText().toString());
kircheisChecked= ((CheckBox) findViewById(R.id.Kirche)).isChecked();

if(kircheisChecked)
    Log.d("myTag", "true");
else
    Log.d("myTag", "false");*/

        auszahlung=st.getAuszahlung();
        brutto= st.getBrutto();
        netto=st.getNetto();

        Log.d("letsee", String.valueOf(netto));
        Intent intent = new Intent(this, Results.class);
        intent.putExtra("auszahlung",String.valueOf(auszahlung));

        intent.putExtra("brutto", String.valueOf(brutto));
        intent.putExtra("netto",String.valueOf( netto));
        startActivity(intent);
        //MALIK CODE










//        startActivity(intent);


    }

    // @Override
    //public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    //}

    // @Override
    //Mpublic void onNothingSelected(AdapterView<?> adapterView) {

    // M}
}
