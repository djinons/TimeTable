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

import com.djinons.schoolschedule.AddClassnameRecyclerViewAdapter;
import com.djinons.schoolschedule.DbHelper;
import com.djinons.schoolschedule.EditScheduleRecyclerViewAdapter;
import com.djinons.schoolschedule.R;
import com.djinons.schoolschedule.activitys.MainActivity;
import com.djinons.schoolschedule.models.ClassnameModel;
import com.djinons.schoolschedule.models.SchedulenameModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditDeleteScheduleFragment extends Fragment {

    private static final String KEY_TITLE = "title";
    private RecyclerView recyclerView;
    private ArrayList<SchedulenameModel> schedulenameList;
    private EditScheduleRecyclerViewAdapter schedulenameAdapter;

    DbHelper myDb;
    int id;
    String name;


    public EditDeleteScheduleFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(String title) {
        EditDeleteScheduleFragment f = new EditDeleteScheduleFragment();
        Bundle args = new Bundle();
        args.putString(KEY_TITLE, title);
        f.setArguments(args);
        return (f);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_edit_delete_schedule, container, false);
        recyclerView = view.findViewById(R.id.schedule_name_recycler_view);



        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        assert getActivity()!=null;
        getActivity().setTitle(getArguments().getString(KEY_TITLE));

        schedulenameList = new ArrayList<>();
        myDb = new DbHelper(getContext());
        myDb.getWritableDatabase();
        Cursor resclass = myDb.getAllScheduleName();

        while (resclass.moveToNext()){
            SchedulenameModel schedulename = new SchedulenameModel(id,name);
            schedulename.setId(resclass.getInt(0));
            schedulename.setSchedulename(resclass.getString(1));


                schedulenameList.add(schedulename);


        }
        resclass.close();
        myDb.close();



        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        schedulenameAdapter = new EditScheduleRecyclerViewAdapter(schedulenameList, ((MainActivity) getActivity()));
        recyclerView.setAdapter(schedulenameAdapter);


    }
}
