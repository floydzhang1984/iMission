package com.yunhua.imission;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

/*
 * Ϊÿ��ͼƬ����View����ŵ�ViewArray��
 * ʹ��ViewArray����ViewPagerAdapter
 * ʹ��vp.setAdapter������Adapter
 */

public class GuidingPage extends Activity {
	
	private ViewPager vp;
	private ViewPagerAdapter vpAdapter;
	private List<View> views;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guidingpage);
		initViews();
	}
	
	private void initViews() {
		LayoutInflater inflater = LayoutInflater.from(this);
		
		views = new ArrayList<View>();
		views.add(inflater.inflate(R.layout.guidingpageone, null));
		views.add(inflater.inflate(R.layout.guidingpagetwo, null));
		views.add(inflater.inflate(R.layout.guidingpagethree, null));
		
		vpAdapter = new ViewPagerAdapter(views, this);
		vp = (ViewPager) findViewById(R.id.viewpager);
		vp.setAdapter(vpAdapter);
		
	}
}
