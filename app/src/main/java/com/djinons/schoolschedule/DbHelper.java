package com.djinons.schoolschedule;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_10;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_11;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_12;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_13;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_14;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_15;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_16;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_17;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_18;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_19;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_20;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_21;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_22;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_23;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_24;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_25;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_26;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_27;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_28;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_29;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_30;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_31;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_32;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_33;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_34;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_35;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_36;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_7;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_8;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_9;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_CLASS;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON1_END_AM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON1_END_PM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON1_START_AM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON1_START_PM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON2_END_AM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON2_END_PM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON2_START_AM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON2_START_PM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON3_END_AM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON3_END_PM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON3_START_AM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON3_START_PM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON4_END_AM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON4_END_PM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON4_START_AM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON4_START_PM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON5_END_AM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON5_END_PM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON5_START_AM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON5_START_PM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON6_END_AM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON6_END_PM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON6_START_AM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON6_START_PM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON7_END_AM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON7_END_PM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON7_START_AM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.COL_MON7_START_PM;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.DATABASE_NAME;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.MONDAY_1;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.MONDAY_2;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.MONDAY_3;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.MONDAY_4;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.MONDAY_5;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.NAME;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.TABLE_CLASSNAME;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.TABLE_NAME;
import static com.djinons.schoolschedule.TimeTableContract.TimeTableEntry.TABLE_START_TIME;

/**
 * Created by djinons on 9.1.2018..
 */

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        //create timetable db
        db.execSQL("create table " + "time_table" + "(ID INTEGER PRIMARY KEY , " +
                " NAME TEXT," +
                " MONDAY1 TEXT, TUESDAY1 TEXT, WEDNESDAY1 TEXT, THURSDAY1 TEXT, FRIDAY1 TEXT," +
                " MONDAY2 TEXT, TUESDAY2 TEXT, WEDNESDAY2 TEXT, THURSDAY2 TEXT, FRIDAY2 TEXT," +
                " MONDAY3 TEXT, TUESDAY3 TEXT, WEDNESDAY3 TEXT, THURSDAY3 TEXT, FRIDAY3 TEXT," +
                " MONDAY4 TEXT, TUESDAY4 TEXT, WEDNESDAY4 TEXT, THURSDAY4 TEXT, FRIDAY4 TEXT," +
                " MONDAY5 TEXT, TUESDAY5 TEXT, WEDNESDAY5 TEXT, THURSDAY5 TEXT, FRIDAY5 TEXT," +
                " MONDAY6 TEXT, TUESDAY6 TEXT, WEDNESDAY6 TEXT, THURSDAY6 TEXT, FRIDAY6 TEXT," +
                " MONDAY7 TEXT, TUESDAY7 TEXT, WEDNESDAY7 TEXT, THURSDAY7 TEXT, FRIDAY7 TEXT )");

