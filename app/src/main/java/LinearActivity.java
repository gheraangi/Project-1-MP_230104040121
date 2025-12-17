package com.example.project1mp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LinearActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_linear);

        Button btn = findViewById(R.id.btnLinearName);
        TextView tv = findViewById(R.id.textLinear);

        btn.setOnClickListener(v ->
                Toast.makeText(this, "Hello Muhayat!", Toast.LENGTH_SHORT).show());
    }
}