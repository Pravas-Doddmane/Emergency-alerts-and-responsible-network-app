package com.devdroid.emergency2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OtherActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EmergencyAdapter adapter;
    List<EmergencyContact> contactList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        findViewById(R.id.backButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OtherActivity.this, MenuActivity.class));
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize emergency contacts
        contactList = new ArrayList<>();
        contactList.add(new EmergencyContact("Police", "100"));
        contactList.add(new EmergencyContact("Ambulance", "108"));
        contactList.add(new EmergencyContact("Fire", "101"));
        contactList.add(new EmergencyContact("Traffic Police", "103"));
        contactList.add(new EmergencyContact("CyberCrime", "1930"));
        contactList.add(new EmergencyContact("Electricity Helpline", "1912"));
        contactList.add(new EmergencyContact("Railway", "139"));
        contactList.add(new EmergencyContact("LPG Leakage", "1960"));
        contactList.add(new EmergencyContact("Childline", "1098"));
        contactList.add(new EmergencyContact("Woman's helpline", "1090"));
        contactList.add(new EmergencyContact("Coast Guard", "1962"));


        adapter = new EmergencyAdapter(contactList, this);
        recyclerView.setAdapter(adapter);





    }
}