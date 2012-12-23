package com.example.quotereader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;

public class QuoteDetail extends Activity {

	private ImageView mImageView;
	private EditText mQuote;
	private int mPosition;
	private DataSourceItem mItem;

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
	}
}
