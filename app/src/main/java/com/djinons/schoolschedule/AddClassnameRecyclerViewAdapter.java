package com.djinons.schoolschedule;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.djinons.schoolschedule.activitys.MainActivity;
import com.djinons.schoolschedule.models.ClassnameModel;

import java.util.ArrayList;

public class AddClassnameRecyclerViewAdapter  extends RecyclerView.Adapter<StudentClassnameCardViewHolder>{

    private StudentClassnameCardViewHolder studentClassnameCardViewHolder;
    private ArrayList<ClassnameModel> classnameList;
    private MainActivity mainActivity;

    public AddClassnameRecyclerViewAdapter(ArrayList<ClassnameModel> classnameList, MainActivity mainActivity){

        this.mainActivity = mainActivity;
        this.classnameList = classnameList;

    }


    @NonNull
    @Override
    public StudentClassnameCardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_classname_list_item, viewGroup, false);
        studentClassnameCardViewHolder = new StudentClassnameCardViewHolder(view);

        return studentClassnameCardViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentClassnameCardViewHolder studentClassnameCardViewHolder, int i) {

        studentClassnameCardViewHolder.nameTV.setText(classnameList.get(i).getClassname());



    }

    @Override
    public int getItemCount() {
        return classnameList.size();
    }


}
