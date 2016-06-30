package com.fragment.worldtrival;

import com.ui.worldtrival.Local_Map_activaty;
import com.ui.worldtrival.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

/**
 *当地Fragment 
 *
 */

public class LocationFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.tabs_fragment_local, container, false);
		view.findViewById(R.id.map_earth).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), Local_Map_activaty.class);
				startActivity(intent); //这里用getActivity().startActivity(intent);
				
			}
		});
		return view;
	}
}
