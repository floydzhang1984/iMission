package com.yunhua.imission.ui;

import com.yunhua.imission.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabFragment extends Fragment {
	
	private int pos;
	public TabFragment(int pos) {
		this.pos = pos;
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment, container, false);
		TextView tv = (TextView) view.findViewById(R.id.id_fragtv);
		tv.setText(TabAdapter.TITLES[pos]);
		return view;
	}
}
