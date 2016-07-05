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

import com.lidroid.xutils.BitmapUtils;
import com.worldtrival.bean.LocalData;
import com.worldtrival.bean.LocalGoodsBranch;
import com.worldtrival.bean.Localcity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Local_Ticket extends Activity {

	private String sUrllocal = "http://120.26.208.234:10320/?url=local_recommend_main";
	private ImageView imgview;
	private TextView tv1, tv2, tv3;
	private LinearLayout liner;
			
	private MyHandler mhandler = new MyHandler();
	private Context context = this;
	
	private String longitudeShangHai = "121.22";
	private String latitudeShangHai = "31.05";
	private String longitudeXiann = "109.013273";
	private String latitudeXiann = "34.24985";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.local_ticket);

		// 初始化
		initial();
		new Thread(new Runnable() {

			@Override
			public void run() {
				String jsonStr = webLocalRequest();
				LocalData data = parseJsonToModel(jsonStr);
				Message msg = new Message();
				msg.what = 3002;
				msg.obj = data;
				mhandler.sendMessage(msg);

			}

		}).start();

	}
	
	private void initial() {

		imgview = (ImageView) findViewById(R.id.imageView_localGoodsTicket1);
		tv1 = (TextView) findViewById(R.id.tv_localGoodsTicket1);
		tv2 = (TextView) findViewById(R.id.tv_localGoodsTicket2);
		tv3 = (TextView) findViewById(R.id.tv_localGoodsTicket3);
		liner = (LinearLayout) findViewById(R.id.linearLayout_local_ticket);
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
			bw.write("json={\"longitude\": \"" + longitudeXiann + "\",\"latitude\": \"" + latitudeXiann + "\"}");
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
			JSONObject jData = jo.getJSONObject("data");
			JSONObject jCity = jData.getJSONObject("city");
			Localcity localCity = new Localcity();
			localCity.setName(jCity.getString("cn_name"));
			List<LocalGoodsBranch> localGoodsBranch = new ArrayList<LocalGoodsBranch>();
			LocalGoodsBranch branch = null;
			JSONArray array = jData.getJSONArray("goods");
			for (int i = 0; i < array.length(); i++) {
				JSONObject obj = array.getJSONObject(i);
				branch = new LocalGoodsBranch();
				branch.setImg(obj.getString("img"));
				branch.setGoods_id(obj.getString("goods_id"));
				branch.setName(obj.getString("name"));
				branch.setMarket_price(obj.getString("market_price"));
				branch.setShop_price(obj.getString("shop_price"));
				branch.setApp_cut_price(obj.getString("app_cut_price"));
				branch.setApp_cut_price_desc(obj
						.getString("app_cut_price_desc"));

				localGoodsBranch.add(branch);

			}
			data.setCity(localCity);
			data.setGoods(localGoodsBranch);

			return data;

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	class MyHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);

			switch (msg.what) {
			case 3002:
				LocalData data = (LocalData) msg.obj;

				// 加载当地数据
				localDataDownload(data);
				// 当地特色内容跳转
				localOnClickListener(data);

				break;

			default:
				break;
			}
		}

	}
	private void localOnClickListener(LocalData data) {

		liner.setOnClickListener(new MyOnClickListener("http://www.7zhou.com/tour-"+data.getGoods().get(2).getGoods_id()+".html"));
	}
	
	class MyOnClickListener implements OnClickListener{
		private String url ;
		
		public MyOnClickListener(String url) {
			super();
			this.url = url;
		}

		@Override
		public void onClick(View arg0) {
			switch (arg0.getId()) {
			case R.id.linearLayout_local_ticket:
				Intent intent = new Intent(context, WebActivity.class);
				intent.putExtra("url", url);
				context.startActivity(intent);
				break;

			default:
				break;
			}
			
		}
		
	}

	private void localDataDownload(LocalData data) {
		BitmapUtils bitmap = new BitmapUtils(context);
		bitmap.display(imgview, data.getGoods().get(2).getImg());
		tv1.setText(data.getGoods().get(2).getName());
		
		tv3.setText("￥" + data.getGoods().get(2).getMarcket_price());
		
		tv2.setText("￥" + data.getGoods().get(2).getShop_price() + "起");
		

	}

}
