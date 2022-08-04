package com.richa.fitness_partner.Adapter;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.richa.fitness_partner.R;

public class Excercise_deails_adapter extends RecyclerView.Adapter<Excercise_deails_adapter.MyViewHolder> {

    Activity context;
    int position_older;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        ImageView imageViewIcon;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.tvExcersice);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.ivExcersice);
        }
    }

    public Excercise_deails_adapter(Activity mContext, int positionold) {
        this.context = mContext;
        position_older = positionold;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_excersice_details, parent, false);


        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        ImageView imageView = holder.imageViewIcon;
        if (position_older == 0) {
            if (listPosition == 0) {
                holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.plank));
                holder.textViewName.setText("Plank");
            } else if (listPosition == 1) {
                holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.reverse_crunches));
                holder.textViewName.setText("Reverse Crunches");
            } else if (listPosition == 2) {
                holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.dead_bug));
                holder.textViewName.setText("Dead bug");
            } else if (listPosition == 3) {
                holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.mountain));
                holder.textViewName.setText("Mountain climber");
            } else if (listPosition == 4) {
                holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.lag_up));
                holder.textViewName.setText("Leg Raise");
            }
        } else if (position_older == 1) {
            if (listPosition == 0) {
                holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.abs_rollout));
                holder.textViewName.setText("Abs roll-out");
            } else if (listPosition == 1) {
                holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.hanging));
                holder.textViewName.setText("Bird-dog");
            } else if (listPosition == 2) {
                holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.bird_dog));
                holder.textViewName.setText("Hanging Knee Raise");
            } else if (listPosition == 3) {
                holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.plank));
                holder.textViewName.setText("Plank");
            } else if (listPosition == 4) {
                holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.reverse_crunches));
                holder.textViewName.setText("Reverse Crunches");
            }
        } else if (position_older == 2) {
            if (listPosition == 0) {
                holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.globlet));
                holder.textViewName.setText("Goblet Squat");
            } else if (listPosition == 1) {
                holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.band));
                holder.textViewName.setText("Banded Lateral Walk");
            } else if (listPosition == 2) {
                holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.single_lag));
                holder.textViewName.setText("Single-Leg Deadlift");
                holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.sumo));
                holder.textViewName.setText("Sumo Deadlift");
            } else if (listPosition == 4) {
                holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.stability));
                holder.textViewName.setText("Stability Ball Bridge");
            }

        } else if (position_older == 3) {
            if (listPosition == 0) {
                holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.power));
                holder.textViewName.setText("Power Grip");
            } else if (listPosition == 1) {
                holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.pintch));
                holder.textViewName.setText("Pinch");
            } else if (listPosition == 2) {
                holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.thum_extension));
                holder.textViewName.setText("Thumb Extension");
            } else if (listPosition == 3) {
                holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.flextion));
                holder.textViewName.setText("Finger Flexion");
            } else if (listPosition == 4) {
                holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.rotation));
                holder.textViewName.setText("Thumb Roll");
            }

        } /*else if (position_older == 4) {
            if (listPosition == 0) {
                holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.abs_rollout));
                holder.textViewName.setText("Abs roll-out");
            } else if (listPosition == 1) {
                holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.hanging));
                holder.textViewName.setText("Bird-dog");
            } else if (listPosition == 2) {
                holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.bird_dog));
                holder.textViewName.setText("Hanging Knee Raise");
            } else if (listPosition == 3) {
                holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.plank));
                holder.textViewName.setText("Plank");
            } else if (listPosition == 4) {
                holder.imageViewIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.reverse_crunches));
                holder.textViewName.setText("Reverse Crunches");
            }

        }*/


    }

    @Override
    public int getItemCount() {
        return 5;
    }
}