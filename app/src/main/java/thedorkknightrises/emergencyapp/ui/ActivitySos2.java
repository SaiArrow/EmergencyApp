package thedorkknightrises.emergencyapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import thedorkknightrises.emergencyapp.R;

/**
 * Created by Admin on 29-01-2017.
 */
public class ActivitySos2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button b5,b6,b7,b8,b9;
        b5=(Button)findViewById(R.id.button);
        b6=(Button)findViewById(R.id.button4);
        b7=(Button)findViewById(R.id.button5);
        b8=(Button)findViewById(R.id.button6);
        b9=(Button)findViewById(R.id.button7);

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent5 = new Intent(ActivitySos2.this,EmergencyActivity.class);
                startActivity(myIntent5);


            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent6 = new Intent(ActivitySos2.this,EmergencyActivity.class);
                startActivity(myIntent6);


            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent7 = new Intent(ActivitySos2.this,EmergencyActivity.class);
                startActivity(myIntent7);


            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent8 = new Intent(ActivitySos2.this,EmergencyActivity.class);
                startActivity(myIntent8);


            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent3 = new Intent(ActivitySos2.this,EmergencyActivity.class);
                startActivity(myIntent3);


            }
        });
    }
}