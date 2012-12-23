package com.example.quotereader;

import android.graphics.Bitmap;

public class DataSourceItem {
	private Bitmap mThumbnail;
	private Bitmap mHdImage;
	private String mQuote;
	private float mRating;
	
	public Bitmap getmThumbnail() {
		return mThumbnail;
	}
	
	public Bitmap getmHdImage() {
		return mHdImage;
	}
	
	public String getmQuote() {
		return mQuote;
	}
	
	public float getMRating() {
		return mRating;
	}
	
	public void setmRating(float mRating) {
		this.mRating = mRating;
	}
	
	public void setmHdImage(Bitmap mHdImage) {
		this.mHdImage = mHdImage;
	}
	
	public void setmQuote(String mQuote) {
		this.mQuote = mQuote;
	}
	
	public DataSourceItem() {
		mQuote = "New Quote is added";
	}
	
	public DataSourceItem(Bitmap thumbnail, Bitmap hdImage, String quote) {
		if (thumbnail == null || hdImage == null || quote == null) {
			throw new IllegalArgumentException();
		}
		
		mThumbnail = thumbnail;
		mHdImage = hdImage;
		mQuote = quote;
		
		mRating = 2.5f;
	}
}
