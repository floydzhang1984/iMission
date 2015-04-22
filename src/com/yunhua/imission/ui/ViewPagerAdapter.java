package com.yunhua.imission.ui;

import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class ViewPagerAdapter extends PagerAdapter {

	private List<View> views;
	@SuppressWarnings("unused")
	private Context context;
	
	public ViewPagerAdapter(List<View> views, Context context) {
		this.views = views;
		this.context = context;
	}
	
	@Override
	public void destroyItem(View container, int position, Object object) {
		
		((ViewPager) container).removeView(views.get(position));
	}
	
	@Override
	public Object instantiateItem(View container, int position) {
		//通过position来进行索引
		((ViewPager) container).addView(views.get(position));
		return views.get(position);
	}
	
	@Override
	public int getCount() {
		return views.size();
	}

	
	
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// 判断当前的View是不是我们所需要的对象
		return (arg0 == arg1);
	}

}
