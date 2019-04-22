package com.djinons.schooleschedule.activitys;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.djinons.schooleschedule.DbHelper;
import com.djinons.schooleschedule.R;
import com.djinons.schooleschedule.dialogs.Close_dialog;
import com.djinons.schooleschedule.dialogs.Info_dialog;
import com.djinons.schooleschedule.fragments.FridayFragment;
import com.djinons.schooleschedule.fragments.MondayFragment;
import com.djinons.schooleschedule.fragments.ThursdayFragment;
import com.djinons.schooleschedule.fragments.TuesdayFragment;
import com.djinons.schooleschedule.fragments.WednesdayFragment;
import com.djinons.schooleschedule.models.SchedulenameModel;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.model.ExpandableDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileSettingDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondarySwitchDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.djinons.schooleschedule.R.layout.fragment_monday;
import static java.lang.System.out;
import static java.security.AccessController.getContext;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ViewPager vPager;
    DayViewPagerAdapter dayViewPagerAdapter;
    DbHelper myDb;
    private AccountHeader headerDrawer = null;
    public static Drawer drawer = null;

    ArrayAdapter<String> adapter;


    Spinner mon1, mon2, mon3, mon4, mon5, mon6, mon7;
    Spinner tue1, tue2, tue3, tue4, tue5, tue6, tue7;
    Spinner wed1, wed2, wed3, wed4, wed5, wed6, wed7;
    Spinner thu1, thu2, thu3, thu4, thu5, thu6, thu7;
    Spinner fri1, fri2, fri3, fri4, fri5, fri6, fri7;
    Spinner toolbarspinner;

    TextView mon1t, mon2t, mon3t, mon4t, mon5t, mon6t, mon7t;
    TextView tue1t, tue2t, tue3t, tue4t, tue5t, tue6t, tue7t;
    TextView wed1t, wed2t, wed3t, wed4t, wed5t, wed6t, wed7t;
    TextView thu1t, thu2t, thu3t, thu4t, thu5t, thu6t, thu7t;
    TextView fri1t, fri2t, fri3t, fri4t, fri5t, fri6t, fri7t;

    String Monday1, Monday2, Monday3, Monday4, Monday5, Monday6, Monday7;
    String Tuesday1, Tuesday2, Tuesday3, Tuesday4, Tuesday5, Tuesday6, Tuesday7;
    String Wednesday1, Wednesday2, Wednesday3, Wednesday4, Wednesday5, Wednesday6, Wednesday7;
    String Thursday1, Thursday2, Thursday3, Thursday4, Thursday5, Thursday6, Thursday7;
    String Friday1, Friday2, Friday3, Friday4, Friday5, Friday6, Friday7;
    String studentname;

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        studentname = toolbarspinner.getSelectedItem().toString();

        vPager = findViewById(R.id.vPager);
        dayViewPagerAdapter = new DayViewPagerAdapter(getSupportFragmentManager());

        if (vPager != null) {

            vPager.setAdapter(dayViewPagerAdapter);

        } else if (vPager == null) {

            Cursor res = myDb.getRow1(studentname);
            //reading DB
            if (res != null) {
                while (res.moveToNext()) {

                    Monday1 = (res.getString(2));
                    Monday2 = (res.getString(7));
                    Monday3 = (res.getString(12));
                    Monday4 = (res.getString(17));
                    Monday5 = (res.getString(22));
                    Monday6 = (res.getString(27));
                    Monday7 = (res.getString(32));

                    Tuesday1 = (res.getString(3));
                    Tuesday2 = (res.getString(8));
                    Tuesday3 = (res.getString(13));
                    Tuesday4 = (res.getString(18));
                    Tuesday5 = (res.getString(23));
                    Tuesday6 = (res.getString(28));
                    Tuesday7 = (res.getString(33));

                    Wednesday1 = (res.getString(4));
                    Wednesday2 = (res.getString(9));
                    Wednesday3 = (res.getString(14));
                    Wednesday4 = (res.getString(19));
                    Wednesday5 = (res.getString(24));
                    Wednesday6 = (res.getString(29));
                    Wednesday7 = (res.getString(34));

                    Thursday1 = (res.getString(5));
                    Thursday2 = (res.getString(10));
                    Thursday3 = (res.getString(15));
                    Thursday4 = (res.getString(20));
                    Thursday5 = (res.getString(25));
                    Thursday6 = (res.getString(30));
                    Thursday7 = (res.getString(35));

                    Friday1 = (res.getString(6));
                    Friday2 = (res.getString(11));
                    Friday3 = (res.getString(16));
                    Friday4 = (res.getString(21));
                    Friday5 = (res.getString(26));
                    Friday6 = (res.getString(31));
                    Friday7 = (res.getString(36));

                }

                //TextView reference
                mon1t = findViewById(R.id.mon1TextView);
                mon2t = findViewById(R.id.mon2TextView);
                mon3t = findViewById(R.id.mon3TextView);
                mon4t = findViewById(R.id.mon4TextView);
                mon5t = findViewById(R.id.mon5TextView);
                mon6t = findViewById(R.id.mon6TextView);
                mon7t = findViewById(R.id.mon7TextView);

                tue1t = findViewById(R.id.tue1TextView);
                tue2t = findViewById(R.id.tue2TextView);
                tue3t = findViewById(R.id.tue3TextView);
                tue4t = findViewById(R.id.tue4TextView);
                tue5t = findViewById(R.id.tue5TextView);
                tue6t = findViewById(R.id.tue6TextView);
                tue7t = findViewById(R.id.tue7TextView);

                wed1t = findViewById(R.id.wed1TextView);
                wed2t = findViewById(R.id.wed2TextView);
                wed3t = findViewById(R.id.wed3TextView);
                wed4t = findViewById(R.id.wed4TextView);
                wed5t = findViewById(R.id.wed5TextView);
                wed6t = findViewById(R.id.wed6TextView);
                wed7t = findViewById(R.id.wed7TextView);

                thu1t = findViewById(R.id.thu1TextView);
                thu2t = findViewById(R.id.thu2TextView);
                thu3t = findViewById(R.id.thu3TextView);
                thu4t = findViewById(R.id.thu4TextView);
                thu5t = findViewById(R.id.thu5TextView);
                thu6t = findViewById(R.id.thu6TextView);
                thu7t = findViewById(R.id.thu7TextView);

                fri1t = findViewById(R.id.fri1TextView);
                fri2t = findViewById(R.id.fri2TextView);
                fri3t = findViewById(R.id.fri3TextView);
                fri4t = findViewById(R.id.fri4TextView);
                fri5t = findViewById(R.id.fri5TextView);
                fri6t = findViewById(R.id.fri6TextView);
                fri7t = findViewById(R.id.fri7TextView);

                //setting values from DB
                mon1t.setText(Monday1);
                mon2t.setText(Monday2);
                mon3t.setText(Monday3);
                mon4t.setText(Monday4);
                mon5t.setText(Monday5);
                mon6t.setText(Monday6);
                mon7t.setText(Monday7);

                tue1t.setText(Tuesday1);
                tue2t.setText(Tuesday2);
                tue3t.setText(Tuesday3);
                tue4t.setText(Tuesday4);
                tue5t.setText(Tuesday5);
                tue6t.setText(Tuesday6);
                tue7t.setText(Tuesday7);

                wed1t.setText(Wednesday1);
                wed2t.setText(Wednesday2);
                wed3t.setText(Wednesday3);
                wed4t.setText(Wednesday4);
                wed5t.setText(Wednesday5);
                wed6t.setText(Wednesday6);
                wed7t.setText(Wednesday7);

                thu1t.setText(Thursday1);
                thu2t.setText(Thursday2);
                thu3t.setText(Thursday3);
                thu4t.setText(Thursday4);
                thu5t.setText(Thursday5);
                thu6t.setText(Thursday6);
                thu7t.setText(Thursday7);

                fri1t.setText(Friday1);
                fri2t.setText(Friday2);
                fri3t.setText(Friday3);
                fri4t.setText(Friday4);
                fri5t.setText(Friday5);
                fri6t.setText(Friday6);
                fri7t.setText(Friday7);

                myDb.close();

            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myDb = new DbHelper(this);
        myDb.getWritableDatabase();

        Cursor gotclassname = myDb.getAllDataClass();
        Cursor gotschedule = myDb.getAllScheduleName();

        if (gotclassname.getCount() < 2) {

            Intent addClassIntent = new Intent(MainActivity.this, AddClassNameActivity.class);
            MainActivity.this.startActivity(addClassIntent);

        }else if (gotschedule.getCount() < 1) {
            Intent addScheduleIntent = new Intent(MainActivity.this, AddNewScheduleActivity.class);
            MainActivity.this.startActivity(addScheduleIntent);
        }




        setContentView(R.layout.activity_main);

       // invalidateOptionsMenu();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbarspinner = findViewById(R.id.spinner_nav_sub);


        IProfile profile;
        profile = new ProfileDrawerItem().withName("Loggen user")//TODO username add
                .withIcon(R.drawable.gravatar);

     //   if (!Const.theme) {

            headerDrawer = new AccountHeaderBuilder()
                    .withActivity(this)
                    .withCompactStyle(true)
                    .withHeaderBackground(R.drawable.header)
                    .withCompactStyle(true)
                    .withDividerBelowHeader(true)
                    .addProfiles(
                            profile,
                            new ProfileSettingDrawerItem().withName("Manage Account")
                                    .withIcon(R.drawable.ic_manage_account_black).withIdentifier(200)
                                    .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                                        @Override
                                        public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                                            if (drawerItem != null) {
                                                Fragment fragment;
//                                                switch ((int) drawerItem.getIdentifier()) {
//                                                    case 200:
//                                                        clearBackStack();
//                                                        fragment = ManageAccountFragment.newInstance(getString(R.string.title_fragment_manage_account));
//                                                        FRAGMENT_TAG = getString(R.string.fragment_manage_account_tag);
//                                                        switchFragmentNoBackStackByTag
//                                                                (R.id.fragment_container, fragment, FRAGMENT_TAG);
//                                                        new android.os.Handler().postDelayed(
//                                                                new Runnable() {
//                                                                    public void run() {
//                                                                        drawer.deselect();
//                                                                    }
//                                                                }
//                                                                , 300);
//                                                        break;
//                                                    default:
//                                                        break;
//                                                }
                                            }
                                            toolbar.setTitle("Manage Account");
                                            return false;
                                        }
                                    })

                    )
                    .withSavedInstance(savedInstanceState)
                    .build();

            drawer = new DrawerBuilder()
                    .withActivity(this)
                    .withToolbar(toolbar)
                    .withTranslucentStatusBar(false)
                    .withActionBarDrawerToggleAnimated(true)
                    .withAccountHeader(headerDrawer)
                    .addDrawerItems(
                            new PrimaryDrawerItem().withName(R.string.drawer_item_home)
                                    .withIcon(R.drawable.ic_home_black)
                                    .withIdentifier(1),
//                            new PrimaryDrawerItem()
//                                    .withName(R.string.drawer_item_notifications)
//                                    .withIcon(R.drawable.ic_notifications_black)
//                                    .withIdentifier(3)
//                                    .withBadgeStyle(new BadgeStyle().withTextColor(Color.WHITE)
//                                            .withColorRes(R.color.colorAccent)),
//                            new PrimaryDrawerItem()
//                                    .withName("New message")
//                                    .withIcon(R.drawable.ic_message_black)
//                                    .withIdentifier(4)
//                                    .withBadgeStyle(new BadgeStyle().withTextColor(Color.WHITE)
//                                            .withColorRes(R.color.colorAccent)),

                            new PrimaryDrawerItem()
                                    .withName("Add classname")
                                    .withIcon(R.drawable.ic_employees_black)
                                    .withIdentifier(10),
                            new PrimaryDrawerItem()
                                    .withName("Add student")
                                    .withIcon(R.drawable.ic_absences_black)
                                    .withIdentifier(11),

                            new PrimaryDrawerItem()
                                    .withName("Edit schedule")
                                    .withIcon(R.drawable.ic_realizations_black)
                                    .withIdentifier(15),

                            new SectionDrawerItem()
                                    .withName("Accessories")
                                    .withIdentifier(5),
                            new ExpandableDrawerItem().withName("Settings")
                                    .withIcon(R.drawable.ic_settings_black)
                                    .withIdentifier(6)
                                    .withSelectable(false)
                                    .withSubItems(
                                            new SecondarySwitchDrawerItem()
                                                    .withName("Theme")
                                                    .withIcon(R.drawable.ic_theme_black)
                                                    .withIdentifier(100)
                                                    .withSelectable(false)
                                                  //  .withChecked(sharedPreferences.getBoolean(Const.DEFAULT_THEME, false))
                                              //      .withOnCheckedChangeListener(onCheckedChangeListener)//TODO comma separator
//                                            new SecondaryDrawerItem()
//                                                    .withName(R.string.drawer_item_notification_sleep_timer)
//                                                    .withIcon(R.drawable.ic_notifications_frequency_black)
//                                                    .withIdentifier(102)
//                                                    .withSelectable(false)
                                    )
                    )
                    .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                        @Override
                        public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                            if (drawerItem != null) {
                                Fragment fragment;
//                                switch ((int) drawerItem.getIdentifier()) {
//                                    case 1:
//                                        clearBackStack();
//                                        fragment = HomeFragment.newInstance(getString(R.string.app_name));
//                                        FRAGMENT_TAG = getString(R.string.fragment_home_tag);
//                                        break;
//                                    case 3:
//                                        clearBackStack();
//                                        Const.notifications = NotificationBackgroundService.getNotifications();
//                                        notificationsCount = Const.notifications.size();
//                                        fragment = NotificationsFragment.newInstance(getString(R.string.title_fragment_notifications), notificationsCount);
//                                        FRAGMENT_TAG = getString(R.string.fragment_notifications_tag);
//                                        break;
//                                    case 4:
//                                        clearBackStack();
//                                        fragment = SendMessageFragment.newInstance("New message");
//                                        FRAGMENT_TAG = getString(R.string.fragment_notifications_tag);
//                                        break;
//                                    case 20:
//                                        clearBackStack();
//                                        fragment = AboutUsFragment.newInstance(getString(R.string.title_fragment_about_us));
//                                        FRAGMENT_TAG = getString(R.string.fragment_about_us_tag);
//                                        break;
//                                    case 21:
//                                        clearBackStack();
//                                        showAlertLogOut();
//                                        drawer.setSelection(1, true);
//                                        checkLogOut = true;
//                                        fragment = HomeFragment.newInstance(getString(R.string.app_name));
//                                        FRAGMENT_TAG = getString(R.string.fragment_home_tag);
//                                        break;
//                                    case 10:
//                                        clearBackStack();
//                                        fragment = EmployeeFragment.newInstance(getString(R.string.title_fragment_employees));
//                                        FRAGMENT_TAG = getString(R.string.fragment_employees_tag);
//                                        break;
//                                    case 11:
//                                        clearBackStack();
//                                        Const.teamLeaderCheckingEmployees = false;
//                                        fragment = AbsencesTabFragment.newInstance(getString(R.string.title_fragment_absences));
//                                        FRAGMENT_TAG = getString(R.string.fragment_absences_tag);
//                                        break;
//                                    case 12:
//                                        // clearBackStack();
//                                        fragment = NewAbsenceFragment.newInstance(getString(R.string.title_fragment_new_absence));
//                                        FRAGMENT_TAG = getString(R.string.fragment_new_absences_tag);
//                                        break;
//                                    case 15:
//                                        clearBackStack();
//                                        fragment = RealizationsFragment.newInstance(getString(R.string.title_fragment_realizations));
//                                        FRAGMENT_TAG = getString(R.string.fragment_realizations_tag);
//                                        break;
//                                    case 102:
//                                        toolbarTitle = toolbar.getTitle().toString();
//                                        notificationFrequencyDialogOpen = true;
//                                        ShowNotificationSleepTimer();
//
//                                    default:
//                                        clearBackStack();
//                                        fragment = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);
//                                        break;
//                                }
//                                switchFragmentNoBackStackByTag(R.id.fragment_container, fragment, FRAGMENT_TAG);

                            }
                            if (drawerItem instanceof Nameable) {
//                                if (!(((Nameable) drawerItem).getName().getText(MainActivity.this))
//                                        .equalsIgnoreCase(getString(R.string.drawer_item_settings)) || (((Nameable) drawerItem).getName()
//                                        .getText(MainActivity.this)).equalsIgnoreCase(getString(R.string.drawer_item_theme_switch))) {
//                                    if (!checkLogOut) {
//                                        toolbar.setTitle((((Nameable) drawerItem).getName().getText(MainActivity.this)));
//                                    } else {
//                                        toolbar.setTitle(getString(R.string.app_name));
//                                        checkLogOut = false;
//                                    }
//                                    if (notificationFrequencyDialogOpen) {
//                                        toolbar.setTitle(toolbarTitle);
//                                        notificationFrequencyDialogOpen = false;
//                                    }
//                                }
                            }
                            return false;
                        }
                    })
                    .withOnDrawerListener(new Drawer.OnDrawerListener() {
                                              @Override
                                              public void onDrawerOpened(View drawerView) {
                                                  new Handler().postDelayed(
                                                          new Runnable() {
                                                              public void run() {
                                                                  long item = drawer.getCurrentSelection();
                                                                  drawer.deselect();
                                                                  drawer.setSelection(item, false);
                                                              }
                                                          }, 200);
                                              }

                                              @Override
                                              public void onDrawerClosed(View drawerView) {
                                                  new Handler().postDelayed(
                                                          new Runnable() {
                                                              public void run() {
                                                    //              updateNotificationBadge(false);
                                                              }
                                                          }, 500);
                                              }

                                              @Override
                                              public void onDrawerSlide(View drawerView, float slideOffset) {

                                              }
                                          }
                    )
                    .addStickyDrawerItems(
                            new SecondaryDrawerItem()
                                    .withName("About")
                                    .withIcon(R.drawable.ic_info_black)
                                    .withIdentifier(20)
                    ).withSavedInstance(savedInstanceState)
                    .addStickyDrawerItems(
                            new SecondaryDrawerItem()
                                    .withName("Log out")
                                    .withIcon(R.drawable.ic_log_out_black)
                                    .withIdentifier(21)

                    ).withSavedInstance(savedInstanceState)
                    .build();
    //    }







        int id = 0;
        String name = null;
        ArrayList<SchedulenameModel> ScheduleNameArray = new ArrayList<>();
        Cursor schedulename = myDb.getAllScheduleName();
        while (schedulename.moveToNext()) {

            SchedulenameModel schedulenameModel = new SchedulenameModel(id, name);
            schedulenameModel.setId(schedulename.getInt(0));
            schedulenameModel.setSchedulename((schedulename.getString(1)));
            ScheduleNameArray.add(schedulenameModel);
            out.println(schedulenameModel.getId());
            out.println(schedulenameModel.getSchedulename());
        }

        Set<String> set = new HashSet<String>();
        Cursor schedulename1 = myDb.getAllScheduleName();

        if (schedulename1.moveToFirst()) {
            do {
                set.add(schedulename1.getString(1));
            } while (schedulename1.moveToNext());
        }
        schedulename1.close();


