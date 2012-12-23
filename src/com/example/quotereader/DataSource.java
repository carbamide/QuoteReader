package com.example.quotereader;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;

import java.util.ArrayList;


public class DataSource {
	private Context mContext;
	private ArrayList<DataSourceItem> mItemsData;

	public DataSource(Context context) {
		this.mContext = context;
		mItemsData = new ArrayList<DataSourceItem>();
		setupItemsData();
	}

	public ArrayList<DataSourceItem> getmItemsData() {
		return mItemsData;
	}

	private void setupItemsData() {
		mItemsData.add(new DataSourceItem(((BitmapDrawable)mContext.getResources().getDrawable(R.drawable.steve_1)).getBitmap(), 
				((BitmapDrawable)mContext.getResources().getDrawable(R.drawable.steve_hd_1)).getBitmap(), mContext.getResources().getString(R.string.quote_1)));
		mItemsData.add(new DataSourceItem(((BitmapDrawable)mContext.getResources().getDrawable(R.drawable.steve_2)).getBitmap(), 
				((BitmapDrawable)mContext.getResources().getDrawable(R.drawable.steve_hd_2)).getBitmap(), mContext.getResources().getString(R.string.quote_2)));
		mItemsData.add(new DataSourceItem(((BitmapDrawable)mContext.getResources().getDrawable(R.drawable.steve_3)).getBitmap(), 
				((BitmapDrawable)mContext.getResources().getDrawable(R.drawable.steve_hd_3)).getBitmap(), mContext.getResources().getString(R.string.quote_3)));
		mItemsData.add(new DataSourceItem(((BitmapDrawable)mContext.getResources().getDrawable(R.drawable.steve_4)).getBitmap(), 
				((BitmapDrawable)mContext.getResources().getDrawable(R.drawable.steve_hd_4)).getBitmap(), mContext.getResources().getString(R.string.quote_4)));
		mItemsData.add(new DataSourceItem(((BitmapDrawable)mContext.getResources().getDrawable(R.drawable.steve_5)).getBitmap(), 
				((BitmapDrawable)mContext.getResources().getDrawable(R.drawable.steve_hd_5)).getBitmap(), mContext.getResources().getString(R.string.quote_5)));
		mItemsData.add(new DataSourceItem(((BitmapDrawable)mContext.getResources().getDrawable(R.drawable.steve_6)).getBitmap(), 
				((BitmapDrawable)mContext.getResources().getDrawable(R.drawable.steve_hd_6)).getBitmap(), mContext.getResources().getString(R.string.quote_6)));
		mItemsData.add(new DataSourceItem(((BitmapDrawable)mContext.getResources().getDrawable(R.drawable.steve_7)).getBitmap(), 
				((BitmapDrawable)mContext.getResources().getDrawable(R.drawable.steve_hd_7)).getBitmap(), mContext.getResources().getString(R.string.quote_7)));
		mItemsData.add(new DataSourceItem(((BitmapDrawable)mContext.getResources().getDrawable(R.drawable.steve_8)).getBitmap(), 
				((BitmapDrawable)mContext.getResources().getDrawable(R.drawable.steve_hd_8)).getBitmap(), mContext.getResources().getString(R.string.quote_8)));
		mItemsData.add(new DataSourceItem(((BitmapDrawable)mContext.getResources().getDrawable(R.drawable.steve_9)).getBitmap(), 
				((BitmapDrawable)mContext.getResources().getDrawable(R.drawable.steve_hd_9)).getBitmap(), mContext.getResources().getString(R.string.quote_9)));
		mItemsData.add(new DataSourceItem(((BitmapDrawable)mContext.getResources().getDrawable(R.drawable.steve_10)).getBitmap(), 
				((BitmapDrawable)mContext.getResources().getDrawable(R.drawable.apple_hd)).getBitmap(), mContext.getResources().getString(R.string.quote_10)));
	}

	public int getDataSourceLength() {
		return mItemsData.size();
	}

	private static DataSource mDataSource;

	public static DataSource getDataSourceInstance(Context context) {
		if (mDataSource == null) {
			mDataSource = new DataSource(context);
		}
		return mDataSource;
	}
}