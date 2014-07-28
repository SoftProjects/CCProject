package com.ccproject.adapter;

import java.util.List;

import com.ccproject.activity.R;
import com.ccproject.listener.JumpToStallInfor;
import com.comicon.pamphlet.data.model.CircleModel;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ViewPagerAdapter extends PagerAdapter{

	private Context mContext;
	private List<CircleModel> models;
	private LayoutInflater mInflater;
	public ViewPagerAdapter(Context mContext, List<CircleModel> models){
		this.mContext =mContext;
		this.mInflater = LayoutInflater.from(mContext);
		this.models = models;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}
	public void destroyItem(ViewGroup container, int position, Object object) {  
	      container.removeView((View) object);  
	}  
	  
	    @Override  
	public Object instantiateItem(ViewGroup container, int position) {
	      View rootView =  mInflater.inflate(R.layout.viewpage_context, null);
	      TextView stallname = (TextView) rootView.findViewById(R.id.viewpager_stall_name);
	      int currentPos = position % models.size();
	      CircleModel model = models.get(currentPos);
	      RelativeLayout stallNameLayout = (RelativeLayout)rootView.findViewById(R.id.viewpager_context_frame);
	      stallNameLayout.setOnClickListener(new JumpToStallInfor(mContext,model));
	      stallname.setText(model.getName());
	      container.addView(rootView);  
	      return rootView;  
	}  
	  
	    @Override  
	public int getItemPosition(Object object) {  
	     return POSITION_NONE;  
	}  
	  
}
