package com.djinons.schoolschedule.activitys;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;

import com.djinons.schoolschedule.DbHelper;
import com.djinons.schoolschedule.R;
import com.djinons.schoolschedule.WeekRecyclerViewAdapter;
import com.djinons.schoolschedule.fragments.AddClassnameFragment;
import com.djinons.schoolschedule.fragments.ClassStartEndFragment;
import com.djinons.schoolschedule.fragments.EditDeleteScheduleFragment;
import com.djinons.schoolschedule.fragments.FridayFragment;
import com.djinons.schoolschedule.fragments.HomeFragment;
import com.djinons.schoolschedule.fragments.MondayFragment;
import com.djinons.schoolschedule.fragments.ThursdayFragment;
import com.djinons.schoolschedule.fragments.TuesdayFragment;
import com.djinons.schoolschedule.fragments.WednesdayFragment;
import com.djinons.schoolschedule.models.SchedulenameModel;
import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperActivityToast;
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.interfaces.OnCheckedChangeListener;
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



public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static Drawer drawer = null;
    public static String FRAGMENT_TAG = "";
    DbHelper myDb;
    ArrayAdapter<String> adapter;
    Spinner toolbarspinner;
    String studentname;

    private ArrayList<Integer> classNumberList;
    private ArrayList<String> mondayClassnameList;
    private ArrayList<String> tuesdayClassnameList;
    private ArrayList<String> wednesdayClassnameList;
    private ArrayList<String> thursdayClassnameList;
    private ArrayList<String> fridayClassnameList;
    private WeekRecyclerViewAdapter weekRecyclerViewAdapter;

    private boolean doubleBackToExitPressedOnce = false;


    private OnCheckedChangeListener onCheckedChangeListener = new OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(IDrawerItem drawerItem, CompoundButton buttonView, boolean isChecked) {
            //  SharedPreferences.Editor editor = sharedPreferences.edit();

            if (drawerItem instanceof Nameable)
                //               if (drawerItem.getIdentifier() == 100) {
                //        editor.putBoolean(Const.DEFAULT_THEME, isChecked).apply(); //commit
//                    if (isChecked) {
//                        Const.theme = true;
//                        ChangeTheme.changeToTheme(MainActivity.this, ChangeTheme.THEME_DARK);
//                    } else {
//                        ChangeTheme.changeToTheme(MainActivity.this, ChangeTheme.THEME_LIGHT);
//                        Const.theme = false;
//                    }
//                }
                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                //                updateNotificationBadge(false);
                            }
                        }
                        , 500);
        }
    };



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        studentname = toolbarspinner.getSelectedItem().toString();

        RecyclerView mainLandRecyclerView = findViewById(R.id.main_land_recycler_view);

        if(mainLandRecyclerView == null){

            Fragment fragment;
            clearBackStack();
            fragment = HomeFragment.newInstance(getString(R.string.app_name));
            FRAGMENT_TAG = "Home_fragment_tag";
            switchFragmentNoBackStackByTag(R.id.fragment_container, fragment, FRAGMENT_TAG);

        }

        if (mainLandRecyclerView != null) {


            // DbHelper myDb;

            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            mainLandRecyclerView.setLayoutManager(layoutManager);


            classNumberList = new ArrayList<>();
            mondayClassnameList = new ArrayList<>();
            tuesdayClassnameList = new ArrayList<>();
            wednesdayClassnameList = new ArrayList<>();
            thursdayClassnameList = new ArrayList<>();
            fridayClassnameList = new ArrayList<>();

            myDb = new DbHelper(this);
            myDb.getWritableDatabase();
            Cursor dataForWeek = myDb.getDataForWeek("Dunja");

            while (dataForWeek.moveToNext()) {

                classNumberList.add(Integer.valueOf(dataForWeek.getString(0)));
                mondayClassnameList.add(dataForWeek.getString(1));
                tuesdayClassnameList.add(dataForWeek.getString(2));
                wednesdayClassnameList.add(dataForWeek.getString(3));
                thursdayClassnameList.add(dataForWeek.getString(4));
                fridayClassnameList.add(dataForWeek.getString(5));
            }
            dataForWeek.close();
            myDb.close();


            weekRecyclerViewAdapter = new WeekRecyclerViewAdapter(classNumberList, mondayClassnameList, tuesdayClassnameList,
                    wednesdayClassnameList, thursdayClassnameList, fridayClassnameList, this);
            mainLandRecyclerView.setAdapter(weekRecyclerViewAdapter);

            myDb.close();


        }
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private Fragment getVisibleFragment() {
        FragmentManager fragmentManager = MainActivity.this.getSupportFragmentManager();
        List<Fragment> fragments = fragmentManager.getFragments();
        for (Fragment fragment : fragments) {
            if (fragment != null && fragment.isVisible())
                return fragment;
        }
        return null;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myDb = new DbHelper(this);
        myDb.getWritableDatabase();




        Cursor allTableNames = myDb.getTableNames();




        if (allTableNames.getCount() < 1) {

            Fragment fragment;
            clearBackStack();
            fragment = AddClassnameFragment.newInstance("Add Classname");
            FRAGMENT_TAG = "fragment_add_classname_tag";
            switchFragmentNoBackStackByTag(R.id.fragment_container, fragment, FRAGMENT_TAG);

        }

//        myDb.CreateTimeTableForStudent("Dunja");
//        myDb.CreateClassStartEndTable();
//        myDb.CreateClassnameTable();

        setContentView(R.layout.activity_main);


        while (allTableNames.moveToNext()) {

            System.out.println(myDb.getTableNames());


        }



        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbarspinner = findViewById(R.id.spinner_nav_sub);


        IProfile profile;
        profile = new ProfileDrawerItem().withName("Logged user")//TODO username add
                .withIcon(R.drawable.gravatar);

        //   if (!Const.theme) {

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
        AccountHeader headerDrawer = new AccountHeaderBuilder()
                .withActivity(this)
                .withCompactStyle(false)
                .withHeaderBackground(R.drawable.header)
                //   .withCompactStyle(true)
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
                        new PrimaryDrawerItem()
                                .withName("Home")
                                .withIcon(R.drawable.ic_home_black)
                                .withIdentifier(1),
                        new PrimaryDrawerItem()
                                .withName("Add student")
                                .withIcon(R.drawable.ic_absences_black)
                                .withIdentifier(11),
                        new PrimaryDrawerItem()
                                .withName("Edit schedule")
                                .withIcon(R.drawable.ic_realizations_black)
                                .withIdentifier(15),
                        new PrimaryDrawerItem()
                                .withName("Add classname")
                                .withIcon(R.drawable.ic_employees_black)
                                .withIdentifier(10),
                        new PrimaryDrawerItem()
                                .withName("Set Start/End Time")
                                .withIcon(R.drawable.ic_realizations_black)
                                .withIdentifier(50),
                        new PrimaryDrawerItem()
                                .withName("My Grades")
                                .withIcon(R.drawable.ic_realizations_black)
                                .withIdentifier(60),

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
                                                .withOnCheckedChangeListener(onCheckedChangeListener),//TODO comma separator
                                        new SecondaryDrawerItem()
                                                .withName("Language")
                                                .withIcon(R.drawable.ic_notifications_frequency_black)
                                                .withIdentifier(102)
                                                .withSelectable(false)
                                )
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {

                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem != null) {
                            Fragment fragment;
                            switch ((int) drawerItem.getIdentifier()) {
                                   case 1:
                                        clearBackStack();
                                        fragment = HomeFragment.newInstance(getString(R.string.app_name));
                                        FRAGMENT_TAG = "Home_fragment_tag";

//                                        vPager.setVisibility(View.GONE);
//                                        viewPagerTab.setVisibility(View.GONE);

                                       switchFragmentNoBackStackByTag(R.id.fragment_container, fragment, FRAGMENT_TAG);


                                       break;
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
                                case 11:
                                    drawer.setSelection(1, true);
                                    Intent addScheduleIntent = new Intent(MainActivity.this, AddNewScheduleActivity.class);
                                    MainActivity.this.startActivity(addScheduleIntent);
                                    break;
                                case 10:
                                    clearBackStack();
                                    fragment = AddClassnameFragment.newInstance("Add Classname");
                                    FRAGMENT_TAG = "fragment_add_classname_tag";
//                                    vPager.setVisibility(View.GONE);
//                                    viewPagerTab.setVisibility(View.GONE);
                                    switchFragmentNoBackStackByTag(R.id.fragment_container, fragment, FRAGMENT_TAG);
                                    break;
                                case 50:
                                    clearBackStack();
                                    fragment = ClassStartEndFragment.newInstance("Set Start/End Time");
                                    FRAGMENT_TAG = "fragment_set_start_end_time_tag";
//                                    vPager.setVisibility(View.GONE);
//                                    viewPagerTab.setVisibility(View.GONE);
                                    switchFragmentNoBackStackByTag(R.id.fragment_container, fragment, FRAGMENT_TAG);
                                    break;
//                                    case 12:
//                                        // clearBackStack();
//                                        fragment = NewAbsenceFragment.newInstance(getString(R.string.title_fragment_new_absence));
//                                        FRAGMENT_TAG = getString(R.string.fragment_new_absences_tag);
//                                        break;
                                case 15:
                                    clearBackStack();
                                    fragment = EditDeleteScheduleFragment.newInstance("Edit/Delete Schedule");
                                    FRAGMENT_TAG = "fragment_edit_delete_schedule_tag";
//                                    vPager.setVisibility(View.GONE);
//                                    viewPagerTab.setVisibility(View.GONE);
                                    switchFragmentNoBackStackByTag(R.id.fragment_container, fragment, FRAGMENT_TAG);
                                    break;
//                                    case 102:
//                                        toolbarTitle = toolbar.getTitle().toString();
//                                        notificationFrequencyDialogOpen = true;
//                                        ShowNotificationSleepTimer();
//
                                default:
                                    clearBackStack();
                                    //fragment = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);
                                    break;
                            }


                        }
                        if (drawerItem instanceof Nameable) {
                            if (!(((Nameable) drawerItem).getName().getText(MainActivity.this))
                                    .equalsIgnoreCase("settings") || (((Nameable) drawerItem).getName()
                                    .getText(MainActivity.this)).equalsIgnoreCase("theme")) {
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
                            }
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
                ).addStickyDrawerItems(
                        new SecondaryDrawerItem()
                                .withName("Help")
                                .withIcon(R.drawable.ic_question_sign_dark)
                                .withIdentifier(20)
                ).withSavedInstance(savedInstanceState)
                .addStickyDrawerItems(
                        new SecondaryDrawerItem()
                                .withName("About")
                                .withIcon(R.drawable.ic_info_black)
                                .withIdentifier(20)
                ).withSavedInstance(savedInstanceState)
                .addStickyDrawerItems(
                        new SecondaryDrawerItem()
                                .withName("Exit")
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

        }

        Set<String> set = new HashSet<String>();
        Cursor schedulename1 = myDb.getTableNames();

        if (schedulename1.moveToFirst()) {
            do {

                String sName = schedulename1.getString(0);

                String[] split = sName.split("_");




                set.add(split[2]);




            } while (schedulename1.moveToNext());
        }
        schedulename1.close();


