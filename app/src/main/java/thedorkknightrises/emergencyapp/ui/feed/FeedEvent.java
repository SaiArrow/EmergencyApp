package thedorkknightrises.emergencyapp.ui.feed;

/**
 * Created by ysr on 1/28/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import thedorkknightrises.emergencyapp.R;


public class FeedEvent extends AppCompatActivity {
    TextView title, news_title, news_description;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_news);
        setSupportActionBar(toolbar);
        title = (TextView) findViewById(R.id.toolbar_title);
        toolbar.setTitle("Researchers Clear 'Patient Zero' From AIDS Origin Story");
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FeedEvent.super.onBackPressed();
            }
        });
        Intent i=getIntent();
        String title_text=i.getStringExtra("title");
        String desc=i.getStringExtra("desc");
        news_title = (TextView) findViewById(R.id.news_title);
        news_description = (TextView) findViewById(R.id.news_description);
        img = (ImageView) findViewById(R.id.Newspic);
        title.setText(title_text);
        news_title.setText(title_text);
        news_description.setText(desc);
        img.setImageResource(R.drawable.batman);
    }

}
