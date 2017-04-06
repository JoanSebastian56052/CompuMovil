package lab2.gr11_20171.compumovil.udea.edu.co.apigooglemaps;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Google_Maps_Activity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private MarkerOptions mu;
    private EditText ubicacion;
    private Button buscarUbicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google__maps_);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        ubicacion=(EditText) findViewById(R.id.Ubicacion);
        buscarUbicacion=(Button) findViewById(R.id.buscarUbicacion);
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
        mu = new MarkerOptions();

        // Add a marker in Sydney and move the camera
        LatLng udea = new LatLng(6.26631172, -75.56797240);
        LatLng udeaNew = new LatLng(6.266455, -75.566545);
        mMap.addMarker(new MarkerOptions().position(udea).title("Marker in UdeA"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(udea));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(udea, 19));

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        } else {
            Toast.makeText(getApplicationContext(), "Revisa los permisos de ubicacion!!!", Toast.LENGTH_SHORT).show();
        }
        CircleOptions circleOptions = new CircleOptions().center(new LatLng(udea.latitude, udea.longitude)).radius(2000);
        Circle circle = mMap.addCircle(circleOptions);
        //mMap.addMarker(new MarkerOptions().position(udeaNew).title("Marcador"));
        buscarUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.addMarker(mu.position(new LatLng(6.266455, -75.566545)).title(ubicacion.getText().toString()));
            }
        });

    }
}
