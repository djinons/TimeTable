package com.djinons.schoolschedule;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.djinons.schoolschedule.models.StartEndModel;

import java.util.ArrayList;

public class OneDayRecyclerViewAdapter extends RecyclerView.Adapter<OneDayViewCardViewHolder> {

    private ArrayList<String> classList;
    private ArrayList<StartEndModel> startEndList;



    public OneDayRecyclerViewAdapter(  ArrayList<String> classList,ArrayList<StartEndModel> startEndList){


        this.classList = classList;
        this.startEndList = startEndList;


    }


    @NonNull
    @Override
    public OneDayViewCardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_one_day_view, viewGroup, false);

        return new OneDayViewCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OneDayViewCardViewHolder itemView, int i) {


        String startEndAM= startEndList.get(i).getStartAM() + " - " + startEndList.get(i).getEndAM();
        String startEndPM= startEndList.get(i).getStartPM() + " - " + startEndList.get(i).getEndPM();

        String classNum = String.valueOf(i+1);

        itemView.cardClassNumTV.setText(classNum);
        itemView.cardClassNameTV.setText(classList.get(i));
        itemView.cardStartEndAMTV.setText(startEndAM);
        itemView.cardStartEndPMTV.setText(startEndPM);



    }

    @Override
    public int getItemCount() {
        return classList.size();
    }
}
