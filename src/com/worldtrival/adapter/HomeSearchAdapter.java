package com.worldtrival.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.ui.worldtrival.R;
import com.worldtrival.bean.Recommend;

public class HomeSearchAdapter extends BaseAdapter {
	private List<Recommend> list;
	private Context context;
	private LayoutInflater inflater;
	private boolean isFirst ;
	
	
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
		
		
		holder.item_text.setText(recommend.getGoods_name());
		return v;
	}
	class ViewHolder{
		TextView item_title,item_text;
	}
}
