package com.elmira.dailyclean;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import com.google.gson.Gson;

public class AllCleaningItems extends AppCompatActivity {
    final Context context = this;
    //    public static String EXTRA_DAILY_CLEANING_ITEM = "com.elmira.dailyclean.EXTRA_DAILY_CLEANING_ITEM";
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_cleaning_items);

//        listView = (ListView) findViewById(R.id.all_cleaning_items_list_view);
//        String[] dummyData = {"one", "two", "three", "four", "five"};
//        String[] listItems = new String[dummyData.length];
//        for (int i = 0; i < listItems.length; i++) {
//            listItems[i] = dummyData[i];
//        }
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems);
//        listView.setAdapter(adapter);


        final SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("CleaningData", MODE_PRIVATE);

        // TODO - get data --> ArrayAdapter
        Map<String, ?> allSharedPrefData = sharedPreferences.getAll();
        System.out.println("getting shared prefs");
        for (Map.Entry<String, ?> roomAndItemsToClean : allSharedPrefData.entrySet()) {
            System.out.println("Shared Pref: " + roomAndItemsToClean.getKey() + ": " + roomAndItemsToClean.getValue());
        }

        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expandable_list_view_parent);
        if (expandableListView != null) {
            ParentLevelAdapter parentLevelAdapter = new ParentLevelAdapter(this, allSharedPrefData);
            expandableListView.setAdapter(parentLevelAdapter);
        }

//                        Gson gson = new Gson();
//                String cleaningDetails = sharedPreferences.getString("myBedroom", "noData");
//                Room myRoom = gson.fromJson(cleaningDetails, Room.class);
//                System.out.println("cleaningDetails: " + cleaningDetails);
//                System.out.println("myRoom: " + myRoom.getName() + ", item1: " + myRoom.getCleaningItems().get("floors").get(0));
//                return true;

        FloatingActionButton floatingActionButton = findViewById(R.id.floating_action_button);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddItemDialogFragment addItemDialogFragment = new AddItemDialogFragment();
                addItemDialogFragment.show(getSupportFragmentManager(), "AddItemDialogFragment");
//                final Dialog dialog = new Dialog(context);
//                dialog.setContentView(R.layout.dialog_add_item);
//                dialog.setTitle("Add Item");
//                Room myBedroom = new Room("my bedroom");
//                System.out.println("my bedroom name: " + myBedroom.getName());
//                ArrayList<String> cleaningActions = new ArrayList<>();
//                cleaningActions.add("wash");
//                cleaningActions.add("vacuum");
//                myBedroom.addCleaningItem("floors", cleaningActions);
//
//                SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
//                Gson gson = new Gson();
//                String json = gson.toJson(myBedroom);
//                sharedPreferencesEditor.putString("myBedroom", json);
//                sharedPreferencesEditor.apply();
//                Toast.makeText(getBaseContext(), "you added a file!", Toast.LENGTH_SHORT).show();


            }
        });
//        floatingActionButton.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                Gson gson = new Gson();
//                String cleaningDetails = sharedPreferences.getString("myBedroom", "noData");
//                Room myRoom = gson.fromJson(cleaningDetails, Room.class);
//                System.out.println("cleaningDetails: " + cleaningDetails);
//                System.out.println("myRoom: " + myRoom.getName() + ", item1: " + myRoom.getCleaningItems().get("floors").get(0));
//                return true;
//            }
//        });

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
