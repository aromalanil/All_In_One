package com.lamora.allinone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Temperature extends AppCompatActivity {

    RadioGroup button_group;
    EditText quantity;
    TextView cel, far, kel;
    double temperature =0, c =0, f =0, k =0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        button_group = findViewById(R.id.temperature_option);
        quantity = findViewById(R.id.quantity);
        cel = findViewById(R.id.celsius_text);
        kel = findViewById(R.id.kelvin_text);
        far = findViewById(R.id.fahrenheit_text);
    }
    public void convert(View view){
        int selectedId = button_group.getCheckedRadioButtonId();
        if(quantity.getText().toString().isEmpty()){
            Toast.makeText(Temperature.this,"Please Enter A Value",Toast.LENGTH_LONG).show();
        }
        else {
            temperature = Double.parseDouble( quantity.getText().toString() );
            if (selectedId == R.id.celsius_button) {
                c = temperature;
            }
            else if(selectedId == R.id.fahrenheit_button){
                f = temperature;
                c=((f-32)*(5.0/9.0));
            }
            else if(selectedId == R.id.kelvin_button){
                k = temperature;
                c=(k-273.15);
            }
            else{
                Toast.makeText(Temperature.this,"Select a Unit",Toast.LENGTH_LONG).show();
            }
            k=c+273.15;
            f=(c*1.8)+32;
            cel.setText(String.valueOf(c)+" °C");
            far.setText(String.valueOf(f)+" °F");
            kel.setText(String.valueOf(k)+" K");
        }
    }
}
