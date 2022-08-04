package com.richa.fitness_partner.Adapter;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.richa.fitness_partner.Interface.OnexcerciseClick;
import com.richa.fitness_partner.R;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    OnexcerciseClick onexcerciseClick;
    Activity context;
    private MyViewHolder holder;
    private int listPosition;


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.tvExcersice);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.ivExcersice);
        }
    }

    public CustomAdapter(Activity mContext) {
        this.context = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_excersice, parent, false);


        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, @SuppressLint("RecyclerView") final int listPosition) {
        this.holder = holder;
        this.listPosition = listPosition;

        TextView textViewName = holder.textViewName;
        ImageView imageView = holder.imageViewIcon;
        if (listPosition == 0) {
            holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.stomach));
            holder.textViewName.setText("Stomach");
        } else if (listPosition == 1) {
            holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.abs));
            holder.textViewName.setText("Abs");
        } else if (listPosition == 2) {
            holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.lags));
            holder.textViewName.setText("Legs");
        } else if (listPosition == 3) {
            holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.hand));
            holder.textViewName.setText("Hands");
        } /*else if (listPosition == 4) {
            holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.back));
            holder.textViewName.setText("Back");
        }*/
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onexcerciseClick.onclickexc(listPosition);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 4;
    }
    public void onclickexcersice(OnexcerciseClick onexcerciseClick1)
    {
        onexcerciseClick=onexcerciseClick1;
    }
}