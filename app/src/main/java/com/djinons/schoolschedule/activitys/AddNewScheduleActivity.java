package com.djinons.schoolschedule.activitys;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.djinons.schoolschedule.DbHelper;
import com.djinons.schoolschedule.R;
import com.djinons.schoolschedule.models.ClassnameModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE;

public class AddNewScheduleActivity extends AppCompatActivity {

    DbHelper myDb;

    EditText name1;
    Spinner mon1, mon2, mon3, mon4, mon5, mon6, mon7;
    Spinner tue1, tue2, tue3, tue4, tue5, tue6, tue7;
    Spinner wed1, wed2, wed3, wed4, wed5, wed6, wed7;
    Spinner thu1, thu2, thu3, thu4, thu5, thu6, thu7;
    Spinner fri1, fri2, fri3, fri4, fri5, fri6, fri7;

    String Monday21, Monday22, Monday23, Monday24, Monday25, Monday26, Monday27;
    String Tuesday21, Tuesday22, Tuesday23, Tuesday24, Tuesday25, Tuesday26, Tuesday27;
    String Wednesday21, Wednesday22, Wednesday23, Wednesday24, Wednesday25, Wednesday26, Wednesday27;
    String Thursday21, Thursday22, Thursday23, Thursday24, Thursday25, Thursday26, Thursday27;
    String Friday21, Friday22, Friday23, Friday24, Friday25, Friday26, Friday27;
    String name;

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        setContentView(R.layout.activity_add_new_schedule);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myDb = new DbHelper(this);
        myDb.getWritableDatabase();
/**
        Cursor rer = myDb.getRow1();
        //reading DB
        if (rer != null) {
            while (rer.moveToNext()) {

                Monday21 = (rer.getString(1));
                Monday22 = (rer.getString(6));
                Monday23 = (rer.getString(11));
                Monday24 = (rer.getString(16));
                Monday25 = (rer.getString(21));
                Monday26 = (rer.getString(26));
                Monday27 = (rer.getString(31));

                Tuesday21 = (rer.getString(2));
                Tuesday22 = (rer.getString(7));
                Tuesday23 = (rer.getString(12));
                Tuesday24 = (rer.getString(17));
                Tuesday25 = (rer.getString(22));
                Tuesday26 = (rer.getString(27));
                Tuesday27 = (rer.getString(32));


                Wednesday21 = (rer.getString(3));
                Wednesday22 = (rer.getString(8));
                Wednesday23 = (rer.getString(13));
                Wednesday24 = (rer.getString(18));
                Wednesday25 = (rer.getString(23));
                Wednesday26 = (rer.getString(28));
                Wednesday27 = (rer.getString(33));

                Thursday21 = (rer.getString(4));
                Thursday22 = (rer.getString(9));
                Thursday23 = (rer.getString(14));
                Thursday24 = (rer.getString(19));
                Thursday25 = (rer.getString(24));
                Thursday26 = (rer.getString(29));
                Thursday27 = (rer.getString(34));

                Friday21 = (rer.getString(5));
                Friday22 = (rer.getString(10));
                Friday23 = (rer.getString(15));
                Friday24 = (rer.getString(20));
                Friday25 = (rer.getString(25));
                Friday26 = (rer.getString(30));
                Friday27 = (rer.getString(35));
            }
*/

            int id = 0;
            String name = new String();
            ArrayList<ClassnameModel> ClassnameArray = new ArrayList<>();
            Cursor classname = myDb.getAllDataClass();
            while (classname.moveToNext()){

                ClassnameModel Classname = new ClassnameModel(id,name);
                Classname.setId(classname.getInt(0));
                Classname.setClassname(classname.getString(1));
                ClassnameArray.add(Classname);

            }

            Set<String> set = new HashSet<String>();
            Cursor classname1 = myDb.getAllDataClass();
            if (classname1.moveToFirst()) {
                do {
                    set.add(classname1.getString(1));
                } while (classname1.moveToNext());
            }
            classname1.close();



//Convert set into list
            List<String> list = new ArrayList<String>(set);
//Sort Data Alphabetical order
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String lhs, String rhs) {
                    return lhs.compareTo(rhs);
                }
            });
            adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


