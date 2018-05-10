package com.elmira.dailyclean;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    private String name;
    private HashMap<String, ArrayList<String>> cleaningItemsAndActions = new HashMap<>();

    public Room(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void addCleaningItem(String item, ArrayList<String> cleaningActions) {
        cleaningItemsAndActions.put(item, cleaningActions);
    }

    public HashMap<String, ArrayList<String>> getCleaningItems() {
        return cleaningItemsAndActions;
    }
}
