package com.yunhua.imission.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {

	public static String[] TITLES = new String[] { "�γ�", "�ʴ�", "���", "ѧϰ", "�ƻ�" };

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
