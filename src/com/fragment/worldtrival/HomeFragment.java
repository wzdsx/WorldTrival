package com.fragment.worldtrival;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fragmentadapter.worldtrival.HomeFragmentAdapter;
import com.ui.worldtrival.HomeActivityDialog;
import com.ui.worldtrival.R;
import com.ui.worldtrival.WebActivity;
import com.worldtrival.adapter.HomeAdapter;
import com.worldtrival.base.BaseHomeMessage;
import com.worldtrival.base.Url;
import com.worldtrival.bean.GoodList;
import com.worldtrival.bean.ListViewData;
import com.worldtrival.message.HomeMessageContent;
import com.worldtrival.message.HomeMessageLocation;
import com.worldtrival.message.HomeMessageZhou;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

/**
 * 首页 Fragment
 * 
 */
public class HomeFragment extends Fragment implements OnClickListener {
	private ListView listview;
	private ViewPager viewpager;
	private RelativeLayout title;
	private View view;
	private List<BaseHomeMessage> list;
	private HomeAdapter adapter;
	private View item, view1, view2, view3;
	private List<View> listPager;
	private HomeFragmentAdapter viewAdapter;
	private List<Url> listURL;
	private Context context;
	private String urlListView = "http://120.26.208.234:10320/?url=home/item";
	Url urlBean = null;
	// private MyHandler handlerPict = new MyHandler();
	// private Position position;
	// 设置handler 的what time
	private final int AUTO = 1;
	private final int TIME = 3000;
	// 设置viewpager当前页卡position
	private int index = 0;

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		this.context = context;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		new MyAsyncTask().execute(urlListView);
		view = inflater.inflate(R.layout.guide_home, container, false);
		initView();
		initItem();
		addListPager();
		addListener();
		viewpager = (ViewPager) item.findViewById(R.id.guide_home_viewpager);
		viewAdapter = new HomeFragmentAdapter(listPager);
		viewpager.setAdapter(viewAdapter);
		listview.addHeaderView(item);
		handler.sendEmptyMessageDelayed(AUTO, TIME);
		
