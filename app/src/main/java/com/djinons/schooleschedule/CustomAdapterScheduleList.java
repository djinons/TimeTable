package com.djinons.schooleschedule;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.djinons.schooleschedule.activitys.EditTimeTableActivity;
import com.djinons.schooleschedule.models.SchedulenameModel;


import java.util.ArrayList;

/**
 * Created by macbookpro on 93//18.
 */

public class CustomAdapterScheduleList extends BaseAdapter {

    Context context;
    ArrayList<SchedulenameModel> itemSchedulenameModelList;
    DbHelper myDb;
    int id;
    String name;




    ArrayList<SchedulenameModel> SchedulenameArray;


    public CustomAdapterScheduleList(Context context, ArrayList<SchedulenameModel> scheduleList) {

        this.context = context;
        this.SchedulenameArray = scheduleList;


    }

    @Override
    public int getCount() {
        return SchedulenameArray.size();
    }

    @Override
    public Object getItem(int position) {
        return SchedulenameArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        convertView = null;
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.student_list_item, null);



            final TextView tvName = (TextView) convertView.findViewById(R.id.tvName);

            ImageView imgEdit = (ImageView) convertView.findViewById(R.id.imgEdit);

            ImageView imgRemove = (ImageView) convertView.findViewById(R.id.imgRemove);

            final SchedulenameModel m = SchedulenameArray.get(position);

            tvName.setText(m.getSchedulename());





            // click listener for remove button
            imgRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    myDb = new DbHelper(context);
                    myDb.getWritableDatabase();
                    SchedulenameArray.remove(position);
                    myDb.deleteSchedule(m.getId());
                    notifyDataSetChanged();

                    myDb.close();
                }


            });
            // click listener for edit button
            imgEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent editScheduleintent= new Intent(context, EditTimeTableActivity.class);
                    editScheduleintent.putExtra("schedulename", m.getSchedulename());
                    context.startActivity(editScheduleintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));



                }

            });
        }
        return convertView;


    }


}