/**           spinner.setAdapter(adapter);
 ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, spinnerLists);
 ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.items, android.R.layout.simple_spinner_item);
 adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
 */
            name1 = findViewById(R.id.schedule_name);
            mon1 = findViewById(R.id.mon_1);
            tue1 = findViewById(R.id.tue_1);
            wed1 = findViewById(R.id.wed_1);
            fri1 = findViewById(R.id.fri_1);
            thu1 = findViewById(R.id.thu_1);
            mon2 = findViewById(R.id.mon_2);
            tue2 = findViewById(R.id.tue_2);
            wed2 = findViewById(R.id.wed_2);
            mon3 = findViewById(R.id.mon_3);
            tue3 = findViewById(R.id.tue_3);
            wed3 = findViewById(R.id.wed_3);
            mon4 = findViewById(R.id.mon_4);
            tue4 = findViewById(R.id.tue_4);
            wed4 = findViewById(R.id.wed_4);
            mon5 = findViewById(R.id.mon_5);
            tue5 = findViewById(R.id.tue_5);
            wed5 = findViewById(R.id.wed_5);
            mon6 = findViewById(R.id.mon_6);
            tue6 = findViewById(R.id.tue_6);
            wed6 = findViewById(R.id.wed_6);
            fri2 = findViewById(R.id.fri_2);
            thu2 = findViewById(R.id.thu_2);
            fri3 = findViewById(R.id.fri_3);
            thu3 = findViewById(R.id.thu_3);
            fri4 = findViewById(R.id.fri_4);
            thu4 = findViewById(R.id.thu_4);
            fri5 = findViewById(R.id.fri_5);
            thu5 = findViewById(R.id.thu_5);
            fri6 = findViewById(R.id.fri_6);
            thu6 = findViewById(R.id.thu_6);
            mon7 = findViewById(R.id.mon_7);
            tue7 = findViewById(R.id.tue_7);
            wed7 = findViewById(R.id.wed_7);
            fri7 = findViewById(R.id.fri_7);
            thu7 = findViewById(R.id.thu_7);

            //getting spinner position
            String compareValue1 = Monday21;
            String compareValue2 = Monday22;
            String compareValue3 = Monday23;
            String compareValue4 = Monday24;
            String compareValue5 = Monday25;
            String compareValue6 = Monday26;
            String compareValue7 = Monday27;

            String compareValue8 = Tuesday21;
            String compareValue9 = Tuesday22;
            String compareValue10 = Tuesday23;
            String compareValue11 = Tuesday24;
            String compareValue12 = Tuesday25;
            String compareValue13 = Tuesday26;
            String compareValue14 = Tuesday27;

            String compareValue15 = Wednesday21;
            String compareValue16 = Wednesday22;
            String compareValue17 = Wednesday23;
            String compareValue18 = Wednesday24;
            String compareValue19 = Wednesday25;
            String compareValue20 = Wednesday26;
            String compareValue21 = Wednesday27;

            String compareValue22 = Thursday21;
            String compareValue23 = Thursday22;
            String compareValue24 = Thursday23;
            String compareValue25 = Thursday24;
            String compareValue26 = Thursday25;
            String compareValue27 = Thursday26;
            String compareValue28 = Thursday27;

            String compareValue29 = Friday21;
            String compareValue30 = Friday22;
            String compareValue31 = Friday23;
            String compareValue32 = Friday24;
            String compareValue33 = Friday25;
            String compareValue34 = Friday26;
            String compareValue35 = Friday27;

            //setting spinner values from database
            mon1.setAdapter(adapter);
            if (compareValue1 != null) {
                int spinnerPosition = adapter.getPosition(compareValue1);
                mon1.setSelection(spinnerPosition);
            }
            mon2.setAdapter(adapter);
            if (compareValue2 != null) {
                int spinnerPosition = adapter.getPosition(compareValue2);
                mon2.setSelection(spinnerPosition);
            }
            mon3.setAdapter(adapter);
            if (compareValue3 != null) {
                int spinnerPosition = adapter.getPosition(compareValue3);
                mon3.setSelection(spinnerPosition);
            }
            mon4.setAdapter(adapter);
            if (compareValue4 != null) {
                int spinnerPosition = adapter.getPosition(compareValue4);
                mon4.setSelection(spinnerPosition);
            }
            mon5.setAdapter(adapter);
            if (compareValue5 != null) {
                int spinnerPosition = adapter.getPosition(compareValue5);
                mon5.setSelection(spinnerPosition);
            }
            mon6.setAdapter(adapter);
            if (compareValue6 != null) {
                int spinnerPosition = adapter.getPosition(compareValue6);
                mon6.setSelection(spinnerPosition);
            }
            mon7.setAdapter(adapter);
            if (compareValue7 != null) {
                int spinnerPosition = adapter.getPosition(compareValue7);
                mon7.setSelection(spinnerPosition);
            }
            tue1.setAdapter(adapter);
            if (compareValue8 != null) {
                int spinnerPosition = adapter.getPosition(compareValue8);
                tue1.setSelection(spinnerPosition);
            }
            tue2.setAdapter(adapter);
            if (compareValue9 != null) {
                int spinnerPosition = adapter.getPosition(compareValue9);
                tue2.setSelection(spinnerPosition);
            }
            tue3.setAdapter(adapter);
            if (compareValue10 != null) {
                int spinnerPosition = adapter.getPosition(compareValue10);
                tue3.setSelection(spinnerPosition);
            }
            tue4.setAdapter(adapter);
            if (compareValue11 != null) {
                int spinnerPosition = adapter.getPosition(compareValue11);
                tue4.setSelection(spinnerPosition);
            }
            tue5.setAdapter(adapter);
            if (compareValue12 != null) {
                int spinnerPosition = adapter.getPosition(compareValue12);
                tue5.setSelection(spinnerPosition);
            }
            tue6.setAdapter(adapter);
            if (compareValue13 != null) {
                int spinnerPosition = adapter.getPosition(compareValue13);
                tue6.setSelection(spinnerPosition);
            }
            tue7.setAdapter(adapter);
            if (compareValue14 != null) {
                int spinnerPosition = adapter.getPosition(compareValue14);
                tue7.setSelection(spinnerPosition);
            }
            wed1.setAdapter(adapter);
            if (compareValue15 != null) {
                int spinnerPosition = adapter.getPosition(compareValue15);
                wed1.setSelection(spinnerPosition);
            }
            wed2.setAdapter(adapter);
            if (compareValue16 != null) {
                int spinnerPosition = adapter.getPosition(compareValue16);
                wed2.setSelection(spinnerPosition);
            }
            wed3.setAdapter(adapter);
            if (compareValue17 != null) {
                int spinnerPosition = adapter.getPosition(compareValue17);
                wed3.setSelection(spinnerPosition);
            }
            wed4.setAdapter(adapter);
            if (compareValue18 != null) {
                int spinnerPosition = adapter.getPosition(compareValue18);
                wed4.setSelection(spinnerPosition);
            }
            wed5.setAdapter(adapter);
            if (compareValue19 != null) {
                int spinnerPosition = adapter.getPosition(compareValue19);
                wed5.setSelection(spinnerPosition);
            }
            wed6.setAdapter(adapter);
            if (compareValue20 != null) {
                int spinnerPosition = adapter.getPosition(compareValue20);
                wed6.setSelection(spinnerPosition);
            }
            wed7.setAdapter(adapter);
            if (compareValue21 != null) {
                int spinnerPosition = adapter.getPosition(compareValue21);
                wed7.setSelection(spinnerPosition);
            }
            thu1.setAdapter(adapter);
            if (compareValue22 != null) {
                int spinnerPosition = adapter.getPosition(compareValue22);
                thu1.setSelection(spinnerPosition);
            }
            thu2.setAdapter(adapter);
            if (compareValue23 != null) {
                int spinnerPosition = adapter.getPosition(compareValue23);
                thu2.setSelection(spinnerPosition);
            }
            thu3.setAdapter(adapter);
            if (compareValue24 != null) {
                int spinnerPosition = adapter.getPosition(compareValue24);
                thu3.setSelection(spinnerPosition);
            }
            thu4.setAdapter(adapter);
            if (compareValue25 != null) {
                int spinnerPosition = adapter.getPosition(compareValue25);
                thu4.setSelection(spinnerPosition);
            }
            thu5.setAdapter(adapter);
            if (compareValue26 != null) {
                int spinnerPosition = adapter.getPosition(compareValue26);
                thu5.setSelection(spinnerPosition);
            }
            thu6.setAdapter(adapter);
            if (compareValue27 != null) {
                int spinnerPosition = adapter.getPosition(compareValue27);
                thu6.setSelection(spinnerPosition);
            }
            thu7.setAdapter(adapter);
            if (compareValue28 != null) {
                int spinnerPosition = adapter.getPosition(compareValue28);
                thu7.setSelection(spinnerPosition);
            }
            fri1.setAdapter(adapter);
            if (compareValue29 != null) {
                int spinnerPosition = adapter.getPosition(compareValue29);
                fri1.setSelection(spinnerPosition);
            }
            fri2.setAdapter(adapter);
            if (compareValue30 != null) {
                int spinnerPosition = adapter.getPosition(compareValue30);
                fri2.setSelection(spinnerPosition);
            }
            fri3.setAdapter(adapter);
            if (compareValue31 != null) {
                int spinnerPosition = adapter.getPosition(compareValue31);
                fri3.setSelection(spinnerPosition);
            }
            fri4.setAdapter(adapter);
            if (compareValue32 != null) {
                int spinnerPosition = adapter.getPosition(compareValue32);
                fri4.setSelection(spinnerPosition);
            }
            fri5.setAdapter(adapter);
            if (compareValue33 != null) {
                int spinnerPosition = adapter.getPosition(compareValue33);
                fri5.setSelection(spinnerPosition);
            }
            fri6.setAdapter(adapter);
            if (compareValue34 != null) {
                int spinnerPosition = adapter.getPosition(compareValue34);
                fri6.setSelection(spinnerPosition);
            }
            fri7.setAdapter(adapter);
            if (compareValue35 != null) {
                int spinnerPosition = adapter.getPosition(compareValue35);
                fri7.setSelection(spinnerPosition);
            }
            //rer.close();

        }
   // }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        /**  if (id == R.id.action_refresh) {
         if (isNetworkAvailable()) {
         getTodayWeather();
         getLongTermWeather();
         } else {
         Snackbar.make(appView, getString(R.string.msg_connection_not_available), Snackbar.LENGTH_LONG).show();
         }
         return true;
         }

         if (id == R.id.action_search) {
         searchCities();
         return true;
         }
         if (id == R.id.action_location) {
         getCityByLocation();
         return true;
         }*/
        if (id == R.id.action_save) {

            if (name1.getText().length() == 0) {
                Toast.makeText(getApplicationContext(), R.string.please_enter_name,
                        Toast.LENGTH_LONG).show();
            } else {


                //  DeleteBase();
                SaveTimeTable();
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);

                Intent editIntent = new Intent(AddNewScheduleActivity.this, MainActivity.class);
                AddNewScheduleActivity.this.startActivity(editIntent);

            }
           // return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);

    }

    public void DeleteBase() {
        myDb.deleteData(0);
    }

    public void SaveTable(View view) {
        DeleteBase();
        SaveTimeTable();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);

        Intent editIntent = new Intent(AddNewScheduleActivity.this, MainActivity.class);
        AddNewScheduleActivity.this.startActivity(editIntent);
    }

    public void SaveTimeTable() {


        mon1 = findViewById(R.id.mon_1);
        tue1 = findViewById(R.id.tue_1);
        wed1 = findViewById(R.id.wed_1);
        fri1 = findViewById(R.id.fri_1);
        thu1 = findViewById(R.id.thu_1);
        mon2 = findViewById(R.id.mon_2);
        tue2 = findViewById(R.id.tue_2);
        wed2 = findViewById(R.id.wed_2);
        mon3 = findViewById(R.id.mon_3);
        tue3 = findViewById(R.id.tue_3);
        wed3 = findViewById(R.id.wed_3);
        mon4 = findViewById(R.id.mon_4);
        tue4 = findViewById(R.id.tue_4);
        wed4 = findViewById(R.id.wed_4);
        mon5 = findViewById(R.id.mon_5);
        tue5 = findViewById(R.id.tue_5);
        wed5 = findViewById(R.id.wed_5);
        mon6 = findViewById(R.id.mon_6);
        tue6 = findViewById(R.id.tue_6);
        wed6 = findViewById(R.id.wed_6);
        fri2 = findViewById(R.id.fri_2);
        thu2 = findViewById(R.id.thu_2);
        fri3 = findViewById(R.id.fri_3);
        thu3 = findViewById(R.id.thu_3);
        fri4 = findViewById(R.id.fri_4);
        thu4 = findViewById(R.id.thu_4);
        fri5 = findViewById(R.id.fri_5);
        thu5 = findViewById(R.id.thu_5);
        fri6 = findViewById(R.id.fri_6);
        thu6 = findViewById(R.id.thu_6);
        mon7 = findViewById(R.id.mon_7);
        tue7 = findViewById(R.id.tue_7);
        wed7 = findViewById(R.id.wed_7);
        fri7 = findViewById(R.id.fri_7);
        thu7 = findViewById(R.id.thu_7);


        //String name = name1.getText().toString();
    //    if (name1.getText().length() == 0) {
    //        Toast.makeText(getApplicationContext(), "Please enter name",
    //                Toast.LENGTH_LONG).show();

//        } else {
             myDb.updateSchedule(
                    "Dunja",
                     mon1.getSelectedItem().toString(), tue1.getSelectedItem().toString(), wed1.getSelectedItem().toString(), thu1.getSelectedItem().toString(), fri1.getSelectedItem().toString(),
                     mon2.getSelectedItem().toString(), tue2.getSelectedItem().toString(), wed2.getSelectedItem().toString(), thu2.getSelectedItem().toString(), fri2.getSelectedItem().toString(),
                     mon3.getSelectedItem().toString(), tue3.getSelectedItem().toString(), wed3.getSelectedItem().toString(), thu3.getSelectedItem().toString(), fri3.getSelectedItem().toString(),
                     mon4.getSelectedItem().toString(), tue4.getSelectedItem().toString(), wed4.getSelectedItem().toString(), thu4.getSelectedItem().toString(), fri4.getSelectedItem().toString(),
                     mon5.getSelectedItem().toString(), tue5.getSelectedItem().toString(), wed5.getSelectedItem().toString(), thu5.getSelectedItem().toString(), fri5.getSelectedItem().toString(),
                     mon6.getSelectedItem().toString(), tue6.getSelectedItem().toString(), wed6.getSelectedItem().toString(), thu6.getSelectedItem().toString(), fri6.getSelectedItem().toString(),
                     mon7.getSelectedItem().toString(), tue7.getSelectedItem().toString(), wed7.getSelectedItem().toString(), thu7.getSelectedItem().toString(), fri7.getSelectedItem().toString());

                Toast.makeText(AddNewScheduleActivity.this, R.string.data_inserted, Toast.LENGTH_LONG).show();
                ReadSQL();


            myDb.close();
        }
 //   }



    public void ReadSQL() {
        Cursor res = myDb.getAllData();

        if (res.getCount() == 0) {
            // showMessage("Error", "Nothing Found");
            res.close();
            return;
        }
    }
}


