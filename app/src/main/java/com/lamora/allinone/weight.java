package com.lamora.allinone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class weight extends AppCompatActivity {

    RadioGroup button_group;
    EditText quantity;
    TextView grm,kgrm, pnd;
    double weight;
    double g=0;
    double pn=0;
    double kg=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        button_group = findViewById(R.id.temperature_option);
        quantity = findViewById(R.id.quantity);
        grm = findViewById(R.id.celsius_text);
        pnd = findViewById(R.id.fahrenheit_text);
        kgrm = findViewById(R.id.kelvin_text);
    }
    public void convert(View view){
        int selectedId = button_group.getCheckedRadioButtonId();
        if(quantity.getText().toString().isEmpty()){
            Toast.makeText(weight.this,"Please Enter A Value",Toast.LENGTH_LONG).show();
        }
        else {
            weight = Double.parseDouble( quantity.getText().toString() );
            //Meter
            if (selectedId == R.id.celsius_button) {
                g= weight;
            }
            else if(selectedId == R.id.fahrenheit_button){
                pn = weight;
                g= pn*453.592;
            }
            else if(selectedId == R.id.kelvin_button){
                kg= weight;
                g=kg*1000;
            }
            else{
                Toast.makeText(weight.this,"Select a Unit",Toast.LENGTH_LONG).show();
            }
            kg=g/1000;
            pn=g/453.592;
            grm.setText(String.valueOf(g)+" g");
            kgrm.setText(String.valueOf(kg)+" kg");
            pnd.setText(String.valueOf(pn)+" Pound");
        }
    }
}
