package com.example.newsimple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
            }
        });

        PostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PostActivity.class);
                startActivity(intent);
            }
        });

    }
}
