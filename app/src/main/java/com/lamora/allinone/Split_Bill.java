package com.lamora.allinone;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Split_Bill extends AppCompatActivity {

    private MediaPlayer mp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split__bill);
        mp = MediaPlayer.create(Split_Bill.this, R.raw.click);
    }

    public void click(View view) {
        if(!(mp.isPlaying())){
            mp.stop();
            mp.reset();
            mp = MediaPlayer.create(Split_Bill.this, R.raw.click);
            mp.start();
        }
        else{
            mp.stop();
            mp.reset();
            mp = MediaPlayer.create(Split_Bill.this, R.raw.click);
            mp.start();

        }
        TextView result = findViewById(R.id.result);
        EditText amount = findViewById(R.id.amount);
        EditText people = findViewById(R.id.people);
        if((people.getText().toString().isEmpty())||(amount.getText().toString().isEmpty())){
            result.setText("Please Fill All The Fields");
        }
        else{
            int a = Integer.parseInt(amount.getText().toString());
            int p = Integer.parseInt(people.getText().toString());
            if (p > 0) {
                int r = a / p;
                result.setText("Each One Should Pay : Rs." + r + "/-");
            } else {
                result.setText("Invalid Number Of People");
            }
        }
    }
}