		return view;
	}

	private void addListener() {
		title.setOnClickListener(this);
		view1.setOnClickListener(this);
		view2.setOnClickListener(this);
		view3.setOnClickListener(this);
	}

	private void addListPager() {
		listPager = new ArrayList<View>();
		listPager.add(view1);
		listPager.add(view2);
		listPager.add(view3);
	}

	private void initItem() {
		item = View.inflate(getContext(), R.layout.guide_home_guide, null);
		view1 = View.inflate(getContext(), R.layout.home_viewpager_one, null);
		view2 = View.inflate(getContext(), R.layout.home_viewpager_two, null);
		view3 = View.inflate(getContext(), R.layout.home_viewpager_three, null);

	}

	private void initView() {
		listview = (ListView) view.findViewById(R.id.guide_home_listview);
		title = (RelativeLayout) view.findViewById(R.id.home_title);
	}

	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case AUTO:
				viewpager.setCurrentItem(index);
				if (index < 2) {
					handler.sendEmptyMessageDelayed(AUTO, TIME);

					index++;
				} else {
					index = 0;
					handler.sendEmptyMessageDelayed(AUTO, TIME);
				}
			}
		}

	};


	@Override
	public void onClick(View v) {
		Intent intent1 = new Intent(context, WebActivity.class);
		switch (v.getId()) {
		case R.id.home_title:
			Intent intent = new Intent(context, HomeActivityDialog.class);
			startActivity(intent);
			Activity activity = (Activity) context;
			activity.overridePendingTransition(R.anim.push_bottom_in, 0);
			break;
		case R.id.home_viewpager_one:
			
			intent1.putExtra("url", "http://m.7zhou.com/article.php?id=254");
			startActivity(intent1);
		case R.id.home_viewpager_two:
			intent1.putExtra("url", "http://m.7zhou.com/article.php?id=253");
			startActivity(intent1);
		case R.id.home_viewpager_three:
			intent1.putExtra("url", "http://m.7zhou.com/article.php?id=252");
			startActivity(intent1);
		default:
			break;
		}
	}

	class MyAsyncTask extends AsyncTask<String, Void, Object> {

		@Override
		protected void onPostExecute(Object result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			List<ListViewData> listData = (List<ListViewData>) result;
//			 Log.e("title", listData.get(1).getText());
			// Log.e("goods_list", listData.get(1).getList().get(1).getUrl());
			addData(listData);
			adapter = new HomeAdapter(getActivity(), list);
			listview.setAdapter(adapter);
		}

		@Override
		protected Object doInBackground(String... params) {
			String jsonContent = getJsonContent(params[0]);
			List<ListViewData> data = getListViewData(jsonContent);
			return data;
		}

	}

	public String getJsonContent(String url) {
		try {
			URL u = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) u.openConnection();
			conn.setRequestMethod("POST");
			// conn.setDoOutput(true);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while ((line = br.readLine()) != null) {
				builder.append(line);
			}
			br.close();
			conn.disconnect();
			return builder.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void addData(List<ListViewData> listData) {
		list = new ArrayList<BaseHomeMessage>();

		list.add(new HomeMessageZhou(0, R.drawable.ic_launcher,
				R.drawable.ic_launcher, R.drawable.ic_launcher,
				R.drawable.ic_launcher, R.drawable.ic_launcher,
				R.drawable.ic_launcher, R.drawable.ic_launcher, "亚洲", "欧洲",
				"大洋洲", "非洲", "北美洲", "南美洲", "南极洲"));
		list.add(new HomeMessageLocation(1, R.drawable.ic_launcher,
				R.drawable.ic_launcher, R.drawable.ic_launcher,
				R.drawable.ic_launcher, "当地玩乐", "机场接送", "酒店度假村", "结伴同游"));
//		list.add(new HomeMessageSearch(2, R.drawable.ic_launcher, "发现更多",
//				"七洲有礼 在线互动 同城聚会", "惊喜活动天天有", false));
//		list.add(new HomeMessageSearch(2, R.drawable.ic_launcher, "基金商城",
//				"旅游基金用起来", "礼品多多", true));
		String[] tap = new String[] { "玩转七洲", "", "", "", "", "", "", "" };
		for (int i = 0; i < listData.size(); i++) {

			ArrayList<GoodList> goodlist = listData.get(i).getList();
			list.add(new HomeMessageContent(3, goodlist.get(0).getImg(),
					goodlist.get(1).getImg(), goodlist.get(2).getImg(),
					goodlist.get(3).getImg(), goodlist.get(4).getImg(),
					goodlist.get(5).getImg(), goodlist.get(6).getImg(),
					goodlist.get(7).getImg(), tap[i], listData.get(i)
							.getTitle(), listData.get(i).getText(), goodlist
							.get(1).getName(), goodlist.get(2).getName(),
					goodlist.get(3).getName(), goodlist.get(4).getName(),
					goodlist.get(5).getName(), goodlist.get(6).getName(),
					goodlist.get(6).getName(), goodlist.get(7).getName(),
					new Url("http://www.7zhou.com/" + goodlist.get(0).getUrl(),
							"http://www.7zhou.com/" + goodlist.get(1).getUrl(),
							"http://www.7zhou.com/" + goodlist.get(2).getUrl(),
							"http://www.7zhou.com/" + goodlist.get(3).getUrl(),
							"http://www.7zhou.com/" + goodlist.get(4).getUrl(),
							"http://www.7zhou.com/" + goodlist.get(5).getUrl(),
							"http://www.7zhou.com/" + goodlist.get(6).getUrl(),
							"http://www.7zhou.com/" + goodlist.get(7).getUrl())));

		}
	}

	public List<ListViewData> getListViewData(String jsonContent) {
		try {
			JSONObject jo = new JSONObject(jsonContent);
			GoodList goodlist = null;
			// data数组中的每一个元素
			ListViewData listViewData = null;
			// json解析出data数组
			JSONArray jArray = jo.getJSONArray("data");
			// data数组元素中的数组goods_list
			List<ListViewData> dataList = new ArrayList<ListViewData>();
			for (int i = 0; i < jArray.length(); i++) {
				// 从data数组中得到每一个元素的对象
				JSONObject data = jArray.getJSONObject(i);
				// 从元素中得到goods_list数组
				JSONArray goods_list = data.getJSONArray("goods_list");
				ArrayList<GoodList> listGood = new ArrayList<GoodList>();
				for (int j = 0; j < goods_list.length(); j++) {
					// 得到每个goods_list数组元素的对象
					JSONObject obj = goods_list.getJSONObject(j);
					goodlist = new GoodList();
					// 将解析的内容分别赋值给GoodList
					goodlist.setName(obj.getString("name"));
					goodlist.setImg(obj.getString("goods_img"));
					goodlist.setUrl(obj.getString("url"));
					listGood.add(goodlist);
				}
				listViewData = new ListViewData();
				listViewData.setList(listGood);
				listViewData.setText(data.getString("class_text"));
				listViewData.setTitle(data.getString("class_title"));
				dataList.add(listViewData);
			}
			return dataList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
