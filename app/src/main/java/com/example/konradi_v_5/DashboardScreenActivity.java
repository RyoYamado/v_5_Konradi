package com.example.konradi_v_5;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_screen);

        TextView tvHello = findViewById(R.id.tvHello);
        Button btnExit = findViewById(R.id.btnExit);
        Button btnOnline = findViewById(R.id.btnOnline);
        Button btnSnapshot = findViewById(R.id.btnSnapshot);

        String name = getIntent().getStringExtra("name");
        if (name == null || name.isEmpty()) {
            name = getString(R.string.default_name);
        }
        tvHello.setText(getString(R.string.hello, name));

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardScreenActivity.this, StatisticActivity.class));
            }
        });

        btnSnapshot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));
            }
        });
    }
}
