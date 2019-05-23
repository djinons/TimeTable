package com.djinons.schoolschedule;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.djinons.schoolschedule.activitys.MainActivity;
import com.djinons.schoolschedule.models.ClassnameModel;

import java.util.ArrayList;

public class WeekRecyclerViewAdapter extends RecyclerView.Adapter<WeekViewCardViewHolder> {

    private WeekViewCardViewHolder weekViewCardViewHolder;
    private ArrayList<Integer> classNumberList;
    private ArrayList<String > mondayClassnameList;
    private ArrayList<String> tuesdayClassnameList;
    private ArrayList<String> wednesdayClassnameList;
    private ArrayList<String> thursdayClassnameList;
    private ArrayList<String> fridayClassnameList;


    private MainActivity mainActivity;


    public WeekRecyclerViewAdapter(ArrayList<Integer> classNumberList,ArrayList<String> mondayClassnameList,ArrayList<String>tuesdayClassnameList,
                                   ArrayList<String>wednesdayClassnameList,ArrayList<String>thursdayClassnameList,
                                   ArrayList<String>fridayClassnameList, MainActivity mainActivity){

        this.mainActivity = mainActivity;
        this.classNumberList = classNumberList;
        this.mondayClassnameList = mondayClassnameList;
        this.tuesdayClassnameList = tuesdayClassnameList;
        this.wednesdayClassnameList = wednesdayClassnameList;
        this.thursdayClassnameList = thursdayClassnameList;
        this.fridayClassnameList = fridayClassnameList;

    }


    @NonNull
    @Override
    public WeekViewCardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_week_view, viewGroup, false);
        weekViewCardViewHolder = new WeekViewCardViewHolder(view);

        return weekViewCardViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WeekViewCardViewHolder itemView, int i) {



            itemView.classTV.setText( String.valueOf(classNumberList.get(i)));
            itemView.mondayTV.setText(mondayClassnameList.get(i));
            itemView.tuesdayTV.setText(tuesdayClassnameList.get(i));
            itemView.wednesdayTV.setText(wednesdayClassnameList.get(i));
            itemView.thursdayTV.setText(thursdayClassnameList.get(i));
            itemView.fridayTv.setText(fridayClassnameList.get(i));



    }



    @Override
    public int getItemCount() {

        return classNumberList.size();
    }
}
