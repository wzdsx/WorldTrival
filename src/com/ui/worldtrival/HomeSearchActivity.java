package com.ui.worldtrival;

import com.worldtrival.HomeFragment.FragmentContinent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeSearchActivity extends FragmentActivity {
	private LinearLayout linear;
	private TextView contient;
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		Intent intent = getIntent();
		String url_path = intent.getStringExtra("url_path");
		String url_param1 = intent.getStringExtra("url_param1");
		String url_param2 = intent.getStringExtra("url_param2");
		String adress = intent.getStringExtra("adress");
		setContentView(R.layout.fragmeng_continent);
		initView();
		contient.setText(adress);
//		Log.e("from", url_param1+1+url_param2);
		FragmentContinent fragment = new FragmentContinent();
		Bundle bundle = new Bundle();
		bundle.putString("url_path",url_path);
		bundle.putString("url_param1",url_param1 );
		bundle.putString("url_param2", url_param2);
		fragment.setArguments(bundle);
		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction transaction =  manager.beginTransaction();
//		transaction.add(R.id.fragment_contient, fragment);
		transaction.add(R.id.fragment_contient, fragment, "HomeSearchFragment");
		transaction.commit();
	}

	private void initView() {
		contient = (TextView) findViewById(R.id.fragment_continent_adress);
	}
}
