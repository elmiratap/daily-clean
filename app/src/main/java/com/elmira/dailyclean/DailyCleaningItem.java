package com.elmira.dailyclean;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DailyCleaningItem extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_cleaning_item);
//        Intent intent = getIntent();
//        String randomCleaningItem = intent.getStringExtra(AllCleaningItems.EXTRA_DAILY_CLEANING_ITEM);
//        System.out.println("DAILY ITEM ==> randomCleaningItem: " + randomCleaningItem);
//        TextView textView = findViewById(R.id.textView);
//        textView.setText(randomCleaningItem);
    }
}
