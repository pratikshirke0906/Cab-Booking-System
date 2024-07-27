package com.example.calckit2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BMICalculatorActivity extends AppCompatActivity {

    private EditText heightEditText, weightEditText;
    private Button calculateBMIButton;
    private TextView bmiResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        heightEditText = findViewById(R.id.heightEditText);
        weightEditText = findViewById(R.id.weightEditText);
        calculateBMIButton = findViewById(R.id.calculateBMIButton);
        bmiResultTextView = findViewById(R.id.bmiResultTextView);

        // Add TextWatcher to the heightEditText and weightEditText
        heightEditText.addTextChangedListener(textWatcher);
        weightEditText.addTextChangedListener(textWatcher);

        calculateBMIButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        // Get user input
        double heightCM, weight;

        try {
            // Convert height to centimeters
            heightCM = Double.parseDouble(heightEditText.getText().toString());
            weight = Double.parseDouble(weightEditText.getText().toString());
        } catch (NumberFormatException e) {
            bmiResultTextView.setText("Please enter valid height and weight");
            return;
        }

        // Perform BMI calculation
        // Note: The BMI formula expects height in meters, so we need to convert height to meters by dividing by 100
        double heightM = heightCM / 100.0;
        double bmi = weight / (heightM * heightM);

        // Display the result
        bmiResultTextView.setText(String.format("BMI: %.2f", bmi));
    }

    // TextWatcher to monitor changes in the height and weight fields
    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            // Not used, but required by interface
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            // Calculate BMI when text changes
            calculateBMI();
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // Not used, but required by interface
        }
    };
}
