package com.example.konradi_v_5;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardScreen extends AppCompatActivity {

    @SuppressLint("StringFormatInvalid")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_screen);

        TextView tvHello = findViewById(R.id.tvHello);
        Button btnExit = findViewById(R.id.btnExit);
        Button btnSettings = findViewById(R.id.btnSettings);
        Button btnSnapshot = findViewById(R.id.btnSnapshot);

        String name = getIntent().getStringExtra("name");
        if (name == null || name.isEmpty()) {
            name = getString(R.string.default_name);
        }
        tvHello.setText(getString(R.string.hello, name));

        btnExit.setOnClickListener(v -> finish());

        btnSettings.setOnClickListener(v -> startActivity(new Intent(DashboardScreen.this, Statistic.class)));

        btnSnapshot.setOnClickListener(v -> startActivity(new Intent(MediaStore.ACTION_IMAGE_CAPTURE)));
    }
}
