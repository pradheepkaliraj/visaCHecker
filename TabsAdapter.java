package com.example.pradh.visachecker;



import android.app.Fragment;
import android.app.FragmentManager;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * Created by pradh on 8/4/2018.
 */

public class TabsAdapter extends FragmentPagerAdapter {

   static String[] continents  = {"Africa","Asia","Europe","N.America","Oceania","S.America"};

    public TabsAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new africaFragment();
            case 1:
                return new asiaFragment();
            case 2:
                return new euroFragment();
            case 3:
                return new namericaFragment();
            case 5:
                return new samericaFragment();
            case 4:
                return new oceaniaFragment();
        }return null;
    }



    @Override
    public int getCount() {
        return continents.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return continents[position];
    }

 }