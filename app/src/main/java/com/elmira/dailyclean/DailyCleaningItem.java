package com.elmira.dailyclean;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class DailyCleaningItem extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_cleaning_item);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_all_cleaning_items:
                        Toast.makeText(DailyCleaningItem.this, "Action - all cleaning items clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_daily_cleaning_item:
                        Toast.makeText(DailyCleaningItem.this, "Action - daily cleaning item clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_timer:
                        Toast.makeText(DailyCleaningItem.this, "Action - timer clicked", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
//        Intent intent = getIntent();
//        String randomCleaningItem = intent.getStringExtra(AllCleaningItems.EXTRA_DAILY_CLEANING_ITEM);
//        System.out.println("DAILY ITEM ==> randomCleaningItem: " + randomCleaningItem);
//        TextView textView = findViewById(R.id.textView);
//        textView.setText(randomCleaningItem);
    }
}
