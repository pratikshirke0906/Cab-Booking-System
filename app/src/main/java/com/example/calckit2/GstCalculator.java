package com.example.calckit2;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GstCalculator extends AppCompatActivity {

    private EditText originalAmountEditText;
    private EditText gstRateEditText;
    private TextView resultTextView;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gst_calculator);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        originalAmountEditText = findViewById(R.id.originalAmountEditText);
        gstRateEditText = findViewById(R.id.gstRateEditText);
        resultTextView = findViewById(R.id.resultTextView);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateGST();
            }
        });
    }

    private void calculateGST() {
        // Get values from EditText fields
        double originalAmount = Double.parseDouble(originalAmountEditText.getText().toString());
        double gstRate = Double.parseDouble(gstRateEditText.getText().toString());

        // GST calculation logic
        double gstAmount = (originalAmount * gstRate) / 100;
        double totalAmount = originalAmount + gstAmount;

        // Display the result
        resultTextView.setText(String.format("Total Amount (incl. GST): %.2f", totalAmount));
    }
}
