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
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Calendar;

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
        scheduleAlarm();
//        Intent intent = getIntent();
//        String randomCleaningItem = intent.getStringExtra(AllCleaningItems.EXTRA_DAILY_CLEANING_ITEM);
//        System.out.println("DAILY ITEM ==> randomCleaningItem: " + randomCleaningItem);
//        TextView textView = findViewById(R.id.textView);
//        textView.setText(randomCleaningItem);
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
