package com.worldtrival.adapter;

import java.util.List;

import com.lidroid.xutils.BitmapUtils;
import com.ui.worldtrival.R;
import com.ui.worldtrival.WebActivity;
import com.worldtrival.bean.LocalGoodsBranch;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LocalGoodsAdapter extends BaseAdapter {
	private List<LocalGoodsBranch> list;
	private Context context;
	private LayoutInflater inflater;
	
	
	
	

	public LocalGoodsAdapter(Context context) {
		super();
		this.context = context;
		inflater = LayoutInflater.from(context);
	}

	public LocalGoodsAdapter(List<LocalGoodsBranch> list, Context context) {
		super();
		this.list = list;
		this.context = context;
		inflater = LayoutInflater.from(context);
	}
	
	public void setData(List<LocalGoodsBranch> data){
		this.list = data;
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View v, ViewGroup parent) {
		ViewHolder holder = null;
		if (v == null) {
			holder = new ViewHolder();
			// 加载布局
			v = inflater.inflate(com.ui.worldtrival.R.layout.local_goods_list, null);
			// 适配数据

			holder.tv_localGoods1 = (TextView) v.findViewById(com.ui.worldtrival.R.id.tv_localGoods1);
			holder.tv_localGoods2 = (TextView) v.findViewById(com.ui.worldtrival.R.id.tv_localGoods2);
			holder.tv_localGoods3 = (TextView) v.findViewById(com.ui.worldtrival.R.id.tv_localGoods3);
			holder.linear = (LinearLayout) v.findViewById(R.id.local_goods_list);
			holder.imageView_localGoods = (ImageView) v.findViewById(com.ui.worldtrival.R.id.imageView_localGoods);
			

			v.setTag(holder);
		} else {
			holder = (ViewHolder) v.getTag();
		}

		// 设置数据
		LocalGoodsBranch lgb = list.get(position);
		holder.tv_localGoods1.setText(lgb.getName());
		holder.tv_localGoods2.setText(lgb.getShop_price() + "起");
		holder.tv_localGoods3.setText(lgb.getMarcket_price());
		
		// 用Bitmap设置图片
		BitmapUtils bitmap = new BitmapUtils(context);
		bitmap.display(holder.imageView_localGoods, lgb.getImg());
		holder.linear.setOnClickListener(new MyOnClickListener("http://www.7zhou.com/tour-"+lgb.getGoods_id()+".html"));
		
		
		
		
		
		
		return v;
	}
	
	private class ViewHolder {
		TextView tv_localGoods1, tv_localGoods2, tv_localGoods3;
		ImageView imageView_localGoods;
		LinearLayout linear;
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
			case R.id.local_goods_list:
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
