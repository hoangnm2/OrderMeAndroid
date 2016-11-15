package com.android.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.android.fragment.DetailFragment;
import com.android.fragment.MapFragment;
import com.android.fragment.MenuFragment;
import com.android.fragment.SystemFregment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by binhb on 13/11/2016.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> listFragment=new ArrayList<>();
    List<String> titleFragment=new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        listFragment.add(new MenuFragment());
        listFragment.add(new DetailFragment());
        listFragment.add(new MapFragment());
        listFragment.add(new SystemFregment());

        titleFragment.add("Danh sách món ăn");
        titleFragment.add("Chi tiết bàn ăn");
        titleFragment.add("Địa chỉ quán ăn");
        titleFragment.add("Cài đặt");
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleFragment.get(position);
    }
}
