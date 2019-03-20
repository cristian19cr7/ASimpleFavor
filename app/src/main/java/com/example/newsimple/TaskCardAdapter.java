package com.example.newsimple;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class TaskCardAdapter extends RecyclerView.Adapter<TaskCardAdapter.myViewHolder> {

    private Context mContext;
    private List<TaskCard> mData;

    public TaskCardAdapter(Context context, List<TaskCard> data) {
        this.mContext = context;
        this.mData = data;
    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.list_card_layout, viewGroup,false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder myViewHolder, int i) {

        myViewHolder.cardImgV.setImageResource(mData.get(i).getBackground());
        myViewHolder.headerTV.setText(mData.get(i).getTaskHeader());
        myViewHolder.descTV.setText(mData.get(i).getTaskDesc());
        myViewHolder.budgetTV.setText(mContext.getString(R.string.dollar_sign) + mData.get(i).getTaskBudget());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView cardImgV;
        TextView headerTV, descTV, budgetTV;

        public myViewHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            cardImgV = itemView.findViewById(R.id.CardImgView);
            headerTV = itemView.findViewById(R.id.CardHeaderTV);
            descTV = itemView.findViewById(R.id.CardDescriptionTV);
            budgetTV = itemView.findViewById(R.id.CardBudgetTV);
        }

        @Override
        public void onClick(View v) {
            int i = getAdapterPosition();
            Toast.makeText(mContext,"view in detail"+ i, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(mContext, TaskInfoActivity.class);
            intent.putExtra("Task_desc",  mData.get(getAdapterPosition()).getTaskDesc());
            intent.putExtra("Task_Header", mData.get(getAdapterPosition()).getTaskHeader());
            intent.putExtra("Task_Budget", mData.get(getAdapterPosition()).getTaskBudget());
            mContext.startActivity(intent);
        }
    }
}
