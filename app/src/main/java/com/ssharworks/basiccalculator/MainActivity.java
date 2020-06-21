package com.ssharworks.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button calculate;
    private Button metric;
    private Button imperial;
    private EditText bodyWeight;
    private EditText height;
    private TextView bmi;
    private TextView unit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculate = (Button) findViewById(R.id.calculate);
        metric = (Button) findViewById(R.id.metric);
        imperial = (Button) findViewById(R.id.imperial);
        bodyWeight = (EditText) findViewById(R.id.body_weight);
        height = (EditText) findViewById(R.id.height);
        bmi = (TextView) findViewById(R.id.bmi);
        unit = (TextView) findViewById(R.id.unit);

        View.OnClickListener calculate_bmi = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int weight_kg = Integer.parseInt(bodyWeight.getText().toString());
                double height_m = Integer.parseInt(height.getText().toString()) / 100.0;
                double final_kg_m;
                final_kg_m = weight_kg / (height_m * height_m);
                String final_kgm2 = "" + final_kg_m;
                bmi.setText(final_kgm2);
            }
        };
        calculate.setOnClickListener(calculate_bmi);

    }
}