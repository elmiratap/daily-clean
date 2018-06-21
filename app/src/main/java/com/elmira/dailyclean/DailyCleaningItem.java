package com.elmira.dailyclean;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Calendar;

public class DailyCleaningItem extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_cleaning_item);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        Menu bottomNavigationMenu = bottomNavigationView.getMenu();
        MenuItem bottomNavigationMenuItem = bottomNavigationMenu.getItem(1);
        bottomNavigationMenuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_all_cleaning_items:
                        Intent allCleaningItemsIntent = new Intent(DailyCleaningItem.this, AllCleaningItems.class);
                        startActivity(allCleaningItemsIntent);
                        break;
                    case R.id.menu_daily_cleaning_item:
                        break;
                    case R.id.menu_daily_cleaning_timer:
                        Intent dailyCleaningTimerIntent = new Intent(DailyCleaningItem.this, DailyCleaningTimer.class);
                        startActivity(dailyCleaningTimerIntent);
                        break;
                }
                return true;
            }
        });
        scheduleAlarm();
    }

    public void scheduleAlarm() {
        Log.i("alarm", "schedule alarm");
        Intent alarmIntent = new Intent(getApplicationContext(), AlarmReceiver.class);
        AlarmManager alarmManager = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        final PendingIntent pendingAlarmIntent = PendingIntent.getBroadcast(this, AlarmReceiver.REQUEST_CODE, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + 1000L,
                1000L, pendingAlarmIntent);
//        calendar.set(Calendar.HOUR_OF_DAY, 6);
//        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingAlarmIntent);
    }

    public void cancelAlarm() {
        Intent alarmIntent = new Intent(getApplicationContext(), AlarmReceiver.class);
        final PendingIntent pendingAlarmIntent = PendingIntent.getBroadcast(this, AlarmReceiver.REQUEST_CODE, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pendingAlarmIntent);
    }
}
