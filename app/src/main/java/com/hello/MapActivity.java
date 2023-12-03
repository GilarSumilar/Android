package com.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        // Koordinat lokasi (latitude dan longitude) sebagai contoh
        double latitude = 37.7749;
        double longitude = -122.4194;

        // Membuat Uri dari koordinat lokasi
        Uri geoLocation = Uri.parse("geo:" + latitude + "," + longitude);

        // Memanggil metode showMap untuk menampilkan peta
        showMap(geoLocation);
    }

    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}