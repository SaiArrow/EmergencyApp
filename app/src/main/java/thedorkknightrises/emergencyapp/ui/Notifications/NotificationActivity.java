package thedorkknightrises.emergencyapp.ui.Notifications;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

import thedorkknightrises.emergencyapp.Constants;
import thedorkknightrises.emergencyapp.R;
import thedorkknightrises.emergencyapp.model.SosData;
import thedorkknightrises.emergencyapp.ui.maps.MapActivity;

/**
 * Created by DELL on 29/01/2017.
 */

public class NotificationActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    DatabaseReference root;
    NotificationListAdapter adapter;
    TextView no_item_textview;
    ArrayList<SosData> sosDatas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        root = FirebaseDatabase.getInstance().getReference();

        toolbar =(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);


        no_item_textview =(TextView)findViewById(R.id.no_item_textview);
        recyclerView = (RecyclerView)findViewById(R.id.notification_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(NotificationActivity.this));
        recyclerView.scrollToPosition(0);

    }

    @Override
    protected void onResume() {
        super.onResume();
        FetchAllNotifications task = new FetchAllNotifications();
        task.execute();
    }

    private void updateUI(final ArrayList<SosData> sosDatas){
        Collections.reverse(sosDatas);
        adapter = new NotificationListAdapter(getApplicationContext(),sosDatas);
        recyclerView.setAdapter(new NotificationListAdapter(getApplicationContext(),sosDatas));

        if (sosDatas.size() ==0) no_item_textview.setVisibility(View.VISIBLE);
        else no_item_textview.setVisibility(View.GONE);

        recyclerView.addOnItemTouchListener(
                new RecyclerViewItemClickListener(getApplicationContext(), recyclerView, new RecyclerViewItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        try{
                            SosData data = sosDatas.get(position);
                            Intent intent = new Intent(NotificationActivity.this, MapActivity.class);
                            intent.setAction("SOS");
                            intent.putExtra("lat",data.getUser_lat());
                            intent.putExtra("lon",data.getUser_long());
                            intent.putExtra("type",data.getUser_type());
                            intent.putExtra("name",data.getUser_name());
                            startActivity(intent);

                        }
                        catch(Exception e){
                            Toast.makeText(getApplicationContext(),"Data not loaded properly",Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                })
        );

    }

    private class FetchAllNotifications extends AsyncTask<String,Void,ArrayList<SosData>>{
        public FetchAllNotifications() {
        }

        @Override
        protected ArrayList<SosData> doInBackground(String... strings) {
            sosDatas = new ArrayList<>();
            DatabaseReference sosRef = root.child(Constants.SOS_ROOT);
            ValueEventListener listener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    sosDatas.clear();
                    for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                        String name = (String)snapshot.child(Constants.USER_NAME).getValue();
                        String type =(String) snapshot.child(Constants.USER_TYPE).getValue();
                        String lat =(String) snapshot.child(Constants.USER_LAT).getValue();
                        String lon =(String) snapshot.child(Constants.USER_LONG).getValue();

                        SosData data = new SosData(name,lon,lat,type);
                        sosDatas.add(data);
                    }
                    updateUI(sosDatas);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(getApplicationContext(),"onCancelled "+databaseError,Toast.LENGTH_SHORT).show();
                }
            };

            sosRef.addValueEventListener(listener);

            return sosDatas;
        }

        @Override
        protected void onPostExecute(ArrayList<SosData> sosDatas) {
            super.onPostExecute(sosDatas);
        }
    }


}
