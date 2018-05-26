package com.elmira.dailyclean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Room {
    private String name;
    private Map<String, Set<String>> cleaningItemsAndActions = new HashMap<>();

    public Room(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void addCleaningItem(String item, Set<String> cleaningActions) {
        cleaningItemsAndActions.put(item, cleaningActions);
    }

    public Map<String, Set<String>> getCleaningItems() {
        return cleaningItemsAndActions;
    }

    public Set<String> getItemCleaningActions(String item) {
        return cleaningItemsAndActions.get(item);
    }
}
