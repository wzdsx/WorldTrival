package com.worldtrival.adapter;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;
import com.ui.worldtrival.R;
import com.ui.worldtrival.WebActivity;
import com.worldtrival.bean.SearchContinent;

public class HomeSearchFragmentAdapter extends BaseAdapter {
	private List<SearchContinent> list ;
	private Context context;
	private LayoutInflater inflater;
	
	
	public HomeSearchFragmentAdapter(List<SearchContinent> list, Context context) {
		super();
		this.list = list;
		this.context = context;
		inflater = LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	@Override
	public View getView(int position, View v, ViewGroup parent) {
		ViewHolder holder = null;
		if(v == null){
			v = inflater.inflate(R.layout.fragment_contient_listview_item, null, false);
			holder = new ViewHolder();
			holder.item = (LinearLayout) v.findViewById(R.id.fragment_contient_listview_item);
			holder.image = (ImageView) v.findViewById(R.id.contient_listview_item_image);
			holder.name = (TextView) v.findViewById(R.id.contient_listview_item_name);
			holder.market_price = (TextView) v.findViewById(R.id.contient_listview_item_normalPrice);
			holder.shop_price = (TextView) v.findViewById(R.id.contient_listview_item_price);
			holder.app_cut_price_desc = (TextView) v.findViewById(R.id.contient_listview_item_introduce);
			v.setTag(holder);
		}else{
			holder = (ViewHolder) v.getTag();
		}
		SearchContinent searchContinent = list.get(position);
		BitmapUtils bitmap = new BitmapUtils(context);
		bitmap.display(holder.image, searchContinent.getGoods_img());
		holder.name.setText(searchContinent.getName());
		holder.market_price.setText(searchContinent.getMarket_price());
		holder.shop_price.setText(searchContinent.getShop_price());
		holder.app_cut_price_desc.setText("下单立减￥"+searchContinent.getApp_cut_price_desc());
		holder.app_cut_price_desc.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
		holder.item.setOnClickListener(new MyOnClickListener("http://www.7zhou.com/tour-"+searchContinent.getGoods_id()+".html"));
		return v;
	}
	class ViewHolder{
		LinearLayout item;
		ImageView image;
		TextView name , market_price , shop_price , app_cut_price_desc;
	}
	class MyOnClickListener implements OnClickListener{
		private String url;
		
		public MyOnClickListener(String url) {
			super();
			this.url = url;
		}

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.fragment_contient_listview_item:
				Intent intent = new Intent(context,WebActivity.class);
				intent.putExtra("url", url);
				context.startActivity(intent);
				break;

			default:
				break;
			}
		}
		
	}
}	
