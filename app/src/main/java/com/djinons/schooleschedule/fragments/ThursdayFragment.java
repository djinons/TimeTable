package com.djinons.schooleschedule.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.djinons.schooleschedule.DbHelper;
import com.djinons.schooleschedule.R;
import com.djinons.schooleschedule.activitys.MainActivity;

import static java.lang.System.out;


public class ThursdayFragment extends Fragment {


    TextView thu1t, thu2t, thu3t, thu4t, thu5t, thu6t, thu7t;

    TextView mon1startEndAM, mon1startEndPM, mon2startEndAM, mon2startEndPM, mon3startEndAM, mon3startEndPM, mon4startEndAM, mon4startEndPM,
            mon5startEndAM, mon5startEndPM, mon6startEndAM, mon6startEndPM, mon7startEndAM, mon7startEndPM;

    String Thursday1, Thursday2, Thursday3, Thursday4, Thursday5, Thursday6, Thursday7;

    String  Mon1startAM, Mon1endAM, Mon1startPM, Mon1endPM, Mon2startAM, Mon2endAM, Mon2startPM, Mon2endPM, Mon3startAM, Mon3endAM, Mon3startPM,
            Mon3endPM, Mon4startAM, Mon4endAM, Mon4startPM, Mon4endPM, Mon5startAM, Mon5endAM, Mon5startPM, Mon5endPM, Mon6startAM, Mon6endAM,
            Mon6startPM, Mon6endPM, Mon7startAM, Mon7endAM, Mon7startPM, Mon7endPM;

    DbHelper myDb;


    public ThursdayFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        MainActivity activity = (MainActivity) getActivity();
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
        View viewThursday = inflater.inflate(R.layout.fragment_thursday, container, false);

        myDb = new DbHelper(getContext());
        myDb.getWritableDatabase();



        thu1t = viewThursday.findViewById(R.id.first_class_thu);
        thu2t = viewThursday.findViewById(R.id.second_class_thu);
        thu3t = viewThursday.findViewById(R.id.thrid_class_thu);
        thu4t = viewThursday.findViewById(R.id.forth_class_thu);
        thu5t = viewThursday.findViewById(R.id.fifth_class_thu);
        thu6t = viewThursday.findViewById(R.id.sixth_class_thu);
        thu7t = viewThursday.findViewById(R.id.seventh_class_thu);

        mon1startEndAM = viewThursday.findViewById(R.id.mon1startEndAM);
        mon1startEndPM = viewThursday.findViewById(R.id.mon1startEndPM);
        mon2startEndAM = viewThursday.findViewById(R.id.mon2startEndAM);
        mon2startEndPM = viewThursday.findViewById(R.id.mon2startEndPM);
        mon3startEndAM = viewThursday.findViewById(R.id.mon3startEndAM);
        mon3startEndPM = viewThursday.findViewById(R.id.mon3startEndPM);
        mon4startEndAM = viewThursday.findViewById(R.id.mon4startEndAM);
        mon4startEndPM = viewThursday.findViewById(R.id.mon4startEndPM);
        mon5startEndAM = viewThursday.findViewById(R.id.mon5startEndAM);
        mon5startEndPM = viewThursday.findViewById(R.id.mon5startEndPM);
        mon6startEndAM = viewThursday.findViewById(R.id.mon6startEndAM);
        mon6startEndPM = viewThursday.findViewById(R.id.mon6startEndPM);
        mon7startEndAM = viewThursday.findViewById(R.id.mon7startEndAM);
        mon7startEndPM = viewThursday.findViewById(R.id.mon7startEndPM);


        Cursor res = myDb.getRow1(studentname);


        if (res != null) {
            while (res.moveToNext()) {
                Thursday1 = (res.getString(5));
                Thursday2 = (res.getString(10));
                Thursday3 = (res.getString(15));
                Thursday4 = (res.getString(20));
                Thursday5 = (res.getString(25));
                Thursday6 = (res.getString(30));
                Thursday7 = (res.getString(35));
            }
            res.close();
        }
        thu1t.setText(Thursday1);
        thu2t.setText(Thursday2);
        thu3t.setText(Thursday3);
        thu4t.setText(Thursday4);
        thu5t.setText(Thursday5);
        thu6t.setText(Thursday6);
        thu7t.setText(Thursday7);

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


        return viewThursday;
    }


}
