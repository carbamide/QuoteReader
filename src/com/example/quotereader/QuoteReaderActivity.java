package com.example.quotereader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class QuoteReaderActivity extends Activity {

	private ListView mListView;
	private static int CREATE_QUOTE_ID = 1;

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
		
		registerForContextMenu(mListView);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		
		menu.setHeaderTitle(getResources().getString(R.string.context_menu_title));
		
		MenuInflater menuInflator = getMenuInflater();
		menuInflator.inflate(R.layout.context_menu, menu);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterContextMenuInfo info = (AdapterContextMenuInfo)item.getMenuInfo();
		
		if (item.getItemId() == R.id.delete) {
			DataSource.getDataSourceInstance(this).getmItemsData().remove(info.position);
			
			QuoteAdapter adapter = (QuoteAdapter)mListView.getAdapter();
			adapter.notifyDataSetChanged();
			
			return true;
		}
		return super.onContextItemSelected(item);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(Menu.NONE, CREATE_QUOTE_ID, Menu.NONE, "Create new quote");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == CREATE_QUOTE_ID) {
			DataSource dataSource = DataSource.getDataSourceInstance(this);
			dataSource.getmItemsData().add(new DataSourceItem());
			
			QuoteAdapter adapter = (QuoteAdapter)mListView.getAdapter();
			adapter.notifyDataSetChanged();
			
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
