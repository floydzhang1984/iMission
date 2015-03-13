package com.yunhua.imission;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Window;

import com.viewpagerindicator.TabPageIndicator;

public class MainActivity extends FragmentActivity {
	private static final String TAG = "MainActivity"; // for debug
	
	private ViewPager mViewPager;
	private TabPageIndicator mTabPageIndicator;
	private List<Fragment> mFragments;
	private TabAdapter mTabAdapter;
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i(TAG, "MainActivity Started");
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i(TAG, "MainActivity Paused");
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i(TAG, "MainActivity Stopped");
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i(TAG, "MainActivity Resumed");
	}
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i(TAG, "MainActivity Restarted");
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i(TAG, "MainActivity Destroyed");
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		Log.i(TAG, "MainActivity Created!");
		
		initView();

	}
	
	private void initView() {
		mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
		mTabPageIndicator = (TabPageIndicator) findViewById(R.id.id_indicator);
		mTabAdapter = new TabAdapter(getSupportFragmentManager());
		mViewPager.setAdapter(mTabAdapter);
		
		mTabPageIndicator.setViewPager(mViewPager, 0);
	}
	
}
