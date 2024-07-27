package com.example.calckit2;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FdCalculator extends AppCompatActivity {

    private EditText principalEditText;
    private EditText interestRateEditText;
    private EditText tenureEditText;
    private TextView resultTextView;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fd_calculator);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        principalEditText = findViewById(R.id.principalEditText);
        interestRateEditText = findViewById(R.id.interestRateEditText);
        tenureEditText = findViewById(R.id.tenureEditText);
        resultTextView = findViewById(R.id.resultTextView);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateFDMaturityAmount();
            }
        });
    }

    private void calculateFDMaturityAmount() {
        // Get values from EditText fields
        double principalAmount = Double.parseDouble(principalEditText.getText().toString());
        double interestRate = Double.parseDouble(interestRateEditText.getText().toString());
        double tenure = Double.parseDouble(tenureEditText.getText().toString());

        // FD maturity amount calculation logic
        double maturityAmount = principalAmount * Math.pow((1 + interestRate / (12 * 100)), 12 * tenure);

        // Display the result
        resultTextView.setText(String.format("Maturity Amount: %.2f", maturityAmount));
    }
}
