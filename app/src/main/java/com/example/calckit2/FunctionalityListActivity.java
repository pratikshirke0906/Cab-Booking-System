package com.example.calckit2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FunctionalityListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functionalities);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button areaCalculatorButton = findViewById(R.id.areaCalculatorButton);
        Button bmiCalculatorButton = findViewById(R.id.bmiCalculatorButton);
        Button discountCalculatorButton = findViewById(R.id.discountCalculatorButton);
        Button emiCalculatorButton = findViewById(R.id.emiCalculatorButton);
        Button gstCalculatorButton = findViewById(R.id.gstCalculatorButton);
        Button fdCalculatorButton = findViewById(R.id.fdCalculatorButton);
        Button ppfCalculatorButton = findViewById(R.id.ppfCalculatorButton);
        Button scientificCalculatorButton = findViewById(R.id.scientificCalculatorButton);
        Button setOperationsButton = findViewById(R.id.setOperationsButton);

        areaCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FunctionalityListActivity.this, AreaCalculatorActivity.class);
                startActivity(intent);
            }
        });

        bmiCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FunctionalityListActivity.this, BMICalculatorActivity.class);
                startActivity(intent);
            }
        });

        discountCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FunctionalityListActivity.this, DiscountCalculatorActivity.class);
                startActivity(intent);
            }
        });


        emiCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FunctionalityListActivity.this, EmiCalculator.class);
                startActivity(intent);
            }
        });

        gstCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FunctionalityListActivity.this, GstCalculator.class);
                startActivity(intent);
            }
        });

        fdCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FunctionalityListActivity.this, FdCalculator.class);
                startActivity(intent);
            }
        });

        ppfCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FunctionalityListActivity.this, PpfCalculator.class);
                startActivity(intent);
            }
        });

        scientificCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FunctionalityListActivity.this, ScientificCalculator.class);
                startActivity(intent);
            }
        });

        setOperationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FunctionalityListActivity.this, SetOperationsActivity.class);
                startActivity(intent);
            }
        });
    }
}

