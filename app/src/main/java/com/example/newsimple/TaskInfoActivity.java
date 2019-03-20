package com.example.newsimple;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewDebug;
import android.widget.TextView;

public class TaskInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_info);
        TextView tv = findViewById(R.id.detail_desc);
        TextView tv_header = findViewById(R.id.detailHeader);
        TextView tv_budget = findViewById(R.id.detailBudget);

        tv.setText(getIntent().getStringExtra("Task_desc"));
        tv_header.setText(getIntent().getStringExtra("Task_Header"));
        tv_budget.setText("$ " + getIntent().getIntExtra("Task_Budget", 0));
    }
}
