package com.elmira.dailyclean;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class CleaningItemsMaintenanceService extends IntentService {

    public CleaningItemsMaintenanceService() {
        super("CleaningItemsMaintenanceService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("CleaningData", MODE_PRIVATE);
        Map<String, ?> sharedPreferencesData = sharedPreferences.getAll();
        Random random = new Random();
        int randomCleaningItemIndex = random.nextInt(sharedPreferencesData.size());
        String[] cleaningItems = new String[sharedPreferencesData.size()];
        Set<String> cleaningItemsSet = sharedPreferencesData.keySet();
        cleaningItems = cleaningItemsSet.toArray(cleaningItems);
        Log.i("onHandleIntent", cleaningItems[randomCleaningItemIndex]);
    }
}
