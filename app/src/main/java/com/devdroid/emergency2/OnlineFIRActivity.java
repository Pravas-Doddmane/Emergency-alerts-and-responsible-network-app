package com.devdroid.emergency2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OnlineFIRActivity extends AppCompatActivity {

    EditText nameInput, phoneInput, addressInput, descriptionInput;
    Button uploadButton, submitButton;
    ImageButton backButton;
    Uri fileUri;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_firactivity);

        backButton = findViewById(R.id.backButton);
        nameInput = findViewById(R.id.nameInput);
        phoneInput = findViewById(R.id.phoneInput);
        addressInput = findViewById(R.id.addressInput);
        descriptionInput = findViewById(R.id.descriptionInput);
        uploadButton = findViewById(R.id.uploadButton);
        submitButton = findViewById(R.id.submitButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnlineFIRActivity.this, MenuActivity.class);
                startActivity(intent);

            }
        });
        ActivityResultLauncher<String> filePicker = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                uri -> {
                    if (uri != null) {
                        fileUri = uri;
                        Toast.makeText(this, "File selected successfully!", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        // Upload button click event
        uploadButton.setOnClickListener(v -> filePicker.launch("image/*"));


        submitButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString().trim();
            String phone = phoneInput.getText().toString().trim();
            String address = addressInput.getText().toString().trim();
            String description = descriptionInput.getText().toString().trim();

            if (name.isEmpty() || phone.isEmpty() || address.isEmpty() || description.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Your details have been submitted", Toast.LENGTH_LONG).show();
            finish(); // Goes back to the previous page
        });





    }
}