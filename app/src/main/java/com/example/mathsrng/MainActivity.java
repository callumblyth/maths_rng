package com.example.mathsrng;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {
    int sum1 = ThreadLocalRandom.current().nextInt(1, 100);
    int sum2 = ThreadLocalRandom.current().nextInt(1, 100);
    int oprng = ThreadLocalRandom.current().nextInt(1, 4); // Changed to include 3
    int sum;
    TextView Txt_Math_Output;
    TextView txt_yon;
    Button btn_next;
    Button btn_equals;
    EditText data_input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Txt_Math_Output = findViewById(R.id.Txt_Math_Output);
        btn_next = findViewById(R.id.btn_next);
        btn_equals = findViewById(R.id.btn_equals);
        data_input = findViewById(R.id.data_input);
        txt_yon = findViewById(R.id.txt_yon);

        switch (oprng) {
            case 1:
                sum = sum1 + sum2;
                Txt_Math_Output.setText(sum1 + " + " + sum2 + " = ?");
                break;
            case 2:
                sum = sum1 - sum2;
                Txt_Math_Output.setText(sum1 + " - " + sum2 + " = ?");
                break;
            case 3:
                sum = sum1 * sum2;
                Txt_Math_Output.setText(sum1 + " x " + sum2 + " = ?");
                break;
            default:
                // Handle unexpected value of oprng
                break;
        }

        btn_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the equals button click
                // Check the user input against the correct answer
                // Display a message or take appropriate action


                EditText data_input = findViewById(R.id.data_input);

// Get the text from EditText
                String userInput = data_input.getText().toString();

// Check if the input is not empty
                if (!userInput.isEmpty()) {
                    try {
                        // Parse the input as an integer
                        int intValue = Integer.parseInt(userInput);

                        // Now 'intValue' contains the integer value entered by the user
                        // You can use 'intValue' for calculations or comparisons

                        if (intValue == sum){
                            switch (oprng) {
                                case 1:
                                    sum = sum1 + sum2;
                                    txt_yon.setText(sum1 + " + " + sum2 + " = " + sum+ " :Correct");
                                    break;
                                case 2:
                                    sum = sum1 - sum2;
                                    txt_yon.setText(sum1 + " - " + sum2 + " = "+ sum+ " :Correct");
                                    break;
                                case 3:
                                    sum = sum1 * sum2;
                                    txt_yon.setText(sum1 + " x " + sum2 + " = "+ sum+ " :Correct");
                                    break;
                                default:
                                    // Handle unexpected value of oprng
                                    break;
                            };
                        }
                        else{
                            switch (oprng) {
                                case 1:
                                    sum = sum1 + sum2;
                                    txt_yon.setText(sum1 + " + " + sum2 + " = " + sum+ " :Incorrect");
                                    break;
                                case 2:
                                    sum = sum1 - sum2;
                                    txt_yon.setText(sum1 + " - " + sum2 + " = "+ sum+ " :Incorrect");
                                    break;
                                case 3:
                                    sum = sum1 * sum2;
                                    txt_yon.setText(sum1 + " x " + sum2 + " = "+ sum+ " :Incorrect");
                                    break;
                                default:
                                    // Handle unexpected value of oprng
                                    break;
                            };
                        }

                    } catch (NumberFormatException e) {
                        // Handle the case where the input is not a valid integer
                        // For example, display an error message or take appropriate action
                        Toast.makeText(MainActivity.this, "Invalid input. Please enter a valid number.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Handle the case where the input is empty
                    // For example, display an error message or take appropriate action
                    Toast.makeText(MainActivity.this, "Please enter a number.", Toast.LENGTH_SHORT).show();
                }

                sum1 = ThreadLocalRandom.current().nextInt(1, 100);
                sum2 = ThreadLocalRandom.current().nextInt(1, 100);
                oprng = ThreadLocalRandom.current().nextInt(1, 4); // Changed to include 3
                switch (oprng) {
                    case 1:
                        sum = sum1 + sum2;
                        Txt_Math_Output.setText(sum1 + " + " + sum2 + " = ?");
                        break;
                    case 2:
                        sum = sum1 - sum2;
                        Txt_Math_Output.setText(sum1 + " - " + sum2 + " = ?");
                        break;
                    case 3:
                        sum = sum1 * sum2;
                        Txt_Math_Output.setText(sum1 + " x " + sum2 + " = ?");
                        break;
                    default:
                        // Handle unexpected value of oprng
                        break;
                }




            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the next button click
                // Generate new random numbers and update the UI
                sum1 = ThreadLocalRandom.current().nextInt(1, 100);
                sum2 = ThreadLocalRandom.current().nextInt(1, 100);
                oprng = ThreadLocalRandom.current().nextInt(1, 4); // Changed to include 3
                switch (oprng) {
                    case 1:
                        sum = sum1 + sum2;
                        Txt_Math_Output.setText(sum1 + " + " + sum2 + " = ?");
                        txt_yon.setText("");
                        break;
                    case 2:
                        sum = sum1 - sum2;
                        Txt_Math_Output.setText(sum1 + " - " + sum2 + " = ?");
                        txt_yon.setText("");
                        break;
                    case 3:
                        sum = sum1 * sum2;
                        Txt_Math_Output.setText(sum1 + " x " + sum2 + " = ?");
                        txt_yon.setText("");
                        break;
                    default:
                        // Handle unexpected value of oprng
                        break;
                }
            }
        });
    }
}