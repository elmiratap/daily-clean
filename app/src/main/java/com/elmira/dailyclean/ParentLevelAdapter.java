package com.elmira.dailyclean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParentLevelAdapter extends BaseExpandableListAdapter {
    private final Context context;
    private Map<String, ?> sharedPreferencesData;
    private List<String> roomNames; // Need index-based access

    public ParentLevelAdapter(Context context, Map<String, ?> sharedPreferencesData) {
        this.context = context;
        this.sharedPreferencesData = sharedPreferencesData;
        roomNames = new ArrayList<>(sharedPreferencesData.keySet()); // TODO - hopefully this works; if not, add in a loop
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }


    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final CustomExpandableListView secondLevelExpandableListView = new CustomExpandableListView(this.context);
        String parentNode = (String) getGroup(groupPosition);
        secondLevelExpandableListView.setAdapter(new SecondLevelAdapter(this.context, sharedPreferencesData, parentNode));
        secondLevelExpandableListView.setGroupIndicator(null);
        return secondLevelExpandableListView;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition); // TODO maybe get something else here
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.drawer_list_group, parent, false);
        }
        TextView lblListHeader = (TextView) convertView.findViewById(R.id.list_header);
        lblListHeader.setText(headerTitle);
        return convertView;
    }

    @Override
    public int getGroupCount() {
        return roomNames.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return roomNames.get(groupPosition); // TODO - need to do something else here? get the name or something?
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
