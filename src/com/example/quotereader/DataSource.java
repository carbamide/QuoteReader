package com.example.quotereader;


import java.util.ArrayList;

import android.graphics.Bitmap;

public class DataSource {
    private ArrayList<Integer> mPhotoPool;
    private ArrayList<Integer> mQuotePool;
    private ArrayList<Integer> mPhotoHdPool;

    private Bitmap mThumbnail;
    private Bitmap mHdImage;
    private String mQuote;
    private float mRating;
    
    public Bitmap getmThumbnaiol() {
    	return mThumbnail;
    }
    
    public Bitmap getmHdImage() {
    	return mHdImage;
    }
    
    public String getmQuote() {
    	return mQuote;
    }
    
    public float getmRating() {
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
    
    
    public ArrayList<Integer> getmPhotoHdPool() {
        return mPhotoHdPool;
    }

    public ArrayList<Integer> getmPhotoPool() {
        return mPhotoPool;
    }

    public ArrayList<Integer> getmQuotePool() {
        return mQuotePool;
    }
 
    private void setupPhotoPool() {
    	mPhotoPool.add(R.drawable.steve_1);
    	mPhotoPool.add(R.drawable.steve_2);
    	mPhotoPool.add(R.drawable.steve_3);
    	mPhotoPool.add(R.drawable.steve_4);
    	mPhotoPool.add(R.drawable.steve_5);
    	mPhotoPool.add(R.drawable.steve_6);
    	mPhotoPool.add(R.drawable.steve_7);
    	mPhotoPool.add(R.drawable.steve_8);
    	mPhotoPool.add(R.drawable.steve_9);
    	mPhotoPool.add(R.drawable.steve_10);
    }
     
    private void setupQuotePool() {
    	mQuotePool.add(R.string.quote_1);
    	mQuotePool.add(R.string.quote_2);
    	mQuotePool.add(R.string.quote_3);
    	mQuotePool.add(R.string.quote_4);
    	mQuotePool.add(R.string.quote_5);
    	mQuotePool.add(R.string.quote_6);
    	mQuotePool.add(R.string.quote_7);
    	mQuotePool.add(R.string.quote_8);
    	mQuotePool.add(R.string.quote_9);
    	mQuotePool.add(R.string.quote_10);
    }
     
    private void setupPhotoHDPool() {
    	mPhotoHdPool.add(R.drawable.steve_hd_1);
    	mPhotoHdPool.add(R.drawable.steve_hd_2);
    	mPhotoHdPool.add(R.drawable.steve_hd_3);
    	mPhotoHdPool.add(R.drawable.steve_hd_4);
    	mPhotoHdPool.add(R.drawable.steve_hd_5);
    	mPhotoHdPool.add(R.drawable.steve_hd_6);
    	mPhotoHdPool.add(R.drawable.steve_hd_7);
    	mPhotoHdPool.add(R.drawable.steve_hd_8);
    	mPhotoHdPool.add(R.drawable.steve_hd_9);
    	mPhotoHdPool.add(R.drawable.apple_hd);
    }
    
    public int getDataSourceLength() {
    	return mPhotoPool.size();
    }
    
    public DataSource() {
    	mPhotoPool = new ArrayList<Integer>();
    	mQuotePool = new ArrayList<Integer>();
    	mPhotoHdPool = new ArrayList<Integer>();
    	
    	setupPhotoPool();
    	setupQuotePool();
    	setupPhotoHDPool();
    }
}