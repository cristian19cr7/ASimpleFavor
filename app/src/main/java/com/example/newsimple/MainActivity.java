package com.example.newsimple;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.Timestamp;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv1, tv2;
        Button EarnBtn, PostBtn;
        tv1 = (TextView) findViewById(R.id.MainEarnTV);
        tv2 = (TextView) findViewById(R.id.MainPostTV);

        tv1.setText("Find A Task To\nEarn Cash Now");
        tv2.setText("Post A Task You\nNeed Done Now");

        EarnBtn = (Button) findViewById(R.id.MainEarnButton);
        PostBtn = (Button) findViewById(R.id.MainPostButton);

        EarnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EarnActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
            }
        });

        PostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PostActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
            }
        });

        //hideNavBar();

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        hideNavBar();
//    }
//
//    private void hideNavBar() {
//
//        this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN|
//                                                                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
//                                                                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
//                                                                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
//                                                                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//        );
//    }
}
