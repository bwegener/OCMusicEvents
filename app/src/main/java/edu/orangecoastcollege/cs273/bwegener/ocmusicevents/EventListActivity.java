package edu.orangecoastcollege.cs273.bwegener.ocmusicevents;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class EventListActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        // Define a built-in list adapter for this ListActivity:
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicEvent.titles));
    }
}
