package com.djinons.schoolschedule.fragments;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.djinons.schoolschedule.DbHelper;
import com.djinons.schoolschedule.OneDayRecyclerViewAdapter;
import com.djinons.schoolschedule.R;
import com.djinons.schoolschedule.models.StartEndModel;

import java.util.ArrayList;


public class WednesdayFragment extends Fragment {


    DbHelper myDb;
    RecyclerView recyclerView;
    OneDayRecyclerViewAdapter adapter;
    ArrayList<String> classnameList = new ArrayList<>();
    ArrayList<StartEndModel> startEndList = new ArrayList<>();
    TextView dayTV;


    public WednesdayFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewWednesday = inflater.inflate(R.layout.fragment_for_one_day, container, false);

        recyclerView = viewWednesday.findViewById(R.id.one_day_recycler_view);
        dayTV = viewWednesday.findViewById(R.id.day_name_one_frag_TV);


        myDb = new DbHelper(getContext());
        myDb.getWritableDatabase();


        Cursor mondayClass = myDb.getDataForDay("Dunja","WEDNESDAY");

        if (mondayClass != null) {
            while (mondayClass.moveToNext()) {


                classnameList.add(mondayClass.getString(0));


            }
            mondayClass.close();
        }
        Cursor startEnd = myDb.ReadStartEndTable();

        if (startEnd != null) {
            while (startEnd.moveToNext()) {


                StartEndModel startEndModel = new StartEndModel(startEnd.getString(1),startEnd.getString(2),startEnd.getString(3),startEnd.getString(4));

                startEndList.add(startEndModel);

            }


        }




        return viewWednesday;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new OneDayRecyclerViewAdapter(classnameList,startEndList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        recyclerView.setAdapter(adapter);
        dayTV.setText(getString(R.string.wednesday));

    }


}
