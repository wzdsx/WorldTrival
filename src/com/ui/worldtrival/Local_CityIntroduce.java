package com.ui.worldtrival;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.lidroid.xutils.BitmapUtils;
import com.worldtrival.bean.LocalCityIntroduce;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Local_CityIntroduce extends Activity {
	private String longitude;
	private String latitude;
	

	private String sUrllocal = "http://120.26.208.234:10320/?url=get_spot_list";
	private ImageView imgview;
	private TextView tv1, tv2, tv3;
			
	private MyHandler mhandler = new MyHandler();
	private Context context = this;
	private LinearLayout liner;
	
	private String longitudeShangHai = "121.22";
	private String latitudeShangHai = "31.05";
	private String longitudeXiann = "109.013273";
	private String latitudeXiann = "34.24985";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.local_introduce);

		// 初始化
		initial();
		new Thread(new Runnable() {

			@Override
			public void run() {
				String jsonStr = webLocalRequest();
				LocalCityIntroduce lci = parseJsonToModel(jsonStr);
				Message msg = new Message();
				msg.what = 3003;
				msg.obj = lci;
				mhandler.sendMessage(msg);

			}

		}).start();

	}
	
	private void initial() {

		imgview = (ImageView) findViewById(R.id.imageView_localCityIntroduce);
		tv1 = (TextView) findViewById(R.id.tv_localCityIntroduce2);
		tv2 = (TextView) findViewById(R.id.tv_localCityIntroduce1);
		tv3 = (TextView) findViewById(R.id.tv_localCityIntroduce3);
		liner = (LinearLayout) findViewById(R.id.linearLayout_local_introduce);
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
			bw.write("json= {\"longitude\":\"" + longitudeXiann + "\",\"latitude\":\"" + latitudeXiann + "\",\"dest_id\":\"603\"}");
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

	private LocalCityIntroduce parseJsonToModel(String jsonString) {
		try {
			// json解析
			JSONObject jo = new JSONObject(jsonString);
			LocalCityIntroduce lci = new LocalCityIntroduce();
			JSONObject jData = jo.getJSONObject("data");
			JSONArray array = jData.getJSONArray("spot");
			JSONObject obj = array.getJSONObject(0);
			lci.setDistance(obj.getString("distance"));
			lci.setGoods_id(obj.getString("goods_id"));
			lci.setImg_url(obj.getString("img_url"));
			lci.setName(obj.getString("name"));
			lci.setSummary(obj.getString("summary"));


			return lci;

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
			case 3003:
				LocalCityIntroduce lci = (LocalCityIntroduce) msg.obj;

				// 加载当地数据
				localDataDownload(lci);
				// 跳转当地介绍
				liner.setOnClickListener(new MyOnClickListener("http://guide.7zhou.com/doc-view-"+lci.getGoods_id()+".html"));

				break;

			default:
				break;
			}
		}

	}

	private void localDataDownload(LocalCityIntroduce lci) {
		BitmapUtils bitmap = new BitmapUtils(context);
		bitmap.display(imgview, lci.getImg_url());
		tv1.setText(lci.getName());
		
		tv3.setText(lci.getDistance());
		
		tv2.setText(lci.getSummary());
		

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
			case R.id.linearLayout_local_introduce:
				Intent intent = new Intent(context, WebActivity.class);
				intent.putExtra("url", url);
				context.startActivity(intent);
				break;

			default:
				break;
			}	
		}
		
	}

}
