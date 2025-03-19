package com.devdroid.emergency2;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Home Button
        Button homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, HomePage.class));
            }
        });

        // Add Family and Friends Button
        Button addFamilyButton = findViewById(R.id.addFamilyButton);
        addFamilyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, AddFamilyActivity.class);
                startActivity(intent);
            }
        });

        // Share Live Location Button
        Button shareLocationButton = findViewById(R.id.shareLocationButton);
        shareLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, ShareLocationActivity.class));
            }
        });

        // Online FIR Button
        Button onlineFirButton = findViewById(R.id.onlineFirButton);
        onlineFirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, OnlineFIRActivity.class));
            }
        });

        //Other button
        Button otherButton = findViewById(R.id.otherButton);
        otherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this,OtherActivity.class));
            }
        });



        // Exit Button
        Button exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity(); // Closes the app completely
            }
        });
    }
}
