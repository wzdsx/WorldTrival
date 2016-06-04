package com.fragmentadapter.worldtrival;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;
<<<<<<< HEAD

=======
/**
 *Fragment适配器
 */
>>>>>>> 19341655d24ceecd1a457aaaad612da507ccb5a3
public class GuideFragmentAdapter extends FragmentStatePagerAdapter {
	private List<Fragment> listfragment;
	public GuideFragmentAdapter(FragmentManager fm,List<Fragment> listfragment) {
		super(fm);
		this.listfragment = listfragment;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return listfragment.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listfragment.size();
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		super.destroyItem(container, position, object);
	}

	@Override
	public Object instantiateItem(ViewGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		return super.instantiateItem(arg0, arg1);
	}
	
	

}
