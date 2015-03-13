package com.yunhua.imission;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {

	public static String[] TITLES = new String[] { "课程", "问答", "求课", "学习", "计划" };

	public TabAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		TabFragment fragment = new TabFragment(arg0);
		return fragment;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return TITLES.length;
	}
	
	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return TITLES[position];
	}

}
