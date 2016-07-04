package com.ui.worldtrival;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView image;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initView();
		
		handler.sendEmptyMessageDelayed(1, 1000);
	}

	private void initView() {
		image = (ImageView) findViewById(R.id.image_main);
	}

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch(msg.what){
			case 1:
				image.setImageResource(R.drawable.start_page2);
				handler.sendEmptyMessageDelayed(2, 1000);
				
				break;
			case 2 :
				
				startActivity(new Intent(MainActivity.this,World_MainActivity.class ));
				finish();
				break;
			}
		};
	};
}
