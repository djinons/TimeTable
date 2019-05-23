package com.djinons.schoolschedule;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class WeekViewCardViewHolder extends RecyclerView.ViewHolder {

    TextView classTV;
    TextView mondayTV;
    TextView tuesdayTV;
    TextView wednesdayTV;
    TextView thursdayTV;
    TextView fridayTv;

    public WeekViewCardViewHolder(@NonNull View itemView) {
        super(itemView);

        classTV = itemView.findViewById(R.id.class_tv_land);
        mondayTV = itemView.findViewById(R.id.monday_tv_land);
        tuesdayTV = itemView.findViewById(R.id.tuesday_tv_land);
        wednesdayTV = itemView.findViewById(R.id.wednesday_tv_land);
        thursdayTV = itemView.findViewById(R.id.thursday_tv_land);
        fridayTv = itemView.findViewById(R.id.friday_tv_land);
    }
}
