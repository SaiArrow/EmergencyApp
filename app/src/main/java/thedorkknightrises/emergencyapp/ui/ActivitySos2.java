package thedorkknightrises.emergencyapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import thedorkknightrises.emergencyapp.Constants;
import thedorkknightrises.emergencyapp.R;
import thedorkknightrises.emergencyapp.model.SosData;

/**
 * Created by Admin on 29-01-2017.
 */
public class ActivitySos2 extends AppCompatActivity {

    //String type;

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
                updateToFirebase("fire");
                finish();
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateToFirebase("tsunami");
                finish();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateToFirebase("terror_attack");
                finish();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateToFirebase("flood");
                finish();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateToFirebase("earthquake");
                finish();
            }
        });
    }

    public void updateToFirebase(String type){

        DatabaseReference root;
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user == null){
            //not signed in
            Toast.makeText(getApplicationContext(),"not signed in",Toast.LENGTH_SHORT).show();
        }
        else {
            String user_name = user.getDisplayName();
            double lat = getIntent().getDoubleExtra("lat",0);
            double lon = getIntent().getDoubleExtra("lon",0);
            SosData sosData = new SosData(user_name,Double.toString(lat),Double.toString(lon),type);
            HashMap<String, Object> sosHashmap = sosData.getHashMap();
            root = FirebaseDatabase.getInstance().getReference();
            String sosDatasKey = root.child(Constants.SOS_ROOT).push().getKey();

            HashMap<String, Object> updateHashmap = new HashMap<>();
            updateHashmap.put("/" + Constants.SOS_ROOT + "/" + sosDatasKey, sosHashmap);

            root.updateChildren(updateHashmap, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    if (databaseError != null) {
                        Toast.makeText(getApplicationContext(), "Error: " + databaseError, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}