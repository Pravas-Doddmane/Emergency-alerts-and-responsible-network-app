package com.devdroid.emergency2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ShareLocationActivity extends AppCompatActivity {

    ImageButton backButton;
    Button shareButton, stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_location);

        backButton = findViewById(R.id.backButton);
        shareButton = findViewById(R.id.shareButton);
        stopButton = findViewById(R.id.stopButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShareLocationActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });


        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ShareLocationActivity.this, "Live location sharing is started", Toast.LENGTH_SHORT).show();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ShareLocationActivity.this, "Live location sharing is stoped", Toast.LENGTH_SHORT).show();
            }
        });




    }
}