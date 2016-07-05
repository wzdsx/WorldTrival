package com.worldtrival.consult;


import java.util.ArrayList;
import java.util.List;

import com.ui.worldtrival.R;
import com.worldtrival.adapter.SimpleTreeListViewAdapter;
import com.worldtrival.adapter.TreeListViewAdapter.OnTreeNodeClickListener;
import com.worldtrival.bean.FileBean;
import com.worldtrival.bean.OrgBean;
import com.worldtrival.utils.Node;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Consult_Center extends Activity {
	private ListView mTree;
	private SimpleTreeListViewAdapter<OrgBean> mAdapter;
	private List<FileBean> mDatas;
	private List<OrgBean> mDatas2;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.consult_more_center);

		mTree = (ListView) findViewById(R.id.id_listview);

		initDatas();
		try
		{
			mAdapter = new SimpleTreeListViewAdapter<OrgBean>(mTree, this,
					mDatas2, 0);
			mTree.setAdapter(mAdapter);
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}

		initEvent();
	}
	//点击跳转问题页面
	private void initEvent()
	{
		mAdapter.setOnTreeNodeClickListener(new OnTreeNodeClickListener()
		{
			@Override
			public void onClick(Node node, int position)
			{
				switch (node.getId()) {
				case 5:
					Intent intent1 = new Intent(Consult_Center.this, Consult_Question.class);
					intent1.putExtra("text", 1);
					startActivityForResult(intent1, 1);
					break;
				case 6:
					Intent intent2 = new Intent(Consult_Center.this, Consult_Question.class);
					intent2.putExtra("text", 2);
					startActivityForResult(intent2, 2);
					break;
				case 7:
					Intent intent3 = new Intent(Consult_Center.this, Consult_Question.class);
					intent3.putExtra("text", 3);
					startActivityForResult(intent3, 3);
					break;
				case 8:
					Intent intent4 = new Intent(Consult_Center.this, Consult_Question.class);
					intent4.putExtra("text", 4);
					startActivityForResult(intent4, 4);
					break;
				case 9:
					Intent intent5 = new Intent(Consult_Center.this, Consult_Question.class);
					intent5.putExtra("text", 5);
					startActivityForResult(intent5, 5);
					break;
				case 10:
					Intent intent6 = new Intent(Consult_Center.this, Consult_Question.class);
					intent6.putExtra("text", 6);
					startActivityForResult(intent6, 6);
					break;
				case 11:
					Intent intent7 = new Intent(Consult_Center.this, Consult_Question.class);
					intent7.putExtra("text", 7);
					startActivityForResult(intent7, 7);
					break;
				case 12:
					Intent intent8 = new Intent(Consult_Center.this, Consult_Question.class);
					intent8.putExtra("text", 8);
					startActivityForResult(intent8, 8);
					break;
				case 13:
					Intent intent9 = new Intent(Consult_Center.this, Consult_Question.class);
					intent9.putExtra("text", 9);
					startActivityForResult(intent9, 9);
					break;
				case 14:
					Intent intent10 = new Intent(Consult_Center.this, Consult_Question.class);
					intent10.putExtra("text", 10);
					startActivityForResult(intent10, 10);
					break;
				case 15:
					Intent intent11 = new Intent(Consult_Center.this, Consult_Question.class);
					intent11.putExtra("text", 11);
					startActivityForResult(intent11, 11);
					break;
				case 16:
					Intent intent12 = new Intent(Consult_Center.this, Consult_Question.class);
					intent12.putExtra("text", 12);
					startActivityForResult(intent12, 12);
					break;
				case 17:
					Intent intent13 = new Intent(Consult_Center.this, Consult_Question.class);
					intent13.putExtra("text", 13);
					startActivityForResult(intent13, 13);
					break;
				case 18:
					Intent intent14 = new Intent(Consult_Center.this, Consult_Question.class);
					intent14.putExtra("text", 14);
					startActivityForResult(intent14, 14);
					break;
				case 19:
					Intent intent15 = new Intent(Consult_Center.this, Consult_Question.class);
					intent15.putExtra("text", 15);
					startActivityForResult(intent15, 15);
					break;
				case 20:
					Intent intent16 = new Intent(Consult_Center.this, Consult_Question.class);
					intent16.putExtra("text", 16);
					startActivityForResult(intent16, 16);
					break;
				case 21:
					Intent intent17 = new Intent(Consult_Center.this, Consult_Question.class);
					intent17.putExtra("text", 17);
					startActivityForResult(intent17, 17);
					break;
				case 22:
					Intent intent18 = new Intent(Consult_Center.this, Consult_Question.class);
					intent18.putExtra("text", 18);
					startActivityForResult(intent18, 18);
					break;
				case 23:
					Intent intent19 = new Intent(Consult_Center.this, Consult_Question.class);
					intent19.putExtra("text", 19);
					startActivityForResult(intent19, 19);
					break;
				default:
					break;
				}
			}
		});

		
	}
	//加入节点数据
	private void initDatas()
	{
		mDatas = new ArrayList<FileBean>();
		FileBean bean = new FileBean(1, 0, "出游凭证问题");
		mDatas.add(bean);
		bean = new FileBean(2, 0, "在线支付问题");
		mDatas.add(bean);
		bean = new FileBean(3, 0, "在线预约问题");
		mDatas.add(bean);
		bean = new FileBean(4, 0, "红包使用问题");
		mDatas.add(bean);
		bean = new FileBean(5, 1, this.getResources().getStringArray(R.array.question)[0]);
		mDatas.add(bean);
		bean = new FileBean(6, 1, this.getResources().getStringArray(R.array.question)[1]);
		mDatas.add(bean);
		bean = new FileBean(7, 1, this.getResources().getStringArray(R.array.question)[2]);
		mDatas.add(bean);
		bean = new FileBean(8, 1, this.getResources().getStringArray(R.array.question)[3]);
		mDatas.add(bean);
		bean = new FileBean(9, 1, this.getResources().getStringArray(R.array.question)[4]);
		mDatas.add(bean);
		bean = new FileBean(10, 1, this.getResources().getStringArray(R.array.question)[5]);
		mDatas.add(bean);
		bean = new FileBean(11, 2, this.getResources().getStringArray(R.array.question)[6]);
		mDatas.add(bean);
		bean = new FileBean(12, 2, this.getResources().getStringArray(R.array.question)[7]);
		mDatas.add(bean);
		bean = new FileBean(13, 2, this.getResources().getStringArray(R.array.question)[8]);
		mDatas.add(bean);
		bean = new FileBean(14, 3, this.getResources().getStringArray(R.array.question)[9]);
		mDatas.add(bean);
		bean = new FileBean(15, 3, this.getResources().getStringArray(R.array.question)[10]);
		mDatas.add(bean);
		bean = new FileBean(16, 3, this.getResources().getStringArray(R.array.question)[11]);
		mDatas.add(bean);
		bean = new FileBean(17, 3, this.getResources().getStringArray(R.array.question)[12]);
		mDatas.add(bean);
		bean = new FileBean(18, 3, this.getResources().getStringArray(R.array.question)[13]);
		mDatas.add(bean);
		bean = new FileBean(19, 3, this.getResources().getStringArray(R.array.question)[14]);
		mDatas.add(bean);
		bean = new FileBean(20, 3, this.getResources().getStringArray(R.array.question)[15]);
		mDatas.add(bean);
		bean = new FileBean(21, 4, this.getResources().getStringArray(R.array.question)[16]);
		mDatas.add(bean);
		bean = new FileBean(22, 4, this.getResources().getStringArray(R.array.question)[17]);
		mDatas.add(bean);
		bean = new FileBean(23, 4, this.getResources().getStringArray(R.array.question)[18]);
		mDatas.add(bean);

		// initDatas
		mDatas2 = new ArrayList<OrgBean>();
		OrgBean bean2 = new OrgBean(1, 0, "出游凭证问题");
		mDatas2.add(bean2);
		bean2 = new OrgBean(2, 0, "在线支付问题");
		mDatas2.add(bean2);
		bean2 = new OrgBean(3, 0, "在线预约问题");
		mDatas2.add(bean2);
		bean2 = new OrgBean(4, 0, "红包使用问题");
		mDatas2.add(bean2);
		bean2 = new OrgBean(5, 1, this.getResources().getStringArray(R.array.question)[0]);
		mDatas2.add(bean2);
		bean2 = new OrgBean(6, 1, this.getResources().getStringArray(R.array.question)[1]);
		mDatas2.add(bean2);
		bean2 = new OrgBean(7, 1, this.getResources().getStringArray(R.array.question)[2]);
		mDatas2.add(bean2);
		bean2 = new OrgBean(8, 1, this.getResources().getStringArray(R.array.question)[3]);
		mDatas2.add(bean2);
		bean2 = new OrgBean(9, 1, this.getResources().getStringArray(R.array.question)[4]);
		mDatas2.add(bean2);
		bean2 = new OrgBean(10, 1, this.getResources().getStringArray(R.array.question)[5]);
		mDatas2.add(bean2);
		bean2 = new OrgBean(11, 2, this.getResources().getStringArray(R.array.question)[6]);
		mDatas2.add(bean2);
		bean2 = new OrgBean(12, 2, this.getResources().getStringArray(R.array.question)[7]);
		mDatas2.add(bean2);
		bean2 = new OrgBean(13, 2, this.getResources().getStringArray(R.array.question)[8]);
		mDatas2.add(bean2);
		bean2 = new OrgBean(14, 3, this.getResources().getStringArray(R.array.question)[9]);
		mDatas2.add(bean2);
		bean2 = new OrgBean(15, 3, this.getResources().getStringArray(R.array.question)[10]);
		mDatas2.add(bean2);
		bean2 = new OrgBean(16, 3, this.getResources().getStringArray(R.array.question)[11]);
		mDatas2.add(bean2);
		bean2 = new OrgBean(17, 3, this.getResources().getStringArray(R.array.question)[12]);
		mDatas2.add(bean2);
		bean2 = new OrgBean(18, 3, this.getResources().getStringArray(R.array.question)[13]);
		mDatas2.add(bean2);
		bean2 = new OrgBean(19, 3, this.getResources().getStringArray(R.array.question)[14]);
		mDatas2.add(bean2);
		bean2 = new OrgBean(20, 3, this.getResources().getStringArray(R.array.question)[15]);
		mDatas2.add(bean2);
		bean2 = new OrgBean(21, 4, this.getResources().getStringArray(R.array.question)[16]);
		mDatas2.add(bean2);
		bean2 = new OrgBean(22, 4, this.getResources().getStringArray(R.array.question)[17]);
		mDatas2.add(bean2);
		bean2 = new OrgBean(23, 4, this.getResources().getStringArray(R.array.question)[18]);
		mDatas2.add(bean2);

	}

}
