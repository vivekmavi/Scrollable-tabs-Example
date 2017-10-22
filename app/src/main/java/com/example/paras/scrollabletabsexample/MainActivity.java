package com.example.paras.scrollabletabsexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{ ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.pager_in_main_xml);

        FragmentManager fragmentManager = getSupportFragmentManager();
        MyAdapter viewPagerAdapter = new MyAdapter(fragmentManager);

        viewPager.setAdapter(viewPagerAdapter);
    }
}

class MyAdapter extends FragmentPagerAdapter
{

    public MyAdapter(FragmentManager fm)
    {
        // mandatory adapter
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        Fragment fragment = null;

        switch (position)
        {
            case 0 : fragment = new FragmentA() ; break;
            case 1 : fragment = new FragmentB() ; break;
            case 2 : fragment = new FragmentC() ; break;
        }
        return fragment;
    }

    @Override
    public int getCount()
    {
//        return 0; by default it was 0 but we change it to no of pages that we have
        return 3;   // bcs we have 3 pages/fragments
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "no title";
        switch (position)
        {
            case 0 : title = "tab 1"; return title;
            case 1 : title = "tab 2"; return title;
            case 2 : title = "tab 3"; return title;

        }


        return title;
    }
}