package com.example.ass2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Ass2_2 extends AppCompatActivity {

    private Spinner spinnerCurrencies;
    private EditText editTextAmount;
    private Button buttonConvert;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ass22);

        spinnerCurrencies = findViewById(R.id.spinnerCurrencies);
        editTextAmount = findViewById(R.id.editTextAmount);
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewResult = findViewById(R.id.textViewResult);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.currency_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerCurrencies.setAdapter(adapter);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertCurrency();
            }
        });
    }

    private void convertCurrency() {
        // Get user input
        String selectedCurrency = spinnerCurrencies.getSelectedItem().toString();
        double amount = Double.parseDouble(editTextAmount.getText().toString());

        // Conversion rates (replace with actual rates)
        double rupeesToDollarsRate = 0.014; // Replace with actual rate
        double dollarsToRupeesRate = 71.43; // Replace with actual rate
        double rupeesToPoundRate = 0.012;  // Replace with actual rate
        double poundToRupeesRate = 85.71;  // Replace with actual rate

        // Perform conversion
        double convertedAmount = 0.0;

        // Determine the conversion based on the selected currency
        switch (selectedCurrency) {
            case "Rupees to Dollars":
                convertedAmount = amount * rupeesToDollarsRate;
                break;
            case "Dollars to Rupees":
                convertedAmount = amount * dollarsToRupeesRate;
                break;
            case "Rupees to Pounds":
                convertedAmount = amount * rupeesToPoundRate;
                break;
            case "Pounds to Rupees":
                convertedAmount = amount * poundToRupeesRate;
                break;
            default:
                // Unsupported conversion
                textViewResult.setText("Unsupported conversion");
                return;
        }
        // Display the result
        String result = String.format("%.2f %s = %.2f %s", amount, selectedCurrency.split(" ")[0], convertedAmount, selectedCurrency.split(" ")[2]);
        textViewResult.setText(result);
    }
}