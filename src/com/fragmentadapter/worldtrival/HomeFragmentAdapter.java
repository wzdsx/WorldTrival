package com.fragmentadapter.worldtrival;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class HomeFragmentAdapter extends PagerAdapter{
	private List<View> listview;
	
	
	
	public HomeFragmentAdapter(List<View> listview) {
		super();
		this.listview = listview;
	}

	@Override
	public int getCount() {
		return listview.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.removeView(listview.get(position));
		container.addView(listview.get(position));
		return listview.get(position);
	}
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(listview.get(position));
	}
	

}
