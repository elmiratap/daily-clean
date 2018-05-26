package com.elmira.dailyclean;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SecondLevelAdapter extends BaseExpandableListAdapter {
    private final Context context;
    private Room room;
    private Map<String, ?> sharedPreferencesData;
    private String roomName;
    private List<String> items; // need index-based access

    public SecondLevelAdapter(Context context, Map<String, ?> sharedPreferencesData, String roomName) {
        this.context = context;
        this.sharedPreferencesData = sharedPreferencesData;
        this.roomName = roomName;
        Gson gson = new Gson();
        String itemsAndActions = sharedPreferencesData.get(roomName).toString(); // TODO - sketch conversion
        room = gson.fromJson(itemsAndActions, Room.class);
        items = new ArrayList(room.getCleaningItems().keySet()); // TODO - may not work

//        Gson gson = new Gson();
//                String cleaningDetails = sharedPreferences.getString("myBedroom", "noData");
//                Room myRoom = gson.fromJson(cleaningDetails, Room.class);
//                System.out.println("cleaningDetails: " + cleaningDetails);
//                System.out.println("myRoom: " + myRoom.getName() + ", item1: " + myRoom.getCleaningItems().get("floors").get(0));

    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        List<String> cleaningActions = new ArrayList(room.getItemCleaningActions(items.get(groupPosition)));
        return cleaningActions.get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.drawer_list_item, parent, false);
        }
        TextView textListChild = (TextView) convertView.findViewById(R.id.lblListItem);
        textListChild.setText(childText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        try {
            return room.getItemCleaningActions(items.get(groupPosition)).size();
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public Object getGroup(int groupPosition) {
        return items.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return items.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.drawer_list_group_second, parent, false);
        }
        TextView listHeader = (TextView) convertView.findViewById(R.id.list_header);
        listHeader.setText(headerTitle);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
