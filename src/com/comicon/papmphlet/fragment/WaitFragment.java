package com.comicon.papmphlet.fragment;

import com.comicon.papmphlet.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class WaitFragment extends Fragment{
	public WaitFragment(){
		
	}
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState){
		        View watiView = inflater.inflate(R.layout.search_is_doing, container,false);
				return watiView;
	}
} 
