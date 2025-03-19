package com.devdroid.emergency2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OTPpage extends AppCompatActivity {

    EditText otp1, otp2, otp3, otp4;
    Button btnSubmitOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otppage);

        // Initialize UI elements
        otp1 = findViewById(R.id.otp1);
        otp2 = findViewById(R.id.otp2);
        otp3 = findViewById(R.id.otp3);
        otp4 = findViewById(R.id.otp4);
        btnSubmitOtp = findViewById(R.id.btnSubmitOtp);

        // Set up OTP auto focus behavior
        setupOtpFields();

        // Button Click Listener
        btnSubmitOtp.setOnClickListener(v -> {
            String enteredOtp = otp1.getText().toString().trim() +
                    otp2.getText().toString().trim() +
                    otp3.getText().toString().trim() +
                    otp4.getText().toString().trim();

            if (TextUtils.isEmpty(enteredOtp) || enteredOtp.length() < 4) {
                Toast.makeText(OTPpage.this, "Enter a valid 4-digit OTP", Toast.LENGTH_SHORT).show();
            } else {
                // Navigate to Home Page (Next Screen)
                Intent intent = new Intent(OTPpage.this, HomePage.class);
                startActivity(intent);
                finish(); // Close OTP screen
            }
        });
    }

    // Set up automatic focus movement for OTP fields
    private void setupOtpFields() {
        EditText[] otpFields = {otp1, otp2, otp3, otp4};

        for (int i = 0; i < otpFields.length; i++) {
            final int index = i;
            otpFields[i].addTextChangedListener(new OtpWatcher(otpFields, index));
        }
    }

    // Hide keyboard when user taps outside the input fields
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View view = getCurrentFocus();
            if (view instanceof EditText) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
                view.clearFocus();
            }
        }
        return super.dispatchTouchEvent(event);
    }
}
