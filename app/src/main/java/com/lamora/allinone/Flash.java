package com.lamora.allinone;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Flash extends AppCompatActivity {


    private ImageButton switch_on;
    private ImageButton switch_off;
    private TextView state;
    private ImageView glow;
    private boolean flashOn=false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        switch_on=findViewById(R.id.switch_on);
        switch_off=findViewById(R.id.switch_off);
        state=findViewById(R.id.state);
        glow=findViewById(R.id.glow);

    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void on(View view) {
        if(!flashOn) {
            CameraManager camManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
            String cameraId = null; // Usually front camera is at 0 position.
            try {
                cameraId = camManager.getCameraIdList()[0];
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
            try {
                camManager.setTorchMode(cameraId, true);
                glow.setVisibility(View.VISIBLE);
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
            flashOn=true;
            switch_on.setVisibility(View.GONE);
            switch_off.setVisibility(View.VISIBLE);
            state.setText("ON");
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void off(View view) {
        if(flashOn){
            CameraManager camManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
            String cameraId = null; // Usually front camera is at 0 position.
            try {
                cameraId = camManager.getCameraIdList()[0];
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
            try {
                camManager.setTorchMode(cameraId, false);
                glow.setVisibility(View.GONE);
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
            flashOn=false;
            switch_off.setVisibility(View.GONE);
            switch_on.setVisibility(View.VISIBLE);
            state.setText("OFF");
        }


    }


}
