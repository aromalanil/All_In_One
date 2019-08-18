package com.lamora.allinone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void split(View view) {
        Intent sp = new Intent(MainActivity.this,Split_Bill.class);
        startActivity(sp);
    }

    public void toss(View view) {
        Intent to = new Intent(MainActivity.this,Coin_Toss.class);
        startActivity(to);
    }

    public void Convert (View view) {
        Intent con = new Intent(MainActivity.this,Converter.class);
        startActivity(con);
    }

    public void sensor(View view) {
        Intent sen = new Intent(MainActivity.this,Sensor.class);
        startActivity(sen);
    }

    public void flash(View view) {
        Intent fla = new Intent(MainActivity.this,Flash.class);
        startActivity(fla);
    }
}
