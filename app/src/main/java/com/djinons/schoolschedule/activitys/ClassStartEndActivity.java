package com.djinons.schoolschedule.activitys;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.djinons.schoolschedule.DbHelper;
import com.djinons.schoolschedule.R;


public class ClassStartEndActivity extends AppCompatActivity {

    TextView mon1startAM,mon1endAM;
    TextView mon2startAM,mon2endAM;
    TextView mon3startAM,mon3endAM;
    TextView mon4startAM,mon4endAM;
    TextView mon5startAM,mon5endAM;
    TextView mon6startAM,mon6endAM;
    TextView mon7startAM,mon7endAM;

    TextView mon1startPM,mon1endPM;
    TextView mon2startPM,mon2endPM;
    TextView mon3startPM,mon3endPM;
    TextView mon4startPM,mon4endPM;
    TextView mon5startPM,mon5endPM;
    TextView mon6startPM,mon6endPM;
    TextView mon7startPM,mon7endPM;

    String  Mon1startAM, Mon1endAM, Mon1startPM, Mon1endPM, Mon2startAM, Mon2endAM,
            Mon2startPM, Mon2endPM, Mon3startAM, Mon3endAM, Mon3startPM, Mon3endPM,
            Mon4startAM, Mon4endAM, Mon4startPM, Mon4endPM, Mon5startAM, Mon5endAM,
            Mon5startPM, Mon5endPM, Mon6startAM, Mon6endAM, Mon6startPM, Mon6endPM,
            Mon7startAM, Mon7endAM, Mon7startPM, Mon7endPM;

    int mHour;
    int mMinute;
    int mMinuteend;

    DbHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
        setContentView(R.layout.activity_class_start_end);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myDb = new DbHelper(this);
        myDb.getWritableDatabase();

        mon1startAM = findViewById(R.id.mon1startAM);
        mon1endAM = findViewById(R.id.mon1endAM);
        mon2startAM = findViewById(R.id.mon2startAM);
        mon2endAM = findViewById(R.id.mon2endAM);
        mon3startAM = findViewById(R.id.mon3startAM);
        mon3endAM = findViewById(R.id.mon3endAM);
        mon4startAM = findViewById(R.id.mon4startAM);
        mon4endAM = findViewById(R.id.mon4endAM);
        mon5startAM = findViewById(R.id.mon5startAM);
        mon5endAM = findViewById(R.id.mon5endAM);
        mon6startAM = findViewById(R.id.mon6startAM);
        mon6endAM = findViewById(R.id.mon6endAM);
        mon7startAM = findViewById(R.id.mon7startAM);
        mon7endAM = findViewById(R.id.mon7endAM);

        mon1startPM = findViewById(R.id.mon1startPM);
        mon1endPM = findViewById(R.id.mon1endPM);
        mon2startPM = findViewById(R.id.mon2startPM);
        mon2endPM = findViewById(R.id.mon2endPM);
        mon3startPM = findViewById(R.id.mon3startPM);
        mon3endPM = findViewById(R.id.mon3endPM);
        mon4startPM = findViewById(R.id.mon4startPM);
        mon4endPM = findViewById(R.id.mon4endPM);
        mon5startPM = findViewById(R.id.mon5startPM);
        mon5endPM = findViewById(R.id.mon5endPM);
        mon6startPM = findViewById(R.id.mon6startPM);
        mon6endPM = findViewById(R.id.mon6endPM);
        mon7startPM = findViewById(R.id.mon7startPM);
        mon7endPM = findViewById(R.id.mon7endPM);


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

        mon1startAM.setText(Mon1startAM);
        mon2startAM.setText(Mon2startAM);
        mon3startAM.setText(Mon3startAM);
        mon4startAM.setText(Mon4startAM);
        mon5startAM.setText(Mon5startAM);
        mon6startAM.setText(Mon6startAM);
        mon7startAM.setText(Mon7startAM);

        mon1startPM.setText(Mon1startPM);
        mon2startPM.setText(Mon2startPM);
        mon3startPM.setText(Mon3startPM);
        mon4startPM.setText(Mon4startPM);
        mon5startPM.setText(Mon5startPM);
        mon6startPM.setText(Mon6startPM);
        mon7startPM.setText(Mon7startPM);

        mon1endAM.setText(Mon1endAM);
        mon2endAM.setText(Mon2endAM);
        mon3endAM.setText(Mon3endAM);
        mon4endAM.setText(Mon4endAM);
        mon5endAM.setText(Mon5endAM);
        mon6endAM.setText(Mon6endAM);
        mon7endAM.setText(Mon7endAM);

