package com.elmira.dailyclean;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    private HashMap<String, ArrayList<String>> cleaningItemsAndActions = new HashMap<>();

    public void addCleaningItem(String item, ArrayList<String> cleaningActions) {
        cleaningItemsAndActions.put(item, cleaningActions);
    }

    public HashMap<String, ArrayList<String>> getCleaningItems() {
        return cleaningItemsAndActions;
    }
}
