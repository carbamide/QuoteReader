package com.example.quotereader;

import java.io.FileNotFoundException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

public class QuoteDetail extends Activity {

	private ImageView mImageView;
	private EditText mQuote;
	private int mPosition;
	private DataSourceItem mItem;
	private RatingBar mRatingBar;
	
	private static final int SELECT_PHOTO = 100;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quote_detail);
		
		Intent i = getIntent();
	
		mPosition = i.getIntExtra("position", 0);
		
		mImageView = (ImageView)findViewById(R.detail.image);
		
		mQuote = (EditText)findViewById(R.detail.quote);
		
		System.out.println("the current line is" + mPosition);
		
		mItem = DataSource.getDataSourceInstance(this).getmItemsData().get(mPosition);
		mImageView.setImageBitmap(mItem.getmHdImage());
		mQuote.setText(mItem.getmQuote());
		
		mQuote.addTextChangedListener(new TextWatcher() {
			
			@Override
			
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				mItem.setmQuote(s.toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				
			}
		});
		
		mImageView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
				
				photoPickerIntent.setType("image/*");
				
				startActivityForResult(photoPickerIntent, SELECT_PHOTO);
			}
		});
		
		mRatingBar = (RatingBar)findViewById(R.id.rating_bar);
		mRatingBar.setRating(mItem.getMRating());
		
		mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
				mItem.setmRating(rating);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		switch(requestCode) {
		case SELECT_PHOTO:
			if (resultCode == RESULT_OK) {
				Uri selectedImage = data.getData();
				
				try {
					InputStream imageStream = getContentResolver().openInputStream(selectedImage);
					
					Bitmap yourSelectedImage = BitmapFactory.decodeStream(imageStream);
					
					mItem.setmHdImage(yourSelectedImage);
					
					mImageView.setImageBitmap(yourSelectedImage);
				}
				catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
