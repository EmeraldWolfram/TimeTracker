package com.test.ghiny.timetracker;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by GhinY on 29/04/2016.
 */
public class TimeTrackerAdapter extends CursorAdapter {

    public TimeTrackerAdapter(Context context, Cursor cursor){
        super(context, cursor);
    }

    public void bindView(View view, Context context, Cursor cursor){
        TextView timeView = (TextView) view.findViewById(R.id.time_view);
        TextView noteView = (TextView) view.findViewById(R.id.note_view);

        timeView.setText(cursor.getString(cursor.getColumnIndex("time")));
        noteView.setText(cursor.getString(cursor.getColumnIndex("notes")));
    }

    public View newView(Context context, Cursor cursor, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.time_item_list, parent, false);
        return view;
    }
}
