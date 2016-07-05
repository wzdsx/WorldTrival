package com.worldtrival.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;

import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;

import android.widget.ImageView;

public class HttpThread extends Thread {
	private String imgurl;
	private Handler handler;
	private ImageView imgView;
	
	

	public HttpThread(String imgurl, Handler handler, ImageView imgView) {
		super();
		this.imgurl = imgurl;
		this.handler = handler;
		this.imgView = imgView;
	}



	@Override
	public void run() {
		try {
			URL url = new URL(imgurl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setReadTimeout(5000);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			FileOutputStream fOut = null;
			File downloadFile = null;

			if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
				File parent = Environment.getExternalStorageDirectory();
				downloadFile = new File(parent,"imgCache");
				fOut = new FileOutputStream(downloadFile);
			}
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			String result = "";
			String line = null;
			while ((line = br.readLine()) != null) {
				result += line;
			}
			
			final Bitmap bitmap = BitmapFactory.decodeFile(downloadFile.getAbsolutePath());

			handler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					imgView.setImageBitmap(bitmap);
				}
			});
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.run();
		
	}
	

}
