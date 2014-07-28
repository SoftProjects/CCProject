package com.comicon.papmphlet.bean;

public class StallItemInfor {
   private String title;
   private String type;
   private String url;
   private int price;
   
   public String getStallItemTitle(){
	   return title;
   }
   public void setStallItemTitle(String title){
	   this.title = title;
   }
   
   public String getStallItemType(){
	   return type;
   }
   public void setStallItemType(String type){
	   this.type =type;
   }
   
   public String getStallItemUrl(){
	   return url;
   }
   public void setStallItemUrl(String url){
	   this.url = url;
   }
   
   public int getStallItemPrice(){
	   return price;
   }
   public void setStallItemPrice(int price){
	   this.price = price;
   }
   
   
}
