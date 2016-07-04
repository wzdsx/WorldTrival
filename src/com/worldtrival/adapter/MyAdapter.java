package com.worldtrival.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SearchViewCompat.OnCloseListenerCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;
import com.newgame.sdk.AndroidShare;
import com.ui.worldtrival.R;
import com.ui.worldtrival.WebActivity;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.media.QQShareContent;
import com.umeng.socialize.media.QZoneShareContent;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.sso.QZoneSsoHandler;
import com.umeng.socialize.sso.SinaSsoHandler;
import com.umeng.socialize.sso.SmsHandler;
import com.umeng.socialize.sso.TencentWBSsoHandler;
import com.umeng.socialize.sso.UMQQSsoHandler;
import com.umeng.socialize.weixin.controller.UMWXHandler;
import com.umeng.socialize.weixin.media.CircleShareContent;
import com.umeng.socialize.weixin.media.WeiXinShareContent;
import com.worldtrival.message.MessageModel;

public class MyAdapter extends BaseAdapter {
	private List<MessageModel> list;
	private LayoutInflater inflater;
	private Context context;
	final UMSocialService mController = UMServiceFactory
			.getUMSocialService("com.umeng.share");
	public MyAdapter(List<MessageModel> list, Context context) {
		super();
		this.list = list;
		this.context = context;
		// inflater = LayoutInflater.from(context);
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
	public View getView(int position, View v, ViewGroup viewgroup) {
		inflater = LayoutInflater.from(context);
		ViewHolder holder = null;
		if (v == null) {
			holder = new ViewHolder();
			v = inflater.inflate(R.layout.guide_search__item, null);

			holder.img1 = (ImageView) v.findViewById(R.id.img);
			holder.tv_head1 = (TextView) v.findViewById(R.id.tv_head);
			holder.tv_cont1 = (TextView) v.findViewById(R.id.tv_cont);
			holder.tv_time1 = (TextView) v.findViewById(R.id.tv_time);
			holder.img_share1 = (ImageView) v.findViewById(R.id.img_share);
			holder.img_share1.setAlpha(0.5f);
			v.setTag(holder);
		} else {
			holder = (ViewHolder) v.getTag();
		}

		final MessageModel model = list.get(position);
		BitmapUtils bitmap = new BitmapUtils(context);
		bitmap.display(holder.img1, model.getImg());
		holder.tv_head1.setText(model.getTv_head());
		holder.tv_cont1.setText(model.getTv_cont());
		holder.tv_time1.setText(model.getTv_time());
		holder.img_share1.setImageResource(model.getImg_share());
		holder.img1.setOnClickListener(new MyOnClickListener(model.getUrl()));
		holder.img_share1.setOnClickListener(new MyOnClickListener(model));

		return v;
	}

	private class ViewHolder {
		ImageView img1, img_share1;
		TextView tv_head1, tv_cont1, tv_time1;
	}
	class MyOnClickListener implements OnClickListener{
		private String url;
		private MessageModel model;
		
		public MyOnClickListener(MessageModel model) {
			super();
			this.model = model;
		}

		public MyOnClickListener(String url) {
			super();
			this.url = url;
		}
		
		public MyOnClickListener() {
			super();
		}

		@Override
		public void onClick(View v) {
		switch (v.getId()) {
		case R.id.img:
			Intent intent = new Intent(context, WebActivity.class);
			intent.putExtra("url", url);
			context.startActivity(intent);
			break;
		case R.id.img_share:
			init(model);
			mController.getConfig().removePlatform(SHARE_MEDIA.RENREN,
					SHARE_MEDIA.FACEBOOK);
			//默认分享方式
			mController.openShare((Activity)context, false);
			
			break;
	
		
		}	
		
		}
		
	} 
	public void init(MessageModel model) {// 设置分享内容
		mController
		.setShareContent(model.getTv_cont());
// 设置分享图片, 参数2为图片的url地址
mController.setShareMedia(new UMImage(context, R.drawable.shar_img));
//--------------------------------------------------------------------------------------------------------
// 参数1为当前Activity，参数2为开发者在QQ互联申请的APP ID，参数3为开发者在QQ互联申请的APP kEY.（自己申请）
UMQQSsoHandler qqSsoHandler = new UMQQSsoHandler((Activity)context, "1105426435","LPqAnPaACpHL5CtJ");
qqSsoHandler.addToSocialSDK();
QQShareContent qqShareContent = new QQShareContent();
// 设置分享文字
qqShareContent.setShareContent(model.getTv_cont());
// 设置分享title
qqShareContent.setTitle("环球自由行");
// 设置分享图片
qqShareContent.setShareImage(new UMImage(context, model.getImg()));
// 设置点击分享内容的跳转链接
qqShareContent.setTargetUrl(model.getUrl());
mController.setShareMedia(qqShareContent);
//--------------------------------------------------------------------------------------------------------
// 参数1为当前Activity，参数2为开发者在QQ互联申请的APP ID，参数3为开发者在QQ互联申请的APP kEY.（自己申请）
QZoneSsoHandler qZoneSsoHandler = new QZoneSsoHandler((Activity)context,"1105426435", "LPqAnPaACpHL5CtJ");
qZoneSsoHandler.addToSocialSDK();
QZoneShareContent qzone = new QZoneShareContent();
// 设置分享文字
qzone.setShareContent(model.getTv_cont());
// 设置点击消息的跳转URL
qzone.setTargetUrl(model.getUrl());
// 设置分享内容的标题
qzone.setTitle("环球自由行");
// 设置分享图片
qzone.setShareImage(new UMImage(context,model.getImg()));
mController.setShareMedia(qzone);
//--------------------------------------------------------------------------------------------------------
// 设置腾讯微博SSO handler
mController.getConfig().setSsoHandler(new TencentWBSsoHandler());
//--------------------------------------------------------------------------------------------------------
// 设置新浪SSO handler
//SinaSsoHandler sinaSsoHandler = new SinaSsoHdanler(context,"","");
//sinaSsoHandler.addToSocialSDK();

mController.getConfig().setSsoHandler(new SinaSsoHandler());

//--------------------------------------------------------------------------------------------------------
// 添加微信的appID appSecret要自己申请
String appID = "wxcfe11bd55e6f8a24";
String appSecret = "4bb96adedd5dac97027da5d9ed508350";
// 添加微信平台
UMWXHandler wxHandler = new UMWXHandler((Activity)context,appID,appSecret);
wxHandler.addToSocialSDK();
// 设置微信好友分享内容
WeiXinShareContent weixinContent = new WeiXinShareContent();

// 设置分享文字
weixinContent.setShareContent(model.getTv_cont());
// 设置title
weixinContent.setTitle("环球自由行");
// 设置分享内容跳转URL
weixinContent.setTargetUrl(model.getUrl());
// 设置分享图片
weixinContent.setShareImage(new UMImage(context,
		model.getImg()));
mController.setShareMedia(weixinContent);
//--------------------------------------------------------------------------------------------------------
// 添加微信朋友圈(自会显示title，不会显示内容，官网这样说的)
UMWXHandler wxCircleHandler = new UMWXHandler((Activity)context,appID,appSecret);
// 设置微信朋友圈分享内容
CircleShareContent circleMedia = new CircleShareContent();
circleMedia.setShareContent(model.getTv_cont());
// 设置朋友圈title
circleMedia.setTitle("环球自由行");
circleMedia.setShareImage(new UMImage(context,model.getImg()));
circleMedia.setTargetUrl(model.getUrl());
mController.setShareMedia(circleMedia);
wxCircleHandler.setToCircle(true);
wxCircleHandler.addToSocialSDK();
//--------------------------------------------------------------------------------------------------------		
// 添加短信
SmsHandler smsHandler = new SmsHandler();
smsHandler.addToSocialSDK();
//--------------------------------------------------------------------------------------------------------
//btn = (Button) findViewById(R.id.img_share);
//btn.setOnClickListener(this);
		// TODO Auto-generated method stub
		
	}
}
