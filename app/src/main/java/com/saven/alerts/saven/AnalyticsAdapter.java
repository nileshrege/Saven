package com.saven.alerts.saven;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AnalyticsAdapter extends FragmentStatePagerAdapter {
    final String IMAGE_RESOURCE = "IMAGE_RESOURCE";
    final String DATE_FORMAT = "ddMMyyyy";

    final int MAX_DURATION = 7;
    String weekdays[] = new String[7];


    public AnalyticsAdapter(FragmentManager fm) {
        super(fm);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        weekdays[0] = sdf.format(calendar.getTime());
        for(int i= 1 ; i < MAX_DURATION; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            weekdays[i] = sdf.format(calendar.getTime());
        }
    }

    @Override
    public Fragment getItem(int position) {

        String analyticsOnThisDate = getAnalysisForDate(position);

        Fragment fragment = new DailyAnalyticsFragment();
        Bundle args = new Bundle();
        args.putString(IMAGE_RESOURCE, analyticsOnThisDate);
        fragment.setArguments(args);

        return fragment;
    }

    private String getAnalysisForDate(int position) {
        if (position == 0 || position == 1 ) {
            return weekdays[0];
        } else {
            return weekdays[position-1];
        }
    }

    @Override
    public int getCount() {
        return MAX_DURATION;
    }

}
