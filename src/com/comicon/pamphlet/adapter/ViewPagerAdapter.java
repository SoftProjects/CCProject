package com.comicon.pamphlet.adapter;

import java.util.List;

import com.comicon.pamphlet.R;
import com.comicon.pamphlet.data.model.CircleModel;
import com.comicon.pamphlet.listener.JumpToStallInfor;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ViewPagerAdapter extends PagerAdapter{

	private Context mContext;
	private List<CircleModel> models;
	private LayoutInflater mInflater;
	private SparseArray<View> views = new SparseArray<View>();
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
	      if(models.size()!=0){
	    	  View rootView =  mInflater.inflate(R.layout.viewpage_context, null);
		      TextView stallname = (TextView) rootView.findViewById(R.id.viewpager_stall_name);
	    	  int currentPos = position % models.size();
	    	  CircleModel model = models.get(currentPos);
	    	  RelativeLayout stallNameLayout = (RelativeLayout)rootView.findViewById(R.id.viewpager_context_frame);
	    	  stallNameLayout.setOnClickListener(new JumpToStallInfor(mContext,model));
	    	  stallname.setText(model.getName());
	    	  container.addView(rootView);
	    	  views.put(position, rootView);
	    	  return rootView;
	      }else{
	    	  return null;
	      }  
	}  
	  
	@Override
	public void notifyDataSetChanged() {
			// TODO Auto-generated method stub
			super.notifyDataSetChanged();
	}
	@Override  
	public int getItemPosition(Object object) {  
	     return POSITION_NONE;  
	}  
	  
}
