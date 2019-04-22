package com.djinons.schooleschedule.fragments;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.djinons.schooleschedule.DbHelper;
import com.djinons.schooleschedule.R;
import com.djinons.schooleschedule.activitys.MainActivity;

import static java.lang.System.out;


public class MondayFragment extends Fragment {

    TextView mon1t, mon2t, mon3t, mon4t, mon5t, mon6t, mon7t;

    TextView mon1startEndAM, mon1startEndPM, mon2startEndAM, mon2startEndPM, mon3startEndAM, mon3startEndPM, mon4startEndAM, mon4startEndPM,
             mon5startEndAM, mon5startEndPM, mon6startEndAM, mon6startEndPM, mon7startEndAM, mon7startEndPM;

    String  Monday1, Monday2, Monday3, Monday4, Monday5, Monday6, Monday7;

    String  Mon1startAM, Mon1endAM, Mon1startPM, Mon1endPM, Mon2startAM, Mon2endAM, Mon2startPM, Mon2endPM, Mon3startAM, Mon3endAM, Mon3startPM,
            Mon3endPM, Mon4startAM, Mon4endAM, Mon4startPM, Mon4endPM, Mon5startAM, Mon5endAM, Mon5startPM, Mon5endPM, Mon6startAM, Mon6endAM,
            Mon6startPM, Mon6endPM, Mon7startAM, Mon7endAM, Mon7startPM, Mon7endPM;

    DbHelper myDb;




