package com.fragment.worldtrival;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ui.worldtrival.R;
import com.worldtrival.adapter.MyAdapter;
import com.worldtrival.bean.SearchBean;
import com.worldtrival.message.MessageModel;
/**
 *发现Fragment 
 *
 */
public class SearchFragment extends Fragment {
	private ListView lv;
	private List<MessageModel> listMessage;
//	private List<SearchBean> list;
	private MyAdapter adp;
	private drawimg img_share;
	private Intent intent;
	private static String url = "http://120.26.208.234:10320/?url=activity_area";
	private static String parm = "json=%7B%22pagination%22%3A%7B%22count%22%3A10%2C%22page%22%3A1%7D%7D";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.guide_search, container, false);
		lv = (ListView) view.findViewById(R.id.lv);
		lv.setDivider(null);
		new MyAsyncTask().execute(url,parm);
		return view;
	} 

	class MyAsyncTask extends AsyncTask<String, Void, List<SearchBean>>{
		
		@Override
		protected void onPostExecute(List<SearchBean> result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			addList(result);
			adp = new MyAdapter(listMessage, getContext());
			lv.setAdapter(adp);

		}
 
		@Override
		protected List<SearchBean> doInBackground(String... arg0) {
			try {
				URL url = new URL(arg0[0]);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
				bw.write(arg0[1]);
				bw.flush();
				bw.close();
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				StringBuilder builder = new StringBuilder();
				String line = null;
				while((line = br.readLine())!=null){
					builder.append(line);
				}
				br.close();
				conn.disconnect();
				Log.e("jsonString", builder.toString());
				SearchBean bean = null;
				JSONObject jo = new JSONObject(builder.toString());
				JSONArray array = jo.getJSONArray("data");
				SearchBean b = null;
				List<SearchBean> listBean = new ArrayList<SearchBean>();
				for(int i = 0 ; i < array.length() ; i++){
					JSONObject ob = array.getJSONObject(i); 
					b = new SearchBean();
					b.setType(ob.getString("type"));
					if(ob.getString("type").equals("seven_gift")){
						b.setTitle(ob.getString("title"));
						b.setImg_url(ob.getString("img_url"));
						b.setUrl(ob.getString("7zhou_url"));
						b.setEvent_time(ob.getString("event_time"));
						
					}else{
						b.setTitle(ob.getString("goods_name"));
						b.setImg_url(ob.getString("small"));
					 	b.setUrl(ob.getString("link")); 
						b.setEvent_time("0"); 
					}
					listBean.add(b);
				}
				
				return listBean;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
	}
	public void addList(List<SearchBean> result) {
		listMessage = new ArrayList<MessageModel>();
		MessageModel model = null;
		for(int i = 0 ; i < result.size() ; i ++){
			if(result.get(i).getType().equals("seven_gift")){
				model = new MessageModel(result.get(i).getImg_url(), "七洲有礼",result.get(i).getTitle() , "活动时间："+result.get(i).getEvent_time(),result.get(i).getUrl(), R.drawable.fengxiang);
			}else{
				model = new MessageModel(result.get(i).getImg_url(), "同城聚会",result.get(i).getTitle() , "",result.get(i).getUrl(), R.drawable.fengxiang);
			}
			listMessage.add(model);
		}

	}
	
}
