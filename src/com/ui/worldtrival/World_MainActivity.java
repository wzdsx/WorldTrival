package com.ui.worldtrival;

import java.util.ArrayList;
import java.util.List;

import com.fragment.worldtrival.ConsultFragment;
import com.fragment.worldtrival.HomeFragment;
import com.fragment.worldtrival.LocationFragment;
import com.fragment.worldtrival.MineFragment;
import com.fragment.worldtrival.SearchFragment;
import com.fragmentadapter.worldtrival.GuideFragmentAdapter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * 
 * @author Joker
 * 主页面 里面加载ViewPager 和 底部导航
 * ViewPager中用Fragment实现
 * function:1.拖动ViewPager 导航的视图会发生变化
 * 2*:想要实现给导航添加监听器 点击导航可以使ViewPager发生变换
 *
 */
public class World_MainActivity extends FragmentActivity implements OnPageChangeListener,OnClickListener{
	private List<Fragment>listfragment;
	private ViewPager viewpager;
	private GuideFragmentAdapter fragAdapter;
	private ImageView home_image,consult_image,location_image,search_image,mine_image;
	private TextView home_text,consult_text,location_text,search_text,mine_text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_world__main);
		//初始化控件
		initView();
		//初始化控件属性
		initViewPara();
		//构造数据源
		addListResource();
		//绑定适配器
		initAdapter();
		//监听
		addListener();
	}
	private void initViewPara() {
		home_image.setImageResource(R.drawable.home_normal);
		home_text.setTextColor(Color.GREEN);
	}
	@SuppressWarnings("deprecation")
	private void addListener() {
		viewpager.setOnPageChangeListener(this);
	}
	private void initAdapter() {
		fragAdapter = new GuideFragmentAdapter(getSupportFragmentManager(), listfragment);
		viewpager.setAdapter(fragAdapter);
	}
	private void addListResource() {
		listfragment = new ArrayList<Fragment>();
		listfragment.add(new HomeFragment());
		listfragment.add(new ConsultFragment());
		listfragment.add(new LocationFragment());
		listfragment.add(new SearchFragment());
		listfragment.add(new MineFragment());
	}
	private void initView() {
		//初始化ViewPager
		viewpager = (ViewPager) findViewById(R.id.main_viewpager);
		home_image = (ImageView) findViewById(R.id.main_guide_home_image);
		home_text = (TextView) findViewById(R.id.main_guide_home_text);
		consult_image = (ImageView) findViewById(R.id.main_guide_consult_image);
		consult_text = (TextView) findViewById(R.id.main_guide_consult_text);
		location_image = (ImageView) findViewById(R.id.main_guide_location_image);
		location_text = (TextView) findViewById(R.id.main_guide_location_text);
		search_image = (ImageView) findViewById(R.id.main_guide_search_image);
		search_text = (TextView) findViewById(R.id.main_guide_search_text);
		mine_image = (ImageView) findViewById(R.id.main_guide_mine_image);
		mine_text = (TextView) findViewById(R.id.main_guide_mine_text);
	}
	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onPageSelected(int arg0) {
//		Log.e("TAG", (arg0+1)+""); 
		//导航样式随着ViewPager改变而改变
		switch(arg0){
		case 0:
			home_image.setImageResource(R.drawable.home_click);
			home_text.setTextColor(Color.GREEN);
			consult_image.setImageResource(R.drawable.consult_normal);
			consult_text.setTextColor(Color.GRAY);
			location_image.setImageResource(R.drawable.location_normal);
			location_text.setTextColor(Color.GRAY);
			search_image.setImageResource(R.drawable.search_normal);
			search_text.setTextColor(Color.GRAY);
			mine_image.setImageResource(R.drawable.mine_normal);
			mine_text.setTextColor(Color.GRAY);
			break;
		case 1:
			home_image.setImageResource(R.drawable.home_normal);
			home_text.setTextColor(Color.GRAY);
			consult_image.setImageResource(R.drawable.consult_click);
			consult_text.setTextColor(Color.GREEN);
			location_image.setImageResource(R.drawable.location_normal);
			location_text.setTextColor(Color.GRAY);
			search_image.setImageResource(R.drawable.search_normal);
			search_text.setTextColor(Color.GRAY);
			mine_image.setImageResource(R.drawable.mine_normal);
			mine_text.setTextColor(Color.GRAY);
			break;
		case 2:
			home_image.setImageResource(R.drawable.home_normal);
			home_text.setTextColor(Color.GRAY);
			consult_image.setImageResource(R.drawable.consult_normal);
			consult_text.setTextColor(Color.GRAY);
			location_image.setImageResource(R.drawable.location_click);
			location_text.setTextColor(Color.GREEN);
			search_image.setImageResource(R.drawable.search_normal);
			search_text.setTextColor(Color.GRAY);
			mine_image.setImageResource(R.drawable.mine_normal);
			mine_text.setTextColor(Color.GRAY);
			break;
		case 3:
			home_image.setImageResource(R.drawable.home_normal);
			home_text.setTextColor(Color.GRAY);
			consult_image.setImageResource(R.drawable.consult_normal);
			consult_text.setTextColor(Color.GRAY);
			location_image.setImageResource(R.drawable.location_normal);
			location_text.setTextColor(Color.GRAY);
			search_image.setImageResource(R.drawable.search_click);
			search_text.setTextColor(Color.GREEN);
			mine_image.setImageResource(R.drawable.mine_normal);
			mine_text.setTextColor(Color.GRAY);
			break;
		case 4:
			home_image.setImageResource(R.drawable.home_normal);
			home_text.setTextColor(Color.GRAY);
			consult_image.setImageResource(R.drawable.consult_normal);
			consult_text.setTextColor(Color.GRAY);
			location_image.setImageResource(R.drawable.location_normal);
			location_text.setTextColor(Color.GRAY);
			search_image.setImageResource(R.drawable.search_normal);
			search_text.setTextColor(Color.GRAY);
			mine_image.setImageResource(R.drawable.mine_click);
			mine_text.setTextColor(Color.GREEN);
			break;
		default :
			break;
		}
		
	}
	@Override
	public void onClick(View v) {
	/**
	 * 点击导航Viewpager改变	
	 */
	}

}
