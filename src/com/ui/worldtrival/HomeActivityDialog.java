package com.ui.worldtrival;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.Normalizer;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.worldtrival.adapter.HomeSearchAdapter;
import com.worldtrival.base.BaseHomeMessage;
import com.worldtrival.bean.GoodList;
import com.worldtrival.bean.HintData;
import com.worldtrival.bean.HomeSearchData;
import com.worldtrival.bean.HomeSearchHint;
import com.worldtrival.bean.Recommend;
import com.worldtrival.bean.Status;

import android.app.Activity;

import android.content.Intent;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class HomeActivityDialog extends Activity {
	private ListView listview;
	// private List<BaseHomeMessage> list;
	private List<Recommend> list;
	private HomeSearchAdapter adapter = null;
	private EditText edittext;
	// "json={\"key\":"+search+"}"
	private String url_normal = "http://120.26.208.234:10320/?url=hot_recommend";
	private String url_search = "";
	final int NORMAL = 0x1000;
	final int SEARCH = 0x1001;

	private MyHandler handler = new MyHandler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_search_activitydialog);
		initView();
		new Thread(new Runnable() {

			@Override
			public void run() {
				String json_normal = getNormaoJSON(url_normal);
				HomeSearchData search_data = jsonParse(json_normal);
				Message msg = new Message();
				msg.what = NORMAL;
				msg.obj = search_data;
				handler.sendMessage(msg);

			}
		}).start();
		addListener();
	}

	private void addListener() {
		edittext.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				final String search = edittext.getText().toString();
				new Thread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						String json_search = getSearchJson(
								"http://120.26.208.234:10320/?url=search_hint",
								search);
						HomeSearchHint search_hint = jsonSearchParse(json_search);
						Message msg = new Message();
						msg.what = SEARCH;
						msg.obj = search_hint;
						handler.sendMessage(msg);
					}
				}).start();

			}
		});
	}

	protected String getSearchJson(String string, String search) {
		try {
			URL url = new URL(string);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			String param = "{\"key\":" + search + "}";
			String encoParam = URLEncoder.encode(param, "UTF-8");
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					conn.getOutputStream()));
			bw.write("json=" + encoParam);
			bw.flush();
			bw.close();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while ((line = br.readLine()) != null) {
				builder.append(line);
			}
			Log.e(search, builder.toString());
			return builder.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	protected String getNormaoJSON(String url_normal) {
		try {
			URL url = new URL(url_normal);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while ((line = br.readLine()) != null) {
				builder.append(line);
			}
			Log.e("normal", builder.toString());
			br.close();
			conn.disconnect();
			return builder.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private void initView() {
		listview = (ListView) findViewById(R.id.homesearch);
		edittext = (EditText) findViewById(R.id.home_search_search);
	}

	class MyHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case NORMAL:
//				HomeSearchData search_data = jsonParse((String) msg.obj);
				addList((HomeSearchData)msg.obj);
				adapter = new HomeSearchAdapter(list, HomeActivityDialog.this);
				listview.setAdapter(adapter);
				break;
			case SEARCH:
//				HomeSearchHint search_hint = jsonSearchParse((String)msg.obj);
//				Log.e("澳大利亚", search_hint.getStatus().getError_code()+"");
				addSearchList((HomeSearchHint)msg.obj);
				adapter.notifyDataSetChanged();
//				listview.setAdapter(adapter);
				break;
			default:
				break;
			}
		}
	}

	public HomeSearchData jsonParse(String obj) {
		try {
			HomeSearchData search_hint = new HomeSearchData();
			JSONObject jo = new JSONObject(obj);
			JSONObject data = jo.getJSONObject("data");
			search_hint.setHot_keyworld(data.getString("hot_keyword"));
			JSONArray array = data.getJSONArray("recommend");
			List<Recommend> listRec = new ArrayList<Recommend>();
			Recommend recommend = null;
			for (int i = 0; i < array.length(); i++) {
				recommend = new Recommend();
				JSONObject r = array.getJSONObject(i);
				recommend.setGoods_id(r.getString("goods_id"));
				recommend.setGoods_name(r.getString("goods_name"));
				listRec.add(recommend);
			}
			search_hint.setList(listRec);
			return search_hint;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void addSearchList(HomeSearchHint search_hint) {
		List<HintData> listData = search_hint.getList();
		list.clear();
		Recommend recommend = null; 
		for(int i = 0 ; i < listData.size() ; i ++){
			HintData data = listData.get(i);
			if(TextUtils.isEmpty(data.getDestName())){
				recommend = new Recommend(data.getGoodsName(), data.getGoodsId());
			}else{ 
				recommend = new Recommend(data.getDestName(), data.getDestId());
			}
			Log.e("meiguo", recommend.getGoods_name()); 
			list.add(recommend);
		}
	}

	public HomeSearchHint jsonSearchParse(String obj) {
		try {
			HomeSearchHint searchHint = new HomeSearchHint();
			JSONObject jo = new JSONObject(obj);
			JSONObject s = jo.getJSONObject("status");
			Status st = new Status();
			st.setError_code(s.getInt("error_code"));
			st.setSucceed(s.getInt("succeed"));
			searchHint.setStatus(st);
			List<HintData> listData = new ArrayList<HintData>();
			HintData hintData = null;
			JSONArray array = jo.getJSONArray("data");
			for (int i = 0; i < array.length(); i++) {
				hintData = new HintData();
				JSONObject data = array.getJSONObject(i);
				hintData.setDestId(data.getString("destId"));
				hintData.setDestName(data.getString("destName"));
				hintData.setGoodsId(data.getString("goodsId"));
				hintData.setGoodsName(data.getString("goodsName"));
				hintData.setShopPrice(data.getString("shopPrice"));
				hintData.setCatName(data.getString("catName"));
				listData.add(hintData);
			}
			searchHint.setList(listData);
			return searchHint;
//			searchHint.setList(list)
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public void addList(HomeSearchData search_hint) {
		list = search_hint.getList();
	}

}
