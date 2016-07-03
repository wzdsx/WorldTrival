package com.worldtrival.consult;

import com.ui.worldtrival.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;

public class Consult_Question extends Activity {
	private TextView mTitle;
	private TextView mContent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.consult_question);
		initView();
		receive();
	}
	private void receive() {
		Intent intent = getIntent();
		int i = intent.getExtras().getInt("text");
		switch (i) {
		case 1:
			mTitle.setText(this.getResources().getStringArray(R.array.question)[0]);
			mContent.setText(this.getResources().getStringArray(R.array.answer)[0]);
			break;
		case 2:
			mTitle.setText(this.getResources().getStringArray(R.array.question)[1]);
			mContent.setText(this.getResources().getStringArray(R.array.answer)[1]);
			break;
		case 3:
			mTitle.setText(this.getResources().getStringArray(R.array.question)[2]);
			mContent.setText(this.getResources().getStringArray(R.array.answer)[2]);
			break;
		case 4:
			mTitle.setText(this.getResources().getStringArray(R.array.question)[3]);
			mContent.setText(this.getResources().getStringArray(R.array.answer)[3]);
			break;
		case 5:
			mTitle.setText(this.getResources().getStringArray(R.array.question)[4]);
			mContent.setText(this.getResources().getStringArray(R.array.answer)[4]);
			break;
		case 6:
			mTitle.setText(this.getResources().getStringArray(R.array.question)[5]);
			mContent.setText(this.getResources().getStringArray(R.array.answer)[5]);
			break;
		case 7:
			mTitle.setText(this.getResources().getStringArray(R.array.question)[6]);
			mContent.setText(this.getResources().getStringArray(R.array.answer)[6]);
			break;
		case 8:
			mTitle.setText(this.getResources().getStringArray(R.array.question)[7]);
			mContent.setText(this.getResources().getStringArray(R.array.answer)[7]);
			break;
		case 9:
			mTitle.setText(this.getResources().getStringArray(R.array.question)[8]);
			mContent.setText(this.getResources().getStringArray(R.array.answer)[8]);
			break;
		case 10:
			mTitle.setText(this.getResources().getStringArray(R.array.question)[9]);
			mContent.setText(this.getResources().getStringArray(R.array.answer)[9]);
			break;
		case 11:
			mTitle.setText(this.getResources().getStringArray(R.array.question)[10]);
			mContent.setText(this.getResources().getStringArray(R.array.answer)[10]);
			break;
		case 12:
			mTitle.setText(this.getResources().getStringArray(R.array.question)[11]);
			mContent.setText(this.getResources().getStringArray(R.array.answer)[11]);
			break;
		case 13:
			mTitle.setText(this.getResources().getStringArray(R.array.question)[12]);
			mContent.setText(this.getResources().getStringArray(R.array.answer)[12]);
			break;
		case 14:
			mTitle.setText(this.getResources().getStringArray(R.array.question)[13]);
			mContent.setText(this.getResources().getStringArray(R.array.answer)[13]);
			break;
		case 15:
			mTitle.setText(this.getResources().getStringArray(R.array.question)[14]);
			mContent.setText(this.getResources().getStringArray(R.array.answer)[14]);
			break;
		case 16:
			mTitle.setText(this.getResources().getStringArray(R.array.question)[15]);
			mContent.setText(this.getResources().getStringArray(R.array.answer)[15]);	
			break;
		case 17:
			mTitle.setText(this.getResources().getStringArray(R.array.question)[16]);
			mContent.setText(this.getResources().getStringArray(R.array.answer)[16]);
			break;
		case 18:
			mTitle.setText(this.getResources().getStringArray(R.array.question)[17]);
			mContent.setText(this.getResources().getStringArray(R.array.answer)[17]);
			break;
		case 19:
			mTitle.setText(this.getResources().getStringArray(R.array.question)[18]);
			mContent.setText(this.getResources().getStringArray(R.array.answer)[18]);	
			break;		
		default:
			break;
		}
		
	}
	private void initView() {
		mTitle = (TextView) findViewById(R.id.question);
		mContent = (TextView) findViewById(R.id.answer);
		
	}
	
		
}
