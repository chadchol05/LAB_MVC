package moo.ruts.ac.th.lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.security.PrivateKey;

public class tem extends AppCompatActivity {

    private Button Home, Cal;
    private EditText editt;
    private RadioGroup Group;
    private String strTemp,strTempRadio="Celsius",strAnwer;
    private double douAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tem);


        editt = (EditText)findViewById(R.id.editText);//รับค่าจากช่องใส่ค่า
        Group = (RadioGroup)findViewById(R.id.radiogroup); //รับค่าช่อง Radiogrup ที่มี เซลเซียส ฟาเรนไฮ

        Home = (Button) findViewById(R.id.butHome);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tem.this, profile.class);
                startActivity(intent);
            }
        });

        Cal = (Button) findViewById(R.id.button5); //รับค่าปุ่มคำนวนมา
        Cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    strTemp = editt.getText().toString().trim();
                    if (strTemp.equals("")) {
                        Log.d("Space", "It Have space in Blank");

                    } else if (strTempRadio =="Celsius"){
                        CalCe();
                        Intent intent = new Intent(tem.this, temCal.class);
                        intent.putExtra("Tem", strTemp);
                        intent.putExtra("Unit", strTempRadio);
                        intent.putExtra("Answer", strAnwer);

                        startActivity(intent);
                        Log.d("Press", "It Have space in Data");

                    } else if (strTempRadio =="Fahrenheit"){

                        Intent intent = new Intent(tem.this, temCal.class);
                        CalFa();
                        intent.putExtra("Tem", strTemp);
                        intent.putExtra("Unit", strTempRadio);
                        intent.putExtra("Answer", strAnwer);

                        startActivity(intent);
                        Log.d("Press", "It Have space in Data");

                    } else if (strTempRadio =="Kalvin"){
                        CalKal();
                        Intent intent = new Intent(tem.this, temCal.class);
                        intent.putExtra("Tem", strTemp);
                        intent.putExtra("Unit", strTempRadio);
                        intent.putExtra("Answer", strAnwer);

                        startActivity(intent);
                        Log.d("Pass", "It Have space in Data");
                    }



                } catch (Exception e) {

                }
            }

        });

        Group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radioCe:
                        strTempRadio="Celsius";
                        break;
                    case  R.id.radioFa:
                        strTempRadio="Fahrenheit";
                        break;
                    case R.id.radiokvl:
                        strTempRadio="Kalvin";
                        break;

                }
            }
        });

    } //สูตรคำนวณ แปลค่า
    private void CalCe(){
        douAnswer = Double.parseDouble(strTemp);
        strAnwer = Double.toString(douAnswer);
    }

    private void CalFa(){
        douAnswer = Double.parseDouble(strTemp)*1.8+32;
        strAnwer = Double.toString(douAnswer);
    }

    private void CalKal(){
        douAnswer = Double.parseDouble(strTemp)+273.15;
        strAnwer = Double.toString(douAnswer);
    }

}
