package com.devdroid.emergency2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ImageButton menuButton = findViewById(R.id.menuButton);
        ImageButton helpButton = findViewById(R.id.helpButton);
        Button sosButton = findViewById(R.id.sosButton);

        // SOS Button - Call Emergency Number
        sosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iDial = new Intent(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel:112"));
                startActivity(iDial);
            }
        });

        // Navigate to Menu Page
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        // Navigate to Help Page
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, AboutUsActivity.class);
                startActivity(intent);
            }
        });
    }
}
