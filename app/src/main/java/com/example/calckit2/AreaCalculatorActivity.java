package com.example.calckit2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AreaCalculatorActivity extends AppCompatActivity {

    private Spinner unitSpinner1, unitSpinner2;
    private EditText valueEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_calculator);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        unitSpinner1 = findViewById(R.id.unitSpinner1);
        unitSpinner2 = findViewById(R.id.unitSpinner2);
        valueEditText = findViewById(R.id.valueEditText);
        resultTextView = findViewById(R.id.resultTextView);

        // Populate the spinners with unit options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.area_units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        unitSpinner1.setAdapter(adapter);
        unitSpinner2.setAdapter(adapter);

        // Set item selected listener for the spinners
        unitSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                calculateArea();  // Calculate when the unit is changed
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Handle when nothing is selected
            }
        });

        unitSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                calculateArea();  // Calculate when the unit is changed
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Handle when nothing is selected
            }
        });

        // Add TextWatcher to the valueEditText
        valueEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Not used, but required by interface
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calculateArea();  // Calculate when the text changes
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Not used, but required by interface
            }
        });

        // Calculate the initial area
        calculateArea();
    }

    private void calculateArea() {
        // Get user input
        String unit1 = unitSpinner1.getSelectedItem().toString();
        String unit2 = unitSpinner2.getSelectedItem().toString();

        double inputValue;
        try {
            inputValue = Double.parseDouble(valueEditText.getText().toString());
        } catch (NumberFormatException e) {
            resultTextView.setText("Please enter a valid number");
            return;
        }

        // Perform the conversion based on the selected units
        double result;
        switch (unit1) {
            case "sq kilometers":
                result = convertFromSqKilometers(inputValue, unit2);
                break;
            case "sq metre":
                result = convertFromSqMetre(inputValue, unit2);
                break;
            // Add cases for other units...

            default:
                result = 0.0; // Default to 0 if an invalid unit is selected
        }

        // Display the result
        resultTextView.setText(String.format("%.2f %s = %.2f %s", inputValue, unit1, result, unit2));
    }

    private double convertFromSqKilometers(double value, String toUnit) {
        double result;

        switch (toUnit) {
            case "sq kilometers":
                result = value;
                break;
            case "sq metre":
                result = value * 1_000_000; // 1 sq kilometer = 1,000,000 sq meters
                break;
            // Add cases for other units...

            default:
                result = 0.0; // Default to 0 if an invalid unit is selected
        }

        return result;
    }

    private double convertFromSqMetre(double value, String toUnit) {
        double result;

        switch (toUnit) {
            case "sq kilometers":
                result = value / 1_000_000; // 1 sq meter = 1e-6 sq kilometers
                break;
            case "sq metre":
                result = value;
                break;
            // Add cases for other units...

            default:
                result = 0.0; // Default to 0 if an invalid unit is selected
        }

        return result;
    }

    // Add more conversion methods for other units if needed
}