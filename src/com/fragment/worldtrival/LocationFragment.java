package com.fragment.worldtrival;

import com.ui.worldtrival.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 *当地Fragment 
 *
 */
public class LocationFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.guide_location, container, false);
		return view;
	}
}