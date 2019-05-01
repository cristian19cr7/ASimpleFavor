package com.example.newsimple;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class PostActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    public static final String TAG = "PlaceAutocomplete";
    EditText postTime, postEndtime;
    public EditText postHeader, postDescription, postPay, postEmail, postPhone;
    public TextView postHeadTV, postDescriptionTV, postDateTimeTV;
    public Button postBtn, postDateBtn;
    boolean timeStartEndFlag = true; // true is startTime false is endTime
    LatLng placeLocation;
    FirebaseDatabase database;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        this.overridePendingTransition(0, 1);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        postTime = findViewById(R.id.postStartTime);
        postEndtime = findViewById(R.id.postEndTime);
        postHeader = findViewById(R.id.postHeaderInput);
        postHeadTV =findViewById(R.id.postTVHeader);
        postDescription = findViewById(R.id.postDescrip);
        postDescriptionTV = findViewById(R.id.postDescripTV);
        postDateBtn = findViewById(R.id.postDateBtn);
        postDateTimeTV = findViewById(R.id.postDateTimeTV);
        postPay = findViewById(R.id.postPayout);
        postEmail = findViewById(R.id.postEmail);
        postPhone = findViewById(R.id.postPhone);
        postBtn = findViewById(R.id.postBtnSubmit);
        database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference().child("Task Posts");

        postDescription.setGravity(0);
        postTime.setFocusable(false);
        postTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeStartEndFlag = true;
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });

        postEndtime.setFocusable(false);
        postEndtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeStartEndFlag = false;
                DialogFragment timepickerEnd = new TimePickerFragment();
                timepickerEnd.show(getSupportFragmentManager(), "time picker end");
            }
        });

        PlacesAPIInit();

        // Initialize the AutocompleteSupportFragment.
        AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
                getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment);

        // Specify the types of place data to return.
        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME,Place.Field.LAT_LNG));

        // Set up a PlaceSelectionListener to handle the response.
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                //Get info about the selected place.
                Log.i(TAG, "Place: " + place.getName() + ", " + place.getId() + ", " + place.getLatLng());
                placeLocation = place.getLatLng();
            }

            @Override
            public void onError(Status status) {
                //Handle the error.
                Log.i(TAG, "An error occurred: " + status);
            }
        });

        postDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datepicker = new DatePickerFragment();
                datepicker.show(getSupportFragmentManager(), "DatePicker");
            }
        });


        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmailValid(postEmail.getText().toString())){
                    DatabaseReference ref = myRef.push();
                    ref.child("Header").setValue(postHeader.getText().toString());
                    ref.child("Description").setValue(postDescription.getText().toString());
                    ref.child("addressLat").setValue(placeLocation.latitude);
                    ref.child("addressLong").setValue(placeLocation.longitude);
                    ref.child("Date").setValue(postDateBtn.getText().toString());
                    ref.child("startTime").setValue(postTime.getText().toString());
                    ref.child("endTime").setValue(postEndtime.getText().toString());
                    ref.child("budget").setValue(Integer.parseInt(String.valueOf(postPay.getText())));
                    ref.child("Email").setValue(postEmail.getText().toString());
                    ref.child("phone").setValue(postPhone.getText().toString());
                    startActivity(new Intent(getApplicationContext(), EarnActivity.class));
                    overridePendingTransition(0, 0);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"email is invalid.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void PlacesAPIInit(){
        // Initialize Places.
        Places.initialize(getApplicationContext(), "api key here google places");

        // Create a new Places client instance.
        PlacesClient placesClient = Places.createClient(this);
    }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        postDateBtn.setText(currentDate);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        if(timeStartEndFlag){
            if(minute < 10){

                if(hourOfDay > 12){
                    postTime.setText((hourOfDay -12)+ ":0" + minute + " pm");

                }else if(hourOfDay == 12){
                    postTime.setText(hourOfDay + ":0" + minute + " pm");
                }
                else if(hourOfDay == 0){
                    postTime.setText(12 + ":0" + minute + " am");
                }
                else{
                    postTime.setText(hourOfDay + ":0" + minute + " am");
                }
            }else{
                if(hourOfDay > 12){
                    postTime.setText((hourOfDay -12)+ ":" + minute + " pm");

                }else if(hourOfDay == 12){
                    postTime.setText(hourOfDay + ":" + minute + " pm");
                }
                else if(hourOfDay == 0){
                    postTime.setText(12 + ":" + minute + " am");
                }
                else{
                    postTime.setText(hourOfDay + ":" + minute + " am");
                }
            }
        }else{
            if(minute < 10){

                if(hourOfDay > 12){
                    postEndtime.setText((hourOfDay -12)+ ":0" + minute + " pm");

                }else if(hourOfDay == 12){
                    postEndtime.setText(hourOfDay + ":0" + minute + " pm");
                }
                else if(hourOfDay == 0){
                    postEndtime.setText(12 + ":0" + minute + " am");
                }
                else{
                    postEndtime.setText(hourOfDay + ":0" + minute + " am");
                }
            }else{
                if(hourOfDay > 12){
                    postEndtime.setText((hourOfDay -12)+ ":" + minute + " pm");

                }else if(hourOfDay == 12){
                    postEndtime.setText(hourOfDay + ":" + minute + " pm");
                }
                else if(hourOfDay == 0){
                    postEndtime.setText(12 + ":" + minute + " am");
                }
                else{
                    postEndtime.setText(hourOfDay + ":" + minute + " am");
                }
            }
        }

    }
}
