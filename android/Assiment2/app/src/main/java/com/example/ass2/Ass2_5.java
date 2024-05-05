package com.example.ass2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Ass2_5 extends AppCompatActivity {
    EditText editRollNo, editName, editMobile, editEmail, editCourse, editDOB;
    AutoCompleteTextView autoCompleteCollege;
    Spinner spinnerCity;
    CheckBox checkRead, checkWrite, checkSpeak;
    RadioGroup radioGroupGender;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ass25);

        // Initialize UI components
        editRollNo = findViewById(R.id.editRollNo);
        editName = findViewById(R.id.editName);
        editMobile = findViewById(R.id.editMobile);
        editEmail = findViewById(R.id.editEmail);
        editCourse = findViewById(R.id.editCourse);
        editDOB = findViewById(R.id.editDOB);

        autoCompleteCollege = findViewById(R.id.autoCompleteCollege);
        setupAutoCompleteCollege();

        spinnerCity = findViewById(R.id.spinnerCity);
        setupCitySpinner();

        checkRead = findViewById(R.id.checkRead);
        checkWrite = findViewById(R.id.checkWrite);
        checkSpeak = findViewById(R.id.checkSpeak);

        radioGroupGender = findViewById(R.id.radioGroupGender);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });
    }

    private void setupAutoCompleteCollege() {
        // Example data for CollegeName AutoCompleteTextView
        String[] colleges = {"College A", "College B", "College C", "College D"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, colleges);

        autoCompleteCollege.setAdapter(adapter);
    }

    private void setupCitySpinner() {
        // Example data for City Spinner
        String[] cities = {"City 1", "City 2", "City 3", "City 4"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, cities);

        spinnerCity.setAdapter(adapter);

        // Set listener for item selection
        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Handle selected city
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing
            }
        });
    }

    private void submitForm() {
        // Get data from UI components
        String rollNo = editRollNo.getText().toString().trim();
        String name = editName.getText().toString().trim();
        String mobile = editMobile.getText().toString().trim();
        String email = editEmail.getText().toString().trim();
        String college = autoCompleteCollege.getText().toString().trim();
        String course = editCourse.getText().toString().trim();
        String dob = editDOB.getText().toString().trim();

        // Validate required fields
        if (rollNo.isEmpty() || name.isEmpty() || mobile.isEmpty() || email.isEmpty()
                || college.isEmpty() || course.isEmpty() || dob.isEmpty()) {
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validate mobile and email
        if (!isValidMobile(mobile) || !isValidEmail(email)) {
            return;
        }

        // Get selected city from Spinner
        String selectedCity = spinnerCity.getSelectedItem().toString();

        // Get selected skills from CheckBoxes
        String skills = "";
        if (checkRead.isChecked()) {
            skills += "Read ";
        }
        if (checkWrite.isChecked()) {
            skills += "Write ";
        }
        if (checkSpeak.isChecked()) {
            skills += "Speak";
        }

        // Get selected gender from RadioButtons
        RadioButton selectedGenderRadioButton = findViewById(radioGroupGender.getCheckedRadioButtonId());
        String gender = selectedGenderRadioButton.getText().toString();

        // Display data using Toast
        String toastMessage = "Roll No: " + rollNo + "\nName: " + name + "\nMobile: " + mobile
                + "\nEmail: " + email + "\nCity: " + selectedCity + "\nCollege: " + college
                + "\nCourse: " + course + "\nDOB: " + dob + "\nSkills: " + skills + "\nGender: " + gender;

        Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();
    }

    private boolean isValidMobile(String mobile) {
        // Simple mobile number validation (replace with a more robust validation if needed)
        if (mobile.length() == 10 && android.util.Patterns.PHONE.matcher(mobile).matches()) {
            return true;
        } else {
            Toast.makeText(this, "Invalid Mobile Number", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean isValidEmail(String email) {
        // Simple email validation (replace with a more robust validation if needed)
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return true;
        } else {
            Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}