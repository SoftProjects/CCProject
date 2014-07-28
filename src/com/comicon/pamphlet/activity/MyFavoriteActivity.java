package com.comicon.pamphlet.activity;

import java.util.List;

import com.comicon.papmphlet.R;
import com.comicon.papmphlet.adapter.FavouriteStallAdapter;
import com.comicon.papmphlet.listener.JumpToSearchListener;
import com.comicon.papmphlet.listener.ReturnListener;
import com.comicon.pamphlet.data.cotroller.Controller;
import com.comicon.pamphlet.data.model.CircleModel;

import android.os.Bundle;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class MyFavoriteActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_favorite);
		ImageView returnButton = (ImageView)findViewById(R.id.return_button);
		returnButton.setOnClickListener(new ReturnListener(this));
		ImageView goSearchButton = (ImageView)findViewById(R.id.search_button);
		goSearchButton.setOnClickListener(new JumpToSearchListener(this));
		initView();
		initListView();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_favorite, menu);
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
    	
    	RelativeLayout listFrameview = (RelativeLayout) findViewById(R.id.favourite_stall_list_frame);
    	RelativeLayout.LayoutParams listViewParams = (RelativeLayout.LayoutParams) listFrameview.getLayoutParams();
    	listViewParams.leftMargin = (int)(ScreenWidth * 0.08);
    	listViewParams.rightMargin = (int)(ScreenWidth * 0.08);
    	listFrameview.setLayoutParams(listViewParams);
	} 
	
	public void initListView(){
		ListView favouriteStall = (ListView) findViewById(R.id.favourite_list);
		
		List<CircleModel> models = Controller.instance(this).getFavouriteList();
		FavouriteStallAdapter mAdapter = new FavouriteStallAdapter(this,models);
		favouriteStall.setAdapter(mAdapter);
		
		
	}
		
}
