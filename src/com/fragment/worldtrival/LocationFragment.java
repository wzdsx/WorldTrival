package com.fragment.worldtrival;

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
import com.ui.worldtrival.Local_CityIntroduce;
import com.ui.worldtrival.Local_Insurance;
import com.ui.worldtrival.Local_List_Goods;
import com.ui.worldtrival.Local_Map_activaty;
import com.ui.worldtrival.Local_Ticket;
import com.ui.worldtrival.R;
import com.ui.worldtrival.WebActivity;
import com.worldtrival.bean.LocalData;
import com.worldtrival.bean.LocalGoodsBranch;
import com.worldtrival.bean.Localcity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * ����Fragment
 * 
 */

public class LocationFragment extends Fragment {

	private String sUrllocal = "http://120.26.208.234:10320/?url=local_recommend_main";
	private ImageView imgview1, imgview2, imgview3, imgview4;
	private TextView title_1, title_2, title_3, title_4, original_price_1,
			original_price_2, original_price_3, original_price_4,
			price_title_1, price_title_2, price_title_3, price_title_4;
	private RelativeLayout root1, root2, root3, root4;
	private MyHandler mhandler = new MyHandler();
	private Context context;
	
	private String longitudeShangHai = "121.22";
	private String latitudeShangHai = "31.05";
	private String longitudeXiann = "109.013273";
	private String latitudeXiann = "34.24985";
	private TextView mtop_bar;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// 当地特色数据请求
		new Thread(new Runnable() {

			@Override
			public void run() {
				String jsonStr = webLocalRequest();
				LocalData data = parseJsonToModel(jsonStr);
				Message msg = new Message();
				msg.what = 3000;
				msg.obj = data;
				mhandler.sendMessage(msg);

			}

		}).start();

		View view = inflater.inflate(R.layout.tabs_fragment_local, container,
				false);

		// 初始化
		initial(view);

		// 地图跳转
		view.findViewById(R.id.map_earth).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(getActivity(),
								Local_Map_activaty.class);
						startActivity(intent); // ������getActivity().startActivity(intent);

					}
				});

		// 当地跳转
		view.findViewById(R.id.img_icon_local1).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(getActivity(),
								Local_List_Goods.class);
						startActivity(intent);

					}
				});

		// 门票跳转
		view.findViewById(R.id.img_icon_local3).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(getActivity(),
								Local_Ticket.class);
						startActivity(intent);

					}
				});
		
		// 景点跳转
		view.findViewById(R.id.img_icon_local5).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(getActivity(),
								Local_CityIntroduce.class);
						startActivity(intent); 

					}
				});
		
		
		// 保险跳转
		view.findViewById(R.id.img_icon_local7).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(getActivity(),
								Local_Insurance.class);
						startActivity(intent); 

					}
				});
		
		
		

		return view;
	}

	
	
	class MyOnClickListener implements OnClickListener{
		private String url ;
		private int localid;
		
		public MyOnClickListener(String url, int id) {
			super();
			this.url = url;
			this.localid = id;
		}

		@Override
		public void onClick(View arg0) {
			if(arg0.getId() == localid){
				Intent intent = new Intent(context, WebActivity.class);
				intent.putExtra("url", url);
				context.startActivity(intent);
			}
			
		}
		
	}

	

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		this.context = context;
	}

	private void initial(View view) {

		imgview1 = (ImageView) view.findViewById(R.id.imageView_1);
		imgview2 = (ImageView) view.findViewById(R.id.imageView_2);
		imgview3 = (ImageView) view.findViewById(R.id.imageView_3);
		imgview4 = (ImageView) view.findViewById(R.id.imageView_4);
		title_1 = (TextView) view.findViewById(R.id.title_1);
		title_2 = (TextView) view.findViewById(R.id.title_2);
		title_3 = (TextView) view.findViewById(R.id.title_3);
		title_4 = (TextView) view.findViewById(R.id.title_4);
		original_price_1 = (TextView) view.findViewById(R.id.original_price_1);
		original_price_2 = (TextView) view.findViewById(R.id.original_price_2);
		original_price_3 = (TextView) view.findViewById(R.id.original_price_3);
		original_price_4 = (TextView) view.findViewById(R.id.original_price_4);
		price_title_1 = (TextView) view.findViewById(R.id.price_title_1);
		price_title_2 = (TextView) view.findViewById(R.id.price_title_2);
		price_title_3 = (TextView) view.findViewById(R.id.price_title_3);
		price_title_4 = (TextView) view.findViewById(R.id.price_title_4);
		
		root1 = (RelativeLayout) view.findViewById(R.id.root1);
		root2 = (RelativeLayout) view.findViewById(R.id.root2);
		root3 = (RelativeLayout) view.findViewById(R.id.root3);
		root4 = (RelativeLayout) view.findViewById(R.id.root4);
		
		mtop_bar = (TextView) view.findViewById(R.id.top_text);
		mtop_bar.setText("当地");
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
			bw.write("json={\"longitude\": \""+ longitudeXiann + "\",\"latitude\": \""+ latitudeXiann + "\"}");
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
			case 3000:
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

		root1.setOnClickListener(new MyOnClickListener("http://www.7zhou.com/tour-"+data.getGoods().get(0).getGoods_id()+".html", R.id.root1));
		root2.setOnClickListener(new MyOnClickListener("http://www.7zhou.com/tour-"+data.getGoods().get(1).getGoods_id()+".html", R.id.root2));
		root3.setOnClickListener(new MyOnClickListener("http://www.7zhou.com/tour-"+data.getGoods().get(3).getGoods_id()+".html", R.id.root3));
		root4.setOnClickListener(new MyOnClickListener("http://www.7zhou.com/tour-"+data.getGoods().get(4).getGoods_id()+".html", R.id.root4));
	}

	private void localDataDownload(LocalData data) {
		BitmapUtils bitmap = new BitmapUtils(context);
		bitmap.display(imgview1, data.getGoods().get(0).getImg());
		bitmap.display(imgview2, data.getGoods().get(1).getImg());
		bitmap.display(imgview3, data.getGoods().get(3).getImg());
		bitmap.display(imgview4, data.getGoods().get(4).getImg());
		title_1.setText(data.getGoods().get(0).getName());
		title_2.setText(data.getGoods().get(1).getName());
		title_3.setText(data.getGoods().get(3).getName());
		title_4.setText(data.getGoods().get(4).getName());
		original_price_1.setText("￥"
				+ data.getGoods().get(0).getMarcket_price());
		original_price_2.setText("￥"
				+ data.getGoods().get(1).getMarcket_price());
		original_price_3.setText("￥"
				+ data.getGoods().get(3).getMarcket_price());
		original_price_4.setText("￥"
				+ data.getGoods().get(4).getMarcket_price());
		price_title_1.setText("￥" + data.getGoods().get(0).getShop_price());
		price_title_2.setText("￥" + data.getGoods().get(1).getShop_price());
		price_title_3.setText("￥" + data.getGoods().get(3).getShop_price());
		price_title_4.setText("￥" + data.getGoods().get(4).getShop_price());

	}

}
