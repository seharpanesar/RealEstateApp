package com.example.saas2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ServiceList extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button nextButton;
    ArrayList<String> names = new ArrayList<>(); //these items are passed on to next activity
    ArrayList<String> prices = new ArrayList<>(); //these items are passed on to next activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicelist);
        ArrayList<ExampleItem> exampleList = new ArrayList<>();

        exampleList.add(new ExampleItem(R.drawable.ic_android, "ADT", "Security", "Add", "$400"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio, "Brinks", "Security", "Add", "$200"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun, "Pool Guys", "Backyard", "Add", "$500"));
        exampleList.add(new ExampleItem(R.drawable.ic_star, "Bay Alarm", "Security", "Add", "$700"));
        exampleList.add(new ExampleItem(R.drawable.ic_soap, "Gardeners", "Lawn Care", "Add", "$70"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onAddClick(int position) {
                if (exampleList.get(position).getButtonText().equals("Add")) {
                    exampleList.get(position).setButtonText("Added");
                    names.add(exampleList.get(position).getText1());
                    prices.add(exampleList.get(position).getPrice());
                } else {
                    exampleList.get(position).setButtonText("Add");
                    names.add(exampleList.get(position).getText1());
                    prices.add(exampleList.get(position).getPrice());
                }
                mAdapter.notifyItemChanged(position);
            }
        });

        nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFinal();
            }
        });
    }

    private void openFinal() {
        Intent intent = new Intent(this, FinalConfirmation.class);
        intent.putExtra("names", names);
        intent.putExtra("prices", prices);
        startActivity(intent);
    }
}