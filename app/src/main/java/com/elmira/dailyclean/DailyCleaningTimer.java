package com.elmira.dailyclean;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DailyCleaningTimer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_cleaning_timer);

        TextView title = (TextView)findViewById(R.id.daily_cleaning_timer_text);
        title.setText("this is the timer activity");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        Menu bottomNavigationMenu = bottomNavigationView.getMenu();
        MenuItem bottomNavigationMenuItem = bottomNavigationMenu.getItem(2);
        bottomNavigationMenuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_all_cleaning_items:
                        Intent allCleaningItemsIntent = new Intent(DailyCleaningTimer.this, AllCleaningItems.class);
                        startActivity(allCleaningItemsIntent);
                        break;
                    case R.id.menu_daily_cleaning_item:
                        Intent dailyCleaningItemIntent = new Intent(DailyCleaningTimer.this, DailyCleaningItem.class);
                        startActivity(dailyCleaningItemIntent);
                        break;
                    case R.id.menu_daily_cleaning_timer:
                        break;
                }
                return true;
            }
        });
    }
}
