package com.fragment.worldtrival;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ui.worldtrival.R;
import com.worldtrival.adapter.HomeAdapter;
import com.worldtrival.base.BaseHomeMessage;
import com.worldtrival.message.HomeMessageContent;
import com.worldtrival.message.HomeMessageLocation;
import com.worldtrival.message.HomeMessageSearch;
import com.worldtrival.message.HomeMessageZhou;
;
/**
 *首页 Fragment 
 *
 */
public class HomeFragment extends Fragment {
	private ListView listview;
	private View view;
	private List<BaseHomeMessage> list;
	private HomeAdapter adapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.tabs_fragment_home, container, false);
		initView();
		addListener();
		adapter = new HomeAdapter(getActivity(), list);
		listview.setAdapter(adapter);
		return view;
	}
	private void addListener() {
		list = new ArrayList<BaseHomeMessage>();
		list.add(new HomeMessageZhou(0, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, "亚洲", "欧洲", "大洋洲", "非洲", "北美洲", "南美洲", "南极洲"));
		list.add(new HomeMessageLocation(1, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, "当地玩乐", "机场接送", "酒店度假村", "结伴同游"));
		list.add(new HomeMessageSearch(2, R.drawable.ic_launcher, "发现更多", "七洲有礼 在线互动 同城聚会", "惊喜活动天天有"));
		list.add(new HomeMessageSearch(2, R.drawable.ic_launcher, "基金商城", "旅游基金用起来", "礼品多多"));
		list.add(new HomeMessageContent(3, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, "玩转七洲", "#出海潜伏#", "碧海蓝天，清清沙白"));
		list.add(new HomeMessageContent(3, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, "", "#城市包车#", "华灯璀璨，川流不辞"));
		list.add(new HomeMessageContent(3, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, "", "#特色表演#", "有声有色，精彩绝伦"));
		list.add(new HomeMessageContent(3, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, "", "#亲近动物#", "飞禽走兽，花鸟虫鱼"));
		list.add(new HomeMessageContent(3, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, "", "#按摩SPA#", "放松身心，休养生息"));
		list.add(new HomeMessageContent(3, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, "", "#高空体验#", "冲上云霄，漫步云端"));
		list.add(new HomeMessageContent(3, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, "", "#自然奇观#", "千岩万壑，水天一色"));
		list.add(new HomeMessageContent(3, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher, "", "#历史古迹#", "亭台楼阁，古堡迷踪"));
		
	}
	private void initView() {
		listview = (ListView) view.findViewById(R.id.guide_home_listview);
	}
}
