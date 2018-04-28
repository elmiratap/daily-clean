package com.elmira.dailyclean;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver{

    public static final int REQUEST_CODE = 12345;
    public static final String ACTION = "com.elmira.dailyclean.alarm"; // TODO rename?

    @Override
    public void onReceive(Context context, Intent intent) { // TODO - why pass in intent?
        Log.i("alarm", "inside onReceive");
        Intent i = new Intent(context, CleaningItemsMaintenanceService.class);
        i.putExtra("foo", "bar");
        context.startService(i);
    }
}
