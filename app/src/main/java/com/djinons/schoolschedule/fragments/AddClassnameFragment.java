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

import com.djinons.schoolschedule.AddClassnameRecyclerViewAdapter;
import com.djinons.schoolschedule.DbHelper;
import com.djinons.schoolschedule.R;
import com.djinons.schoolschedule.activitys.MainActivity;
import com.djinons.schoolschedule.models.ClassnameModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddClassnameFragment extends Fragment {

    private static final String KEY_TITLE = "title";
    private RecyclerView recyclerView;
    private ArrayList<ClassnameModel> classnameList;
    private AddClassnameRecyclerViewAdapter classnameAdapter;
    private EditText newClassname;
    private ImageView addClassname;
    DbHelper myDb;
    int id;
    String name;


    public AddClassnameFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(String title) {
        AddClassnameFragment f = new AddClassnameFragment();
        Bundle args = new Bundle();
        args.putString(KEY_TITLE, title);
        f.setArguments(args);
        return (f);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_add_classname, container, false);
        recyclerView = view.findViewById(R.id.classname_recycler_view);
        newClassname = view.findViewById(R.id.editTV);
        addClassname = view.findViewById(R.id.addIV);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        assert getActivity()!=null;
        getActivity().setTitle(getArguments().getString(KEY_TITLE));

        classnameList = new ArrayList<>();
        myDb = new DbHelper(getContext());
        myDb.getWritableDatabase();
        Cursor allClass = myDb.readClassnameTable();

        while (allClass.moveToNext()){
            ClassnameModel classname = new ClassnameModel(id,name);
            classname.setId(allClass.getInt(0));
            classname.setClassname(allClass.getString(1));

            if (classname.getId()!=1) {

                classnameList.add(classname);
            }

        }
        allClass.close();
        myDb.close();



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        classnameAdapter = new AddClassnameRecyclerViewAdapter(classnameList, ((MainActivity) getActivity()));
        recyclerView.setAdapter(classnameAdapter);

        addClassname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = newClassname.getText().toString();
                if (name.isEmpty()) {
                    Toast.makeText(getContext(), R.string.please_enter_classname,
                            Toast.LENGTH_SHORT).show();
                } else {


                    ClassnameModel classname = new ClassnameModel(id,name);

                    myDb.getWritableDatabase();


                    classnameList.add(classname);



                    myDb.insertClassname(name);
                    myDb.close();
                    classnameAdapter.notifyDataSetChanged();
                    newClassname.setText("");
                }

            }
        });
    }



}
