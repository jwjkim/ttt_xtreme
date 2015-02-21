package com.tttxtreme.activities;

import com.tttxtreme.R;
import com.tttxtreme.algorithm.FrameStatus;
import com.tttxtreme.algorithm.StatusUpdate;
import com.tttxtreme.algorithm.TTTAlgorithm;
import com.tttxtreme.others.FlipAnimation;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

@SuppressLint("DefaultLocale")
public class FrameActivity extends Activity {
	RelativeLayout activityRoot, gameFrame, gameFocusedOne;
	Button bReset;
	View frameOne, frameTwo, frameThree, frameFour, frameFive, frameSix,
			frameSeven, frameEight, frameNine, vOneLine, vTwoLine, vThreeLine,
			vFourLine, vFiveLine, vSixLine, vOne, vTwo, hOne, hTwo, hOneLine,
			hTwoLine, hThreeLine, hFourLine, hFiveLine, hSixLine, vFOne, vFTwo,
			hFOne, hFTwo, frameFOneA, frameFOneB, frameFOneC, frameFOneD,
			frameFOneE, frameFOneF, frameFOneG, frameFOneH, frameFOneI;
	static View[] viewArray;
	static View[][] lineArray, lineFocusedArray, viewFArray;
	static TextView testString;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frame_page);

		bReset = (Button) findViewById(R.id.b_reset);

		activityRoot = (RelativeLayout) findViewById(R.id.main_activity_root);
		gameFrame = (RelativeLayout) findViewById(R.id.game_frame);
		gameFocusedOne = (RelativeLayout) findViewById(R.id.game_focused_one);

		vOne = (View) findViewById(R.id.v_one);
		vTwo = (View) findViewById(R.id.v_two);
		hOne = (View) findViewById(R.id.h_one);
		hTwo = (View) findViewById(R.id.h_two);
		vFOne = (View) findViewById(R.id.v_f_one);
		vFTwo = (View) findViewById(R.id.v_f_two);
		hFOne = (View) findViewById(R.id.h_f_one);
		hFTwo = (View) findViewById(R.id.h_f_two);

		vOneLine = (View) findViewById(R.id.v_m_one);
		vTwoLine = (View) findViewById(R.id.v_m_two);
		vThreeLine = (View) findViewById(R.id.v_m_three);
		vFourLine = (View) findViewById(R.id.v_m_four);
		vFiveLine = (View) findViewById(R.id.v_m_five);
		vSixLine = (View) findViewById(R.id.v_m_six);

		hOneLine = (View) findViewById(R.id.h_m_one);
		hTwoLine = (View) findViewById(R.id.h_m_two);
		hThreeLine = (View) findViewById(R.id.h_m_three);
		hFourLine = (View) findViewById(R.id.h_m_four);
		hFiveLine = (View) findViewById(R.id.h_m_five);
		hSixLine = (View) findViewById(R.id.h_m_six);

		frameOne = (View) findViewById(R.id.frame_main_one);
		frameTwo = (View) findViewById(R.id.frame_main_two);
		frameThree = (View) findViewById(R.id.frame_main_three);
		frameFour = (View) findViewById(R.id.frame_main_four);
		frameFive = (View) findViewById(R.id.frame_main_five);
		frameSix = (View) findViewById(R.id.frame_main_six);
		frameSeven = (View) findViewById(R.id.frame_main_seven);
		frameEight = (View) findViewById(R.id.frame_main_eight);
		frameNine = (View) findViewById(R.id.frame_main_nine);

		frameFOneA = (View) findViewById(R.id.frame_focus_one_a);
		frameFOneB = (View) findViewById(R.id.frame_focus_one_b);
		frameFOneC = (View) findViewById(R.id.frame_focus_one_c);
		frameFOneD = (View) findViewById(R.id.frame_focus_one_d);
		frameFOneE = (View) findViewById(R.id.frame_focus_one_e);
		frameFOneF = (View) findViewById(R.id.frame_focus_one_f);
		frameFOneG = (View) findViewById(R.id.frame_focus_one_g);
		frameFOneH = (View) findViewById(R.id.frame_focus_one_h);
		frameFOneI = (View) findViewById(R.id.frame_focus_one_i);

		testString = (TextView) findViewById(R.id.test);

		createArray();

		frameOne.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				FlipAnimation flipAnimation = new FlipAnimation(gameFrame,
						gameFocused);

				if (gameFrame.getVisibility() == View.GONE) {
					flipAnimation.reverse();
				}
				activityRoot.startAnimation(flipAnimation);
				// if (FrameStatus.getFrame(1, 1, 1) != 2) {
				// playerSelected(1, 1, 1);
				// }
			}
		});

		frameFTwo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (FrameStatus.getFrame(1, 1, 2) != 2) {
					playerSelected(2, 1, 1);
				}
			}
		});

		frameFThree.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (FrameStatus.getFrame(1, 1, 3) != 2) {
					playerSelected(3, 1, 1);
				}
			}
		});

		frameFFour.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (FrameStatus.getFrame(1, 1, 4) != 2) {
					playerSelected(4, 1, 1);
				}
			}
		});

		frameFFive.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (FrameStatus.getFrame(1, 1, 5) != 2) {
					playerSelected(5, 1, 1);
				}
			}
		});

		frameFSix.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (FrameStatus.getFrame(1, 1, 6) != 2) {
					playerSelected(6, 1, 1);
				}
			}
		});

		frameFSeven.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (FrameStatus.getFrame(1, 1, 7) != 2) {
					playerSelected(7, 1, 1);
				}
			}
		});

		frameFEight.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (FrameStatus.getFrame(1, 1, 8) != 2) {
					playerSelected(8, 1, 1);
				}
			}
		});

		frameFNine.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (FrameStatus.getFrame(1, 1, 9) != 2) {
					playerSelected(9, 1, 1);
				}
			}
		});
	}

	public static void playerSelected(int x, int y, int player) {
		if (player == 1) {
			viewArray[x].setBackgroundResource(R.drawable.ttt_one);
			FrameStatus.setFrame(1, 1, x, 1);
			StatusUpdate.changeTurn(2);
			TTTAlgorithm.checkXWin(1, 1);
		} else {
			viewArray[x].setBackgroundResource(R.drawable.ttt_two);
			StatusUpdate.changeTurn(1);
		}
	}

	public void createArray() {
		viewArray = new View[10];

		viewArray[1] = frameOne;
		viewArray[2] = frameTwo;
		viewArray[3] = frameThree;
		viewArray[4] = frameFour;
		viewArray[5] = frameFive;
		viewArray[6] = frameSix;
		viewArray[7] = frameSeven;
		viewArray[8] = frameEight;
		viewArray[9] = frameNine;

		lineArray = new View[3][9];

		lineArray[1][1] = vOneLine;
		lineArray[1][2] = vTwoLine;
		lineArray[1][3] = vOne;
		lineArray[1][4] = vThreeLine;
		lineArray[1][5] = vFourLine;
		lineArray[1][6] = vTwo;
		lineArray[1][7] = vFiveLine;
		lineArray[1][8] = vSixLine;
		lineArray[2][1] = hOneLine;
		lineArray[2][2] = hTwoLine;
		lineArray[2][3] = hOne;
		lineArray[2][4] = hThreeLine;
		lineArray[2][5] = hFourLine;
		lineArray[2][6] = hTwo;
		lineArray[2][7] = hFiveLine;
		lineArray[2][8] = hSixLine;

		viewFArray = new View[10][10];

		viewFArray[1][1] = frameFOneA;
		viewFArray[1][2] = frameFOneB;
		viewFArray[1][3] = frameFOneC;
		viewFArray[1][4] = frameFOneD;
		viewFArray[1][5] = frameFOneE;
		viewFArray[1][6] = frameFOneF;
		viewFArray[1][7] = frameFOneG;
		viewFArray[1][8] = frameFOneH;
		viewFArray[1][9] = frameFOneI;

		lineFocusedArray = new View[3][3];

		lineFocusedArray[1][1] = vFOne;
		lineFocusedArray[1][2] = vFTwo;
		lineFocusedArray[2][1] = hFOne;
		lineFocusedArray[2][2] = hFTwo;
	}

	public static void setWinner(int player) {
		if (0 <= player && player <= 2) {
			testString.setText(player + " wins");
		}
		// for (int i = 1; i < 10; i++) {
		// viewArray[i][1].setBackgroundResource(0);
		// }
	}

	//
	//
	// Override methods
	//
	//

	@Override
	public void onBackPressed() {
		moveTaskToBack(true);
	}

	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		gameFrame.getLayoutParams().height = gameFrame.getWidth();
		gameFocused.getLayoutParams().height = gameFrame.getWidth();

		int line = gameFrame.getWidth() / 9;
		RelativeLayout.LayoutParams lpLine, lpFrame;

		for (int i = 1; i < 10; i++) {
			lpFrame = (RelativeLayout.LayoutParams) viewArray[i]
					.getLayoutParams();
			lpFrame.height = line * 3;
			lpFrame.width = line * 3;
			viewArray[i].setLayoutParams(lpFrame);
		}

		for (int j = 1; j < 10; j++) {
			lpFrame = (RelativeLayout.LayoutParams) viewFArray[j]
					.getLayoutParams();
			lpFrame.height = line * 3;
			lpFrame.width = line * 3;
			viewFArray[j].setLayoutParams(lpFrame);
		}

		for (int x = 1; x < 3; x++) {
			for (int y = 1; y < 9; y++) {
				lpLine = (RelativeLayout.LayoutParams) lineArray[x][y]
						.getLayoutParams();
				if (1 == x) {
					lpLine.setMargins(line * y, 0, 0, 0);
				} else {
					lpLine.setMargins(0, line * y, 0, 0);
				}
				lineArray[x][y].setLayoutParams(lpLine);
			}
		}

		for (int a = 1; a < 3; a++) {
			for (int b = 1; b < 3; b++) {
				lpLine = (RelativeLayout.LayoutParams) lineFocusedArray[a][b]
						.getLayoutParams();
				if (1 == a) {
					lpLine.setMargins(line * 3 * b, 0, 0, 0);
				} else {
					lpLine.setMargins(0, line * 3 * b, 0, 0);
				}
			}
		}
	}
}