//        //create classname db
//        db.execSQL("create table " + "class_names" + "(ID INTEGER PRIMARY KEY , " + " CLASSNAME TEXT )");
//
//        db.execSQL("insert into " + "class_names" + "(CLASSNAME) values ('')");

     //   public void CreateClassnameTable(){

          //  SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("create table if not exists " + "classname_table" + " (CLASSNAME_ID INTEGER PRIMARY KEY , CLASSNAME TEXT)");
  //      }

        //create classstart db
        db.execSQL("create table " + TABLE_START_TIME + "(ID INTEGER PRIMARY KEY , " +
                " mon1startam TEXT, mon1endam TEXT, mon2startam TEXT, mon2endam TEXT, mon3startam TEXT," +
                " mon3endam TEXT, mon4startam TEXT, mon4endam TEXT, mon5startam TEXT, mon5endam TEXT," +
                " mon6startam TEXT, mon6endam TEXT, mon7startam TEXT, mon7endam TEXT, mon1startpm TEXT," +
                " mon1endpm TEXT, mon2startpm TEXT, mon2endpm TEXT, mon3startpm TEXT, mon3endpm TEXT," +
                " mon4startpm TEXT, mon4endpm TEXT, mon5startpm TEXT, mon5endpm TEXT, mon6startpm TEXT," +
                " mon6endpm TEXT, mon7startpm TEXT, mon7endpm TEXT)");

    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Cursor getRow1(String studentname) {
        SQLiteDatabase db = this.getWritableDatabase();
        //  Cursor resScore = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE ID = 1", null);
        Cursor resScore = db.rawQuery(new StringBuilder().append("SELECT * FROM ").append("time_table").append(" WHERE NAME =").append("'").append(studentname).append("'").toString(), null);
        return resScore;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor resAll = db.rawQuery("SELECT * FROM " + "time_table" + " WHERE NAME =" + "NAME", null);
        return resAll;
    }


    public void truncateTable() {

        SQLiteDatabase db = this.getWritableDatabase();
        db.rawQuery("DELETE FROM " + TABLE_NAME, null);

    }

    public Integer deleteData(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("time_table", "ID > ?", new String[]{String.valueOf(id)});

    }




    public boolean insertDataClass(String editTextView) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_CLASS, editTextView);

        Long result = db.insert(TABLE_CLASSNAME, null, contentValues);
        return result != -1;
    }

    public boolean insertDataStartEnd(String mon1startAM, String mon1endAM, String mon2startAM, String mon2endAM,
                                      String mon3startAM, String mon3endAM, String mon4startAM, String mon4endAM,
                                      String mon5startAM, String mon5endAM, String mon6startAM, String mon6endAM,
                                      String mon7startAM, String mon7endAM, String mon1startPM, String mon1endPM,
                                      String mon2startPM, String mon2endPM, String mon3startPM, String mon3endPM,
                                      String mon4startPM, String mon4endPM, String mon5startPM, String mon5endPM,
                                      String mon6startPM, String mon6endPM, String mon7startPM, String mon7endPM) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_MON1_START_AM, mon1startAM);
        contentValues.put(COL_MON1_END_AM, mon1endAM);
        contentValues.put(COL_MON2_START_AM, mon2startAM);
        contentValues.put(COL_MON2_END_AM, mon2endAM);
        contentValues.put(COL_MON3_START_AM, mon3startAM);
        contentValues.put(COL_MON3_END_AM, mon3endAM);
        contentValues.put(COL_MON4_START_AM, mon4startAM);
        contentValues.put(COL_MON4_END_AM, mon4endAM);
        contentValues.put(COL_MON5_START_AM, mon5startAM);
        contentValues.put(COL_MON5_END_AM, mon5endAM);
        contentValues.put(COL_MON6_START_AM, mon6startAM);
        contentValues.put(COL_MON6_END_AM, mon6endAM);
        contentValues.put(COL_MON7_START_AM, mon7startAM);
        contentValues.put(COL_MON7_END_AM, mon7endAM);

        contentValues.put(COL_MON1_START_PM, mon1startPM);
        contentValues.put(COL_MON1_END_PM, mon1endPM);
        contentValues.put(COL_MON2_START_PM, mon2startPM);
        contentValues.put(COL_MON2_END_PM, mon2endPM);
        contentValues.put(COL_MON3_START_PM, mon3startPM);
        contentValues.put(COL_MON3_END_PM, mon3endPM);
        contentValues.put(COL_MON4_START_PM, mon4startPM);
        contentValues.put(COL_MON4_END_PM, mon4endPM);
        contentValues.put(COL_MON5_START_PM, mon5startPM);
        contentValues.put(COL_MON5_END_PM, mon5endPM);
        contentValues.put(COL_MON6_START_PM, mon6startPM);
        contentValues.put(COL_MON6_END_PM, mon6endPM);
        contentValues.put(COL_MON7_START_PM, mon7startPM);
        contentValues.put(COL_MON7_END_PM, mon7endPM);

        Long result = db.insert(TABLE_START_TIME, null, contentValues);
        return result != -1;
    }

    public Cursor getAllDataClass() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor resAllClass = db.rawQuery("SELECT * FROM " + TABLE_CLASSNAME + " ORDER BY CLASSNAME ASC", null);
        return resAllClass;
    }

    public Cursor getAllScheduleNameAndId() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor resAllClass = db.rawQuery("SELECT ID,NAME FROM " + "time_table" + " ORDER BY NAME ASC", null);
        return resAllClass;
    }

    public Cursor getAllScheduleName() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor resAllClass = db.rawQuery("SELECT * FROM " + "time_table" + " ORDER BY NAME ASC", null);
        return resAllClass;
    }

    public Integer deleteDataClass(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_CLASSNAME, "ID = ?", new String[]{String.valueOf(id)});

    }

    public Integer deleteSchedule(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("time_table", "ID = ?", new String[]{String.valueOf(id)});

    }

    public void deleteSchedulebyname(String studentname) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + "time_table" + " WHERE " + NAME + "='" + studentname + "'");
        db.close();
    }

    public Integer deleteDataStartEnd(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_START_TIME, "ID = ?", new String[]{String.valueOf(id)});

    }

    public Cursor getRow1StartEnd() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor resScore = db.rawQuery("SELECT * FROM " + TABLE_START_TIME + " WHERE ID = 1", null);
        return resScore;
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////


    public void CreateTimeTableForStudent(String studentname) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("create table if not exists " +TABLE_NAME + studentname + " ( CLASS INTEGER, MONDAY TEXT, TUESDAY TEXT, WEDNESDAY TEXT, THURSDAY TEXT, FRIDAY TEXT )");

        db.execSQL("insert into " +TABLE_NAME+ studentname + " (CLASS) values ('1')");
        db.execSQL("insert into " +TABLE_NAME+ studentname + " (CLASS) values ('2')");
        db.execSQL("insert into " +TABLE_NAME+ studentname + " (CLASS) values ('3')");
        db.execSQL("insert into " +TABLE_NAME+ studentname + " (CLASS) values ('4')");
        db.execSQL("insert into " +TABLE_NAME+ studentname + " (CLASS) values ('5')");
        db.execSQL("insert into " +TABLE_NAME+ studentname + " (CLASS) values ('6')");
        db.execSQL("insert into " +TABLE_NAME+ studentname + " (CLASS) values ('7')");


        //create classname for student db
        db.execSQL("create table if not exists " +TABLE_CLASSNAME+ studentname + " (ID INTEGER PRIMARY KEY , " + " CLASSNAME_ID INTEGER," +
                " GRADE1 INTEGER, GRADE2 INTEGER, GRADE3 INTEGER, GRADE4 INTEGER," +
                " GRADE5 INTEGER, GRADE6 INTEGER, GRADE7 INTEGER, GRADE8 INTEGER )");

    }



    public void UpdateClassnameByID(String studentname, int classname_ID, String newClassname) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE " + TABLE_CLASSNAME + studentname + " SET CLASSNAME = " + newClassname + " WHERE CLASSNAME_ID = " + classname_ID);

    }

    public void CreateClassStartEndTable(){

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("create table if not exists " + "class_start_time" + "(CLASS INTEGER, CLASSSTART_AM TEXT, CLASSEND_AM, CLASSSTART_PM, CLASSEND_PM)");

        db.execSQL("insert into " + "class_start_time"  + " (CLASS) values ('1')");
        db.execSQL("insert into " + "class_start_time"  + " (CLASS) values ('2')");
        db.execSQL("insert into " + "class_start_time"  + " (CLASS) values ('3')");
        db.execSQL("insert into " + "class_start_time"  + " (CLASS) values ('4')");
        db.execSQL("insert into " + "class_start_time"  + " (CLASS) values ('5')");
        db.execSQL("insert into " + "class_start_time"  + " (CLASS) values ('6')");
        db.execSQL("insert into " + "class_start_time"  + " (CLASS) values ('7')");


    }

    public boolean insertClassname(String editTextView) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_CLASS, editTextView);

        Long result = db.insert("classname_table", null, contentValues);
        return result != -1;
    }

    public Cursor readClassnameTable(){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor allClassnames = db.rawQuery("select * from " + "classname_table",null);
        return allClassnames;
    }

    public Cursor ReadStartEndTable(){

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor startEnd = db.rawQuery("select * from " + "class_start_time",null);

        return startEnd;
    }

    public void UpdateClassStartEndTable(int classNum, String startAM,String endAM, String startPM, String endPM){

        SQLiteDatabase db = this.getWritableDatabase();


        db.execSQL("UPDATE " + "class_start_time" + " SET CLASSSTART_AM = '" + startAM + "', CLASSEND_AM = '" + endAM + "', CLASSSTART_PM = '" + startPM + "',CLASSEND_PM = '" + endPM +
                "' WHERE CLASS = " + classNum);


    }

    public void updateSchedule(String studentname, String mon1, String tue1, String wed1, String thu1, String fri1,
                                                   String mon2, String tue2, String wed2, String thu2, String fri2,
                                                   String mon3, String tue3, String wed3, String thu3, String fri3,
                                                   String mon4, String tue4, String wed4, String thu4, String fri4,
                                                   String mon5, String tue5, String wed5, String thu5, String fri5,
                                                   String mon6, String tue6, String wed6, String thu6, String fri6,
                                                   String mon7, String tue7, String wed7, String thu7, String fri7)
    {

        SQLiteDatabase db = this.getWritableDatabase();



        db.execSQL("UPDATE " + TABLE_NAME + studentname + " SET MONDAY = '" + mon1 + "', TUESDAY = '" + tue1 + "', WEDNESDAY = '" + wed1 + "',THURSDAY = '" + thu1 + "', FRIDAY = '" + fri1 +
                   "' WHERE CLASS = 1");
        db.execSQL("UPDATE " + TABLE_NAME + studentname + " SET MONDAY = '" + mon2 + "', TUESDAY = '" + tue2 + "', WEDNESDAY = '" + wed2 + "',THURSDAY = '" + thu2 + "', FRIDAY ='" + fri2 +
                   "' WHERE CLASS = 2");
        db.execSQL("UPDATE " + TABLE_NAME + studentname + " SET MONDAY = '" + mon3 + "', TUESDAY = '" + tue3 + "', WEDNESDAY = '" + wed3 + "',THURSDAY = '" + thu3 + "', FRIDAY ='" + fri3 +
                   "' WHERE CLASS = 3");
        db.execSQL("UPDATE " + TABLE_NAME + studentname + " SET MONDAY = '" + mon4 + "', TUESDAY = '" + tue4 + "', WEDNESDAY = '" + wed4 + "',THURSDAY = '" + thu4 + "', FRIDAY ='" + fri4 +
                   "' WHERE CLASS = 4");
        db.execSQL("UPDATE " + TABLE_NAME + studentname + " SET MONDAY = '" + mon5 + "', TUESDAY = '" + tue5 + "', WEDNESDAY = '" + wed5 + "',THURSDAY = '" + thu5 + "', FRIDAY ='" + fri5 +
                   "' WHERE CLASS = 5");
        db.execSQL("UPDATE " + TABLE_NAME + studentname + " SET MONDAY = '" + mon6 + "', TUESDAY = '" + tue6 + "', WEDNESDAY = '" + wed6 + "',THURSDAY = '" + thu6 + "', FRIDAY ='" + fri6 +
                   "' WHERE CLASS = 6");
        db.execSQL("UPDATE " + TABLE_NAME + studentname + " SET MONDAY = '" + mon7 + "', TUESDAY = '" + tue7 + "', WEDNESDAY = '" + wed7 + "',THURSDAY = '" + thu7 + "', FRIDAY ='" + fri7 +
                   "' WHERE CLASS = 7");




    }


    public Cursor getDataForDay(String studentname, String day) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor mondaySchedule = db.rawQuery("SELECT " + day + " FROM " +TABLE_NAME+ studentname + " left join " + "classname_table" + " on "
                +TABLE_NAME + studentname +"."+day+" = "+ "classname_table" +".CLASSNAME_ID", null);
        return mondaySchedule;
    }

    public Cursor getDataForWeek(String studentname) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor allSchedule = db.rawQuery("SELECT * FROM " +TABLE_NAME+ studentname, null);
        return allSchedule;
    }

    public Cursor getTableNames(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor allTableNames = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name!='android_metadata' AND name LIKE 'time_table_%' order by name",null);
        return  allTableNames;
    }


}

