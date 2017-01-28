package thedorkknightrises.emergencyapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import thedorkknightrises.emergencyapp.R;

/**
 * Created by Admin on 29-01-2017.
 */
public class ActivityRouteDetails extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String action = getIntent().getAction();
        if (action.equals("Road"))
            setContentView(R.layout.activity_road);
        else if (action.equals("Plane"))
            setContentView(R.layout.activity_aeroplane);
        else {
            setContentView(R.layout.activity_train);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
}
