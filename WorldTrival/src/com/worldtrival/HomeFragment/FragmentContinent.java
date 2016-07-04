package com.worldtrival.HomeFragment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.ui.worldtrival.R;
import com.worldtrival.adapter.HomeSearchFragmentAdapter;
import com.worldtrival.bean.ContinentBean;
import com.worldtrival.bean.SearchContinent;

public class FragmentContinent extends Fragment{
	private ListView listview;
	private View view;
	private Activity activity;
	public static final int FIRST = 0x2000;
	private List<SearchContinent> listSearch;
	private HomeSearchFragmentAdapter adapter ;
	private MyHandler handler = new MyHandler();
	@Override
	@Deprecated
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.activity = activity;
	}

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
		ViewGroup container,Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_contient_listview, container, false);
		initView();
		final String url_path = getArguments().getString("url_path");
		final String url_param1 = getArguments().getString("url_param1");
		final String url_param2 = getArguments().getString("url_param2");
		new Thread(new Runnable() {
	 		
			@Override
			public void run() {
				//在洲搜索中获得json字符串
				String json = getJson(url_path,url_param1+1+url_param2);
				Log.e("sssss", json);
				ContinentBean continentBean = getContinentBean(json);
//				Log.e("fsf", continentBean.getList().get(1).getGoods_id());
				Log.e("gsdg", continentBean.getList().get(2).getGoods_id());
				Message msg = new Message();
				msg.what = FIRST;
				msg.obj = continentBean;
				handler.sendMessage(msg);
			}
		}).start();
		
		
		return view;
	}

	protected ContinentBean getContinentBean(String json) {
		ContinentBean continentBean = new ContinentBean();
		try {
			JSONObject jo = new JSONObject(json);
			List<SearchContinent> list = new ArrayList<SearchContinent>();
			JSONArray array = jo.getJSONArray("data");
			SearchContinent searchContient = null;
			for(int i = 0 ; i < array.length() ; i ++){
				JSONObject object = array.getJSONObject(i);
				searchContient = new SearchContinent();
				searchContient.setGoods_id(object.getString("goods_id"));
				searchContient.setName(object.getString("name"));
				searchContient.setMarket_price(object.getString("market_price"));
				searchContient.setShop_price(object.getString("shop_price"));
				searchContient.setApp_cut_price_desc(object.getString("app_cut_price"));
				searchContient.setGoods_img(object.getString("goods_img"));
				list.add(searchContient);
			}
			continentBean.setList(list);
//			Log.e("fff", continentBean.getList().get(0).getName());
//			Log.e("ggg", continentBean.getList().get(1).getName());
			return  continentBean;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
		/*try {
			JSONObject jo = new JSONObject(json);
			JSONArray array = jo.getJSONArray("data");
			ContinentBean continentBean = new ContinentBean();
			List<SearchContinent> list = new ArrayList<SearchContinent>();
			SearchContinent searchContient = null;
			for(int i = 0 ; i < array.length() ; i ++){
				JSONObject object = array.getJSONObject(i);
				searchContient = new SearchContinent();
				searchContient.setGoods_id(object.getString("goods_id"));
			}
			continentBean.setList(list);
//			Log.e("tag", continentBean.getList().get(1).getGoods_id());
			return continentBean;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		*/
	}

	protected String getJson(String url_path, String string) {
		try {
			URL url = new URL(url_path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			String param = URLEncoder.encode(string, "UTF-8");
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			bw.write("json="+param);
			bw.flush();
			bw.close();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while((line = br.readLine())!=null){
				builder.append(line);
			}
			br.close();
			conn.disconnect();
//			Log.e("fragment", builder.toString());
			return builder.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 

	private void initView() {
		listview =(ListView) view.findViewById(R.id.fragment_contient_listview); 
	}
	class MyHandler extends Handler{
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case FIRST:
				addFirstList((ContinentBean)msg.obj);
				adapter = new HomeSearchFragmentAdapter(listSearch,activity);
				listview.setAdapter(adapter);
				
				
				break;

			default:
				break;
			}
		}
	}
	public void addFirstList(ContinentBean obj) {
		listSearch = obj.getList();
	}
}
