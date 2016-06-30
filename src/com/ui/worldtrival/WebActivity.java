package com.ui.worldtrival;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends Activity {
	private WebView wv;
	
	
		

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	    	
	        super.onCreate(savedInstanceState);
	        Intent intent = getIntent();
	         String url = intent.getStringExtra("url");
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.webview);
	        
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


	}


