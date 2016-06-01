package com.ui.worldtrival;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Fragment_consult extends FragmentActivity {
	private ListView mlistConsult;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.tabs_fragment_consult);
		initListView();
	}
	


	private void initListView() {
		mlistConsult = (ListView) findViewById(R.id.listView_consult);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.tabs_fragment_consult_fag_item,
				R.id.mTitle, getData());
		mlistConsult.setAdapter(adapter);

	}

	// 创建数据
	private String[] getData() {
		String[] data = { "何时收到出游凭证？", "需要提前多少天预订？", "出游凭证是什么？", "我可以到当地现付吗？", "如何获得红包" };
		return data;

	}
}
