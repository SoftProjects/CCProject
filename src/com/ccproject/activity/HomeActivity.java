package com.ccproject.activity;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.ccproject.adapter.ViewPagerAdapter;
import com.comicon.pamphlet.data.cotroller.Controller;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class HomeActivity extends Activity {
	private int  TimeInterval = 3; //viewpager切换时间间隔是3秒
    private int currentItem = 0;
    private ScheduledExecutorService  scheduledExecutorService;
	private ViewPager viewpage;
	//用于定时切换viewpager中的文字的handler
	private Handler viewPagerHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			viewpage.setCurrentItem(currentItem, true);
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		Controller.instance(this).initial();
		
		Controller.instance(this).checkUpdate(new Handler(){
			private ProgressDialog mDialog;

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				switch(msg.what){
				  case 0:    //开始联网
					  mDialog = ProgressDialog.show(HomeActivity.this, "数据更新", "正在玩命加载数据中...",true);
					  break;
				  case 1:    //数据正在下载 
				      break;
				  case 2:   //数据入库
					  break;
				  case 3:   //更新成功
				      mDialog.dismiss();
				      showDialog("更新完成么么哒~");
				      initViewPager();
				      break;
				  case 4:   //更新失败
				      mDialog.dismiss();
				      showDialog("更新失败！请重新检查联网情况");
				      break;
				  case 5:   //数据不需要更新
				      mDialog.dismiss();
				      showDialog("更新完成么么哒~");
				      initViewPager();					  
					  break;
				  case 6:  //刚刚发现数据更新 
					  Controller.instance(HomeActivity.this).update(this);
					  break;
				};
			}
			
		});
		
		initView();
		initListener();
	}
    private AlertDialog showDialog(String msg){
    	return new AlertDialog.Builder(HomeActivity.this).setTitle("来自CC的消息").setMessage(msg).setPositiveButton("确定", null).show(); 
    }    

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
	
    private void initView(){
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

    private void initListener(){
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
    
    public void initViewPager(){
		viewpage = (ViewPager) findViewById(R.id.view_pager_show);
		ViewPagerAdapter mAdapter = new ViewPagerAdapter(this, Controller.instance(this).getAllList());
		viewpage.setAdapter(mAdapter);
		StartScroll();
    }
	private void StartScroll() {
		// TODO Auto-generated method stub
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleAtFixedRate(new ScrollTask(), 1, TimeInterval, TimeUnit.SECONDS);
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		scheduledExecutorService.shutdownNow();
		super.onStop();
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		if(scheduledExecutorService!=null){
			scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
			scheduledExecutorService.scheduleAtFixedRate(new ScrollTask(), 1, TimeInterval, TimeUnit.SECONDS);
		}
		super.onStart();
	}

	private class ScrollTask implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized (viewpage){
				currentItem = (currentItem + 1);
				viewPagerHandler.obtainMessage().sendToTarget();
			}
		}
		
	}
}
