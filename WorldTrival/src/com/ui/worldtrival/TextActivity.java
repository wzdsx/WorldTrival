package com.ui.worldtrival;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.worldtrival.bean.ContinentBean;
import com.worldtrival.bean.SearchContinent;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;

public class TextActivity extends Activity {
	private String url = "http://120.26.208.234:10320/?url=search";
	private String param = "json=%7B%22pagination%22%3A%7B%22count%22%3A10%2C%22page%22%3A1%7D%2C%22filter%22%3A%7B%22brand_id%22%3A%22%22%2C%22category_id%22%3A%22%22%2C%22keywords%22%3A%22%22%2C%22category_name%22%3A%22%22%2C%22dest_id%22%3A%22106%22%2C%22sort_by%22%3A%22top_sale%22%7D%7D";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
new Thread(new Runnable() {
			
			@Override
			public void run() {
				//在洲搜索中获得json字符串
				String json = getJson(url,param);
				Log.e("sssss", json);
				ContinentBean continentBean = getContinentBean(json);
//				continentBean.getList().get(0).getName();
				Log.e("gsdg", continentBean.toString());
//				Message msg = new Message();
				
			}
		}).start();
	
	}
	protected String getJson(String url_path, String string) {
		try {
			URL url = new URL(url_path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
//			String param = URLEncoder.encode(string, "UTF-8");
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			bw.write(string);
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
			Log.e("fragment", builder.toString());
			return builder.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
	/*protected ContinentBean getContinentBean(String json) {
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
				searchContient.setApp_cut_price_desc(object.getString("app_cut_price_desc"));
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
	}
*/
	private ContinentBean getContinentBean(String json){
		try {
			JSONObject jo = new JSONObject(json);
			JSONArray array = jo.getJSONArray("data");
			ContinentBean continentBean = new ContinentBean();
			List<SearchContinent> list = new ArrayList<SearchContinent>();
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
			return continentBean;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	} 
}