//Convert set into list
        List<String> list = new ArrayList<>(set);
//Sort Data Alphabetical order
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String lhs, String rhs) {
                return lhs.compareTo(rhs);
            }
        });
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        toolbarspinner.setAdapter(adapter);
        toolbarspinner.setOnItemSelectedListener(this);


    }



    public String getMyData() {
        return studentname;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//
//        // Inflate the menu; this adds items to the action bar if it is present.
//        Cursor gotclassname = myDb.getAllDataClass();
//        Cursor gotschedule = myDb.getAllScheduleName();


//        if (myFragment != null && myFragment.isVisible()) {
//            // add your code here
//
//            getMenuInflater().inflate(R.menu.menu_save, menu);
//        }


//
//        LayoutInflater layoutInflater = LayoutInflater.from(this);
//
//
//        if (gotclassname.getCount() < 2) {
//            getMenuInflater().inflate(R.menu.menu_inicial, menu);
//
//
//        } else if (gotschedule.getCount() < 1) {
//            getMenuInflater().inflate(R.menu.menu_got_classname, menu);
//
//        } else {
//            getMenuInflater().inflate(R.menu.menu_got_classname_schedule, menu);
//        }
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        /**  if (id == R.id.action_refresh) {
//         if (isNetworkAvailable()) {
//         getTodayWeather();
//         getLongTermWeather();
//         } else {
//         Snackbar.make(appView, getString(R.string.msg_connection_not_available), Snackbar.LENGTH_LONG).show();
//         }
//         return true;
//         }
//
//         if (id == R.id.action_search) {
//         searchCities();
//         return true;
//         }*/
//        if (id == R.id.action_addClassname) {
//            Intent addClassIntent = new Intent(MainActivity.this, AddClassNameActivity.class);
//            MainActivity.this.startActivity(addClassIntent);
//        }
//        if (id == R.id.action_edit) {
//            Intent editIntent = new Intent(MainActivity.this, EditDeleteActivity.class);
//            MainActivity.this.startActivity(editIntent);
//        }
//        if (id == R.id.action_class_start_end) {
//            Intent startendIntent = new Intent(MainActivity.this, ClassStartEndActivity.class);
//            MainActivity.this.startActivity(startendIntent);
//        }
//        if (id == R.id.help) {
//            Intent helpIntent = new Intent(MainActivity.this, HelpActivity.class);
//            MainActivity.this.startActivity(helpIntent);
//        }
//        if (id == R.id.action_addSchedule) {
//            Intent addScheduleIntent = new Intent(MainActivity.this, AddNewScheduleActivity.class);
//            MainActivity.this.startActivity(addScheduleIntent);
//        }
//
//        if (id == R.id.action_about) {
//            aboutDialog();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }





    @Override
    public void onBackPressed() {


        if (drawer != null && drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        } else {
            int fragmentBackStackCount = getSupportFragmentManager().getBackStackEntryCount();
            if (fragmentBackStackCount > 0) {
                Fragment fr = getSupportFragmentManager().getFragments().get(0);
                FRAGMENT_TAG = fr.getTag();

                getSupportFragmentManager().beginTransaction()
//                        .setCustomAnimations(R.anim.push_left_in, R.anim.push_left_out)
                        .replace(R.id.fragment_container, fr, FRAGMENT_TAG)
                        .commit();

                getSupportFragmentManager().popBackStack();

                clearBackStack();

            } else {
                // Close application
                if (doubleBackToExitPressedOnce) {
//                        if (sharedPreferences.getString("username", "").equals("")) {
//                            Intent i = new Intent(getApplicationContext(), NotificationBackgroundService.class);
//                            i.putExtra("notificationURL", Const.SERVICE_GET_ALL_NOTIFICATIONS);
//                            i.putExtra("username", Const.loggedUser.getUsername());
//                            i.putExtra("password", Const.loggedUser.getPassword());
//                            i.putExtra("sleepTimer", 0);
//                            startService(i);
//                        }
                    super.onBackPressed();
                    return;
                }
                if (drawer.getCurrentSelection() != 1) {
                    drawer.setSelection(1, true);
//                     getSupportFragmentManager().getBackStackEntryAt(0);

                } else {
                    this.doubleBackToExitPressedOnce = true;

                    SuperActivityToast.create(this, new Style(), Style.TYPE_STANDARD)
                            .setText("Press again to exit")
                            .setDuration(Style.DURATION_LONG)
                            .setFrame(Style.FRAME_LOLLIPOP)
                            .setColor(PaletteUtils.getSolidColor(PaletteUtils.DARK_GREY))
                            .setAnimations(Style.ANIMATIONS_POP).show();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            doubleBackToExitPressedOnce = false;
                        }
                    }, Style.DURATION_LONG);
                }
            }
        }

    }



    public void clearBackStack() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    public void switchFragmentNoBackStackByTag(int id, Fragment fragment, String fragment_tag) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        // fragmentTransaction.setCustomAnimations(R.anim.push_left_in, R.anim.push_left_out);
        fragmentTransaction.replace(id, fragment, fragment_tag);
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    public class DayViewPagerAdapter extends FragmentStatePagerAdapter {

        static final int NUM_ITEMS = 5;
        public String monday = getString(R.string.monday);
        public String tuesday = getString(R.string.tuesday);
        public String wednesday = getString(R.string.wednesday);
        public String thursday = getString(R.string.thursday);
        public String friday = getString(R.string.friday);
        final String[] TAB_TITLES = new String[]{monday, tuesday, wednesday, thursday, friday};


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

