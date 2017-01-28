package thedorkknightrises.emergencyapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import thedorkknightrises.emergencyapp.R;

/**
 * Created by Admin on 28-01-2017.
 */
public class SafetyActivity extends AppCompatActivity {
    ImageView img,img2,img1,img3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.safetytips);

        img=(ImageView) findViewById(R.id.imageView2);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }});
        img1=(ImageView) findViewById(R.id.imageView3);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }});
        img2=(ImageView) findViewById(R.id.imageView4);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }});

        img3=(ImageView) findViewById(R.id.imageView5);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }});
    }
}


