package com.example.calckit2;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PpfCalculator extends AppCompatActivity {

    EditText principalEditText, rateEditText, timeEditText;
    Button calculateButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppf_calculator);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        principalEditText = findViewById(R.id.principalEditText);
        rateEditText = findViewById(R.id.interestRateEditText);
        timeEditText = findViewById(R.id.tenureEditText);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatePPF();
            }
        });
    }

    private void calculatePPF() {
        try {
            double principal = Double.parseDouble(principalEditText.getText().toString());
            double rate = Double.parseDouble(rateEditText.getText().toString());
            double time = Double.parseDouble(timeEditText.getText().toString());

            double amount = principal * Math.pow(1 + (rate / 100), time);

            resultTextView.setText(String.format("PPF Amount: %.2f", amount));
        } catch (NumberFormatException e) {
            resultTextView.setText("Please enter valid numbers");
        }
    }
}
