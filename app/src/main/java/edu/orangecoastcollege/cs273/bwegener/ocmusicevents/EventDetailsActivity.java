package edu.orangecoastcollege.cs273.bwegener.ocmusicevents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class EventDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        // Get the data out of the Intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String details = intent.getStringExtra("details");

        // Create references to the text views
        TextView titleTextView = (TextView) findViewById(R.id.eventTitleTextView);
        TextView detailsTextView = (TextView) findViewById(R.id.eventDetailsTextView);

        // Set the text of the text views
        titleTextView.setText(title);
        detailsTextView.setText(details);

    }

    protected void goBackToList(View v)
    {
        // Terminates the current activity (terminate the details activity)
        finish();

        /*
        Intent activityIntent = new Intent(this, EventListActivity.class);
        startActivity(activityIntent);
        */
    }


}
