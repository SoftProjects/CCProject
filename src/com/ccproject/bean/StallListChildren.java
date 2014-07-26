package com.ccproject.bean;

import java.util.ArrayList;
import java.util.List;
public class StallListChildren {
	private List<StallListChildBean> childrenList = new ArrayList<StallListChildBean>();
	public List<StallListChildBean> getChildrenList(){
		return childrenList;
	}
	public void setChildrenList(List<StallListChildBean> childrenList){
		this.childrenList = childrenList;
	}
}
