

package thedorkknightrises.emergencyapp.ui.feed;

/**
 * Created by ysr on 1/28/2017.
 */
        import thedorkknightrises.emergencyapp.ui.MainActivity;
        import android.content.Intent;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.DividerItemDecoration;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.support.v7.widget.Toolbar;
        import android.view.View;

        import java.util.ArrayList;
        import thedorkknightrises.emergencyapp.R;

public class FeedActivity extends AppCompatActivity {
    String[] s ={"Algeria: Cold wave - Emergency Plan of Action (EPoA) DREF Operation ","Algeria has been suffering from a cold wave that began on 16 January 2017. As of 20 January it became clear that additional support would be needed and the Algerian Red Crescent (ARCS) requested DREF support on 20 January.","Gov. Edwards updates Louisiana flood recovery status: Months to go, billions still needed","State leaders are moving forward with a plan that would direct about $1.3 billion to help homeowners rebuild from historic floods that swept Louisiana last year. But it could still be months before those housing programs are up and running, and leaders say even more money is needed from Congress to help the state fully recover.","FEMA: Fire victims won't lose benefits by applying for disaster relief","Survivors of the Sevier County wildfires will not lose Social Security benefits, pay additional taxes or have to give up income-based benefit programs if they accept federal disaster assistance, according to a news release Friday from the Federal Emergency Management Association."};

            RecyclerView newsRecyclerView = (RecyclerView)findViewById(R.id.news_recycler_view);


    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_news);

    LinearLayoutManager linearLayoutManager;
    RecyclerAdapterNews recyclerAdapterNews;

    ArrayList<FeedItem> FeedItemArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);


        toolbar.setNavigationIcon(R.drawable.ic_cancel);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.print("Navigation On Click");
                Intent intent = new Intent(FeedActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        toolbar.setTitle("News");
        toolbar.setTitleTextColor(Color.WHITE);


        int i = 0;
        FeedItem FeedItem = new FeedItem(s[i], s[i + 1], R.drawable.coldwave);
        FeedItemArrayList.add(FeedItem);
        i = 2;
        FeedItem FeedItem1 = new FeedItem(s[i], s[i + 1], R.drawable.flood);
        FeedItemArrayList.add(FeedItem1);
        i = 4;
        FeedItem FeedItem2 = new FeedItem(s[i], s[i + 1], R.drawable.fire);
        FeedItemArrayList.add(FeedItem2);
        recyclerAdapterNews = new RecyclerAdapterNews(getApplicationContext(), FeedItemArrayList);


        linearLayoutManager = new LinearLayoutManager(FeedActivity.this);
        newsRecyclerView.setAdapter(recyclerAdapterNews);
        newsRecyclerView.setLayoutManager(linearLayoutManager);
        newsRecyclerView.addItemDecoration(new DividerItemDecoration(FeedActivity.this, DividerItemDecoration.HORIZONTAL));


    }

}

