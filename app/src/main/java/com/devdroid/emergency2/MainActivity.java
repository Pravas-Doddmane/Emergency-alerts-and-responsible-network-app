package com.devdroid.emergency2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtPhoneNumber;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPhoneNumber = findViewById(R.id.etPhoneNumber);
        btnLogin = findViewById(R.id.btnLogin);

        // Hide keyboard when tapping outside EditText
        findViewById(R.id.appLogo).setOnClickListener(v -> hideKeyboard());
        findViewById(R.id.etPhoneNumber).setOnClickListener(v -> hideKeyboard());

        btnLogin.setOnClickListener(v -> {
            String phoneNumber = edtPhoneNumber.getText().toString().trim();
            if (phoneNumber.isEmpty() || phoneNumber.length() < 10) {
                Toast.makeText(MainActivity.this, "Enter a valid phone number", Toast.LENGTH_SHORT).show();
            } else {
                // Move to new page (OTPpage)
                Intent intent = new Intent(MainActivity.this, OTPpage.class);
                intent.putExtra("PHONE_NUMBER", phoneNumber);
                startActivity(intent);
            }
        });
    }

    // Hide keyboard when clicking outside EditText
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (v instanceof EditText) {
                hideKeyboard();
            }
        }
        return super.dispatchTouchEvent(event);
    }

    // Method to hide keyboard
    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
