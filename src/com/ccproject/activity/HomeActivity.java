package com.ccproject.activity;


import com.comicon.pamphlet.data.cotroller.Controller;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		Controller.instance(this).initial();
//		Controller.instance(this).update(new Handler());
		Controller.instance(this).update(new Handler(){

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				switch(msg.what){
				     case 6 : //刚刚发现数据更新
				    	
				    	 break;
				     case 0 : //(开始联网)
				       
				    	 break;
				     case 5 : //数据不需要更新
				         break;
				     case 1 : //数据正在下载 
				    	 
				     case 2 :// 数据入库
				    	 
				     case 3 : //更新成功
				    	 
				     case 4 :// 更新失败 				     	 
				     //progressDiolog
				     
				};
				super.handleMessage(msg);
			}
	          		
		});
		initView();
		initListener();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
	
    public void initView(){
    	DisplayMetrics dm = new DisplayMetrics();
    	getWindowManager().getDefaultDisplay().getMetrics(dm);
    	int ScreenHeight = dm.heightPixels;
    	int ScreenWidth = dm.widthPixels;
    	
    	RelativeLayout headLayout = (RelativeLayout)findViewById(R.id.mainFrame_head);
    	RelativeLayout.LayoutParams headParams = (RelativeLayout.LayoutParams) headLayout.getLayoutParams();
    	headParams.height=(int)(ScreenHeight * 0.1);
    	headLayout.setLayoutParams(headParams);
    	
    	RelativeLayout buttomLayout = (RelativeLayout)findViewById(R.id.mainFrame_bottom);
    	RelativeLayout.LayoutParams bottomParams = (RelativeLayout.LayoutParams) buttomLayout.getLayoutParams();
    	bottomParams.height=(int)(ScreenHeight * 0.06);
    	buttomLayout.setLayoutParams(bottomParams);
    	
    	RelativeLayout previewLayout = (RelativeLayout)findViewById(R.id.mainFrame_preview);
    	RelativeLayout.LayoutParams previewParams = (RelativeLayout.LayoutParams) previewLayout.getLayoutParams();
    	previewParams.height=(int)(ScreenHeight * 0.2);
    	previewLayout.setLayoutParams(previewParams);
    	
    	
    	LinearLayout chooseLayout = (LinearLayout)findViewById(R.id.choose_button_frame);
    	RelativeLayout.LayoutParams chooseParams = (RelativeLayout.LayoutParams) chooseLayout.getLayoutParams();
    	chooseParams.height=(int)(ScreenHeight * 0.64);
    	chooseParams.bottomMargin = (int)(ScreenHeight * 0.05);
    	chooseParams.topMargin = (int)(ScreenHeight * 0.05);
    	chooseParams.leftMargin = (int)(ScreenWidth * 0.1);
    	chooseParams.rightMargin = (int)(ScreenWidth * 0.1);
    	
    	chooseLayout.setLayoutParams(chooseParams);
    }

    public void initListener(){
    	RelativeLayout stallList = (RelativeLayout) findViewById(R.id.stall_list);
    	stallList.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(HomeActivity.this, StallListActivity.class);
				startActivity(intent);
			}
		});
    	
    	RelativeLayout siteMap = (RelativeLayout) findViewById(R.id.stall_map);
    	siteMap.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(HomeActivity.this, SiteMapActivity.class);
				startActivity(intent);
			}
		});

    	RelativeLayout trafficInfor = (RelativeLayout) findViewById(R.id.stall_tranfic_info);
    	trafficInfor.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(HomeActivity.this, TrafficInforActivity.class);
				startActivity(intent);
			}
		});
    	
    	RelativeLayout stallFeedback = (RelativeLayout) findViewById(R.id.stall_feedback);
    	stallFeedback.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(HomeActivity.this, InforFeedbackActivity.class);
				startActivity(intent);
			}
		});
    	
    	ImageView search_button = (ImageView) findViewById(R.id.search_button);
    	search_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(HomeActivity.this, StallSearchActivity.class);
				startActivity(intent);
			}
		});
    	
    	ImageView collect_button = (ImageView) findViewById(R.id.collect_button);
    	collect_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(HomeActivity.this, MyFavoriteActivity.class);
				startActivity(intent);
			}
		});
    	
    	
    }
}
