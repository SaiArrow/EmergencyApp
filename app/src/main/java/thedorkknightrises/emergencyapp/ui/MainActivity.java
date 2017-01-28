package thedorkknightrises.emergencyapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;

import thedorkknightrises.emergencyapp.R;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    final String LOG ="MAINACTIVITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    private void checkUserSignedIn(){
        //to check if the user is signed in
        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser() != null){

        }
        else{
            Log.e(LOG,"is NULL");
            Intent intent = new Intent(MainActivity.this,SignInActivity.class);
            //startActivity(intent);
        }
    }

}
