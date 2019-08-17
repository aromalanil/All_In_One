package com.lamora.allinone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Sensor extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
    }

    public void check(View view) {
        ImageView acce =findViewById(R.id.accelerometer);
        ImageView gyro =findViewById(R.id.gyroscope);
        ImageView temp =findViewById(R.id.temperature);
        ImageView proxy =findViewById(R.id.proximity);
        ImageView magnet =findViewById(R.id.magnetic);

        PackageManager manager = getPackageManager();
        boolean hasAccelerometer = manager.hasSystemFeature(PackageManager.FEATURE_SENSOR_ACCELEROMETER);
        if(hasAccelerometer){
            acce.setImageResource(R.drawable.tick);
        }
        else{
            acce.setImageResource(R.drawable.wrong);
        }
        boolean hasGyroscope = manager.hasSystemFeature(PackageManager.FEATURE_SENSOR_GYROSCOPE);
        if(hasGyroscope){
            gyro.setImageResource(R.drawable.tick);
        }
        else{
            gyro.setImageResource(R.drawable.wrong);
        }
        boolean hasTemperature = manager.hasSystemFeature(PackageManager.FEATURE_SENSOR_AMBIENT_TEMPERATURE);
        if(hasTemperature){
            temp.setImageResource(R.drawable.tick);
        }
        else{
            temp.setImageResource(R.drawable.wrong);
        }
        boolean hasProximity = manager.hasSystemFeature(PackageManager.FEATURE_SENSOR_PROXIMITY);
        if(hasProximity){
            proxy.setImageResource(R.drawable.tick);
        }
        else{
            proxy.setImageResource(R.drawable.wrong);
        }
        boolean hasMagnet = manager.hasSystemFeature(PackageManager.FEATURE_SENSOR_COMPASS);
        if(hasMagnet){
            magnet.setImageResource(R.drawable.tick);
        }
        else{
            magnet.setImageResource(R.drawable.wrong);
        }
    }
}

