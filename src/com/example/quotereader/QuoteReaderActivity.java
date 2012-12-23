package com.example.quotereader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class QuoteReaderActivity extends Activity {

	private ListView mListView;

	public class QuoteAdapter extends BaseAdapter {
		private Context mContext;
		private LayoutInflater mInflator;
		private DataSource mDataSource;

		public QuoteAdapter(Context c) {
			mContext = c;
			mInflator = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			mDataSource = DataSource.getDataSourceInstance(mContext);
		}

		@Override
		public int getCount() {
			return mDataSource.getDataSourceLength();
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override 
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView thumbnail;
			TextView quote;

			if (convertView == null) {
				convertView = mInflator.inflate(R.layout.list_item_layout, parent, false);
			}

			thumbnail = (ImageView)convertView.findViewById(R.list.thumb);
			thumbnail.setImageBitmap(mDataSource.getmItemsData().get(position).getmThumbnail());

			quote = (TextView)convertView.findViewById(R.list.text);
			quote.setText(mDataSource.getmItemsData().get(position).getmQuote());


			return convertView;
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		
		if (mListView != null) {
			QuoteAdapter adapter = (QuoteAdapter) mListView.getAdapter();
			adapter.notifyDataSetChanged();
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quote_reader);

		mListView = (ListView)findViewById(R.id.quotes_list);
		mListView.setAdapter(new QuoteAdapter(this));

		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView arg0, View arg1, int position, long arg3) {				
				Intent i = new Intent(QuoteReaderActivity.this, QuoteDetail.class);
				i.putExtra("position", position);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_quote_reader, menu);
		return true;
	}

}
