package thedorkknightrises.emergencyapp.ui;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import thedorkknightrises.emergencyapp.R;

public class SOSMapActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;
    double latitude, longitude;
    private int LOCATION_PERMISSION_CODE = 125;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sosmap);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        final Context context = this;
        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ActivitySos2.class);
                i.putExtra("lat", latitude);
                i.putExtra("lon", longitude);
                startActivity(i);
            }
        });
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                Toast.makeText(this, getText(R.string.location_permission_rationale), Toast.LENGTH_LONG).show();


            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission_group.LOCATION}, LOCATION_PERMISSION_CODE);

                // LOCATION_PERMISSION_CODE is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
            Toast.makeText(this, getText(R.string.location_access),Toast.LENGTH_LONG).show();
        } else mMap.setMyLocationEnabled(true);
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String bestProvider = locationManager.getBestProvider(criteria, true);
        if (mMap.getMyLocation() != null) {
            onLocationChanged(mMap.getMyLocation());
        }
        locationManager.requestLocationUpdates(bestProvider, 20000, 0, this);
        if (mMap.getMyLocation() != null) {
            latitude = mMap.getMyLocation().getLatitude();
            longitude = mMap.getMyLocation().getLongitude();
            mMap.animateCamera(CameraUpdateFactory.zoomTo(13));
        }
        if (getIntent().getAction()!= null && getIntent().getAction().equals("SOS")) {
            double lat = getIntent().getDoubleExtra("lat",0);
            double lon = getIntent().getDoubleExtra("lon",0);
            if (lat!=0 && lon!=0) {
                MarkerOptions markerOptions = new MarkerOptions();
                LatLng latLng = new LatLng(lat, lon);
                markerOptions.position(latLng);
                if (getIntent().getStringExtra("type") != null)
                    markerOptions.title(getIntent().getStringExtra("type"));
                mMap.addMarker(markerOptions);
            }
        }
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
