package com.elmira.dailyclean;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CleaningItemsMaintenanceService extends IntentService {
    ArrayList<Room> rooms = new ArrayList<>();
    HashMap<String, ArrayList<String>> cleaningItems = new HashMap();
    public CleaningItemsMaintenanceService() {
        super("CleaningItemsMaintenanceService");

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        HashSet<String> cleaningActions = new HashSet<>();
        cleaningActions.add("wash");
        cleaningActions.add("vacuum");
        Room myBedroom = new Room("my bedroom");
        myBedroom.addCleaningItem("floors", cleaningActions);
        rooms.add(myBedroom);
        // Do the task here
        Log.i("alarm", "inside CleaningItemsService - onHandleIntent");
        Set<String> actions = rooms.get(0).getCleaningItems().get("floors");
        for (String action : actions) {
            Log.i("alarm", action);
        }
    }
}
