package com.fragment.worldtrival;

import com.ui.worldtrival.R;
import com.worldtrival.consult.Consult_Center;
import com.worldtrival.consult.Consult_Online;
import com.worldtrival.consult.Consult_Question;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * Fragment咨询主页面
 * @author Administrator
 *
 */
public class ConsultFragment extends Fragment implements OnClickListener {
	private View view;
	private ImageView mOnlineCon;
	private ImageView mPhoneCon;
	private ImageView mOverseasCon;
	private TextView mMore;
	private TextView mQuestitm_00;
	private TextView mQuestitm_01;
	private TextView mQuestitm_02;
	private TextView mQuestitm_03;
	private TextView mQuestitm_04;
	private TextView mtop_text;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.tabs_fragment_consult, container, false);
		initView();
		initEvent();
		return view;
	}

	private void initEvent() {
		mOnlineCon.setOnClickListener(this);
		mPhoneCon.setOnClickListener(this);
		mOverseasCon.setOnClickListener(this);
		mMore.setOnClickListener(this);
		mQuestitm_00.setOnClickListener(this);
		mQuestitm_01.setOnClickListener(this);
		mQuestitm_02.setOnClickListener(this);
		mQuestitm_03.setOnClickListener(this);
		mQuestitm_04.setOnClickListener(this);

	}

	// 初始化控件
	private void initView() {
		mOnlineCon = (ImageView) view.findViewById(R.id.mContact1);
		mPhoneCon = (ImageView) view.findViewById(R.id.mContact2);
		mOverseasCon = (ImageView) view.findViewById(R.id.mContact3);
		mMore = (TextView) view.findViewById(R.id.consult_more);
		mQuestitm_00 = (TextView) view.findViewById(R.id.consult_text1);
		mQuestitm_01 = (TextView) view.findViewById(R.id.consult_text2);
		mQuestitm_02 = (TextView) view.findViewById(R.id.consult_text3);
		mQuestitm_03 = (TextView) view.findViewById(R.id.consult_text4);
		mQuestitm_04 = (TextView) view.findViewById(R.id.consult_text5);
		mtop_text = (TextView) view.findViewById(R.id.top_text);
		mtop_text.setText("咨询");
	}

	// 点击事件
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.mContact1:
			Intent int_Online = new Intent(this.getActivity(), Consult_Online.class);
			startActivity(int_Online);
			break;
		// 拨打电话咨询
		case R.id.mContact2:
			String PhoneCon = "123";
			Intent int_Phone = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + PhoneCon));
			startActivity(int_Phone);
			break;
		// 拨打境外咨询
		case R.id.mContact3:
			String OverseasCon = "456";
			Intent int_Overseas = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + OverseasCon));
			startActivity(int_Overseas);
			break;
		case R.id.consult_more:
			Intent int_more = new Intent(this.getActivity(), Consult_Center.class);
			startActivity(int_more);
			break;
		case R.id.consult_text1:
			Intent intent1 = new Intent(this.getActivity(), Consult_Question.class);
			intent1.putExtra("text", 1);
			startActivityForResult(intent1, 1);
			break;
		case R.id.consult_text2:
			Intent intent2 = new Intent(this.getActivity(), Consult_Question.class);
			intent2.putExtra("text", 10);
			startActivityForResult(intent2, 10);
			break;

		case R.id.consult_text3:
			Intent intent3 = new Intent(this.getActivity(), Consult_Question.class);
			intent3.putExtra("text", 3);
			startActivityForResult(intent3, 3);
			break;

		case R.id.consult_text4:
			Intent intent4 = new Intent(this.getActivity(), Consult_Question.class);
			intent4.putExtra("text", 9);
			startActivityForResult(intent4, 9);
			break;

		case R.id.consult_text5:
			Intent intent5 = new Intent(this.getActivity(), Consult_Question.class);
			intent5.putExtra("text", 17);
			startActivityForResult(intent5, 17);
			break;

		default:
			break;
		}

	}

}
