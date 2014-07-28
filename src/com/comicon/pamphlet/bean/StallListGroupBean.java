package com.comicon.pamphlet.bean;

import java.util.ArrayList;
import java.util.List;

import com.comicon.pamphlet.data.model.CircleModel;

public class StallListGroupBean {
    private String left;
    private String right;
    private List<CircleModel> circlemodels = new ArrayList<CircleModel>();
    public void setLeft(String left){
    	this.left = left;
    }
    public String getLeft(){
    	return left;
    }
    
    public void setRight(String right){
    	this.right = right;
    }
    public String getRight(){
    	return right;
    }
    public List<CircleModel> getModels(){
    	return circlemodels;
    }
    public void addModels(List<CircleModel> circlemodel){
    	circlemodels.addAll(circlemodel);
    }
}