        mon1endPM.setText(Mon1endPM);
        mon2endPM.setText(Mon2endPM);
        mon3endPM.setText(Mon3endPM);
        mon4endPM.setText(Mon4endPM);
        mon5endPM.setText(Mon5endPM);
        mon6endPM.setText(Mon6endPM);
        mon7endPM.setText(Mon7endPM);





        mon1startAM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(ClassStartEndActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,int minute) {
                                mHour = hourOfDay;
                                mMinute = minute;
                                mMinuteend = minute+45;

                                mon1startAM.setText(String.format("%02d:%02d", hourOfDay, minute));
                                if (mMinuteend >= 60) {
                                    hourOfDay ++;
                                    mMinuteend = mMinuteend % 60;
                                }
                                mon1endAM.setText(String.format("%02d:%02d", hourOfDay, mMinuteend));
                            }
                        }, mHour, mMinute, true);
                timePickerDialog.show();

            }
        });

        mon1startPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(ClassStartEndActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,int minute) {
                                mHour = hourOfDay;
                                mMinute = minute;
                                mMinuteend = minute+45;

                                mon1startPM.setText(String.format("%02d:%02d", hourOfDay, minute));
                                if (mMinuteend >= 60) {
                                    hourOfDay ++;
                                    mMinuteend = mMinuteend % 60;
                                }
                                mon1endPM.setText(String.format("%02d:%02d", hourOfDay, mMinuteend));
                            }
                        }, mHour, mMinute, true);
                timePickerDialog.show();

            }
        });

        mon2startAM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(ClassStartEndActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,int minute) {
                                mHour = hourOfDay;
                                mMinute = minute;
                                mMinuteend = minute+45;

                                mon2startAM.setText(String.format("%02d:%02d", hourOfDay, minute));
                                if (mMinuteend >= 60) {
                                    hourOfDay ++;
                                    mMinuteend = mMinuteend % 60;
                                }
                                mon2endAM.setText(String.format("%02d:%02d", hourOfDay, mMinuteend));
                            }
                        }, mHour, mMinute, true);
                timePickerDialog.show();

            }
        });

        mon2startPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(ClassStartEndActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,int minute) {
                                mHour = hourOfDay;
                                mMinute = minute;
                                mMinuteend = minute+45;

                                mon2startPM.setText(String.format("%02d:%02d", hourOfDay, minute));
                                if (mMinuteend >= 60) {
                                    hourOfDay ++;
                                    mMinuteend = mMinuteend % 60;
                                }
                                mon2endPM.setText(String.format("%02d:%02d", hourOfDay, mMinuteend));
                            }
                        }, mHour, mMinute, true);
                timePickerDialog.show();

            }
        });

        mon3startAM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(ClassStartEndActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,int minute) {
                                mHour = hourOfDay;
                                mMinute = minute;
                                mMinuteend = minute+45;

                                mon3startAM.setText(String.format("%02d:%02d", hourOfDay, minute));
                                if (mMinuteend >= 60) {
                                    hourOfDay ++;
                                    mMinuteend = mMinuteend % 60;
                                }
                                mon3endAM.setText(String.format("%02d:%02d", hourOfDay, mMinuteend));
                            }
                        }, mHour, mMinute, true);
                timePickerDialog.show();

            }
        });

        mon3startPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(ClassStartEndActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,int minute) {
                                mHour = hourOfDay;
                                mMinute = minute;
                                mMinuteend = minute+45;

                                mon3startPM.setText(String.format("%02d:%02d", hourOfDay, minute));
                                if (mMinuteend >= 60) {
                                    hourOfDay ++;
                                    mMinuteend = mMinuteend % 60;
                                }
                                mon3endPM.setText(String.format("%02d:%02d", hourOfDay, mMinuteend));
                            }
                        }, mHour, mMinute, true);
                timePickerDialog.show();

            }
        });

        mon4startAM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(ClassStartEndActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,int minute) {
                                mHour = hourOfDay;
                                mMinute = minute;
                                mMinuteend = minute+45;

                                mon4startAM.setText(String.format("%02d:%02d", hourOfDay, minute));
                                if (mMinuteend >= 60) {
                                    hourOfDay ++;
                                    mMinuteend = mMinuteend % 60;
                                }
                                mon4endAM.setText(String.format("%02d:%02d", hourOfDay, mMinuteend));
                            }
                        }, mHour, mMinute, true);
                timePickerDialog.show();

            }
        });

        mon4startPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(ClassStartEndActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,int minute) {
                                mHour = hourOfDay;
                                mMinute = minute;
                                mMinuteend = minute+45;

                                mon4startPM.setText(String.format("%02d:%02d", hourOfDay, minute));
                                if (mMinuteend >= 60) {
                                    hourOfDay ++;
                                    mMinuteend = mMinuteend % 60;
                                }
                                mon4endPM.setText(String.format("%02d:%02d", hourOfDay, mMinuteend));
                            }
                        }, mHour, mMinute, true);
                timePickerDialog.show();

            }
        });

        mon4startPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(ClassStartEndActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,int minute) {
                                mHour = hourOfDay;
                                mMinute = minute;
                                mMinuteend = minute+45;

                                mon4startPM.setText(String.format("%02d:%02d", hourOfDay, minute));
                                if (mMinuteend >= 60) {
                                    hourOfDay ++;
                                    mMinuteend = mMinuteend % 60;
                                }
                                mon4endPM.setText(String.format("%02d:%02d", hourOfDay, mMinuteend));
                            }
                        }, mHour, mMinute, true);
                timePickerDialog.show();

            }
        });

        mon5startAM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(ClassStartEndActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,int minute) {
                                mHour = hourOfDay;
                                mMinute = minute;
                                mMinuteend = minute+45;

                                mon5startAM.setText(String.format("%02d:%02d", hourOfDay, minute));
                                if (mMinuteend >= 60) {
                                    hourOfDay ++;
                                    mMinuteend = mMinuteend % 60;
                                }
                                mon5endAM.setText(String.format("%02d:%02d", hourOfDay, mMinuteend));
                            }
                        }, mHour, mMinute, true);
                timePickerDialog.show();

            }
        });

        mon5startPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(ClassStartEndActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,int minute) {
                                mHour = hourOfDay;
                                mMinute = minute;
                                mMinuteend = minute+45;

                                mon5startPM.setText(String.format("%02d:%02d", hourOfDay, minute));
                                if (mMinuteend >= 60) {
                                    hourOfDay ++;
                                    mMinuteend = mMinuteend % 60;
                                }
                                mon5endPM.setText(String.format("%02d:%02d", hourOfDay, mMinuteend));
                            }
                        }, mHour, mMinute, true);
                timePickerDialog.show();

            }
        });

        mon6startAM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(ClassStartEndActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,int minute) {
                                mHour = hourOfDay;
                                mMinute = minute;
                                mMinuteend = minute+45;

                                mon6startAM.setText(String.format("%02d:%02d", hourOfDay, minute));
                                if (mMinuteend >= 60) {
                                    hourOfDay ++;
                                    mMinuteend = mMinuteend % 60;
                                }
                                mon6endAM.setText(String.format("%02d:%02d", hourOfDay, mMinuteend));
                            }
                        }, mHour, mMinute, true);
                timePickerDialog.show();

            }
        });

        mon6startPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(ClassStartEndActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,int minute) {
                                mHour = hourOfDay;
                                mMinute = minute;
                                mMinuteend = minute+45;

                                mon6startPM.setText(String.format("%02d:%02d", hourOfDay, minute));
                                if (mMinuteend >= 60) {
                                    hourOfDay ++;
                                    mMinuteend = mMinuteend % 60;
                                }
                                mon6endPM.setText(String.format("%02d:%02d", hourOfDay, mMinuteend));
                            }
                        }, mHour, mMinute, true);
                timePickerDialog.show();

            }
        });

        mon7startAM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(ClassStartEndActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,int minute) {
                                mHour = hourOfDay;
                                mMinute = minute;
                                mMinuteend = minute+45;

                                mon7startAM.setText(String.format("%02d:%02d", hourOfDay, minute));
                                if (mMinuteend >= 60) {
                                    hourOfDay ++;
                                    mMinuteend = mMinuteend % 60;
                                }
                                mon7endAM.setText(String.format("%02d:%02d", hourOfDay, mMinuteend));
                            }
                        }, mHour, mMinute, true);
                timePickerDialog.show();

            }
        });

        mon7startPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(ClassStartEndActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,int minute) {
                                mHour = hourOfDay;
                                mMinute = minute;
                                mMinuteend = minute+45;

                                mon7startPM.setText(String.format("%02d:%02d", hourOfDay, minute));
                                if (mMinuteend >= 60) {
                                    hourOfDay ++;
                                    mMinuteend = mMinuteend % 60;
                                }
                                mon7endPM.setText(String.format("%02d:%02d", hourOfDay, mMinuteend));
                            }
                        }, mHour, mMinute, true);
                timePickerDialog.show();

            }
        });





    }




    private void timePicker(){
        // Get Current Time
      //  final Calendar c = Calendar.getInstance();
      //  mHour = c.get(Calendar.HOUR_OF_DAY);
      //  mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,int minute) {

                        mHour = hourOfDay;
                        mMinute = minute;

                        mMinuteend = minute+45;

                        mon1startAM.setText(hourOfDay + ":" + minute);
                        mon1endAM.setText(hourOfDay + ":" + mMinuteend);
                    }
                }, mHour, mMinute, true);
        timePickerDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit, menu);
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


            deleteDataStartEnd();
            SaveStartEndTime();

            Intent editIntent = new Intent(ClassStartEndActivity.this, MainActivity.class);
            ClassStartEndActivity.this.startActivity(editIntent);

        }
        return super.onOptionsItemSelected(item);
    }

    public void deleteDataStartEnd() {
        myDb.deleteDataStartEnd(1);
    }

    public void SaveStartEndTime() {

        Cursor resStartEnd = myDb.getRow1StartEnd();
        if (resStartEnd.getCount() < 1) {


        }
        resStartEnd.close();

        mon1startAM = findViewById(R.id.mon1startAM);
        mon1endAM = findViewById(R.id.mon1endAM);
        mon2startAM = findViewById(R.id.mon2startAM);
        mon2endAM = findViewById(R.id.mon2endAM);
        mon3startAM = findViewById(R.id.mon3startAM);
        mon3endAM = findViewById(R.id.mon3endAM);
        mon4startAM = findViewById(R.id.mon4startAM);
        mon4endAM = findViewById(R.id.mon4endAM);
        mon5startAM = findViewById(R.id.mon5startAM);
        mon5endAM = findViewById(R.id.mon5endAM);
        mon6startAM = findViewById(R.id.mon6startAM);
        mon6endAM = findViewById(R.id.mon6endAM);
        mon7startAM = findViewById(R.id.mon7startAM);
        mon7endAM = findViewById(R.id.mon7endAM);

        mon1startPM = findViewById(R.id.mon1startPM);
        mon1endPM = findViewById(R.id.mon1endPM);
        mon2startPM = findViewById(R.id.mon2startPM);
        mon2endPM = findViewById(R.id.mon2endPM);
        mon3startPM = findViewById(R.id.mon3startPM);
        mon3endPM = findViewById(R.id.mon3endPM);
        mon4startPM = findViewById(R.id.mon4startPM);
        mon4endPM = findViewById(R.id.mon4endPM);
        mon5startPM = findViewById(R.id.mon5startPM);
        mon5endPM = findViewById(R.id.mon5endPM);
        mon6startPM = findViewById(R.id.mon6startPM);
        mon6endPM = findViewById(R.id.mon6endPM);
        mon7startPM = findViewById(R.id.mon7startPM);
        mon7endPM = findViewById(R.id.mon7endPM);


        boolean isInserted = myDb.insertDataStartEnd(
                mon1startAM.getText().toString(), mon1endAM.getText().toString(), mon2startAM.getText().toString(), mon2endAM.getText().toString(), mon3startAM.getText().toString(), mon3endAM.getText().toString(),
                mon4startAM.getText().toString(), mon4endAM.getText().toString(), mon5startAM.getText().toString(), mon5endAM.getText().toString(), mon6startAM.getText().toString(), mon6endAM.getText().toString(),
                mon7startAM.getText().toString(), mon7endAM.getText().toString(), mon1startPM.getText().toString(), mon1endPM.getText().toString(), mon2startPM.getText().toString(), mon2endPM.getText().toString(),
                mon3startPM.getText().toString(), mon3endPM.getText().toString(), mon4startPM.getText().toString(), mon4endPM.getText().toString(), mon5startPM.getText().toString(), mon5endPM.getText().toString(),
                mon6startPM.getText().toString(), mon6endPM.getText().toString(), mon7startPM.getText().toString(), mon7endPM.getText().toString());

        if (isInserted == true) {
            Toast.makeText(ClassStartEndActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
            ReadSQL();

        } else
            Toast.makeText(ClassStartEndActivity.this, "Data is not Inserted", Toast.LENGTH_SHORT).show();

        myDb.close();
    }

    public void ReadSQL() {
        Cursor res = myDb.getRow1StartEnd();

        if (res.getCount() == 0) {
            // showMessage("Error", "Nothing Found");
            res.close();
            return;
        }
    }


}
