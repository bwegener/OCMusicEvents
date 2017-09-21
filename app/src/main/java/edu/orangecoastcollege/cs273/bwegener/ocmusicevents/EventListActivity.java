package edu.orangecoastcollege.cs273.bwegener.ocmusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * This is where the title, details, and list activity
 * are all created.
 *
 * @author Brian Wegener
 * @version 1.0
 *
 * Created on 9.21.2017
 */
public class EventListActivity extends ListActivity {


    /**
     * This is what happens when the app is first loaded,
     * create the set list adapter and create a new array adapter.
     *
     * @param savedInstanceState what happens when app is first launched.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Content has already been set for the ListActivity
        // setContentView(R.layout.activity_event_list);

        // Define a built-in list adapter for this ListActivity:
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicEvent.titles));
    }

    /**
     * This allows the user to click items on the list.
     * Creates the title, details, and the intent which connects
     * the text to the event details activity.
     *
     * @param l the list view
     * @param v the view that happens after click
     * @param position the position of the array
     * @param id the id
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        // Use the position in the list to look up in the titles array
        String title = MusicEvent.titles[position];
        String details = MusicEvent.details[position];

        // Create an Intent to go to the DetailsActivity with title and details sent
        Intent detailsIntent = new Intent(this, EventDetailsActivity.class);

        detailsIntent.putExtra("title", title);
        detailsIntent.putExtra("details", details);


        startActivity(detailsIntent);
    }
}
