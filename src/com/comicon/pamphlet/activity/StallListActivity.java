package com.comicon.pamphlet.activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.comicon.pamphlet.R;
import com.comicon.pamphlet.adapter.StallExpandListViewAdapter;
import com.comicon.pamphlet.bean.StallListChildBean;
import com.comicon.pamphlet.bean.StallListChildren;
import com.comicon.pamphlet.bean.StallListGroupBean;
import com.comicon.pamphlet.data.cotroller.Controller;
import com.comicon.pamphlet.data.model.CircleModel;
import com.comicon.pamphlet.listener.JumpToSearchListener;
import com.comicon.pamphlet.listener.ReturnListener;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class StallListActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stall_list);
		
		ImageView returnButton = (ImageView)findViewById(R.id.return_button);
		returnButton.setOnClickListener(new ReturnListener(this));
		ImageView goSearchButton = (ImageView)findViewById(R.id.search_button);
		goSearchButton.setOnClickListener(new JumpToSearchListener(this));

		
		initView();
		
		ExpandableListView expandList =(ExpandableListView)findViewById(R.id.stall_list_expandlistview);
		expandList.setGroupIndicator(null);  
		StallExpandListViewAdapter mAdapter = new StallExpandListViewAdapter(this,getGroups());
		expandList.setAdapter(mAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stall_list, menu);
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
    	
    	ExpandableListView expandlistview = (ExpandableListView)findViewById(R.id.stall_list_expandlistview);
    	RelativeLayout.LayoutParams expandlistviewParams = (RelativeLayout.LayoutParams) expandlistview.getLayoutParams();
    	expandlistviewParams.leftMargin = (int)(ScreenHeight * 0.05);
    	expandlistviewParams.rightMargin = (int)(ScreenHeight * 0.05);
    	expandlistview.setLayoutParams(expandlistviewParams);
    	
	}
	
	private HashMap<String, List<CircleModel>> getSelectStallData(){
		 List<CircleModel> circleList = Controller.instance(this).getAllList();
		HashMap<String, List<CircleModel>> seletedData = new HashMap<String, List<CircleModel>>();
		for(CircleModel item : circleList){
			String firstLetter = item.getSortLetters();
			if(!seletedData.containsKey(firstLetter)){
				List<CircleModel> newList = new ArrayList<CircleModel>();
				seletedData.put(firstLetter, newList);
			}
			
			seletedData.get(firstLetter).add(item);
		}
	 return seletedData;
	}
	
	public List<StallListGroupBean> getGroups(){
		List<StallListGroupBean> groupList =new ArrayList<StallListGroupBean>();
		HashMap<String, List<CircleModel>> selected = getSelectStallData();
		Set keyset = selected.keySet();
        List<String> list = new ArrayList<String>();
        for(Object item : keyset){
        	list.add((String)item);
        }
		Collections.sort(list);
		
        while(list.size()!=0){
        	StallListGroupBean groupBean = new StallListGroupBean();
        	String left = list.remove(0);
        	groupBean.setLeft(left);
        	groupBean.addModels(selected.get(left));
        	if(list.size()!=0){
            	String right = list.remove(0);
            	groupBean.setRight(right);
            	groupBean.addModels(selected.get(right));
        	}else{
        		groupBean.setRight(left);
        	}
        	
        	groupList.add(groupBean);        	
        }
		return groupList;
            		
	}
	

}
