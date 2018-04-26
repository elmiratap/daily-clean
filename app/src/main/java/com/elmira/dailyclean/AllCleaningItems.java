package com.elmira.dailyclean;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AllCleaningItems extends AppCompatActivity {
    public static String EXTRA_DAILY_CLEANING_ITEM = "com.elmira.dailyclean.EXTRA_DAILY_CLEANING_ITEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_cleaning_items);

//        Intent intent = new Intent(this, DailyCleaningItem.class);
//        TextView textView = (TextView) findViewById(R.id.textView);
//        String randomCleaningItem = textView.getText().toString();
//        System.out.println("ALL ITEMS ==> randomCleaningItem: " + randomCleaningItem);
//        intent.putExtra(EXTRA_DAILY_CLEANING_ITEM, randomCleaningItem);
//        startActivity(intent);
    }
}
