package com.tttxtreme.activity;

import com.tttxtreme.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

@SuppressLint("DefaultLocale")
public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_page);
	}
}
