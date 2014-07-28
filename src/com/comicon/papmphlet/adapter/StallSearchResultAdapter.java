package com.comicon.papmphlet.adapter;

import java.util.ArrayList;
import com.comicon.papmphlet.R;
import com.comicon.pamphlet.data.model.WorkModel;
import com.comicon.papmphlet.bean.SearchedStallItem;
import com.comicon.papmphlet.listener.JumpToStallInfor;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class StallSearchResultAdapter extends BaseAdapter{
	private ViewHolder viewHolder;
	private LayoutInflater mInflater;
	private Context mContext;
	private ArrayList<WorkModel> searchResult;
    public StallSearchResultAdapter (Context mContext,  ArrayList<WorkModel> searchResults){
    	this.searchResult = searchResults;
    	this.mContext = mContext;
    	this.mInflater = LayoutInflater.from(mContext);
    }
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return searchResult.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return searchResult.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		viewHolder = null;
		WorkModel itemInfor = searchResult.get(position);
		if(convertView == null){
			viewHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.serach_result_item,null);
			viewHolder.frame = (RelativeLayout)convertView.findViewById(R.id.search_result_frame);
			viewHolder.titleView = (TextView)convertView.findViewById(R.id.search_result_title);
			viewHolder.stallName = (TextView)convertView.findViewById(R.id.search_result_club_name);
			viewHolder.stallCode = (TextView)convertView.findViewById(R.id.search_result_club_code);
			viewHolder.price = (TextView) convertView.findViewById(R.id.search_result_price);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder)convertView.getTag();
		}
		viewHolder.titleView.setText(itemInfor.getName());
		viewHolder.stallName.setText(itemInfor.getCircle().getName());
		viewHolder.stallCode.setText(itemInfor.getCircle().getOrder());
		viewHolder.price.setText(itemInfor.getPrice());
		
		viewHolder.frame.setOnClickListener(new JumpToStallInfor(mContext, itemInfor));
		
		return convertView;
	}
	class ViewHolder{
		public RelativeLayout frame;
		public TextView titleView;
		public TextView stallName;
		public TextView stallCode;
		public TextView price;
	}

}
