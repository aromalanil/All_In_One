package com.lamora.allinone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Time extends AppCompatActivity {

    RadioGroup button_group;
    EditText quantity;
    TextView sec, mnt, hrs;
    double time=0,s=0,m=0,h=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        button_group = findViewById(R.id.temperature_option);
        quantity = findViewById(R.id.quantity);
        sec = findViewById(R.id.celsius_text);
        hrs = findViewById(R.id.kelvin_text);
        mnt = findViewById(R.id.fahrenheit_text);
    }
    public void convert(View view){
        int selectedId = button_group.getCheckedRadioButtonId();
        if(quantity.getText().toString().isEmpty()){
            Toast.makeText(Time.this,"Please Enter A Value",Toast.LENGTH_LONG).show();
        }
        else {
            time = Double.parseDouble( quantity.getText().toString() );
            //Meter
            if (selectedId == R.id.celsius_button) {
                s = time;
                m=s/60;
            }
            else if(selectedId == R.id.fahrenheit_button){
                m = time;
            }
            else if(selectedId == R.id.kelvin_button){
                h = time;
                m = h*60;
            }
            else{
                Toast.makeText(Time.this,"Select a Unit",Toast.LENGTH_LONG).show();
            }
            h = m/60;
            s = m*60;
            sec.setText(String.valueOf(s)+" sec");
            mnt.setText(String.valueOf(m)+" mnt");
            hrs.setText(String.valueOf(h)+" hrs");
        }
    }
}
