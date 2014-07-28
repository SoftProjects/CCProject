package com.comicon.pamphlet.activity;

import com.comicon.papmphlet.R;
import com.comicon.papmphlet.adapter.StallInforAdapter;
import com.comicon.papmphlet.listener.JumpToSearchListener;
import com.comicon.papmphlet.listener.ReturnListener;
import com.comicon.pamphlet.data.cotroller.Controller;
import com.comicon.pamphlet.data.model.CircleModel;

import android.os.Bundle;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class StallInforActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stall_infor);
		
		ImageView returnButton = (ImageView)findViewById(R.id.return_button);
		returnButton.setOnClickListener(new ReturnListener(this));
		ImageView goSearchButton = (ImageView)findViewById(R.id.search_button);
		goSearchButton.setOnClickListener(new JumpToSearchListener(this));

		Bundle bundle = this.getIntent().getExtras();
		int modleCid = bundle.getInt("selectedModelCid");
		CircleModel model =Controller.instance(this).getCircle(modleCid);
		initView();
		initTitle(model);
		initListView(model);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stall_infor, menu);
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

    	RelativeLayout stallFrameLayout = (RelativeLayout)findViewById(R.id.stall_infor_mainframe);
    	RelativeLayout.LayoutParams stallFrameParams = (RelativeLayout.LayoutParams) stallFrameLayout.getLayoutParams();
    	stallFrameParams.leftMargin = (int)(ScreenWidth * 0.08);
    	stallFrameParams.rightMargin = (int)(ScreenWidth * 0.08);
    	stallFrameLayout.setLayoutParams(stallFrameParams);
    	
	}
	
	private void initListView(CircleModel model){		
		ListView stallList = (ListView)findViewById(R.id.stall_item_list);
		StallInforAdapter mAdapter = new StallInforAdapter(this,model);
		stallList.setAdapter(mAdapter);
	}
	
    private void initTitle(final CircleModel model){
    	TextView stallNameView = (TextView) findViewById(R.id.stall_infor_name);
    	stallNameView.setText(model.getName());
    	TextView stallCodeView = (TextView) findViewById(R.id.stall_infor_code);
    	stallCodeView.setText(model.getOrder());
        ImageView collectButton = (ImageView)findViewById(R.id.cllect_stall_button);
        collectButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				model.setFavoirite(true);
				Toast.makeText(StallInforActivity.this, "收藏成功", Toast.LENGTH_SHORT).show(); 
			}
		});
    	
    }
}
