package com.fragment.worldtrival;

import com.ui.worldtrival.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 *咨询 Fragment 
 *
 */
public class ConsultFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.guide_consult, container, false);
		return view;
	}
}
