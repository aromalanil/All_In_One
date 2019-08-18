package com.lamora.allinone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Length extends AppCompatActivity {

    private RadioGroup button_group;
    private EditText quantity;
    private TextView met;
    private TextView kmet;
    private TextView cmet;
    private float m=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        button_group = findViewById(R.id.temperature_option);
        quantity = findViewById(R.id.quantity);
        met = findViewById(R.id.celsius_text);
        cmet = findViewById(R.id.fahrenheit_text);
        kmet = findViewById(R.id.kelvin_text);
    }

    public void convert(View view){
        int selectedId = button_group.getCheckedRadioButtonId();
        if(quantity.getText().toString().isEmpty()){
            Toast.makeText(Length.this,"Please Enter A Value",Toast.LENGTH_LONG).show();
        }
        else {
            float length = Float.parseFloat(quantity.getText().toString());
            //Meter
            float km = 0;
            float cm = 0;
            if (selectedId == R.id.celsius_button) {
                m= length;
            }
            else if(selectedId == R.id.fahrenheit_button){
                cm = length;
                m= cm /100;
            }
            else if(selectedId == R.id.kelvin_button){
                km = length;
                m= km *1000;
            }
            else{
                Toast.makeText(Length.this,"Select a Unit",Toast.LENGTH_LONG).show();
            }
            cm =m*100;
            km =m/1000;
            met.setText(m +" m");
            kmet.setText(km +" km");
            cmet.setText(cm +" cm");
        }
    }
}
