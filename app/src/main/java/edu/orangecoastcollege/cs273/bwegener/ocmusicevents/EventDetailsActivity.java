package edu.orangecoastcollege.cs273.bwegener.ocmusicevents;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * This creates the event details so once the user has clicked
 * the list item they get brought to this event.
 *
 * @author Brian Wegener
 * @version 1.0
 *
 * Created on 9.21.2017
 */
public class EventDetailsActivity extends AppCompatActivity {

    /**
     * This is what happens when the user has clicked the item
     * and is sent to the event details activity.
     *
     * @param savedInstanceState what happens when this view is first loaded.
     */
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
        ImageView eventImageView = (ImageView) findViewById(R.id.eventImageView);

        // Set the text of the text views
        titleTextView.setText(title);
        detailsTextView.setText(details);

        // Use the Asset Manager to retrieve a file (image)
        AssetManager am = getAssets();
        String imageFileName = title.replace(" ", "").concat(".jpeg");

        // Use the Asset Manage to open a stream to the file name
        try {
            InputStream stream = am.open(imageFileName);
            Drawable image = Drawable.createFromStream(stream, title);
            eventImageView.setImageDrawable(image);
        } catch (IOException e) {
            Log.e("OC Music Events", "Error loading image: " + imageFileName, e);
        }

    }

    /**
     * This is what happens when the back button
     * is clicked and sent back to the event list.
     *
     * @param v this is the view that is sent.
     */
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
