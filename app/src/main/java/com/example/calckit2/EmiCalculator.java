package com.example.calckit2;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EmiCalculator extends AppCompatActivity {

    private EditText loanAmountEditText;
    private EditText interestRateEditText;
    private EditText tenureEditText;
    private TextView resultTextView;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emi_calculator);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        loanAmountEditText = findViewById(R.id.loanAmountEditText);
        interestRateEditText = findViewById(R.id.interestRateEditText);
        tenureEditText = findViewById(R.id.tenureEditText);
        resultTextView = findViewById(R.id.resultTextView);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateEMI();
            }
        });
    }

    private void calculateEMI() {
        // Get values from EditText fields
        double loanAmount = Double.parseDouble(loanAmountEditText.getText().toString());
        double interestRate = Double.parseDouble(interestRateEditText.getText().toString());
        double tenure = Double.parseDouble(tenureEditText.getText().toString());

        // EMI calculation logic
        double monthlyInterestRate = interestRate / (12 * 100);
        double numerator = loanAmount * monthlyInterestRate * Math.pow((1 + monthlyInterestRate), tenure);
        double denominator = Math.pow((1 + monthlyInterestRate), tenure) - 1;
        double emi = numerator / denominator;

        // Display the result
        resultTextView.setText(String.format("EMI: %.2f", emi));
    }
}
