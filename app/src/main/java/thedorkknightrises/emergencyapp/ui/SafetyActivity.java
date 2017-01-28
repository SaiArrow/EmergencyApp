package thedorkknightrises.emergencyapp.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
    Context context = this;
    Intent i = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.safetytips);

        img=(ImageView) findViewById(R.id.imageView2);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=pwyOCAt5FNc"));
                context.startActivity(i);
            }});
        img1=(ImageView) findViewById(R.id.imageView3);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=RE8Iy9BsU_M"));
                context.startActivity(i);
            }});
        img2=(ImageView) findViewById(R.id.imageView4);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=YKgIYadRGjA"));
                context.startActivity(i);
            }});

        img3=(ImageView) findViewById(R.id.imageView5);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=G57gCZGEPK0"));
                context.startActivity(i);

            }});
    }
}


