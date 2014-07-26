package com.ccproject.fragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ccproject.activity.R;
import com.ccproject.activity.StallInforActivity;
import com.ccproject.adapter.StallSearchResultAdapter;

import com.ccproject.bean.SearchedStallItem;
import com.comicon.pamphlet.data.model.WorkModel;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class StallSearchDoneFragment extends Fragment{
    private ArrayList<WorkModel> searchResult;
    public StallSearchDoneFragment(){
    	
    }
    public static StallSearchDoneFragment newInstance(ArrayList<WorkModel> serarchedData){
    	StallSearchDoneFragment newFragment = new StallSearchDoneFragment();
    	Bundle bundle = new Bundle();
    	bundle.putSerializable("SearchData",serarchedData);
    	newFragment.setArguments(bundle);
    	return newFragment;
    }
    
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState){
		    View rootView = inflater.inflate(R.layout.search_is_done, null);
		    Bundle args = getArguments();
		    if(args!=null){
		    	this.searchResult = (ArrayList<WorkModel>)args.getSerializable("SearchData");
		    }
		    ListView searchResultListView = (ListView)rootView.findViewById(R.id.search_result_list);
		    

		    
		    StallSearchResultAdapter mAdapter = new StallSearchResultAdapter(getActivity(), this.searchResult);
		    searchResultListView.setAdapter(mAdapter);

			return rootView;
	}
	
	
	
}
