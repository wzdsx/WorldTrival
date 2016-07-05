package com.ui.worldtrival;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.worldtrival.adapter.LocalGoodsAdapter;
import com.worldtrival.bean.LocalData;
import com.worldtrival.bean.LocalGoodsBranch;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.widget.ListView;

public class Local_Insurance extends Activity {

private ListView listView;
	
	private LocalGoodsAdapter adapter;
	
	private String sUrllocal = "http://120.26.208.234:10320/?url=local_recommend";
	
	private MyHandler mhandler = new MyHandler();
	Context context = this;
	
	private String longitudeShangHai = "121.22";
	private String latitudeShangHai = "31.05";
	private String longitudeXiann = "109.013273";
	private String latitudeXiann = "34.24985";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				String jsonStr = webLocalRequest();
				LocalData data =  parseJsonToModel(jsonStr);
				Message msg = new Message();
				msg.what = 3001;
				msg.obj = data;
				mhandler.sendMessage(msg);

			}

		}).start();
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.local_goods_trival);
		listView = (ListView) findViewById(R.id.listview_localGoods);
		
		
		
	
	}
	
	private String webLocalRequest() {
		String result = null;
		try {
			URL url = new URL(sUrllocal);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setReadTimeout(5000);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					conn.getOutputStream()));
			bw.write("json={\"filter\":{\"longitude\":\"" + longitudeXiann + "\",\"latitude\":\"" + latitudeXiann + "\",\"dest_id\":\"603\",\"category_id\":\"405\"},\"pagination\":{\"count\":10,\"page\":1}}");
			bw.flush();

			BufferedReader br = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			result = "";
			String line = null;
			while ((line = br.readLine()) != null) {
				result += line;
			}
 
			bw.close();
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	 

	
	@SuppressWarnings("unchecked")
	private LocalData parseJsonToModel(String jsonString) {
		try {
			// json解析
			JSONObject jo = new JSONObject(jsonString);
			
			
			LocalData data = new LocalData();
			
			
			List<LocalGoodsBranch> localGoodsBranch = new ArrayList<LocalGoodsBranch>();
			LocalGoodsBranch branch = null;
			JSONArray array = jo.getJSONArray("data");
			for (int i = 0; i < array.length(); i++) {
				JSONObject obj = array.getJSONObject(i);
				branch = new LocalGoodsBranch();
				branch.setImg(obj.getString("img"));
				branch.setGoods_id(obj.getString("goods_id"));
				branch.setName(obj.getString("name"));
				branch.setMarket_price(obj.getString("market_price"));
				branch.setShop_price(obj.getString("shop_price"));
				
				
				
				localGoodsBranch.add(branch);
				
			}
			data.setGoods(localGoodsBranch);
			
			
			return data;	

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	class MyHandler extends Handler{
		@Override 
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			
			switch (msg.what) {
			case 3001:
				LocalData data = (LocalData) msg.obj;
				
				//加载当地数据
				adapter = new LocalGoodsAdapter(context);
				
				adapter.setData(data.getGoods());
				listView.setAdapter(adapter);
				
				
				break;

			default:
				break;
			}
		}

		
	}
	
}
