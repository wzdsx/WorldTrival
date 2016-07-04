package com.worldtrival.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;

import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;
import com.ui.worldtrival.R;
import com.ui.worldtrival.WebActivity;
import com.worldtrival.base.BaseHomeMessage;
import com.worldtrival.base.Url;
import com.worldtrival.bean.GoodList;
import com.worldtrival.bean.ListViewData;

import com.worldtrival.message.HomeMessageContent;
import com.worldtrival.message.HomeMessageLocation;
import com.worldtrival.message.HomeMessageSearch;
import com.worldtrival.message.HomeMessageZhou;

public class HomeAdapter extends BaseAdapter {
	private Context context;
	private List<BaseHomeMessage> list;
	private LayoutInflater mInflater;

	private ViewPager pager = null;

	public HomeAdapter(Context context, List<BaseHomeMessage> list) {
		super();
		this.context = context;
		this.list = list;

		mInflater = LayoutInflater.from(context);
	}

	// 2016_6_8
	public ViewPager getPager() {
		return pager;
	}

	public void setPager(ViewPager pager) {
		this.pager = pager;
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

		switch (type) {
		case 0:
			// 第二种类型
			ViewHolder2 holder2 = null;
			if (convertView == null) {
				// 无缓存TI
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
			} else {

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
			// 第三种类型
			ViewHolder3 holder3 = null;
			if (convertView == null) {
				// 无缓存
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
			} else {
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

			// 第四种类型
			ViewHolder4 holder4 = null;
			if (convertView == null) {
				// 无缓存
				holder4 = new ViewHolder4();
				viewItem4 = mInflater.inflate(R.layout.guide_home_search, null, false);
				holder4.image = (ImageView) viewItem4.findViewById(R.id.home_search_right);
				holder4.text1 = (TextView) viewItem4.findViewById(R.id.home_search_left_guide);
				holder4.text2 = (TextView) viewItem4.findViewById(R.id.home_search_left_content1);
				holder4.text3 = (TextView) viewItem4.findViewById(R.id.home_search_left_content2);
				holder4.view = viewItem4.findViewById(R.id.home_search_link);
				viewItem4.setTag(holder4);
				convertView = viewItem4;
			} else {
				holder4 = (ViewHolder4) convertView.getTag();
			}

			HomeMessageSearch search = (HomeMessageSearch) list.get(position);
			if (!search.isFlag()) {
				holder4.view.setVisibility(View.INVISIBLE);
			} else {
				holder4.view.setVisibility(View.VISIBLE);
			}

			holder4.image.setImageResource(search.getImage());
			holder4.text1.setText(search.getText1());
			holder4.text2.setText(search.getText2());
			holder4.text3.setText(search.getText3());
			break;
		case 3:

			// 第五种情况
			ViewHolder5 holder5 = null;
			if (convertView == null) {
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
				holder5.text4 = (TextView) viewItem5.findViewById(R.id.guide_home_content1_text1);
				holder5.text5 = (TextView) viewItem5.findViewById(R.id.guide_home_content1_text2);
				holder5.text6 = (TextView) viewItem5.findViewById(R.id.guide_home_content2_text1);
				holder5.text7 = (TextView) viewItem5.findViewById(R.id.guide_home_content2_text2);
				holder5.text8 = (TextView) viewItem5.findViewById(R.id.guide_home_content2_text3);
				holder5.text9 = (TextView) viewItem5.findViewById(R.id.guide_home_content3_text1);
				holder5.text10 = (TextView) viewItem5.findViewById(R.id.guide_home_content3_text2);
				holder5.text11 = (TextView) viewItem5.findViewById(R.id.guide_home_content3_text3);
				holder5.text4.getBackground().setAlpha(80);
				holder5.text5.getBackground().setAlpha(80);
				holder5.text6.getBackground().setAlpha(80);
				holder5.text7.getBackground().setAlpha(80);
				holder5.text8.getBackground().setAlpha(80);
				holder5.text9.getBackground().setAlpha(80);
				holder5.text10.getBackground().setAlpha(80);
				holder5.text11.getBackground().setAlpha(80);

				viewItem5.setTag(holder5);
				convertView = viewItem5;
			} else {
				holder5 = (ViewHolder5) convertView.getTag();
			}
			HomeMessageContent content = (HomeMessageContent) list.get(position);
			Url url = content.getUrl();
			BitmapUtils bitmap = new BitmapUtils(context);
			bitmap.display(holder5.image1, content.getImage1());
			bitmap.display(holder5.image2, content.getImage2());
			bitmap.display(holder5.image3, content.getImage3());
			bitmap.display(holder5.image4, content.getImage4());
			bitmap.display(holder5.image5, content.getImage5());
			bitmap.display(holder5.image6, content.getImage6());
			bitmap.display(holder5.image7, content.getImage7());
			bitmap.display(holder5.image8, content.getImage8());
			if (content.getText1().equals("玩转七洲")) {
				holder5.text1.setVisibility(View.VISIBLE);
				holder5.text1.setText(content.getText1());
			} else {
				holder5.text1.setVisibility(View.GONE);
			}
			holder5.text2.setText(content.getText2());
			holder5.text3.setText(content.getText3());
			holder5.text4.setText(content.getText4());
			holder5.text5.setText(content.getText5());
			holder5.text6.setText(content.getText6());
			holder5.text7.setText(content.getText7());
			holder5.text8.setText(content.getText8());
			holder5.text9.setText(content.getText9());
			holder5.text10.setText(content.getText10());
			holder5.text11.setText(content.getText11());
			holder5.image1.setOnClickListener(new MyClick(url));
			holder5.image2.setOnClickListener(new MyClick(url));
			holder5.image3.setOnClickListener(new MyClick(url));
			holder5.image4.setOnClickListener(new MyClick(url));
			holder5.image5.setOnClickListener(new MyClick(url));
			holder5.image6.setOnClickListener(new MyClick(url));
			holder5.image7.setOnClickListener(new MyClick(url));
			holder5.image8.setOnClickListener(new MyClick(url));

			break;
		}
		return convertView;
	}

	class ViewHolder1 {

		ImageView image1, image2, image3, image4, image5;
	}

	class ViewHolder2 {
		ImageView image1, image2, image3, image4, image5, image6, image7;
		TextView text1, text2, text3, text4, text5, text6, text7;
	}

	class ViewHolder3 {
		ImageView image1, image2, image3, image4;
		TextView text1, text2, text3, text4;
	}

	class ViewHolder4 {
		ImageView image;
		TextView text1, text2, text3;
		View view;
	}

	class ViewHolder5 {
		TextView text1, text2, text3;
		ImageView image1, image2, image3, image4, image5, image6, image7, image8;
		TextView text4, text5, text6, text7, text8, text9, text10, text11;
	}

	class MyClick implements OnClickListener {
		private Url url;

		MyClick(Url url) {
			this.url = url;
		}

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(context, WebActivity.class);
			switch (v.getId()) {
			case R.id.guide_home_content1_image1:
				intent.putExtra("url", url.getImage1());
				// Log.e("first", url.getImage1());
				break;
			case R.id.guide_home_content1_image2:
				intent.putExtra("url", url.getImage2());
				break;
			case R.id.guide_home_content2_image1:
				intent.putExtra("url", url.getImage3());
				break;
			case R.id.guide_home_content2_image2:
				intent.putExtra("url", url.getImage4());
				break;
			case R.id.guide_home_content2_image3:
				intent.putExtra("url", url.getImage5());
				break;
			case R.id.guide_home_content3_image1:
				intent.putExtra("url", url.getImage6());
				break;
			case R.id.guide_home_content3_image2:
				intent.putExtra("url", url.getImage7());
				break;
			case R.id.guide_home_content3_image3:
				intent.putExtra("url", url.getImage8());
				break;
			}
			context.startActivity(intent);

		}

	}
}
