package com.example.saas2;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirmation extends AppCompatActivity {
    private TextView address;
    private Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);


        address = findViewById(R.id.address);
        confirmButton = findViewById(R.id.confirmButton);

        //receives address from last activity

        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        if (bd != null) {
            String getAddress = (String) bd.get("address");
            address.setText("Property address: " + getAddress);
        }

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openServiceList();
            }
        });
    }

    private void openServiceList() {
        Intent intent = new Intent(this, ServiceList.class);
        //pass necessary data
        startActivity(intent);
    }
}