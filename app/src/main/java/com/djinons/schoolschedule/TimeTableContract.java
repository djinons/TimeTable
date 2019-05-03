package com.djinons.schoolschedule;

import android.provider.BaseColumns;

/**
 * Created by djinons on 8.1.2018..
 */

public class TimeTableContract {


    public static final class TimeTableEntry implements BaseColumns {

        public static final String DATABASE_NAME = "timetable.db";
        public static final String TABLE_NAME = "time_table_";
        public static final String NAME = "NAME";
        public static final String COL_2 = "MONDAY1";
        public static final String COL_3 = "TUESDAY1";
        public static final String COL_4 = "WEDNESDAY1";
        public static final String COL_5 = "THURSDAY1";
        public static final String COL_6 = "FRIDAY1";

        public static final String COL_7 = "MONDAY2";
        public static final String COL_8 = "TUESDAY2";
        public static final String COL_9 = "WEDNESDAY2";
        public static final String COL_10 = "THURSDAY2";
        public static final String COL_11 = "FRIDAY2";

        public static final String COL_12 = "MONDAY3";
        public static final String COL_13 = "TUESDAY3";
        public static final String COL_14 = "WEDNESDAY3";
        public static final String COL_15 = "THURSDAY3";
        public static final String COL_16 = "FRIDAY3";

        public static final String COL_17 = "MONDAY4";
        public static final String COL_18 = "TUESDAY4";
        public static final String COL_19 = "WEDNESDAY4";
        public static final String COL_20 = "THURSDAY4";
        public static final String COL_21 = "FRIDAY4";

        public static final String COL_22 = "MONDAY5";
        public static final String COL_23 = "TUESDAY5";
        public static final String COL_24 = "WEDNESDAY5";
        public static final String COL_25 = "THURSDAY5";
        public static final String COL_26 = "FRIDAY5";

        public static final String COL_27 = "MONDAY6";
        public static final String COL_28 = "TUESDAY6";
        public static final String COL_29 = "WEDNESDAY6";
        public static final String COL_30 = "THURSDAY6";
        public static final String COL_31 = "FRIDAY6";

        public static final String COL_32 = "MONDAY7";
        public static final String COL_33 = "TUESDAY7";
        public static final String COL_34 = "WEDNESDAY7";
        public static final String COL_35 = "THURSDAY7";
        public static final String COL_36 = "FRIDAY7";



        public static final String TABLE_CLASSNAME = "class_names_";
        public static final String COL_CLASS = "CLASSNAME";



        public static final String TABLE_START_TIME = "start_time";
        public static final String COL_MON1_START_AM = "mon1startam";
        public static final String COL_MON1_END_AM = "mon1endam";
        public static final String COL_MON2_START_AM = "mon2startam";
        public static final String COL_MON2_END_AM = "mon2endam";
        public static final String COL_MON3_START_AM = "mon3startam";
        public static final String COL_MON3_END_AM = "mon3endam";
        public static final String COL_MON4_START_AM = "mon4startam";
        public static final String COL_MON4_END_AM = "mon4endam";
        public static final String COL_MON5_START_AM = "mon5startam";
        public static final String COL_MON5_END_AM = "mon5endam";
        public static final String COL_MON6_START_AM = "mon6startam";
        public static final String COL_MON6_END_AM = "mon6endam";
        public static final String COL_MON7_START_AM = "mon7startam";
        public static final String COL_MON7_END_AM = "mon7endam";

        public static final String COL_MON1_START_PM = "mon1startpm";
        public static final String COL_MON1_END_PM = "mon1endpm";
        public static final String COL_MON2_START_PM = "mon2startpm";
        public static final String COL_MON2_END_PM = "mon2endpm";
        public static final String COL_MON3_START_PM = "mon3startpm";
        public static final String COL_MON3_END_PM = "mon3endpm";
        public static final String COL_MON4_START_PM = "mon4startpm";
        public static final String COL_MON4_END_PM = "mon4endpm";
        public static final String COL_MON5_START_PM = "mon5startpm";
        public static final String COL_MON5_END_PM = "mon5endpm";
        public static final String COL_MON6_START_PM = "mon6startpm";
        public static final String COL_MON6_END_PM = "mon6endpm";
        public static final String COL_MON7_START_PM = "mon7startpm";
        public static final String COL_MON7_END_PM = "mon7endpm";

    }



}
