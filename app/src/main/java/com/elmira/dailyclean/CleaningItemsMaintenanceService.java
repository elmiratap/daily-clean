package com.elmira.dailyclean;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class CleaningItemsMaintenanceService extends IntentService {

    public CleaningItemsMaintenanceService() {
        super("CleaningItemsMaintenanceService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // Do the task here
        Log.i("alarm", "inside CleaningItemsService - onHandleIntent");
    }
}
