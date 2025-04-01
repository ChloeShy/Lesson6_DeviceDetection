package com.example.devicedetection;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTxtOrientation;
    private TextView mTxtResolution;
    private Button mDetectDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mTxtOrientation = findViewById(R.id.txtOrientation);
        mTxtResolution = findViewById(R.id.txtResolution);
        mDetectDevice = findViewById(R.id.detectDevice);
        mDetectDevice.setOnClickListener(this);
    }

    public void onClick(View view){
        Display display = getWindowManager().getDefaultDisplay();
        mTxtOrientation.setText("" + display.getRotation());

        Point xy = new Point();
        display.getSize(xy);
        mTxtResolution.setText("x = " + xy.x + " y = " + xy.y);
    }
}