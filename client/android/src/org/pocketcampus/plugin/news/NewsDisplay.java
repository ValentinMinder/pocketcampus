package org.pocketcampus.plugin.news;

import java.util.ArrayList;

import org.pocketcampus.R;
import org.pocketcampus.core.plugin.DisplayBase;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class NewsDisplay extends DisplayBase {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_list);
		
		ListView l = (ListView) findViewById(R.id.news_list_list);
		NewsAdapter a = new NewsAdapter(getApplicationContext(), R.layout.news_newsentry, new ArrayList<NewsItem>());
		l.setAdapter(a);
		a.setDebugData();
		
		l.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				
				TextView tv = (TextView) arg1.findViewById(R.id.news_item_description);
				
				tv.setMaxLines(20);
				
			}
		});
		
	}
	


	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}
	
	
}
