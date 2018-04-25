package com.elmira.dailyclean;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.design.widget.BottomNavigationView;
import android.widget.Toast;


public class AllCleaningItems extends AppCompatActivity {
    public static String EXTRA_DAILY_CLEANING_ITEM = "com.elmira.dailyclean.EXTRA_DAILY_CLEANING_ITEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_cleaning_items);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.action_all_cleaning_items:
                        Toast.makeText(AllCleaningItems.this, "Action - all cleaning items clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_daily_cleaning_item:
                        Toast.makeText(AllCleaningItems.this, "Action - daily cleaning item clicked", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
//        Intent intent = new Intent(this, DailyCleaningItem.class);
//        TextView textView = (TextView) findViewById(R.id.textView);
//        String randomCleaningItem = textView.getText().toString();
//        System.out.println("ALL ITEMS ==> randomCleaningItem: " + randomCleaningItem);
//        intent.putExtra(EXTRA_DAILY_CLEANING_ITEM, randomCleaningItem);
//        startActivity(intent);
    }
}
