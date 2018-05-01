package com.elmira.dailyclean;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    HashMap<String, ArrayList<String>> cleaningItems = new HashMap<>();

    public void addCleaningItem(String item, ArrayList<String> cleaningActions) {
        cleaningItems.put(item, cleaningActions);
    }

    public HashMap<String, ArrayList<String>> getCleaningItems() {
        return cleaningItems;
    }
}
