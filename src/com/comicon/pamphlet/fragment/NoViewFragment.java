package com.comicon.pamphlet.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.comicon.pamphlet.R;

public class NoViewFragment extends Fragment{
	public NoViewFragment(){
		
	}
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState){
		        View watiView = inflater.inflate(R.layout.no_view, container,false);
				return watiView;
	}

}
