package com.comicon.pamphlet.activity;

import java.io.File;

import com.comicon.pamphlet.R;
import com.comicon.pamphlet.data.appsetting.Data;
import com.comicon.pamphlet.listener.JumpToSearchListener;
import com.comicon.pamphlet.listener.ReturnListener;
import com.common.imageLoader.ImageLoader;

import android.net.Uri;
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
import android.widget.RelativeLayout;

public class SiteMapActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_site_map);
		
		ImageView returnButton = (ImageView)findViewById(R.id.return_button);
		returnButton.setOnClickListener(new ReturnListener(this));
		ImageView goSearchButton = (ImageView)findViewById(R.id.search_button);
		goSearchButton.setOnClickListener(new JumpToSearchListener(this));
		
		ImageLoader loader = new ImageLoader(Data.IMAGE_CACHE);
		final ImageView imageview = (ImageView)findViewById(R.id.site_map_image);
		
		loader.setBitmap(imageview, Data.instance(this).getLocalmapUrl(),new Handler(){
			@Override
			public void handleMessage(Message msg) {
				addListener(imageview);
			}
		});        		
		
		initView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.site_map, menu);
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
    	
    }
    
    
    public void addListener(ImageView imageview){
    	imageview.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_VIEW);
				intent.setDataAndType(Uri.fromFile(new File(Data.IMAGE_CACHE+ImageLoader.getBitmapName(Data.instance(SiteMapActivity.this).getLocalmapUrl()))), "image/*");
				startActivity(intent);
			}
		});
    }
}
