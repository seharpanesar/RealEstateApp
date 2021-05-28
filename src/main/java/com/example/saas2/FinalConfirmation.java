package com.example.saas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FinalConfirmation extends AppCompatActivity {
    TextView totalPrice;
    ArrayList<String> names;
    ArrayList<String> prices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_confirmation);

        //receives address from last activity

        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        names = bd.getStringArrayList("names");
        prices = bd.getStringArrayList("prices");

        // Filling and adapting list

        ListView list = findViewById(R.id.list);

        HashMap<String, String> namePrices = new HashMap<>();

        for (int i = 0; i < names.size(); i++) {
            namePrices.put(names.get(i), prices.get(i));
        }

        List<HashMap<String, String>> listItems = new ArrayList<>();

        SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.list_item,
                new String[]{"First Line", "Second Line"}, new int[]{R.id.text1, R.id.text2});

        Iterator it = namePrices.entrySet().iterator();

        while (it.hasNext()) {
            HashMap<String, String> resultsMap = new HashMap<>();
            Map.Entry pair = (Map.Entry) it.next();
            resultsMap.put("First Line", pair.getKey().toString());
            resultsMap.put("Second Line", pair.getValue().toString());
            listItems.add(resultsMap);
        }

        list.setAdapter(adapter);

        // filling price

        setPrice();

    }

    private void setPrice() {
        totalPrice = findViewById(R.id.totalPrice);
        int priceAmount = 0;
        for (String price: prices) {
            String priceNoDollarSign = price.replace("$","");
            priceAmount += Integer.parseInt(priceNoDollarSign);
        }

        totalPrice.setText("Price: $" + priceAmount);
    }
}