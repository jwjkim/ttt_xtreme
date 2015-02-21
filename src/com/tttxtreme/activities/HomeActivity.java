package com.tttxtreme.activities;

import com.tttxtreme.R;
import com.tttxtreme.algorithm.FrameStatus;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

@SuppressLint("DefaultLocale")
public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_page);

		Button startNew = (Button) findViewById(R.id.new_game);

		startNew.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startGame();
			}
		});
	}

	public void startGame() {
		FrameStatus.resetFrame();

		Intent startNewGame = new Intent(this, FrameActivity.class);
		this.startActivity(startNewGame);
	}
}
