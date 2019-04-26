package com.djinons.schoolschedule.activitys;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.djinons.schoolschedule.CustomAdapterScheduleList;
import com.djinons.schoolschedule.DbHelper;
import com.djinons.schoolschedule.R;
import com.djinons.schoolschedule.models.SchedulenameModel;

import java.util.ArrayList;

public class EditDeleteActivity extends AppCompatActivity {

    ListView schedulelistView;
    //EditText editTextView;
    ArrayList<SchedulenameModel> itemSchedulenameModelList;
    CustomAdapterScheduleList customAdapterScheduleList;
    DbHelper myDb;
    int scheduleid;
    String name;
    ArrayList<SchedulenameModel> SchedulenameArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delete);


            schedulelistView = (ListView) findViewById(R.id.scheduleListView);
            //editTextView = (EditText) findViewById(R.id.editTextView);
            itemSchedulenameModelList = new ArrayList<SchedulenameModel>();
            customAdapterScheduleList = new CustomAdapterScheduleList(getApplicationContext(), itemSchedulenameModelList);
            schedulelistView.setEmptyView(findViewById(android.R.id.empty));

            SchedulenameArray = new ArrayList<>();
            myDb = new DbHelper(this);
            myDb.getWritableDatabase();
            Cursor resschedule = myDb.getAllScheduleNameAndId();

            while (resschedule.moveToNext()){
                SchedulenameModel Schedulename = new SchedulenameModel(scheduleid,name);
                Schedulename.setId(resschedule.getInt(0));
                Schedulename.setSchedulename(resschedule.getString(1));

             //   if (Schedulename.getId()!=1) {

                    itemSchedulenameModelList.add(Schedulename);
                    SchedulenameArray.add(Schedulename);
              //  }

            }
            resschedule.close();
            myDb.close();

            schedulelistView.setAdapter(customAdapterScheduleList);

        }
        /**
        @SuppressLint("NewApi")
        public void addValue(View v) {
            String name = editTextView.getText().toString();
            if (name.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please enter Values",
                        Toast.LENGTH_SHORT).show();
            } else {


                ClassnameModel classname = new ClassnameModel(id,name);

                myDb.getWritableDatabase();


                itemClassnameModelList.add(classname);
                myDb.insertDataClass(name);
                myDb.close();
                customAdapter.notifyDataSetChanged();
                editTextView.setText("");
            }
        }
*/
        @Override
        public void onBackPressed() {
            Intent mainIntent = new Intent(EditDeleteActivity.this, MainActivity.class);
            EditDeleteActivity.this.startActivity(mainIntent);
            super.onBackPressed();
        }
    }

