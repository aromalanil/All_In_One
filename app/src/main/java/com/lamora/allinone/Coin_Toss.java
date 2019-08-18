package com.lamora.allinone;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class Coin_Toss extends AppCompatActivity {

    private MediaPlayer mp;
    private boolean t= false;
    private boolean h= false;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin__toss);
        mp = MediaPlayer.create(Coin_Toss.this, R.raw.toss);
    }

    public void toss(View view) {
        TextView result = findViewById(R.id.result);
        Random rand = new Random();
        int n = rand.nextInt(2);
        if(mp.isPlaying()){
            mp.stop();
            mp.reset();
            mp = MediaPlayer.create(Coin_Toss.this, R.raw.toss);
            mp.start();
        }
        else{
            mp.start();
        }
        if(n==0){
            if(t){
                result.setText("The Toss is a Tail Again");
            }
            else {
                result.setText("The Toss is a Tail");
            }
            t=true;
            h=false;
        }
        else if (n == 1){
            if(h) {
                result.setText("The Toss is a Head Again");
            }
            else{
                result.setText("The Toss is a Head");
            }
            h=true;
            t=false;
        }
    }
}
