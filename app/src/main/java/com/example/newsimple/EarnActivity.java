package com.example.newsimple;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EarnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earn);

        RecyclerView recyclerView = findViewById(R.id.EarnRV);
        List<TaskCard> mList = new ArrayList<>();

        //TaskDBHelper taskDBHelper = new TaskDBHelper(getApplicationContext());

        mList.add(new TaskCard("this is a description ", "Need house painted.", 123.133, -123.22, "10:00am", "11:00am", "April 20, 2019",R.drawable.card_bg, 120, "ASASFASFAS@emial.com", "234234234234"));
        mList.add(new TaskCard("this is a description ", "Need house painted.", 123.133, -123.22, "10:00am", "11:00am", "April 20, 2019",R.drawable.card_bg, 120, "ASASFASFAS@emial.com", "234234234234"));
        mList.add(new TaskCard("this is a description ", "Need house painted.", 123.133, -123.22, "10:00am", "11:00am", "April 20, 2019",R.drawable.card_bg, 120, "ASASFASFAS@emial.com", "234234234234"));
        mList.add(new TaskCard("this is a description ", "Need house painted.", 123.133, -123.22, "10:00am", "11:00am", "April 20, 2019",R.drawable.card_bg, 120, "ASASFASFAS@emial.com", "234234234234"));
        mList.add(new TaskCard("this is a description ", "Need house painted.", 123.133, -123.22, "10:00am", "11:00am", "April 20, 2019",R.drawable.card_bg, 120, "ASASFASFAS@emial.com", "234234234234"));
        mList.add(new TaskCard("this is a description ", "Need house painted.", 123.133, -123.22, "10:00am", "11:00am", "April 20, 2019",R.drawable.card_bg, 120, "ASASFASFAS@emial.com", "234234234234"));
        mList.add(new TaskCard("this is a description ", "Need house painted.", 123.133, -123.22, "10:00am", "11:00am", "April 20, 2019",R.drawable.card_bg, 120, "ASASFASFAS@emial.com", "234234234234"));
        mList.add(new TaskCard("this is a description ", "Need house painted.", 123.133, -123.22, "10:00am", "11:00am", "April 20, 2019",R.drawable.card_bg, 120, "ASASFASFAS@emial.com", "234234234234"));
        mList.add(new TaskCard("this is a description ", "Need house painted.", 123.133, -123.22, "10:00am", "11:00am", "April 20, 2019",R.drawable.card_bg, 120, "ASASFASFAS@emial.com", "234234234234"));
        mList.add(new TaskCard("this is a description ", "Need house painted.", 123.133, -123.22, "10:00am", "11:00am", "April 20, 2019",R.drawable.card_bg, 120, "ASASFASFAS@emial.com", "234234234234"));
        mList.add(new TaskCard("this is a description ", "Need house painted.", 123.133, -123.22, "10:00am", "11:00am", "April 20, 2019",R.drawable.card_bg, 120, "ASASFASFAS@emial.com", "234234234234"));




        //Adapter adp = (Adapter) new Adepter(this, mList);
        recyclerView.setAdapter(new TaskCardAdapter(this, mList));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
