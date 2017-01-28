package thedorkknightrises.emergencyapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import thedorkknightrises.emergencyapp.R;

public class SosActivity extends AppCompatActivity {

    Button button;
    ImageButton butto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);

        Toolbar toolbar =(Toolbar)findViewById(R.id.activity_sos_toolbar);
        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.svg_clear_white_36px);

        button=(Button)findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(SosActivity.this,EmergencyActivity.class);
                startActivity(myIntent);


            }
        });





    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                Intent myIntent2 = new Intent(SosActivity.this,SignInActivity.class);
                startActivity(myIntent2);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}