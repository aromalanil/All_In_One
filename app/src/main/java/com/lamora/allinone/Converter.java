package com.lamora.allinone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Converter extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
    }
    public void time(View view){
        Intent ti = new Intent(Converter.this,Time.class);
        startActivity(ti);
    }
    public void length(View view){
        Intent le = new Intent(Converter.this,Length.class);
        startActivity(le);
    }
    public void temperature(View view){
        Intent temp = new Intent(Converter.this,Temperature.class);
        startActivity(temp);
    }
    public void weight(View view){
        Intent we = new Intent(Converter.this,weight.class);
        startActivity(we);
    }
}
