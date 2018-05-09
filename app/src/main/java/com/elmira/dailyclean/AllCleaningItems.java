package com.elmira.dailyclean;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class AllCleaningItems extends AppCompatActivity {
//    public static String EXTRA_DAILY_CLEANING_ITEM = "com.elmira.dailyclean.EXTRA_DAILY_CLEANING_ITEM";
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_cleaning_items);

        listView = (ListView)findViewById(R.id.all_cleaning_items_list_view);
        String[] dummyData = {"one", "two", "three", "four", "five"};
        String[] listItems = new String[dummyData.length];
        for (int i=0; i<listItems.length; i++) {
            listItems[i] = dummyData[i];
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(adapter);

        FloatingActionButton floatingActionButton = findViewById(R.id.floating_action_button);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File directory;
                String fileName = "myfile";
                String fileContents = "myfile contents";
                if (fileName.isEmpty()) {
                    directory = getFilesDir();
                } else {
                    directory = getDir(fileName, MODE_PRIVATE);
                }
                File[] files = directory.listFiles();

                try {
                    FileOutputStream outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
                    outputStream.write(fileContents.getBytes());
                    outputStream.close();
                    Toast.makeText(getBaseContext(),"you added a file!", Toast.LENGTH_SHORT).show();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        floatingActionButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                try {
                    FileInputStream fileIn=openFileInput("myfile");
                    InputStreamReader InputRead= new InputStreamReader(fileIn);

                    char[] inputBuffer= new char[100];
                    String s="";
                    int charRead;

                    while ((charRead=InputRead.read(inputBuffer))>0) {
                        // char to string conversion
                        String readstring=String.copyValueOf(inputBuffer,0,charRead);
                        s +=readstring;
                    }
                    InputRead.close();
                    Toast.makeText(getBaseContext(),"you read a file!", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        Menu bottomNavigationMenu = bottomNavigationView.getMenu();
        MenuItem bottomNavigationMenuItem = bottomNavigationMenu.getItem(0);
        bottomNavigationMenuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_all_cleaning_items:
                        break;
                    case R.id.menu_daily_cleaning_item:
                        Intent dailyCleaningItemIntent = new Intent(AllCleaningItems.this, DailyCleaningItem.class);
                        startActivity(dailyCleaningItemIntent);
                        break;
                    case R.id.menu_daily_cleaning_timer:
                        Intent dailyCleaningTimerIntent = new Intent(AllCleaningItems.this, DailyCleaningTimer.class);
                        startActivity(dailyCleaningTimerIntent);
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
