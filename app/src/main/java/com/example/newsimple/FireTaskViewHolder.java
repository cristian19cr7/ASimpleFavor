package com.example.newsimple;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class FireTaskViewHolder extends RecyclerView.ViewHolder {
    public TextView headerTV, descTV, budgetTV;

    public FireTaskViewHolder(@NonNull View itemView) {
        super(itemView);

        headerTV = itemView.findViewById(R.id.CardHeaderTV);
        descTV = itemView.findViewById(R.id.CardDescriptionTV);
        budgetTV = itemView.findViewById(R.id.CardBudgetTV);
    }
}