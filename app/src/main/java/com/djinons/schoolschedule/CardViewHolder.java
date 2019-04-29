package com.djinons.schoolschedule;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CardViewHolder extends RecyclerView.ViewHolder {

    TextView nameTV;
    ImageView editIV;
    ImageView deleteIV;

    public CardViewHolder(@NonNull View view) {
        super(view);

        nameTV = view.findViewById(R.id.nameTV);
        editIV = view.findViewById(R.id.imgEdit);
        deleteIV = view.findViewById(R.id.imgRemove);
    }
}
