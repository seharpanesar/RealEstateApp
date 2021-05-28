package com.example.saas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private Button startBtn;
    private EditText address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // checking if activity is opened because it needs to be edited

        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        if (bd != null) {
            String getAddress = (String) bd.get("address");
            address.setText(getAddress);
        }

        startBtn = (Button) findViewById(R.id.startBtn);
        address = (EditText) findViewById(R.id.address);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConfirmation();
            }
        });
    }

    // goes to confirmation

    private void openConfirmation() {
        Intent intent = new Intent(this, Confirmation.class);
        intent.putExtra("address", address.getText().toString());
        startActivity(intent);
    }
}