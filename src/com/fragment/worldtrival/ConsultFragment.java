package com.fragment.worldtrival;

import com.ui.worldtrival.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 *
 *
 */
public class ConsultFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.tabs_fragment_consult, container, false);
		return view;
	}
}
