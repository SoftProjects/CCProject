package com.comicon.pamphlet.listener;

import com.comicon.pamphlet.activity.StallSearchActivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class JumpToSearchListener implements OnClickListener{
    private Context mContext;
    public JumpToSearchListener(Context mContext){
    	this.mContext=mContext;
    }
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent inent=new Intent();
		inent.setClass(mContext, StallSearchActivity.class);
		mContext.startActivity(inent);
	}
}
