package com.djinons.schoolschedule;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.djinons.schoolschedule.models.ClassnameModel;

import java.util.ArrayList;

import static java.lang.System.out;

/**
 * Created by macbookpro on 212//18.
 */

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<ClassnameModel> itemClassnameModelList;
    DbHelper myDb;
    int id;
    String name;


    ArrayList<ClassnameModel> ClassnameArray;


    public CustomAdapter(Context context, ArrayList<ClassnameModel> classList) {

        this.context = context;
        this.ClassnameArray = classList;
    }

    @Override
    public int getCount() {
        return ClassnameArray.size();
    }

    @Override
    public Object getItem(int position) {
        return ClassnameArray.get(position);
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
            convertView = mInflater.inflate(R.layout.item, null);

            final TextView tvName = (TextView) convertView.findViewById(R.id.nameTV);
            ImageView imgRemove = (ImageView) convertView.findViewById(R.id.imgRemove);

            final ClassnameModel m = ClassnameArray.get(position);

            out.println("CustomA" + m.getId()+ m.getClassname()+m.getClassname().length());

            tvName.setText(m.getClassname());




            // click listener for remove button
            imgRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    myDb = new DbHelper(context);
                    myDb.getWritableDatabase();

                    ClassnameModel r =ClassnameArray.get(position);
                    ClassnameArray.remove(position);
                    out.println(m.getId());
                    myDb.deleteDataClass(m.getId());
                    notifyDataSetChanged();

                    myDb.close();
                }
            });
        }
        return convertView;
    }
}


