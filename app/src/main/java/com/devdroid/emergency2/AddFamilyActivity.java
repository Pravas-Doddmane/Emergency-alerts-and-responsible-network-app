package com.devdroid.emergency2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddFamilyActivity extends AppCompatActivity {
    EditText editTextNumber;
    LinearLayout numberListLayout;
    Button addbutton;
    ImageButton backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_family);

        editTextNumber = findViewById(R.id.editTextNumber);
        addbutton = findViewById(R.id.addButton);
        numberListLayout = findViewById(R.id.numberListLayout);
        backbutton = findViewById(R.id.backButton);

        backbutton.setOnClickListener(v -> {
            Intent intent = new Intent(AddFamilyActivity.this, MenuActivity.class);
            startActivity(intent);
        });

        addbutton.setOnClickListener(v -> addNumberToList());
    }

    private void addNumberToList() {
        String number = editTextNumber.getText().toString().trim();

        if (number.length() != 10) {
            Toast.makeText(this, "Enter a valid 10-digit number", Toast.LENGTH_SHORT).show();
            return;
        }

        // Row Layout
        LinearLayout rowLayout = new LinearLayout(this);
        rowLayout.setOrientation(LinearLayout.HORIZONTAL);
        rowLayout.setPadding(10, 10, 10, 10);
        rowLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        // Phone Number TextView (Dark & Bold)
        TextView textViewNumber = new TextView(this);
        textViewNumber.setText(number);
        textViewNumber.setTextSize(22);
        textViewNumber.setTextColor(getResources().getColor(android.R.color.black)); // Dark color
        textViewNumber.setTypeface(null, Typeface.BOLD); // Bold text
        textViewNumber.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 2));
        textViewNumber.setPadding(10, 0, 10, 0);

        // Call Button (Larger & Closer)
        ImageButton callButton = new ImageButton(this);
        callButton.setImageResource(R.drawable.baseline_call_24);
        callButton.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        LinearLayout.LayoutParams callParams = new LinearLayout.LayoutParams(150, 150); // Bigger button
        callParams.setMargins(5, 0, 5, 0); // Less gap
        callButton.setLayoutParams(callParams);
        callButton.setOnClickListener(v -> {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:" + number));
            startActivity(callIntent);
        });

        // Delete Button (Larger & Closer)
        ImageButton deleteButton = new ImageButton(this);
        deleteButton.setImageResource(R.drawable.baseline_delete_24);
        deleteButton.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        LinearLayout.LayoutParams deleteParams = new LinearLayout.LayoutParams(150, 150); // Bigger button
        deleteParams.setMargins(5, 0, 5, 0); // Less gap
        deleteButton.setLayoutParams(deleteParams);
        deleteButton.setOnClickListener(v -> numberListLayout.removeView(rowLayout));

        // Add Views to Row
        rowLayout.addView(textViewNumber);
        rowLayout.addView(callButton);
        rowLayout.addView(deleteButton);

        // Add Row to Layout
        numberListLayout.addView(rowLayout);
        editTextNumber.setText("");
    }
}
