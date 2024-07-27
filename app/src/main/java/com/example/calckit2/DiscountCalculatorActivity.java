package com.example.calckit2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DiscountCalculatorActivity extends AppCompatActivity {

    private EditText originalPriceEditText, discountPercentageEditText;
    private TextView discountedPriceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount_calculator);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        originalPriceEditText = findViewById(R.id.originalPriceEditText);
        discountPercentageEditText = findViewById(R.id.discountPercentageEditText);
        discountedPriceTextView = findViewById(R.id.discountedPriceTextView);

        // Add TextWatcher to the originalPriceEditText and discountPercentageEditText
        originalPriceEditText.addTextChangedListener(textWatcher);
        discountPercentageEditText.addTextChangedListener(textWatcher);
    }

    // TextWatcher to monitor changes in the original price and discount percentage fields
    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            // Not used, but required by interface
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            // Calculate discounted price when text changes
            calculateDiscount();
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // Not used, but required by interface
        }
    };

    private void calculateDiscount() {
        // Get user input
        double originalPrice, discountPercentage;

        try {
            originalPrice = Double.parseDouble(originalPriceEditText.getText().toString());
            discountPercentage = Double.parseDouble(discountPercentageEditText.getText().toString());
        } catch (NumberFormatException e) {
            discountedPriceTextView.setText("Please enter valid original price and discount percentage");
            return;
        }

        // Calculate discounted price
        double discountedPrice = originalPrice - (originalPrice * discountPercentage / 100);

        // Display the result
        discountedPriceTextView.setText(String.format("Discounted Price: %.2f", discountedPrice));
    }
}
