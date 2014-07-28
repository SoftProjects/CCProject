package com.comicon.papmphlet.listener;

import android.content.DialogInterface;
import android.os.Handler;

public class UpdateDataListener implements android.content.DialogInterface.OnClickListener{
	private Handler hanler;
	public UpdateDataListener(Handler handler){
		this.hanler =handler;
	}
	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		// TODO Auto-generated method stub
		hanler.sendEmptyMessage(7);
		
	}

}
