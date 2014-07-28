package com.comicon.papmphlet.adapter;


import java.util.List;

import com.comicon.papmphlet.R;
import com.comicon.pamphlet.data.cotroller.Controller;
import com.comicon.pamphlet.data.model.CircleModel;
import com.comicon.papmphlet.bean.FavouriteStall;
import com.comicon.papmphlet.listener.JumpToStallInfor;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FavouriteStallAdapter extends BaseAdapter{

	private ViewHolder holder;
	private Context mContext;  
	private LayoutInflater mInflater;
	private List<CircleModel> favouriteStalls;
	public FavouriteStallAdapter(Context context, List<CircleModel> favouriteStalls){
		this.mContext = context;
		this.mInflater = LayoutInflater.from(mContext);
		this.favouriteStalls = favouriteStalls;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return favouriteStalls.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return favouriteStalls.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		holder=null;
		final CircleModel stallInfor = favouriteStalls.get(position);
		if(convertView == null){
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.favourite_list_item, null);
			holder.frame = (RelativeLayout)convertView.findViewById(R.id.favourite_frame);
			holder.stallCode = (TextView) convertView.findViewById(R.id.favourite_stall_code);
            holder.stallName = (TextView) convertView.findViewById(R.id.favourite_stall_name);
			holder.cancerCollect = (ImageView) convertView.findViewById(R.id.favourite_cancer_collect);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder)convertView.getTag();  
		}
		
		holder.stallName.setText(stallInfor.getName());
		holder.stallCode.setText(stallInfor.getOrder());
		holder.frame.setOnClickListener(new JumpToStallInfor(mContext,stallInfor));
		
		
		holder.cancerCollect.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				stallInfor.setFavoirite(false);
				favouriteStalls= Controller.instance(mContext).getFavouriteList();
				FavouriteStallAdapter.this.notifyDataSetChanged();
			}
		});
		return convertView;
	}

	class ViewHolder{
		public TextView stallCode;
		public TextView stallName;
		public ImageView cancerCollect;
		public RelativeLayout frame;
	}
}
