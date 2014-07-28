package com.comicon.pamphlet.adapter;



import java.util.List;

import com.comicon.pamphlet.R;
import com.comicon.pamphlet.activity.StallInforActivity;
import com.comicon.pamphlet.bean.StallListChildren;
import com.comicon.pamphlet.bean.StallListGroupBean;
import com.comicon.pamphlet.data.model.CircleModel;
import com.comicon.pamphlet.listener.JumpToStallInfor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class StallExpandListViewAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<StallListGroupBean> grouplist;
	public StallExpandListViewAdapter(Context context, List<StallListGroupBean> grouplist){
		this.mContext = context;
		this.mInflater = LayoutInflater.from(mContext);
		this.grouplist = grouplist;
	}
	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return grouplist.get(groupPosition).getModels().get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}
	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
			ViewGroup parent) {
		// TODO Auto-generated method stub
		View rootChildView = mInflater.inflate(R.layout.child_layout, null);
		final CircleModel model = grouplist.get(groupPosition).getModels().get(childPosition);
		TextView codeText = (TextView)rootChildView.findViewById(R.id.stall_list_child_code);
		codeText.setText(model.getOrder());

		TextView nameText = (TextView)rootChildView.findViewById(R.id.stall_list_child_name);
		nameText.setText(model.getName());
		LinearLayout child = (LinearLayout) rootChildView.findViewById(R.id.child_frame);
		child.setOnClickListener(new JumpToStallInfor(mContext,model));
		return rootChildView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return grouplist.get(groupPosition).getModels().size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return grouplist.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return grouplist.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

//	 public View getGroupView(int groupPosition, boolean isExpanded,    
//		     View convertView, ViewGroup parent) {
	
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View groupRootView =mInflater.inflate(R.layout.group_layout, null);
		
		StallListGroupBean groupbean = grouplist.get(groupPosition);
		TextView leftText = (TextView) groupRootView.findViewById(R.id.stall_group_left_letter);
		leftText.setText(groupbean.getLeft());
		
		TextView rightText = (TextView) groupRootView.findViewById(R.id.stall_group_right_letter);
		rightText.setText(groupbean.getRight());
		
		ImageView indicator = (ImageView) groupRootView.findViewById(R.id.stall_list_group_indicator);
		if(isExpanded){
			indicator.setImageResource(R.drawable.stall_unexpand);
		}else{
			indicator.setImageResource(R.drawable.stall_expand);
		}
		
		return groupRootView;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return true;
	}
}
