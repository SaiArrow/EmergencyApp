package thedorkknightrises.emergencyapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        button=(Button)findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(SosActivity.this,EmergencyActivity.class);
                startActivity(myIntent);


            }
        });
        butto=(ImageButton)findViewById(R.id.button3);
        butto.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent myIntent2 = new Intent(SosActivity.this,SignInActivity.class);
                startActivity(myIntent2);
            }


        });

    }
}