package com.djinons.schoolschedule;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class OneDayViewCardViewHolder extends RecyclerView.ViewHolder {

    TextView cardClassNumTV;
    TextView cardStartEndAMTV;
    TextView cardStartEndPMTV;
    TextView cardClassNameTV;

    public OneDayViewCardViewHolder(@NonNull View itemView) {
        super(itemView);

        cardClassNumTV = itemView.findViewById(R.id.card_class_num);
        cardClassNameTV = itemView.findViewById(R.id.card_class_name);
        cardStartEndAMTV = itemView.findViewById(R.id.card_startEndAM);
        cardStartEndPMTV = itemView.findViewById(R.id.card_startEndPM);
    }
}
