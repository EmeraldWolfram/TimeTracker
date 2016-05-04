package com.test.ghiny.timetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class TimeTrack extends AppCompatActivity {

    public TimeTrackerAdapter timeTrackerAdapter;
    public static final int ADD_TIME_REQ_CODE = 3;
    public TimeListDatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_track);

        databaseHelper      = new TimeListDatabaseHelper(getApplicationContext());

        ListView listView   = (ListView) findViewById(R.id.times_list);
        timeTrackerAdapter  = new TimeTrackerAdapter(getApplicationContext(), databaseHelper.getAllTimeRecords());
        listView.setAdapter(timeTrackerAdapter);
    }

    public void onAdd(View view){
        Intent intent = new Intent(getApplicationContext(), AddTime.class);
        startActivityForResult(intent, ADD_TIME_REQ_CODE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == ADD_TIME_REQ_CODE && resultCode == RESULT_OK){
            Bundle extract = data.getExtras();
            if(extract != null) {
                String newTime = extract.getString("time");
                String newNote = extract.getString("note");

                databaseHelper.saveTimeRecord(newTime, newNote);
                timeTrackerAdapter.changeCursor(databaseHelper.getAllTimeRecords());
            }
        }
    }

}
