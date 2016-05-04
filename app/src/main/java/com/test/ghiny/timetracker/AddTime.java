package com.test.ghiny.timetracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by GhinY on 01/05/2016.
 */
public class AddTime extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_entry);
    }

    public void onCancel(View view){
        Intent intent = getIntent();
        this.setResult(RESULT_CANCELED, intent);
        finish();
    }

    public void onSave(View view){
        Intent intent = getIntent();
        EditText inputTime = (EditText)findViewById(R.id.input_time);
        EditText inputNote = (EditText)findViewById(R.id.input_note);

        intent.putExtra("time", inputTime.getText().toString());
        intent.putExtra("note", inputNote.getText().toString());

        this.setResult(RESULT_OK, intent);
        finish();
    }

}
