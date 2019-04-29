package com.example.newsimple;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;


public class EarnActivity extends AppCompatActivity {
    public RecyclerView recyclerView;
    public ArrayList<TaskCard> arrayList;
    public DatabaseReference mDatabase;
    public FirebaseRecyclerOptions<TaskCard> options;
    public FirebaseRecyclerAdapter<TaskCard, FireTaskViewHolder> adapter;
    Query query;

    @Override
    protected void onStart() {
        adapter.startListening();
        super.onStart();
    }

    @Override
    protected void onStop() {
        adapter.stopListening();
        super.onStop();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        this.overridePendingTransition(0, 0);
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earn);
        recyclerView = findViewById(R.id.EarnRV);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        arrayList = new ArrayList<>();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Task Posts");
        query = FirebaseDatabase.getInstance().getReference().child("Task Posts");
        mDatabase.keepSynced(true);
        options =  new FirebaseRecyclerOptions.Builder<TaskCard>().setQuery(query, new SnapshotParser<TaskCard>() {
            @NonNull
            @Override
            public TaskCard parseSnapshot(@NonNull DataSnapshot snapshot) {
                return new TaskCard(snapshot.child("Header").getValue().toString(),
                        snapshot.child("Description").getValue().toString(),
                        Integer.parseInt(snapshot.child("budget").getValue().toString()));
            }
        }).build();

        adapter = new FirebaseRecyclerAdapter<TaskCard, FireTaskViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FireTaskViewHolder holder, int position, @NonNull TaskCard model) {
                holder.descTV.setText(model.getTaskDesc());
                holder.headerTV.setText(model.getTaskHeader());
                String temp = Integer.toString(model.getTaskBudget());
                holder.budgetTV.setText(temp);
            }

            @NonNull
            @Override
            public FireTaskViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                return new FireTaskViewHolder(LayoutInflater.from(EarnActivity.this).inflate(R.layout.list_card_layout,viewGroup, false));
            }
        };

        recyclerView.setAdapter(adapter);
    }

}
