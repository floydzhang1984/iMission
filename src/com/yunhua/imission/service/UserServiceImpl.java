package com.yunhua.imission.service;

import android.util.Log;

public class UserServiceImpl implements UserService{

	private static final String TAG="UserServiceImpl";
	
	@Override
	public void userLogin(String loginName, String loginPassword)
			throws Exception {
		Log.d(TAG, loginName);
		Log.d(TAG, loginPassword);
		
	}

}
