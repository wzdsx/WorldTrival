package com.worldtrival.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.fragment.worldtrival.HomeFragment.IdListener;
import com.ui.worldtrival.R;
import com.ui.worldtrival.WebActivity;
import com.worldtrival.bean.GoodList;
import com.worldtrival.bean.ListViewData;
import com.worldtrival.bean.Recommend;

public class HomeSearchAdapter extends BaseAdapter {
	private List<Recommend> list;
	private Context context;
	private LayoutInflater inflater;
	private boolean isFirst ;
	private List<Recommend> listRecommend;
	

	public HomeSearchAdapter(List<Recommend> list, Context context) {
		super();
		this.list = list;
		this.context = context;
		this.listRecommend = listRecommend;
		inflater = LayoutInflater.from(context);
		isFirst = true;
	}

	@Override
	public int getCount() {
//		Log.e("jjj", listRecommend.get(0).getGoods_id()+listRecommend.get(0).getUrl());
		/*for(int i = 0 ; i < listRecommend.size() ; i++){
			Log.e(i+"", listRecommend.get(i).getGoods_id()+listRecommend.get(i).getUrl());
		}*/
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
		if(v== null){
			holder = new ViewHolder();
			v = inflater.inflate(R.layout.home_search_item2, null, false);
			holder.item_title = (TextView) v.findViewById(R.id.home_search_item2_title);
			holder.item_text = (TextView) v.findViewById(R.id.home_search_item2_content);
			v.setTag(holder);
		}else{
			holder = (ViewHolder) v.getTag();
		}
		Recommend recommend = list.get(position);
		holder.item_title.setText("热门推荐");
		if(position == 0){
			holder.item_title.setVisibility(View.VISIBLE);
		}else{
			holder.item_title.setVisibility(View.GONE);
		}
		holder.item_text.setText(recommend.getGoods_name());
		holder.item_text.setOnClickListener(new MyOnClickListener("http://www.7zhou.com/tour-"+recommend.getGoods_id()+".html"));
//		holder.item_text.setOnClickListener(new MyOnclickListener(""));
		return v;
	}
	class ViewHolder{
		TextView item_title,item_text;
	}
	
	
	
	class MyOnClickListener implements OnClickListener{
		String url;
		
		public MyOnClickListener(String url) {
			super();
			this.url = url;
		}

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.home_search_item2_content:
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
