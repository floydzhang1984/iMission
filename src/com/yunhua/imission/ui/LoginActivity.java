package com.yunhua.imission.ui;

import java.lang.ref.WeakReference;

import com.yunhua.imission.R;
import com.yunhua.imission.service.UserService;
import com.yunhua.imission.service.UserServiceImpl;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	
	
	private EditText txtLoginName;
	private EditText txtLoginPassword;
	private Button btnLogin;
	private Button btnReset;
	
	private static final int FLAG_LOGIN_SUCCESS = 1;
	private static final int FLAG_LOGIN_FAIL = 2;
	
	//??这步还不太明白，UserService只是个接口
	private UserService userService = new UserServiceImpl();
	
	private void init() {
		this.txtLoginName = (EditText) this.findViewById(R.id.txt_login_name);
		this.txtLoginPassword = (EditText) this.findViewById(R.id.txt_login_password);
		this.btnLogin = (Button) this.findViewById(R.id.btn_login);
		this.btnReset = (Button) this.findViewById(R.id.btn_reset);
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_activity);
		
		//初始化控件
		this.init();
		
		//点击登录
		this.btnLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				final String loginName = txtLoginName.getText().toString();
				final String loginPassword = txtLoginPassword.getText().toString();
				
				Toast.makeText(v.getContext(), "登录名：" + loginName, Toast.LENGTH_SHORT).show();
				Toast.makeText(v.getContext(), "密码：" + loginPassword, Toast.LENGTH_SHORT).show();
				
				/*
				 * 输入值验证(待实现)
				 */
				
				
				/*
				 * 副线程 
				 */
				Thread thread = new Thread(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						try {
							userService.userLogin(loginName, loginPassword);
							handler.sendEmptyMessage(FLAG_LOGIN_SUCCESS);
						} catch(Exception e) {
							e.printStackTrace();
							handler.sendEmptyMessage(FLAG_LOGIN_FAIL);
						}
					}
				});
				thread.start();//开始运行线程
			}
		});
		
		//点击重置
		this.btnReset.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				txtLoginName.setText("");
				txtLoginPassword.setText("");
				
			}
		});
	}
	
	private void showTip() {
		
	}
	
	//关于此种类型的用法，主要原因是避免内存泄露，具体文章请见: http://blog.csdn.net/tech_universe/article/details/44975681
	private static class IHandler extends Handler {
		private final WeakReference<Activity> mActivity;
		
		public IHandler(LoginActivity activity) {
			mActivity = new WeakReference<Activity>(activity);
		}
		@Override
		public void handleMessage(Message msg) {
			((LoginActivity)mActivity.get()).showTip();
		}
		
	}
	
	private IHandler handler = new IHandler(this);


}
