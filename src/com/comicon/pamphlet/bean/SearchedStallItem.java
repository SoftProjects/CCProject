package com.comicon.pamphlet.bean;

import java.io.Serializable;

public class SearchedStallItem implements Serializable{
    private String title;
    private String stallName;
    private String stallCode;
    private int price;
    
    public String getTitle(){
    	return title;
    }
    public void setTitle(String title){
    	this.title=title;
    }
    
    public String getStallName(){
    	return stallName;
    }
    public void setStallName(String name){
    	this.stallName=name;
    }
    
    public String getStallCode(){
    	return stallCode;
    }
    public void setStallCode(String code){
    	this.stallCode=code;
    }
    
    public int getPrice(){
    	return price;
    }
    public void setPrice(int price){
    	this.price=price;
    }
}
