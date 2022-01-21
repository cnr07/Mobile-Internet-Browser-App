package com.cnr.cse476assignment2;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {
    private Context myContext;
    int totalTabs;

    public MyAdapter(Context context, FragmentManager fm, int totalTabs){
        super(fm);
        myContext=context;
        this.totalTabs=totalTabs;

    }




    @Override
    public Fragment getItem(int position) {
        switch (position){
            /*case 0:
                NewTab newtab = new NewTab();
                System.out.println("YENİİİİİİİİİİİİİİİİİİİİİİİİİİİİİİİİİİİ'^^!'^!'^'^'!");
                return newtab;
            case 1:
                NewTab newtab1 = new NewTab();
                System.out.println("YENİİİİİİİİİİİİİİİİİİİİİİİİİİİİİİİİİİİ'^^!'^!'^'^'!");
                return newtab1;
            case 2:
                NewTab newtab2 = new NewTab();
                System.out.println("YENİİİİİİİİİİİİİİİİİİİİİİİİİİİİİİİİİİİ'^^!'^!'^'^'!");
                return newtab2;*/
            default:
                NewTab newtab = new NewTab();
                System.out.println("YENİİİİİİİİİİİİİİİİİİİİİİİİİİİİİİİİİİİ'^^!'^!'^'^'!");
                return newtab;
                //return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}

