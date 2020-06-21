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
    private TextView heightText;
    private TextView bodyWeightText;
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
        bodyWeightText = (TextView) findViewById(R.id.textView2);
        heightText = (TextView) findViewById(R.id.textView3);

        height = (EditText) findViewById(R.id.height);
        bmi = (TextView) findViewById(R.id.bmi);
        unit = (TextView) findViewById(R.id.unit);

        View.OnClickListener calculate_bmi = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weight_kg = bodyWeight.getText().toString();
                String height_m = height.getText().toString();
                if ((weight_kg.length() == 0) || (height_m.length() == 0)){
                    return;
                }
                double Weight_kg = Double.parseDouble(weight_kg);
                double Height_m = Double.parseDouble(height_m);
                double final_kg_m = 0.0;
                if (unit.getText().toString().toLowerCase().equals("metric")){
                    final_kg_m = Weight_kg / ((Height_m / 100) * (Height_m / 100));
                }
                else if (unit.getText().toString().toLowerCase().equals("imperial")) {
                    final_kg_m = Weight_kg * 703 / (Height_m * Height_m);
                }
                String final_kgm2 = "" + final_kg_m;
                bmi.setText(final_kgm2);
            }
        };
        calculate.setOnClickListener(calculate_bmi);

        View.OnClickListener unit_selected = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                String buttonName = b.getText().toString().toLowerCase();
                if (buttonName.equals("metric")) {
                    unit.setText(R.string.textmetric);
                    heightText.setText("Height (cm)");
                    bodyWeightText.setText("Weight (kg)");
                    bodyWeight.setText("");
                    height.setText("");
                }
                else if (buttonName.equals("imperial")) {
                    unit.setText(R.string.imperialtext);
                    heightText.setText("Height (in)");
                    bodyWeightText.setText("Weight (lb)");
                    bodyWeight.setText("");
                    height.setText("");
                }
            }
        };
        metric.setOnClickListener(unit_selected);
        imperial.setOnClickListener(unit_selected);
    }
}