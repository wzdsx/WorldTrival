package com.ui.worldtrival;

import java.util.ArrayList;
import java.util.List;

import com.fragment.worldtrival.ConsultFragment;
import com.fragment.worldtrival.HomeFragment;
import com.fragment.worldtrival.LocationFragment;
import com.fragment.worldtrival.MineFragment;
import com.fragment.worldtrival.SearchFragment;
import com.fragmentadapter.worldtrival.GuideFragmentAdapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * @author Joker 主Activity 包含底部导航和ViewPager ViewPager中用Fragment实现
 *         function:1.点击底部导航viewPager改变 2.滑动ViewPager底部导航随之改变
 * 
 */
public class World_MainActivity extends FragmentActivity implements OnPageChangeListener, OnClickListener {
	private List<Fragment> listfragment;
	private ViewPager viewpager;
	private GuideFragmentAdapter fragAdapter;
	private ImageView home_image, consult_image, location_image, search_image, mine_image;
	private TextView home_text, consult_text, location_text, search_text, mine_text;
	private LinearLayout guide_home, guide_consult, guide_location, guide_search, guide_mine;
	// 自定义Toast

	private Toast toast;

	private boolean flag = false; // 判断物理返回按键
	// handler de what and duration
	private final int WHAT = 0x1000;
	private final int TIME = 2000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_world__main);
		// 初始化控件
		initView();
		// 初始化属性 使首页成为默认值
		initViewPara();
		// 添加数据源 List<Fragment>
		addListResource();
		// 适配器
		initAdapter();
		// 添加监听
		addListener();

	}

	private void initViewPara() {
		home_image.setImageResource(R.drawable.home_click);
		home_text.setTextColor(Color.GREEN);
	}

	@SuppressWarnings("deprecation")
	private void addListener() {
		viewpager.setOnPageChangeListener(this);
		guide_home.setOnClickListener(this);
		guide_consult.setOnClickListener(this);
		guide_location.setOnClickListener(this);
		guide_search.setOnClickListener(this);
		guide_mine.setOnClickListener(this);

	}

	private void initAdapter() {
		fragAdapter = new GuideFragmentAdapter(getSupportFragmentManager(), listfragment);
		viewpager.setAdapter(fragAdapter);
	}

	private void addListResource() {
		// 创建5个Fragment将他们存储到List集合中
		listfragment = new ArrayList<Fragment>();
		listfragment.add(new HomeFragment());
		listfragment.add(new ConsultFragment());
		listfragment.add(new LocationFragment());
		listfragment.add(new SearchFragment());
		listfragment.add(new MineFragment());
	}

	private void initView() {
		// 初始化导航控件
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
		guide_home = (LinearLayout) findViewById(R.id.main_guide_home);
		guide_consult = (LinearLayout) findViewById(R.id.main_guide_consult);
		guide_location = (LinearLayout) findViewById(R.id.main_guide_location);
		guide_search = (LinearLayout) findViewById(R.id.main_guide_search);
		guide_mine = (LinearLayout) findViewById(R.id.main_guide_mine);
		// home_image.setImageResource(R.drawable.home_click);
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
		// 滑动ViewPager 使 导航改变
		switch (arg0) {
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
		default:
			break;
		}

	}

	@Override
	public void onClick(View v) {
		/**
		 * 点击导航 使 viewPager 改变
		 */
		switch (v.getId()) {
		case R.id.main_guide_home:
			// 设置当前页卡
			viewpager.setCurrentItem(0);
			break;
		case R.id.main_guide_consult:
			viewpager.setCurrentItem(1);
			break;
		case R.id.main_guide_location:
			viewpager.setCurrentItem(2);
			break;
		case R.id.main_guide_search:
			viewpager.setCurrentItem(3);
			break;
		case R.id.main_guide_mine:
			viewpager.setCurrentItem(4);
			break;
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (!flag) {
				flag = true;
				toast = Toast.makeText(this, "再点击一次退出环球", TIME);
				toast.setGravity(17, 0, -30);
				toast.show();
				handler.sendEmptyMessageDelayed(WHAT, TIME);
			} else {
				finish();
			}
		}
		return false;
	}

	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case WHAT:
				flag = false;
				break;
			}
		}

	};

	@Override
	protected void onPause() {
		if (toast != null)
			toast.cancel();
		super.onPause();

	}

}
