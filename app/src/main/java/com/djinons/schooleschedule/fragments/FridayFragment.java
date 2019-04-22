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


public class FridayFragment extends Fragment {

    TextView fri1t, fri2t, fri3t, fri4t, fri5t, fri6t, fri7t;

    TextView mon1startEndAM, mon1startEndPM, mon2startEndAM, mon2startEndPM, mon3startEndAM, mon3startEndPM, mon4startEndAM, mon4startEndPM,
            mon5startEndAM, mon5startEndPM, mon6startEndAM, mon6startEndPM, mon7startEndAM, mon7startEndPM;

    String Friday1, Friday2, Friday3, Friday4, Friday5, Friday6, Friday7;

    String  Mon1startAM, Mon1endAM, Mon1startPM, Mon1endPM, Mon2startAM, Mon2endAM, Mon2startPM, Mon2endPM, Mon3startAM, Mon3endAM, Mon3startPM,
            Mon3endPM, Mon4startAM, Mon4endAM, Mon4startPM, Mon4endPM, Mon5startAM, Mon5endAM, Mon5startPM, Mon5endPM, Mon6startAM, Mon6endAM,
            Mon6startPM, Mon6endPM, Mon7startAM, Mon7endAM, Mon7startPM, Mon7endPM;

    DbHelper myDb;


    public FridayFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static FridayFragment newInstance(String param1, String param2) {
        FridayFragment fragment = new FridayFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
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
        View viewFriday = inflater.inflate(R.layout.fragment_friday, container, false);

        myDb = new DbHelper(getContext());
        myDb.getWritableDatabase();


        fri1t = viewFriday.findViewById(R.id.first_class_fri);
        fri2t = viewFriday.findViewById(R.id.second_class_fri);
        fri3t = viewFriday.findViewById(R.id.thrid_class_fri);
        fri4t = viewFriday.findViewById(R.id.forth_class_fri);
        fri5t = viewFriday.findViewById(R.id.fifth_class_fri);
        fri6t = viewFriday.findViewById(R.id.sixth_class_fri);
        fri7t = viewFriday.findViewById(R.id.seventh_class_fri);

        mon1startEndAM = viewFriday.findViewById(R.id.mon1startEndAM);
        mon1startEndPM = viewFriday.findViewById(R.id.mon1startEndPM);
        mon2startEndAM = viewFriday.findViewById(R.id.mon2startEndAM);
        mon2startEndPM = viewFriday.findViewById(R.id.mon2startEndPM);
        mon3startEndAM = viewFriday.findViewById(R.id.mon3startEndAM);
        mon3startEndPM = viewFriday.findViewById(R.id.mon3startEndPM);
        mon4startEndAM = viewFriday.findViewById(R.id.mon4startEndAM);
        mon4startEndPM = viewFriday.findViewById(R.id.mon4startEndPM);
        mon5startEndAM = viewFriday.findViewById(R.id.mon5startEndAM);
        mon5startEndPM = viewFriday.findViewById(R.id.mon5startEndPM);
        mon6startEndAM = viewFriday.findViewById(R.id.mon6startEndAM);
        mon6startEndPM = viewFriday.findViewById(R.id.mon6startEndPM);
        mon7startEndAM = viewFriday.findViewById(R.id.mon7startEndAM);
        mon7startEndPM = viewFriday.findViewById(R.id.mon7startEndPM);

        Cursor res = myDb.getRow1(studentname);


        if (res != null) {
            while (res.moveToNext()) {
                Friday1 = (res.getString(6));
                Friday2 = (res.getString(11));
                Friday3 = (res.getString(16));
                Friday4 = (res.getString(21));
                Friday5 = (res.getString(26));
                Friday6 = (res.getString(31));
                Friday7 = (res.getString(36));
            }
            res.close();
        }

        fri1t.setText(Friday1);
        fri2t.setText(Friday2);
        fri3t.setText(Friday3);
        fri4t.setText(Friday4);
        fri5t.setText(Friday5);
        fri6t.setText(Friday6);
        fri7t.setText(Friday7);

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
        mon1startEndAM.setText(Mon1startAM + " - " + Mon1endAM);
        mon2startEndAM.setText(Mon2startAM + " - " + Mon2endAM);
        mon3startEndAM.setText(Mon3startAM + " - " + Mon3endAM);
        mon4startEndAM.setText(Mon4startAM + " - " + Mon4endAM);
        mon5startEndAM.setText(Mon5startAM + " - " + Mon5endAM);
        mon6startEndAM.setText(Mon6startAM + " - " + Mon6endAM);
        mon7startEndAM.setText(Mon7startAM + " - " + Mon7endAM);

        mon1startEndPM.setText(Mon1startPM + " - " + Mon1endPM);
        mon2startEndPM.setText(Mon2startPM + " - " + Mon2endPM);
        mon3startEndPM.setText(Mon3startPM + " - " + Mon3endPM);
        mon4startEndPM.setText(Mon4startPM + " - " + Mon4endPM);
        mon5startEndPM.setText(Mon5startPM + " - " + Mon5endPM);
        mon6startEndPM.setText(Mon6startPM + " - " + Mon6endPM);
        mon7startEndPM.setText(Mon7startPM + " - " + Mon7endPM);

        return viewFriday;
    }


}
