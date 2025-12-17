package com.example.project1mp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnLinear, btnFrame, btnRelative, btnConstraint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLinear = findViewById(R.id.btnLinearLayout);
        btnFrame = findViewById(R.id.btnFrameLayout);
        btnRelative = findViewById(R.id.btnRelativeLayout);
        btnConstraint = findViewById(R.id.btnConstraintLayout);

        btnLinear.setOnClickListener(v -> startActivity(new Intent(this, LinearActivity.class)));
        btnFrame.setOnClickListener(v -> startActivity(new Intent(this, FrameActivity.class)));
        btnRelative.setOnClickListener(v -> startActivity(new Intent(this, RelativeActivity.class)));
        btnConstraint.setOnClickListener(v -> startActivity(new Intent(this, ConstraintActivity.class)));
    }
}