//Convert set into list
        List<String> list = new ArrayList<String>(set);
//Sort Data Alphabetical order
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String lhs, String rhs) {
                return lhs.compareTo(rhs);
            }
        });
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        toolbarspinner.setAdapter(adapter);
        toolbarspinner.setOnItemSelectedListener(this);


    }

    public String getMyData() {
        return studentname;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        Cursor gotclassname = myDb.getAllDataClass();
        Cursor gotschedule = myDb.getAllScheduleName();

        LayoutInflater layoutInflater = LayoutInflater.from(this);


        if (gotclassname.getCount() < 2) {
            getMenuInflater().inflate(R.menu.menu_inicial, menu);


        }else if (gotschedule.getCount() < 1){
            getMenuInflater().inflate(R.menu.menu_got_classname, menu);

        }else{
            getMenuInflater().inflate(R.menu.menu_got_classname_schedule, menu);
        }
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
         }*/
         if (id == R.id.action_addClassname) {
             Intent addClassIntent = new Intent(MainActivity.this, AddClassNameActivity.class);
             MainActivity.this.startActivity(addClassIntent);
         }
         if (id == R.id.action_edit) {
            Intent editIntent = new Intent(MainActivity.this, EditDeleteActivity.class);
            MainActivity.this.startActivity(editIntent);
         }
        if (id == R.id.action_class_start_end) {
            Intent startendIntent = new Intent(MainActivity.this, ClassStartEndActivity.class);
            MainActivity.this.startActivity(startendIntent);
        }
        if (id == R.id.help) {
            Intent helpIntent = new Intent(MainActivity.this, HelpActivity.class);
            MainActivity.this.startActivity(helpIntent);
        }
        if (id == R.id.action_addSchedule) {
            Intent addScheduleIntent = new Intent(MainActivity.this, AddNewScheduleActivity.class);
            MainActivity.this.startActivity(addScheduleIntent);
        }

         if (id == R.id.action_about) {
            aboutDialog();
            return true;
         }
         return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        onShowQuitDialog();
    }

    private void aboutDialog() {
        Info_dialog info_dialog = new Info_dialog();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.addToBackStack(null);
        info_dialog.show(ft,"info_dialog");
    }

    public void SaveTimeTable() {

        Cursor res = myDb.getAllData();
        if (res.getCount() < 1) {

        }
        res.close();

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

/**
        boolean isInserted = myDb.insertData(
                mon1.getSelectedItem().toString(), tue1.getSelectedItem().toString(), wed1.getSelectedItem().toString(), thu1.getSelectedItem().toString(), fri1.getSelectedItem().toString(),
                mon2.getSelectedItem().toString(), tue2.getSelectedItem().toString(), wed2.getSelectedItem().toString(), thu2.getSelectedItem().toString(), fri2.getSelectedItem().toString(),
                mon3.getSelectedItem().toString(), tue3.getSelectedItem().toString(), wed3.getSelectedItem().toString(), thu3.getSelectedItem().toString(), fri3.getSelectedItem().toString(),
                mon4.getSelectedItem().toString(), tue4.getSelectedItem().toString(), wed4.getSelectedItem().toString(), thu4.getSelectedItem().toString(), fri4.getSelectedItem().toString(),
                mon5.getSelectedItem().toString(), tue5.getSelectedItem().toString(), wed5.getSelectedItem().toString(), thu5.getSelectedItem().toString(), fri5.getSelectedItem().toString(),
                mon6.getSelectedItem().toString(), tue6.getSelectedItem().toString(), wed6.getSelectedItem().toString(), thu6.getSelectedItem().toString(), fri6.getSelectedItem().toString(),
                mon7.getSelectedItem().toString(), tue7.getSelectedItem().toString(), wed7.getSelectedItem().toString(), thu7.getSelectedItem().toString(), fri7.getSelectedItem().toString());

        if (isInserted == true) {
            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();

            ReadSQL();

        } else
            Toast.makeText(MainActivity.this, "Data is not Inserted", Toast.LENGTH_SHORT).show();

        myDb.close();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
 */
    }

    public void DeleteBase() {
        myDb.deleteData(0);
    }

    public void SaveTable(View view) {
        DeleteBase();
        SaveTimeTable();
        recreate();
    }

    public void ViewTimeTable(View view) {

        //read from SQLite
        Cursor res = myDb.getAllData();

        if (res != null) {
            while (res.moveToNext()) {
                Monday1 = (res.getString(1));
                Monday2 = (res.getString(6));
                Monday3 = (res.getString(11));
                Monday4 = (res.getString(16));
                Monday5 = (res.getString(21));
                Monday6 = (res.getString(26));

                Tuesday1 = (res.getString(2));
                Tuesday2 = (res.getString(7));
                Tuesday3 = (res.getString(12));
                Tuesday4 = (res.getString(17));
                Tuesday5 = (res.getString(22));
                Tuesday6 = (res.getString(27));

                Wednesday1 = (res.getString(3));
                Wednesday2 = (res.getString(8));
                Wednesday3 = (res.getString(13));
                Wednesday4 = (res.getString(18));
                Wednesday5 = (res.getString(23));
                Wednesday6 = (res.getString(28));

                Thursday1 = (res.getString(4));
                Thursday2 = (res.getString(9));
                Thursday3 = (res.getString(14));
                Thursday4 = (res.getString(19));
                Thursday5 = (res.getString(24));
                Thursday6 = (res.getString(29));

                Friday1 = (res.getString(5));
                Friday2 = (res.getString(10));
                Friday3 = (res.getString(15));
                Friday4 = (res.getString(20));
                Friday5 = (res.getString(25));
                Friday6 = (res.getString(30));

            }
            res.close();
        }
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void ReadSQL() {
        Cursor res = myDb.getAllData();

        if (res.getCount() == 0) {
            showMessage("Error", "Nothing Found");
            res.close();
            return;
        }

    }

    public void onShowQuitDialog() {
        Close_dialog close_dialog = new Close_dialog();
        FragmentTransaction frt = getSupportFragmentManager().beginTransaction();
        frt.addToBackStack(null);
        close_dialog.show(frt, "close_dialog");
    }




    public class DayViewPagerAdapter extends FragmentStatePagerAdapter {

        public String monday = getString(R.string.monday);
        public String tuesday = getString(R.string.tuesday);
        public String wednesday = getString(R.string.wednesday);
        public String thursday = getString(R.string.thursday);
        public String friday = getString(R.string.friday);

        static final int NUM_ITEMS = 5;
        final String[] TAB_TITLES = new String[]{ monday, tuesday, wednesday, thursday, friday};




        public DayViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            saveState();


        }


        @Override
        public Fragment getItem(int position) {


            switch (position) {
                case 0:
                    return new MondayFragment();
                case 1:
                    return new TuesdayFragment();
                case 2:
                    return new WednesdayFragment();
                case 3:
                    return new ThursdayFragment();
                case 4:
                    return new FridayFragment();
                default:
                    return null;

            }


        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return TAB_TITLES[position];
        }



    }

}

