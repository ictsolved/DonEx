package com.example.androidapp.shakyaruja.itsdc.activities;

import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.os.Bundle;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import com.example.androidapp.shakyaruja.itsdc.R;
import android.view.View;
import android.widget.TextView;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.graphics.PorterDuff;
import android.content.Intent;
import com.example.androidapp.shakyaruja.itsdc.activities.HomeActivity;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.ConnectionResult;
import android.util.Log;
import android.widget.Toast;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import android.support.annotation.NonNull;
import com.example.androidapp.shakyaruja.itsdc.activities.PlacesActivity;
import com.google.android.gms.maps.GoogleMap;
import java.util.ArrayList;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.CameraUpdateFactory;
import android.support.v4.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import com.google.android.gms.maps.model.MarkerOptions;

public class PlacesActivity extends AppCompatActivity {
  public LinearLayout mMainLayout;

  public Toolbar appBar;

  public GoogleMap mapView1;

  public ArrayList<Marker> mapView1Markers;

  @Override
  protected void onStart() {
    super.onStart();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.places);

    mMainLayout = (LinearLayout) findViewById(R.id.places);

    this.setup();
  }

  @Override
  protected void onStop() {
    super.onStop();
  }

  @Override
  protected void onResume() {
    super.onResume();

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      getWindow().setStatusBarColor(Color.parseColor("#FF3949AB"));
    }
  }

  public PlacesActivity getContext() {
    return this;
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }

  @Override
  protected void onPause() {
    super.onPause();
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
  }

  @Override
  public void onRequestPermissionsResult(
      int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
    switch (requestCode) {
      case 1000:
        {
          if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            try {
              PlacesActivity.this.mapView1.setMyLocationEnabled(true);
            } catch (SecurityException e) {
            }
          } else {
          }
        }
    }
  }

  public void initializeMap(GoogleMap m) {
    this.mapView1 = m;

    this.mapView1Markers = new ArrayList<Marker>();

    this.mapView1.setOnMapLongClickListener(
        new GoogleMap.OnMapLongClickListener() {
          @Override
          public void onMapLongClick(LatLng touchLocation) {}
        });

    this.mapView1.setOnMarkerClickListener(
        new GoogleMap.OnMarkerClickListener() {
          @Override
          public boolean onMarkerClick(Marker view) {
            final GoogleMap mapView = PlacesActivity.this.mapView1;
            return false;
          }
        });

    mapView1.getUiSettings().setZoomControlsEnabled(true);

    mapView1.getUiSettings().setZoomGesturesEnabled(true);

    mapView1.getUiSettings().setRotateGesturesEnabled(true);

    mapView1.setBuildingsEnabled(true);

    mapView1.setTrafficEnabled(true);

    mapView1.getUiSettings().setMyLocationButtonEnabled(true);

    mapView1.setMapType(GoogleMap.MAP_TYPE_NORMAL);

    mapView1.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(0, 0), 2));

    if (!(ActivityCompat.checkSelfPermission(
                PlacesActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED
        || ActivityCompat.checkSelfPermission(
                PlacesActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION)
            == PackageManager.PERMISSION_GRANTED)) {
      ActivityCompat.requestPermissions(
          PlacesActivity.this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1000);
    } else {
      try {
        this.mapView1.setMyLocationEnabled(true);
      } catch (SecurityException e) {
      }
    }

    Marker marker =
        PlacesActivity.this.mapView1.addMarker(
            new MarkerOptions()
                .title("Trisara Resturant and Bar")
                .position(new LatLng(27.720048904418945d, 85.31902313232422d)));

    PlacesActivity.this.mapView1Markers.add(marker);

    Marker marker1 =
        PlacesActivity.this.mapView1.addMarker(
            new MarkerOptions()
                .title("REEF Restaurant and Lounge Bar")
                .position(new LatLng(27.720048904418945d, 85.31902313232422d)));

    PlacesActivity.this.mapView1Markers.add(marker1);

    Marker marker2 =
        PlacesActivity.this.mapView1.addMarker(
            new MarkerOptions()
                .title("Fire and Ice Pizza")
                .position(new LatLng(27.720048904418945d, 85.31902313232422d)));

    PlacesActivity.this.mapView1Markers.add(marker2);

    Marker marker3 =
        PlacesActivity.this.mapView1.addMarker(
            new MarkerOptions()
                .title("Hotel Blue Horizon")
                .position(new LatLng(27.720048904418945d, 85.31902313232422d)));

    PlacesActivity.this.mapView1Markers.add(marker3);
  }

  private void setup() {
    appBar = (Toolbar) findViewById(R.id.app_bar6);

    PlacesActivity.this.setSupportActionBar(appBar);

    for (int i = 0; i < appBar.getChildCount(); ++i) {
      View child = appBar.getChildAt(i);
      if (child instanceof TextView) {
        child.setBackgroundColor(Color.TRANSPARENT);
        break;
      }
    }

    appBar.setNavigationIcon(ContextCompat.getDrawable(getContext(), R.drawable.back_btn_ffffffff));

    appBar
        .getNavigationIcon()
        .mutate()
        .setColorFilter(Color.parseColor("#FFFFFFFF"), PorterDuff.Mode.SRC_ATOP);

    appBar.setNavigationOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view1) {
            PlacesActivity activity = PlacesActivity.this;
            Intent transitionIntent = new Intent(activity, HomeActivity.class);
            activity.startActivity(transitionIntent);
            activity.overridePendingTransition(
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
          }
        });

    int playServicesConnectionResult =
        GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);

    if (playServicesConnectionResult != ConnectionResult.SUCCESS) {
      Log.d("DS", "API availability: " + playServicesConnectionResult);
      Toast.makeText(
              this, "Required Google Play Services Unavailable on this Device", Toast.LENGTH_LONG)
          .show();
      GoogleApiAvailability.getInstance()
          .getErrorDialog(this, playServicesConnectionResult, playServicesConnectionResult);
    } else {
      MapFragment mapFragment =
          (MapFragment) this.getFragmentManager().findFragmentById(R.id.map_view1);
      mapFragment.getMapAsync(
          new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap m) {
              PlacesActivity.this.initializeMap(m);
            }
          });
    }
  }
}
