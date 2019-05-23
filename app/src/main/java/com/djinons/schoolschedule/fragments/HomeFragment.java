package com.djinons.schoolschedule.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.djinons.schoolschedule.R;
import com.djinons.schoolschedule.activitys.MainActivity;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private static final String KEY_TITLE = "title";
    ViewPager vPager;
    DayViewPagerAdapter dayViewPagerAdapter;
    SmartTabLayout viewPagerTab;


    public HomeFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(String title) {
        HomeFragment f = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(KEY_TITLE, title);
        f.setArguments(args);
        return (f);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        vPager = view.findViewById(R.id.vPager);
        dayViewPagerAdapter = new DayViewPagerAdapter(getFragmentManager());

        if (vPager != null) {


            vPager.setAdapter(dayViewPagerAdapter);

            Calendar calendar = Calendar.getInstance();
            int today = calendar.get(Calendar.DAY_OF_WEEK);

            switch (today) {
                case Calendar.MONDAY:
                    vPager.setCurrentItem(0, true);
                    break;
                case Calendar.TUESDAY:
                    vPager.setCurrentItem(1, true);
                    break;
                case Calendar.WEDNESDAY:
                    vPager.setCurrentItem(2, true);
                    break;
                case Calendar.THURSDAY:
                    vPager.setCurrentItem(3, true);
                    break;
                case Calendar.FRIDAY:
                    vPager.setCurrentItem(4, true);
                    break;
                case Calendar.SATURDAY:
                    vPager.setCurrentItem(0, true);
                    break;
                case Calendar.SUNDAY:
                    vPager.setCurrentItem(0, true);
                    break;

            }


            viewPagerTab = view.findViewById(R.id.viewPagerTab);
            viewPagerTab.setViewPager(vPager);
        }
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
