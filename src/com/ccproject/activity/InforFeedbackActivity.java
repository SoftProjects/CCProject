package com.ccproject.activity;


import com.ccproject.listener.JumpToSearchListener;
import com.ccproject.listener.ReturnListener;
import com.comicon.pamphlet.data.cotroller.Controller;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class InforFeedbackActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_infor_feedback);
		ImageView returnButton = (ImageView)findViewById(R.id.return_button);
		returnButton.setOnClickListener(new ReturnListener(this));
		ImageView goSearchButton = (ImageView)findViewById(R.id.search_button);
		goSearchButton.setOnClickListener(new JumpToSearchListener(this));
		initView();
		initListener();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.infor_feedback, menu);
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
    	
    	RelativeLayout feedbackLayout = (RelativeLayout)findViewById(R.id.feedback_main);
    	RelativeLayout.LayoutParams feedbackParams = (RelativeLayout.LayoutParams) feedbackLayout.getLayoutParams();
    	feedbackParams.leftMargin = (int)(ScreenHeight *0.05);
    	feedbackParams.rightMargin = (int)(ScreenHeight *0.05);
    	feedbackParams.topMargin = (int)(ScreenWidth * 0.1);
    	feedbackParams.bottomMargin = (int)(ScreenWidth * 0.1);
    	feedbackLayout.setLayoutParams(feedbackParams);
    	
    	EditText editText = (EditText) findViewById(R.id.feedback_infor);
    	RelativeLayout.LayoutParams editParams = (RelativeLayout.LayoutParams) editText.getLayoutParams();
    	editParams.topMargin = (int)(ScreenWidth * 0.25);
    	editParams.bottomMargin =(int)(ScreenWidth * 0.22);
    	editText.setLayoutParams(editParams);
    	
	}
	public void initListener(){
		Button submit = (Button) findViewById(R.id.submit_feedback);
		submit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				EditText editText =(EditText) findViewById(R.id.feedback_infor);
				String input = editText.getText().toString();
				Controller.instance(InforFeedbackActivity.this).sendResponse(input, new Handler(){
					@Override
					public void handleMessage(Message msg) {
						// TODO Auto-generated method stub
						super.handleMessage(msg);
					}
				});
				Toast.makeText(InforFeedbackActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
				finish();
			}
		});
	}

}
