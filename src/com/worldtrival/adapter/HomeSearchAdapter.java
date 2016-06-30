package com.worldtrival.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
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

public class HomeSearchAdapter extends BaseAdapter implements IdListener{
	private List<Recommend> list;
	private Context context;
	private LayoutInflater inflater;
	private boolean isFirst ;
	private List<ListViewData> listHomeHot;
	
	

	public HomeSearchAdapter(List<Recommend> list, Context context) {
		super();
		this.list = list;
		this.context = context;
		inflater = LayoutInflater.from(context);
		isFirst = true;
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
		/*int li = listHomeHot.size();
		for(int i = 0 ; i < li ; i ++){
			ArrayList<GoodList> data = listHomeHot.get(i).getList();
			for(int j = 0 ; j < data.size() ; i ++){
				if(data.get(j).getId()==recommend.getGoods_id()){
					holder.item_text.setOnClickListener(new MyOnclickListener(data.get(j).getUrl()));
				}
			}
		}*/
		
		/*if(listHomeHot.get(position).getGoods_id()==recommend.getGoods_id()){
			
		}*/
		holder.item_text.setText(recommend.getGoods_name());
		return v;
	}
	class ViewHolder{
		TextView item_title,item_text;
	}
	
	class MyOnclickListener implements OnClickListener{
		String url;
		
		public MyOnclickListener(String url) {
			super();
			this.url = url;
		}

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.home_search_item2_content:
				Intent intent = new Intent(context,WebActivity.class);
				intent.putExtra("url", url);
				context.startActivity(intent);
				break;

			default:
				break;
			}
		}
		
	}

	@Override
	public void getListRecommend(List<ListViewData> list) {
		listHomeHot = list;
	}
	class MyIdClickListener implements OnClickListener{
		String url;
		
		public MyIdClickListener(String url) {
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
