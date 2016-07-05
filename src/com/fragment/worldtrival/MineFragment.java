package com.fragment.worldtrival;

import com.ui.worldtrival.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/**
 *我的Fragment
 */
public class MineFragment extends Fragment {
	private TextView mtop_bar;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.tabs_fragment_mine, container, false);
		initView(view);
		return view;
	}
	private void initView(View view) {
		mtop_bar = (TextView)view.findViewById(R.id.top_text);
		mtop_bar.setText("我的");
		
	}
	
}
