package com.example.newsimple;

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

        mList.add(new TaskCard("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.", "Need house painted",R.drawable.card_bg, 1500));
        mList.add(new TaskCard("this is a description ", "Need house painted",R.drawable.card_bg, 100));
        mList.add(new TaskCard("this is a description ", "Need house painted",R.drawable.card_bg, 120));
        mList.add(new TaskCard("this is a description ", "Need house painted",R.drawable.card_bg, 50));
        mList.add(new TaskCard("this is a description ", "Need house painted",R.drawable.card_bg, 350));
        mList.add(new TaskCard("this is a description ", "Need house painted",R.drawable.card_bg, 10));
        mList.add(new TaskCard("this is a description ", "Need house painted",R.drawable.card_bg, 25));



        //Adapter adp = (Adapter) new Adepter(this, mList);
        recyclerView.setAdapter(new TaskCardAdapter(this, mList));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
