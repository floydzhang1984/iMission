package com.yunhua.imission.ui;

import com.yunhua.imission.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

/*
 * ���������ÿ���û���Ӧ�ã���������һ�δ�Ӧ��ʱ������Viewpager)�����Ľ���
 */

public class WelcomeActivity extends Activity {
	
	private static final String TAG = "WelcomeActivity"; // for debug
	private boolean isFirstIn = false;
	private static final int TIME = 2000; //�ӳٵ�ʱ��
	private static final int GO_HOME = 1000; //��ת��������
	private static final int GO_GUIDE =1001; //��ת����������
	
	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case GO_HOME:
				goHome();
				break;
			case GO_GUIDE:
				goGuide();
				break;
			}
			
		};
	};
	
	@Override
	protected void onStart() {
		super.onStart();
		Log.i(TAG, "Welcome Activity Started");
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		Log.i(TAG, "Welcome Activity Created");
		init();
	}
	
	private void init() {
		SharedPreferences perPreferences = getSharedPreferences("imission", MODE_PRIVATE);
		isFirstIn = perPreferences.getBoolean("isFirstIn", true);
		if(!isFirstIn){
			mHandler.sendEmptyMessageDelayed(GO_HOME, TIME);
		}else{
			mHandler.sendEmptyMessageDelayed(GO_GUIDE, TIME);
			Editor editor = perPreferences.edit();
			editor.putBoolean("isFirstIn",false);
			editor.commit();
		}
	}
	
	private void goHome() {
		Intent i = new Intent(WelcomeActivity.this, MainActivity.class);
		startActivity(i);
		finish();
	}
	
	private void goGuide() {
		Intent i = new Intent(WelcomeActivity.this, GuidingPage.class);
		startActivity(i);
		finish();
	}
}
