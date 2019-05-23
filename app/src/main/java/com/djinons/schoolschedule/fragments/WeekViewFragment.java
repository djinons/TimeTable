package com.djinons.schoolschedule.fragments;


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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.djinons.schoolschedule.DbHelper;
import com.djinons.schoolschedule.R;
import com.djinons.schoolschedule.WeekRecyclerViewAdapter;
import com.djinons.schoolschedule.activitys.MainActivity;
import com.djinons.schoolschedule.models.ClassnameModel;

import java.util.ArrayList;

import static java.lang.System.out;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeekViewFragment extends Fragment {

    private static final String KEY_TITLE = "title";
    private RecyclerView recyclerView;
    private ArrayList<Integer> classNumberList;
    private ArrayList<String> mondayClassnameList;
    private ArrayList<String> tuesdayClassnameList;
    private ArrayList<String> wednesdayClassnameList;
    private ArrayList<String> thursdayClassnameList;
    private ArrayList<String> fridayClassnameList;
    private WeekRecyclerViewAdapter weekRecyclerViewAdapter;
    private EditText newClassname;
    private ImageView addClassname;
    DbHelper myDb;
    int id;
    String name;


    public WeekViewFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(String title) {
        WeekViewFragment f = new WeekViewFragment();
        Bundle args = new Bundle();
        args.putString(KEY_TITLE, title);
        f.setArguments(args);
        return (f);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_week_view, container, false);
        recyclerView = view.findViewById(R.id.week_recycler_view);



        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        assert getActivity()!=null;
//        getActivity().setTitle(getArguments().getString(KEY_TITLE));

        classNumberList = new ArrayList<>();
        mondayClassnameList = new ArrayList<String>();
        tuesdayClassnameList = new ArrayList<String>();
        wednesdayClassnameList = new ArrayList<String>();
        thursdayClassnameList = new ArrayList<String>();
        fridayClassnameList = new ArrayList<String>();

        myDb = new DbHelper(getContext());
        myDb.getWritableDatabase();
        Cursor dataForWeek = myDb.getDataForWeek("Dunja");

        while (dataForWeek.moveToNext()){

            out.println("////Class////"+dataForWeek.getString(0));

            classNumberList.add(Integer.valueOf(dataForWeek.getString(0)));
            mondayClassnameList.add(dataForWeek.getString(1));
            tuesdayClassnameList.add(dataForWeek.getString(2));
            wednesdayClassnameList.add(dataForWeek.getString(3));
            thursdayClassnameList.add(dataForWeek.getString(4));
            fridayClassnameList.add(dataForWeek.getString(5));


//            ClassnameModel classname = new ClassnameModel(id,name);
//            classname.setId(dataForWeek.getInt(0));
//            classname.setClassname(dataForWeek.getString(1));
//
//            if (classname.getId()!=1) {
//
//                classnameList.add(classname);
//            }

        }
        dataForWeek.close();
        myDb.close();


        out.println("from fragment===== "+classNumberList.size());


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        weekRecyclerViewAdapter = new WeekRecyclerViewAdapter(classNumberList,mondayClassnameList,tuesdayClassnameList,
                wednesdayClassnameList,thursdayClassnameList,fridayClassnameList,((MainActivity) getActivity()));
        recyclerView.setAdapter(weekRecyclerViewAdapter);

//        addClassname.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String name = newClassname.getText().toString();
//                if (name.isEmpty()) {
//                    Toast.makeText(getContext(), R.string.please_enter_classname,
//                            Toast.LENGTH_SHORT).show();
//                } else {
//
//
//                    ClassnameModel classname = new ClassnameModel(id,name);
//
//                    myDb.getWritableDatabase();
//
//
//                    classnameList.add(classname);
//                    myDb.insertDataClass(name);
//                    myDb.close();
//                    weekRecyclerViewAdapter.notifyDataSetChanged();
//                    newClassname.setText("");
//                }
//
//            }
//        });
    }

}
