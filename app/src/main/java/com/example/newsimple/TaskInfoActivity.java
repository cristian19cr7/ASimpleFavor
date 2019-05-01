package com.example.newsimple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.AppComponentFactory;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class TaskInfoActivity extends AppCompatActivity /*implements OnMapReadyCallback*/ {

    private GoogleMap mMap;
    public TaskCard task;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), EarnActivity.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_info);

        TextView tv = findViewById(R.id.detail_desc);
        TextView tv_header = findViewById(R.id.detailHeader);
        TextView tv_budget = findViewById(R.id.detailBudget);

        task = (TaskCard) getIntent().getSerializableExtra("taskInfo");
        tv.setText(task.getTaskDesc());
        tv_header.setText(task.getTaskHeader());
        tv_budget.setText("$ " + task.getTaskBudget());

//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
    }

//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//        LatLng location = new LatLng(task.getTaskAddressLat(), task.getTaskAddressLong());
//        mMap.addMarker(new MarkerOptions().position(location).title("Task location"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
//    }
}
