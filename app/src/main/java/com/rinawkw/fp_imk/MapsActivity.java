package com.rinawkw.fp_imk;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap mMap, nMap;
    EditText etTempat;
    Button btnCari;
    Double dbLat, dbLng;

//    private static final LatLng ini = new LatLng(-7.352854, 112.857342);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btnCari = (Button) findViewById(R.id.cari);
        btnCari.setOnClickListener(operasi);
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
        // Add a marker in Sydney and move the camera
        LatLng its = new LatLng(-7.2819705, 112.795323);
        mMap.addMarker(new MarkerOptions().position(its).title("Marker in ITS").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(its, 16));
//        mMap.setOnMarkerClickListener(this);
    }

    View.OnClickListener operasi = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.cari:
                    gotoCari();
                    break;
            }
        }
    };

    private void gotoCari() {
        etTempat = (EditText) findViewById(R.id.tempat);
        Geocoder g = new Geocoder(getBaseContext());

        List<Address> daftar = null;
        try {
            daftar = g.getFromLocationName(etTempat.getText().toString(), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Address alamat = daftar.get(0);
        String nemuAlamat = alamat.getAddressLine(0);
        Double lintang = alamat.getLatitude();
        Double bujur = alamat.getLongitude();
        gotoPeta(lintang, bujur);
        Toast.makeText(getBaseContext(), "cari " + nemuAlamat, Toast.LENGTH_LONG).show();
    }

    private void gotoPeta(Double lat, Double lng) {
        LatLng Lokasibaru = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().
                position(Lokasibaru).
                title("Marker in  " + lat + ":" + lng));
        mMap.moveCamera(CameraUpdateFactory.
                newLatLngZoom(Lokasibaru, 16));
    }

//    @Override
//    public boolean onMarkerClick(Marker marker) {
//        Intent intentku = new Intent(getBaseContext(),Pangkalan2Activity.class);
//        startActivityForResult(intentku,0);
//        return false;
//    }
}
