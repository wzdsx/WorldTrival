package com.worldtrival.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ui.worldtrival.R;
import com.worldtrival.base.BaseHomeMessage;
import com.worldtrival.message.HomeMessageContent;
import com.worldtrival.message.HomeMessageLocation;
import com.worldtrival.message.HomeMessageSearch;
import com.worldtrival.message.HomeMessageZhou;

public class HomeAdapter extends BaseAdapter {
	private Context context;
	private List<BaseHomeMessage> list;
	private LayoutInflater mInflater;
	
	public HomeAdapter(Context context, List<BaseHomeMessage> list) {
		super();
		this.context = context;
		this.list = list;
		mInflater = LayoutInflater.from(context);
	}
	
	
	@Override
	public int getItemViewType(int position) {
		return list.get(position).getType();
	}


	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 4;
	}


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list == null ? 0 : list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list == null ? null : list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return list == null ? 0 : position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View viewItem2 = null;
		View viewItem3 = null;
		View viewItem4 = null;
		View viewItem5 = null;
		int type = getItemViewType(position);
		switch(type){
		case 0:
			//第二种类型
			ViewHolder2 holder2 = null;
			if(convertView == null){
				//无缓存
				holder2 = new ViewHolder2();
				viewItem2 = mInflater.inflate(R.layout.guide_home_zhou, null, false);
				holder2.image1 = (ImageView) viewItem2.findViewById(R.id.world_Asia_image);
				holder2.image2 = (ImageView) viewItem2.findViewById(R.id.world_Europe_image);
				holder2.image3 = (ImageView) viewItem2.findViewById(R.id.world_Oceania_image);
				holder2.image4 = (ImageView) viewItem2.findViewById(R.id.world_Africa_image);
				holder2.image5 = (ImageView) viewItem2.findViewById(R.id.world_EastAmer_image);
				holder2.image6 = (ImageView) viewItem2.findViewById(R.id.world_NorAmer_image);
				holder2.image7 = (ImageView) viewItem2.findViewById(R.id.world_Antrac_image);
				holder2.text1 = (TextView) viewItem2.findViewById(R.id.world_Asia_text);
				holder2.text2 = (TextView) viewItem2.findViewById(R.id.world_Europe_text);
				holder2.text3 = (TextView) viewItem2.findViewById(R.id.world_Oceania_text);
				holder2.text4 = (TextView) viewItem2.findViewById(R.id.world_Africa_text);
				holder2.text5 = (TextView) viewItem2.findViewById(R.id.world_EastAmer_text);
				holder2.text6 = (TextView) viewItem2.findViewById(R.id.world_NorAmer_text);
				holder2.text7 = (TextView) viewItem2.findViewById(R.id.world_Antrac_text);
				viewItem2.setTag(holder2);
				convertView = viewItem2;
			}else{
				holder2 = (ViewHolder2) convertView.getTag();
			}
			HomeMessageZhou zhou = (HomeMessageZhou) list.get(position);
			holder2.image1.setImageResource(zhou.getImage1());
			holder2.image2.setImageResource(zhou.getImage2());
			holder2.image3.setImageResource(zhou.getImage3());
			holder2.image4.setImageResource(zhou.getImage4());
			holder2.image5.setImageResource(zhou.getImage5());
			holder2.image6.setImageResource(zhou.getImage6());
			holder2.image7.setImageResource(zhou.getImage7());
			holder2.text1.setText(zhou.getText1());
			holder2.text2.setText(zhou.getText2());
			holder2.text3.setText(zhou.getText3());
			holder2.text4.setText(zhou.getText4());
			holder2.text5.setText(zhou.getText5());
			holder2.text6.setText(zhou.getText6());
			holder2.text7.setText(zhou.getText7());
			break;
		case 1:
			//第三种类型
			ViewHolder3 holder3 = null;
			if(convertView == null){
				//无缓存
				holder3 = new ViewHolder3();
				viewItem3 = mInflater.inflate(R.layout.guide_home_location, null, false);
				holder3.image1 = (ImageView) viewItem3.findViewById(R.id.location_location_image);
				holder3.image2 = (ImageView) viewItem3.findViewById(R.id.location_airport_image);
				holder3.image3 = (ImageView) viewItem3.findViewById(R.id.location_hotel_image);
				holder3.image4 = (ImageView) viewItem3.findViewById(R.id.location_friend_image);
				holder3.text1 = (TextView) viewItem3.findViewById(R.id.location_location_text);
				holder3.text2 = (TextView) viewItem3.findViewById(R.id.location_airport_text);
				holder3.text3 = (TextView) viewItem3.findViewById(R.id.location_hotel_text);
				holder3.text4 = (TextView) viewItem3.findViewById(R.id.location_friend_text);
				viewItem3.setTag(holder3);
				convertView = viewItem3;
			}else{
				holder3 = (ViewHolder3) convertView.getTag();
			}
			HomeMessageLocation location = (HomeMessageLocation) list.get(position);
			holder3.image1.setImageResource(location.getImage1());
			holder3.image2.setImageResource(location.getImage2());
			holder3.image3.setImageResource(location.getImage3());
			holder3.image4.setImageResource(location.getImage4());
			holder3.text1.setText(location.getText1());
			holder3.text2.setText(location.getText2());
			holder3.text3.setText(location.getText3());
			holder3.text4.setText(location.getText4());
			break;
		case 2:
			//第四种类型
			ViewHolder4 holder4 = null;
			if(convertView == null){
				//无缓存
				holder4 = new ViewHolder4();
				viewItem4 = mInflater.inflate(R.layout.guide_home_search, null, false);
				holder4.image = (ImageView) viewItem4.findViewById(R.id.home_search_right);
				holder4.text1 = (TextView) viewItem4.findViewById(R.id.home_search_left_guide);
				holder4.text2 = (TextView) viewItem4.findViewById(R.id.home_search_left_content1);
				holder4.text3 = (TextView) viewItem4.findViewById(R.id.home_search_left_content2);
				viewItem4.setTag(holder4);
				convertView = viewItem4;
			}else{
				holder4 = (ViewHolder4) convertView.getTag();
			}
			HomeMessageSearch search = (HomeMessageSearch) list.get(position);
			holder4.image.setImageResource(search.getImage());
			holder4.text1.setText(search.getText1());
			holder4.text2.setText(search.getText2());
			holder4.text3.setText(search.getText3());
			break;
		case 3:
			//第五种情况
			ViewHolder5 holder5 = null;
			if(convertView == null){
				holder5 = new ViewHolder5();
				viewItem5 = mInflater.inflate(R.layout.guide_home_content, null, false);
				holder5.image1 = (ImageView) viewItem5.findViewById(R.id.guide_home_content1_image1);
				holder5.image2 = (ImageView) viewItem5.findViewById(R.id.guide_home_content1_image2);
				holder5.image3 = (ImageView) viewItem5.findViewById(R.id.guide_home_content2_image1);
				holder5.image4 = (ImageView) viewItem5.findViewById(R.id.guide_home_content2_image2);
				holder5.image5 = (ImageView) viewItem5.findViewById(R.id.guide_home_content2_image3);
				holder5.image6 = (ImageView) viewItem5.findViewById(R.id.guide_home_content3_image1);
				holder5.image7 = (ImageView) viewItem5.findViewById(R.id.guide_home_content3_image2);
				holder5.image8 = (ImageView) viewItem5.findViewById(R.id.guide_home_content3_image3);
				holder5.text1 = (TextView) viewItem5.findViewById(R.id.guide_home_title);
				holder5.text2 = (TextView) viewItem5.findViewById(R.id.guide_home_guide_color);
				holder5.text3 = (TextView) viewItem5.findViewById(R.id.guide_home_guide_normal);
				viewItem5.setTag(holder5);
				convertView = viewItem5;
			}else{
				holder5 = (ViewHolder5) convertView.getTag();
			}
			HomeMessageContent content = (HomeMessageContent) list.get(position);
			holder5.image1.setImageResource(content.getImage1());
			holder5.image2.setImageResource(content.getImage2());
			holder5.image3.setImageResource(content.getImage3());
			holder5.image4.setImageResource(content.getImage4());
			holder5.image5.setImageResource(content.getImage5());
			holder5.image6.setImageResource(content.getImage6());
			holder5.image7.setImageResource(content.getImage7());
			holder5.image8.setImageResource(content.getImage8());
			holder5.text1.setText(content.getText1());
			holder5.text2.setText(content.getText2());
			holder5.text3.setText(content.getText3());
			break;
		}
		return convertView;
	}
	class ViewHolder1{
		
	}
	class ViewHolder2{
		ImageView image1,image2,image3,image4,image5,image6,image7;
		TextView text1,text2,text3,text4,text5,text6,text7;
	}
	class ViewHolder3{
		ImageView image1,image2,image3,image4;
		TextView text1,text2,text3,text4;
	}
	class ViewHolder4{
		ImageView image;
		TextView text1,text2,text3;
	}
	class ViewHolder5{
		TextView text1,text2,text3;
		ImageView image1,image2,image3,image4,image5,image6,image7,image8;
	}
}
