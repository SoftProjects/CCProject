package com.ccproject.adapter;

import java.util.List;

import com.ccproject.activity.R;
import com.ccproject.bean.StallItemInfor;
import com.comicon.pamphlet.data.model.CircleModel;
import com.comicon.pamphlet.data.model.WorkModel;

import android.app.Activity;
import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class StallInforAdapter extends BaseAdapter{
    private ViewHolder viewHolder;
	private Context mContext;
	private LayoutInflater mInflater;
	private List<WorkModel> workModels;
	public StallInforAdapter(Context context, CircleModel model){
		this.mContext = context;
		this.mInflater = LayoutInflater.from(mContext);
		this.workModels = model.getWorks();
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return workModels.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return workModels.get(position);
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
		WorkModel modle = workModels.get(position);
		if(convertView ==null){
			viewHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.stall_infor_list_item,null);
			viewHolder.title = (TextView)convertView.findViewById(R.id.stall_infor_title);
			viewHolder.type = (TextView) convertView.findViewById(R.id.stall_infor_type);
			viewHolder.url = (TextView) convertView.findViewById(R.id.stall_infor_link);
			viewHolder.price = (TextView) convertView.findViewById(R.id.stall_infor_price);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder)convertView.getTag();
		}
		
		viewHolder.title.setText(modle.getName());
		viewHolder.type.setText(modle.getCategory());
		viewHolder.price.setText(modle.getPrice());
		
		SpannableString url =new SpannableString(modle.getSample());
		url.setSpan(new URLSpan(modle.getSample()), 0, modle.getSample().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		viewHolder.url.setText(url);
		viewHolder.url.setMovementMethod(LinkMovementMethod.getInstance());
		
		return convertView;
	}

	class ViewHolder{
		public TextView title;
		public TextView type;
		public TextView url;
		public TextView price;
	}
}
