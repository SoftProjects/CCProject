package com.ccproject.listener;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

public class ReturnListener implements OnClickListener{
	private Activity activity;
    public ReturnListener(Activity activity){
    	this.activity=activity;
    }
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		activity.finish();
	}

}
