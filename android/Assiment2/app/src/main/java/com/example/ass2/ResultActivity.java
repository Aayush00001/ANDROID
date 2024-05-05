package com.example.ass2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Retrieve data passed from MainActivity
        Intent intent = getIntent();
        String enrollment = intent.getStringExtra("enrollment");
        String name = intent.getStringExtra("name");
        String semester1 = intent.getStringExtra("semester1");
        String semester2 = intent.getStringExtra("semester2");
        String semester3 = intent.getStringExtra("semester3");
        String semester4 = intent.getStringExtra("semester4");
        String semester5 = intent.getStringExtra("semester5");
        String semester6 = intent.getStringExtra("semester6");

        // Pass the maximum marks for each semester
        double maxMarksSemester1 = intent.getDoubleExtra("maxMarksSemester1", 100.0);
        double maxMarksSemester2 = intent.getDoubleExtra("maxMarksSemester2", 100.0);
        double maxMarksSemester3 = intent.getDoubleExtra("maxMarksSemester3", 100.0);
        double maxMarksSemester4 = intent.getDoubleExtra("maxMarksSemester4", 100.0);
        double maxMarksSemester5 = intent.getDoubleExtra("maxMarksSemester5", 100.0);
        double maxMarksSemester6 = intent.getDoubleExtra("maxMarksSemester6", 100.0);

        // Calculate percentage, pass/fail details, etc.
        double percentage = calculatePercentage(
                maxMarksSemester1, semester1,
                maxMarksSemester2, semester2,
                maxMarksSemester3, semester3,
                maxMarksSemester4, semester4,
                maxMarksSemester5, semester5,
                maxMarksSemester6, semester6
        );
        String passFailDetails = determinePassFail(percentage);

        // Display the result on the layout
        displayResult(enrollment, name, percentage, passFailDetails);
    }

    // Method to calculate the percentage based on Semester marks and maximum marks
    private double calculatePercentage(
            double maxMarks1, String semester1,
            double maxMarks2, String semester2,
            double maxMarks3, String semester3,
            double maxMarks4, String semester4,
            double maxMarks5, String semester5,
            double maxMarks6, String semester6
    ) {
        try {
            // Parse Semester marks to double
            double marks1 = Double.parseDouble(semester1);
            double marks2 = Double.parseDouble(semester2);
            double marks3 = Double.parseDouble(semester3);
            double marks4 = Double.parseDouble(semester4);
            double marks5 = Double.parseDouble(semester5);
            double marks6 = Double.parseDouble(semester6);

            // Calculate the percentage for each semester
            double percentage1 = (marks1 / maxMarks1) * 100;
            double percentage2 = (marks2 / maxMarks2) * 100;
            double percentage3 = (marks3 / maxMarks3) * 100;
            double percentage4 = (marks4 / maxMarks4) * 100;
            double percentage5 = (marks5 / maxMarks5) * 100;
            double percentage6 = (marks6 / maxMarks6) * 100;

            // Calculate the average percentage
            double averagePercentage = (percentage1 + percentage2 + percentage3 + percentage4 + percentage5 + percentage6) / 6.0;

            // Ensure the average percentage is within the valid range (0 to 100)
            return Math.min(100, Math.max(0, Double.parseDouble(new DecimalFormat("#.##").format(averagePercentage))));

        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0.0; // Handle the case where parsing fails
        }
    }

    // Method to determine pass/fail based on the calculated percentage
    private String determinePassFail(double percentage) {
        // Implement your logic to determine pass/fail based on the calculated percentage
        // Return "Pass" or "Fail"
        return (percentage >= 40.0) ? "Pass" : "Fail";
    }

    // Method to display the result on the layout
    private void displayResult(String enrollment, String name, double percentage, String passFailDetails) {
        TextView resultTextView = findViewById(R.id.resultTextView);
        resultTextView.setText("Enrollment: " + enrollment + "\nName: " + name + "\nPercentage: " + percentage + "%\nResult: " + passFailDetails);

        // Display percentage and pass/fail details
        TextView percentageTextView = findViewById(R.id.percentageTextView);
        percentageTextView.setText("Percentage: " + new DecimalFormat("#.##").format(percentage) + "%");

        TextView passFailTextView = findViewById(R.id.passFailTextView);
        passFailTextView.setText("Pass/Fail: " + passFailDetails);
    }
}