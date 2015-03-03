package com.yunhua.imission;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

/*
 * Ϊÿ��ͼƬ����View����ŵ�ViewArray��
 * ʹ��ViewArray����ViewPagerAdapter
 * ʹ��vp.setAdapter������Adapter
 */

public class GuidingPage extends Activity implements OnPageChangeListener {
	
	private ViewPager vp;
	private ViewPagerAdapter vpAdapter;
	private List<View> views;
	private ImageView[] dots;
	private int[] ids = { R.id.guidepoint1, R.id.guidepoint2, R.id.guidepoint3 };
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guidingpage);
		initViews();
		initDots();
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
		vp.setOnPageChangeListener(this);
	}
	
	private void initDots() {
		dots = new ImageView[views.size()];
		for( int i = 0; i < views.size(); i++) {
			dots[i] = (ImageView) findViewById(ids[i]);
		}
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		for(int i = 0; i < ids.length; i++) {
			if( arg0 == i){
				dots[i].setImageResource(R.drawable.login_point_selected);
			} else {
				dots[i].setImageResource(R.drawable.login_point);
			}
		}
		
	}
}
