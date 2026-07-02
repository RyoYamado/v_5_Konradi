package com.example.konradi_v_5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StatisticActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);

        ImageButton btnBack = findViewById(R.id.btnBack);
        Button btnReset = findViewById(R.id.btnReset);
        final CheckBox check1 = findViewById(R.id.check1);
        final CheckBox check2 = findViewById(R.id.check2);
        final CheckBox check3 = findViewById(R.id.check3);

        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String state = isChecked ? "включено" : "выключено";
                Toast.makeText(StatisticActivity.this, buttonView.getText() + ": " + state, Toast.LENGTH_SHORT).show();
            }
        };
        check1.setOnCheckedChangeListener(listener);
        check2.setOnCheckedChangeListener(listener);
        check3.setOnCheckedChangeListener(listener);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check1.setChecked(false);
                check2.setChecked(false);
                check3.setChecked(false);
                Toast.makeText(StatisticActivity.this, R.string.reset_toast, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
