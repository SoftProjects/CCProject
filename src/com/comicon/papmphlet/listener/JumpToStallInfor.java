package com.comicon.papmphlet.listener;

import com.comicon.pamphlet.activity.StallInforActivity;
import com.comicon.pamphlet.data.model.CircleModel;
import com.comicon.pamphlet.data.model.ItemModel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class JumpToStallInfor implements OnClickListener{
    private CircleModel model;
    private Context mContext;
	public JumpToStallInfor(Context mcontext, ItemModel modle){
		this.mContext = mcontext;
		this.model = modle.getCircle();
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.setClass(mContext, StallInforActivity.class);
		Bundle bundle =new Bundle();
		bundle.putInt("selectedModelCid", model.getCid());
		intent.putExtras(bundle);
		mContext.startActivity(intent);
//		Toast.makeText(mContext, "收藏成功", Toast.LENGTH_SHORT).show(); 
	}

}
