package com.ccproject.activity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ccproject.bean.SearchedStallItem;
import com.ccproject.fragment.NoViewFragment;
import com.ccproject.fragment.StallSearchDoneFragment;
import com.ccproject.fragment.WaitFragment;
import com.ccproject.listener.JumpToSearchListener;
import com.ccproject.listener.ReturnListener;
import com.comicon.pamphlet.data.cotroller.Controller;
import com.comicon.pamphlet.data.model.WorkModel;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.Fragment;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class StallSearchActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stall_search);
		
		ImageView returnButton = (ImageView)findViewById(R.id.return_button);
		returnButton.setOnClickListener(new ReturnListener(this));
		
		initView();
		initListener();
		if(savedInstanceState == null){
			getFragmentManager().beginTransaction().add(R.id.search_result_list_frame, new NoViewFragment()).commit();
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stall_search, menu);
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
    	
    	RelativeLayout searchFrameLayout = (RelativeLayout)findViewById(R.id.serach_mainframe);
    	RelativeLayout.LayoutParams searchFrameParams = (RelativeLayout.LayoutParams) searchFrameLayout.getLayoutParams();
    	searchFrameParams.leftMargin = (int)(ScreenWidth * 0.08);
    	searchFrameParams.rightMargin = (int)(ScreenWidth * 0.08);
    	searchFrameLayout.setLayoutParams(searchFrameParams);
    	
	}
	
	public void initListener(){
		ImageView searchButton = (ImageView)findViewById(R.id.search_go_button);
		searchButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 getFragmentManager().beginTransaction().replace(R.id.search_result_list_frame, new WaitFragment()).commit();
				 doSearch();
			}
		});
	}
	public void doSearch(){
		EditText inputView = (EditText)findViewById(R.id.search_key);
		
		List<WorkModel> serarchedData = Controller.instance(this).getSearchResult(inputView.getText().toString());
		ArrayList<WorkModel> serarchedDataForArrayList = new ArrayList<WorkModel>();
		serarchedDataForArrayList.addAll(serarchedData);
		Fragment newFragment = StallSearchDoneFragment.newInstance(serarchedDataForArrayList);
    	getFragmentManager().beginTransaction().replace(R.id.search_result_list_frame, newFragment).commit();
    	ImageView goSearchButton = (ImageView)findViewById(R.id.search_button);
    	inputView.clearFocus();
	}	
}