    public MondayFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {



        }


    }


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        MainActivity activity = (MainActivity) getActivity();
        assert activity != null;
        String studentname = activity.getMyData();

        out.println("fragment"+studentname);
        // Inflate the layout for this fragment

        Mon1startAM ="";
        Mon1endAM ="";
        Mon1startPM ="";
        Mon1endPM ="";
        Mon2startAM ="";
        Mon2endAM ="";
        Mon2startPM ="";
        Mon2endPM ="";
        Mon3startAM ="";
        Mon3endAM ="";
        Mon3startPM ="";
        Mon3endPM ="";
        Mon4startAM ="";
        Mon4endAM ="";
        Mon4startPM ="";
        Mon4endPM ="";
        Mon5startAM ="";
        Mon5endAM ="";
        Mon5startPM ="";
        Mon5endPM ="";
        Mon6startAM ="";
        Mon6endAM ="";
        Mon6startPM ="";
        Mon6endPM ="";
        Mon7startAM ="";
        Mon7endAM ="";
        Mon7startPM ="";
        Mon7endPM ="";

        setHasOptionsMenu(true);
        View viewMonday = inflater.inflate(R.layout.fragment_monday, container, false);

        myDb = new DbHelper(getContext());
        myDb.getWritableDatabase();



        mon1t = viewMonday.findViewById(R.id.first_class_mon);
        mon2t = viewMonday.findViewById(R.id.second_class_mon);
        mon3t = viewMonday.findViewById(R.id.thrid_class_mon);
        mon4t = viewMonday.findViewById(R.id.forth_class_mon);
        mon5t = viewMonday.findViewById(R.id.fifth_class_mon);
        mon6t = viewMonday.findViewById(R.id.sixth_class_mon);
        mon7t = viewMonday.findViewById(R.id.seventh_class_mon);

        mon1startEndAM = viewMonday.findViewById(R.id.mon1startEndAM);
        mon1startEndPM = viewMonday.findViewById(R.id.mon1startEndPM);
        mon2startEndAM = viewMonday.findViewById(R.id.mon2startEndAM);
        mon2startEndPM = viewMonday.findViewById(R.id.mon2startEndPM);
        mon3startEndAM = viewMonday.findViewById(R.id.mon3startEndAM);
        mon3startEndPM = viewMonday.findViewById(R.id.mon3startEndPM);
        mon4startEndAM = viewMonday.findViewById(R.id.mon4startEndAM);
        mon4startEndPM = viewMonday.findViewById(R.id.mon4startEndPM);
        mon5startEndAM = viewMonday.findViewById(R.id.mon5startEndAM);
        mon5startEndPM = viewMonday.findViewById(R.id.mon5startEndPM);
        mon6startEndAM = viewMonday.findViewById(R.id.mon6startEndAM);
        mon6startEndPM = viewMonday.findViewById(R.id.mon6startEndPM);
        mon7startEndAM = viewMonday.findViewById(R.id.mon7startEndAM);
        mon7startEndPM = viewMonday.findViewById(R.id.mon7startEndPM);

        Cursor res = myDb.getRow1(studentname);

        if (res != null) {
            while (res.moveToNext()) {
                Monday1 = (res.getString(2));
                Monday2 = (res.getString(7));
                Monday3 = (res.getString(12));
                Monday4 = (res.getString(17));
                Monday5 = (res.getString(22));
                Monday6 = (res.getString(27));
                Monday7 = (res.getString(32));
            }
            res.close();
        }
        mon1t.setText(Monday1);
        mon2t.setText(Monday2);
        mon3t.setText(Monday3);
        mon4t.setText(Monday4);
        mon5t.setText(Monday5);
        mon6t.setText(Monday6);
        mon7t.setText(Monday7);

        out.println("monday"+Monday1);

        Cursor resStartEnd = myDb.getRow1StartEnd();

        if (resStartEnd != null) {
            while (resStartEnd.moveToNext()) {
                Mon1startAM = (resStartEnd.getString(1));
                Mon1endAM = (resStartEnd.getString(2));
                Mon2startAM = (resStartEnd.getString(3));
                Mon2endAM = (resStartEnd.getString(4));
                Mon3startAM = (resStartEnd.getString(5));
                Mon3endAM = (resStartEnd.getString(6));
                Mon4startAM = (resStartEnd.getString(7));
                Mon4endAM = (resStartEnd.getString(8));
                Mon5startAM = (resStartEnd.getString(9));
                Mon5endAM = (resStartEnd.getString(10));
                Mon6startAM = (resStartEnd.getString(11));
                Mon6endAM = (resStartEnd.getString(12));
                Mon7startAM = (resStartEnd.getString(13));
                Mon7endAM = (resStartEnd.getString(14));

                Mon1startPM = (resStartEnd.getString(15));
                Mon1endPM = (resStartEnd.getString(16));
                Mon2startPM = (resStartEnd.getString(17));
                Mon2endPM = (resStartEnd.getString(18));
                Mon3startPM = (resStartEnd.getString(19));
                Mon3endPM = (resStartEnd.getString(20));
                Mon4startPM = (resStartEnd.getString(21));
                Mon4endPM = (resStartEnd.getString(22));
                Mon5startPM = (resStartEnd.getString(23));
                Mon5endPM = (resStartEnd.getString(24));
                Mon6startPM = (resStartEnd.getString(25));
                Mon6endPM = (resStartEnd.getString(26));
                Mon7startPM = (resStartEnd.getString(27));
                Mon7endPM = (resStartEnd.getString(28));
            }
            resStartEnd.close();
        }
            out.println("monadaysec"+Monday1);





        if (mon1t.getText().toString()!=null|| mon1t.getText().toString().isEmpty()) {
              mon1startEndAM.setText(Mon1startAM + " - " + Mon1endAM);
              mon1startEndPM.setText(Mon1startPM + " - " + Mon1endPM);
        }
        mon2startEndAM.setText(Mon2startAM + " - " + Mon2endAM);
        mon3startEndAM.setText(Mon3startAM + " - " + Mon3endAM);
        mon4startEndAM.setText(Mon4startAM + " - " + Mon4endAM);
        mon5startEndAM.setText(Mon5startAM + " - " + Mon5endAM);
        mon6startEndAM.setText(Mon6startAM + " - " + Mon6endAM);
        mon7startEndAM.setText(Mon7startAM + " - " + Mon7endAM);

        mon2startEndPM.setText(Mon2startPM + " - " + Mon2endPM);
        mon3startEndPM.setText(Mon3startPM + " - " + Mon3endPM);
        mon4startEndPM.setText(Mon4startPM + " - " + Mon4endPM);
        mon5startEndPM.setText(Mon5startPM + " - " + Mon5endPM);
        mon6startEndPM.setText(Mon6startPM + " - " + Mon6endPM);
        mon7startEndPM.setText(Mon7startPM + " - " + Mon7endPM);


        return viewMonday;
    }
   


}
