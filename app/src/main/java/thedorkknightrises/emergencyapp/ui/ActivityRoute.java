package thedorkknightrises.emergencyapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import thedorkknightrises.emergencyapp.R;

/**
 * Created by Admin on 29-01-2017.
 */
public class ActivityRoute extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ImageButton b1, b2, b3;
        b1 = (ImageButton) findViewById(R.id.imageButton2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent39 = new Intent(ActivityRoute.this, ActivityRouteDetails.class);
                myIntent39.setAction("Road");
                startActivity(myIntent39);


            }
        });

        b2 = (ImageButton) findViewById(R.id.imageButton4);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent39 = new Intent(ActivityRoute.this, ActivityRouteDetails.class);
                myIntent39.setAction("Plane");
                startActivity(myIntent39);


            }
        });


        b3 = (ImageButton) findViewById(R.id.imageButton3);

        b3.setOnClickListener(new View.OnClickListener()

                              {
                                  @Override
                                  public void onClick(View view) {
                                      Intent myIntent39 = new Intent(ActivityRoute.this, ActivityRouteDetails.class);
                                      myIntent39.setAction("Railway");
                                      startActivity(myIntent39);


                                  }
                              }

        );
    }
}


