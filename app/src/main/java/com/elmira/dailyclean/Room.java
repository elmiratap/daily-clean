package com.elmira.dailyclean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Room {
    private String name;
    private HashMap<String, HashSet<String>> cleaningItemsAndActions = new HashMap<>();

    public Room(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void addCleaningItem(String item, HashSet<String> cleaningActions) {
        cleaningItemsAndActions.put(item, cleaningActions);
    }

    public HashMap<String, HashSet<String>> getCleaningItems() {
        return cleaningItemsAndActions;
    }
}
