package com.ui.worldtrival;




import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class WebActivity extends Activity implements OnClickListener{
	private WebView wv;
	private ImageView img_back;
	
		

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        Intent intent = getIntent();
	         String url = intent.getStringExtra("url");
	        setContentView(R.layout.webview);
	        img_back =(ImageView) findViewById(R.id.wv_back_img);
			img_back.setOnClickListener(this);
	        
	        initview();
	        wv.getSettings().setJavaScriptEnabled(true);
	        wv.getSettings().setDisplayZoomControls(false);
	        

	        wv.loadUrl(url);
	        
	        
	        wv.setWebViewClient(new WebViewClient(){
	        	@Override
				public void onPageStarted(WebView view, String url, Bitmap favicon) {
					// TODO Auto-generated method stub
					super.onPageStarted(view, url, favicon);
				}
	        	

				@Override
				public void onPageFinished(WebView view, String url) {
					// TODO Auto-generated method stub
					super.onPageFinished(view, url);
				}


				@Override
				public boolean shouldOverrideUrlLoading(WebView view, String url) {
					view.loadUrl(url);
					return true;
				}
	        });
	        wv.setWebChromeClient(new WebChromeClient());
	        
	    }


	    private void initview() {
			wv = (WebView) findViewById(R.id.webview);
		}


		@Override
		public boolean onKeyDown(int keyCode, KeyEvent event) {
			if (keyCode ==KeyEvent.KEYCODE_BACK) {
				boolean isback = wv.canGoBack();
				if (isback) 
					wv.goBack();
				else
					finish();
					return true;
				}
			
			
			return super.onKeyDown(keyCode, event);
		}


		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.wv_back_img:
				finish();
				break;
			}
		}


	}


