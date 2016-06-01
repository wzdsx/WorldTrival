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

	// ��������
	private String[] getData() {
		String[] data = { "��ʱ�յ�����ƾ֤��", "��Ҫ��ǰ������Ԥ����", "����ƾ֤��ʲô��", "�ҿ��Ե������ָ���", "��λ�ú��" };
		return data;

	}
}
