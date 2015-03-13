package com.tttxtreme.activities;

import com.tttxtreme.R;
import com.tttxtreme.algorithm.FrameStatus;
import com.tttxtreme.algorithm.StatusUpdate;
import com.tttxtreme.algorithm.TTTAlgorithm;
import com.tttxtreme.others.FlipAnimation;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

@SuppressLint("DefaultLocale")
public class FrameActivity extends Activity {
	RelativeLayout framesRoot, gameFrame, gameFocusedOne, gameFocusedTwo,
			gameFocusedThree, gameFocusedFour, gameFocusedFive, gameFocusedSix,
			gameFocusedSeven, gameFocusedEight, gameFocusedNine;
	Button bReset, bBack;
	View frameOne, frameTwo, frameThree, frameFour, frameFive, frameSix,
			frameSeven, frameEight, frameNine, vOneLine, vTwoLine, vThreeLine,
			vFourLine, vFiveLine, vSixLine, vOne, vTwo, hOne, hTwo, hOneLine,
			hTwoLine, hThreeLine, hFourLine, hFiveLine, hSixLine, preview;
	// Focused frames
	View frameFOneA, frameFOneB, frameFOneC, frameFOneD, frameFOneE,
			frameFOneF, frameFOneG, frameFOneH, frameFOneI, frameFTwoA,
			frameFTwoB, frameFTwoC, frameFTwoD, frameFTwoE, frameFTwoF,
			frameFTwoG, frameFTwoH, frameFTwoI, frameFThreeA, frameFThreeB,
			frameFThreeC, frameFThreeD, frameFThreeE, frameFThreeF,
			frameFThreeG, frameFThreeH, frameFThreeI, frameFFourA, frameFFourB,
			frameFFourC, frameFFourD, frameFFourE, frameFFourF, frameFFourG,
			frameFFourH, frameFFourI, frameFFiveA, frameFFiveB, frameFFiveC,
			frameFFiveD, frameFFiveE, frameFFiveF, frameFFiveG, frameFFiveH,
			frameFFiveI, frameFSixA, frameFSixB, frameFSixC, frameFSixD,
			frameFSixE, frameFSixF, frameFSixG, frameFSixH, frameFSixI,
			frameFSevenA, frameFSevenB, frameFSevenC, frameFSevenD,
			frameFSevenE, frameFSevenF, frameFSevenG, frameFSevenH,
			frameFSevenI, frameFEightA, frameFEightB, frameFEightC,
			frameFEightD, frameFEightE, frameFEightF, frameFEightG,
			frameFEightH, frameFEightI, frameFNineA, frameFNineB, frameFNineC,
			frameFNineD, frameFNineE, frameFNineF, frameFNineG, frameFNineH,
			frameFNineI;
	// Focused lines
	View vFOneOne, vFOneTwo, hFOneOne, hFOneTwo, vFTwoOne, vFTwoTwo, hFTwoOne,
			hFTwoTwo, vFThreeOne, vFThreeTwo, hFThreeOne, hFThreeTwo,
			vFFourOne, vFFourTwo, hFFourOne, hFFourTwo, vFFiveOne, vFFiveTwo,
			hFFiveOne, hFFiveTwo, vFSixOne, vFSixTwo, hFSixOne, hFSixTwo,
			vFSevenOne, vFSevenTwo, hFSevenOne, hFSevenTwo, vFEightOne,
			vFEightTwo, hFEightOne, hFEightTwo, vFNineOne, vFNineTwo,
			hFNineOne, hFNineTwo;
	static View[] viewArray;
	static View[][] lineArray, lineFocusedArray, viewFArray;
	static TextView testString;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frame_page);

		globalize();

		createArray();

		bBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (preview != gameFrame) {
					flipFrames(preview, gameFrame);
				}
			}
		});

		frameOne.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				flipFrames(gameFrame, gameFocusedOne);
				preview = gameFocusedOne;
			}
		});

		frameTwo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				flipFrames(gameFrame, gameFocusedTwo);
				preview = gameFocusedTwo;
			}
		});

		frameThree.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				flipFrames(gameFrame, gameFocusedThree);
				preview = gameFocusedThree;
			}
		});

		frameFour.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				flipFrames(gameFrame, gameFocusedFour);
				preview = gameFocusedFour;
			}
		});

		frameFive.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				flipFrames(gameFrame, gameFocusedFive);
				preview = gameFocusedFive;
			}
		});

		frameSix.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				flipFrames(gameFrame, gameFocusedSix);
				preview = gameFocusedSix;
			}
		});

		frameSeven.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				flipFrames(gameFrame, gameFocusedSeven);
				preview = gameFocusedSeven;
			}
		});

		frameEight.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				flipFrames(gameFrame, gameFocusedEight);
				preview = gameFocusedEight;
			}
		});

		frameNine.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				flipFrames(gameFrame, gameFocusedNine);
				preview = gameFocusedNine;
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

	public void globalize() {
		bReset = (Button) findViewById(R.id.b_reset);
		bBack = (Button) findViewById(R.id.b_back);

		framesRoot = (RelativeLayout) findViewById(R.id.frames);
		gameFrame = (RelativeLayout) findViewById(R.id.game_frame);
		gameFocusedOne = (RelativeLayout) findViewById(R.id.game_focused_one);
		gameFocusedTwo = (RelativeLayout) findViewById(R.id.game_focused_two);
		gameFocusedThree = (RelativeLayout) findViewById(R.id.game_focused_three);
		gameFocusedFour = (RelativeLayout) findViewById(R.id.game_focused_four);
		gameFocusedFive = (RelativeLayout) findViewById(R.id.game_focused_five);
		gameFocusedSix = (RelativeLayout) findViewById(R.id.game_focused_six);
		gameFocusedSeven = (RelativeLayout) findViewById(R.id.game_focused_seven);
		gameFocusedEight = (RelativeLayout) findViewById(R.id.game_focused_eight);
		gameFocusedNine = (RelativeLayout) findViewById(R.id.game_focused_nine);

		vOne = (View) findViewById(R.id.v_one);
		vTwo = (View) findViewById(R.id.v_two);
		hOne = (View) findViewById(R.id.h_one);
		hTwo = (View) findViewById(R.id.h_two);
		// one
		vFOneOne = (View) findViewById(R.id.v_f_one_one);
		vFOneTwo = (View) findViewById(R.id.v_f_one_two);
		hFOneOne = (View) findViewById(R.id.h_f_one_one);
		hFOneTwo = (View) findViewById(R.id.h_f_one_two);
		frameFOneA = (View) findViewById(R.id.frame_focus_one_a);
		frameFOneB = (View) findViewById(R.id.frame_focus_one_b);
		frameFOneC = (View) findViewById(R.id.frame_focus_one_c);
		frameFOneD = (View) findViewById(R.id.frame_focus_one_d);
		frameFOneE = (View) findViewById(R.id.frame_focus_one_e);
		frameFOneF = (View) findViewById(R.id.frame_focus_one_f);
		frameFOneG = (View) findViewById(R.id.frame_focus_one_g);
		frameFOneH = (View) findViewById(R.id.frame_focus_one_h);
		frameFOneI = (View) findViewById(R.id.frame_focus_one_i);
		// two
		vFTwoOne = (View) findViewById(R.id.v_f_two_one);
		vFTwoTwo = (View) findViewById(R.id.v_f_two_two);
		hFTwoOne = (View) findViewById(R.id.h_f_two_one);
		hFTwoTwo = (View) findViewById(R.id.h_f_two_two);
		frameFTwoA = (View) findViewById(R.id.frame_focus_two_a);
		frameFTwoB = (View) findViewById(R.id.frame_focus_two_b);
		frameFTwoC = (View) findViewById(R.id.frame_focus_two_c);
		frameFTwoD = (View) findViewById(R.id.frame_focus_two_d);
		frameFTwoE = (View) findViewById(R.id.frame_focus_two_e);
		frameFTwoF = (View) findViewById(R.id.frame_focus_two_f);
		frameFTwoG = (View) findViewById(R.id.frame_focus_two_g);
		frameFTwoH = (View) findViewById(R.id.frame_focus_two_h);
		frameFTwoI = (View) findViewById(R.id.frame_focus_two_i);
		// three
		vFThreeOne = (View) findViewById(R.id.v_f_three_one);
		vFThreeTwo = (View) findViewById(R.id.v_f_three_two);
		hFThreeOne = (View) findViewById(R.id.h_f_three_one);
		hFThreeTwo = (View) findViewById(R.id.h_f_three_two);
		frameFThreeA = (View) findViewById(R.id.frame_focus_three_a);
		frameFThreeB = (View) findViewById(R.id.frame_focus_three_b);
		frameFThreeC = (View) findViewById(R.id.frame_focus_three_c);
		frameFThreeD = (View) findViewById(R.id.frame_focus_three_d);
		frameFThreeE = (View) findViewById(R.id.frame_focus_three_e);
		frameFThreeF = (View) findViewById(R.id.frame_focus_three_f);
		frameFThreeG = (View) findViewById(R.id.frame_focus_three_g);
		frameFThreeH = (View) findViewById(R.id.frame_focus_three_h);
		frameFThreeI = (View) findViewById(R.id.frame_focus_three_i);
		// four
		vFFourOne = (View) findViewById(R.id.v_f_four_one);
		vFFourTwo = (View) findViewById(R.id.v_f_four_two);
		hFFourOne = (View) findViewById(R.id.h_f_four_one);
		hFFourTwo = (View) findViewById(R.id.h_f_four_two);
		frameFFourA = (View) findViewById(R.id.frame_focus_four_a);
		frameFFourB = (View) findViewById(R.id.frame_focus_four_b);
		frameFFourC = (View) findViewById(R.id.frame_focus_four_c);
		frameFFourD = (View) findViewById(R.id.frame_focus_four_d);
		frameFFourE = (View) findViewById(R.id.frame_focus_four_e);
		frameFFourF = (View) findViewById(R.id.frame_focus_four_f);
		frameFFourG = (View) findViewById(R.id.frame_focus_four_g);
		frameFFourH = (View) findViewById(R.id.frame_focus_four_h);
		frameFFourI = (View) findViewById(R.id.frame_focus_four_i);
		// five
		vFFiveOne = (View) findViewById(R.id.v_f_five_one);
		vFFiveTwo = (View) findViewById(R.id.v_f_five_two);
		hFFiveOne = (View) findViewById(R.id.h_f_five_one);
		hFFiveTwo = (View) findViewById(R.id.h_f_five_two);
		frameFFiveA = (View) findViewById(R.id.frame_focus_five_a);
		frameFFiveB = (View) findViewById(R.id.frame_focus_five_b);
		frameFFiveC = (View) findViewById(R.id.frame_focus_five_c);
		frameFFiveD = (View) findViewById(R.id.frame_focus_five_d);
		frameFFiveE = (View) findViewById(R.id.frame_focus_five_e);
		frameFFiveF = (View) findViewById(R.id.frame_focus_five_f);
		frameFFiveG = (View) findViewById(R.id.frame_focus_five_g);
		frameFFiveH = (View) findViewById(R.id.frame_focus_five_h);
		frameFFiveI = (View) findViewById(R.id.frame_focus_five_i);
		// six
		vFSixOne = (View) findViewById(R.id.v_f_six_one);
		vFSixTwo = (View) findViewById(R.id.v_f_six_two);
		hFSixOne = (View) findViewById(R.id.h_f_six_one);
		hFSixTwo = (View) findViewById(R.id.h_f_six_two);
		frameFSixA = (View) findViewById(R.id.frame_focus_six_a);
		frameFSixB = (View) findViewById(R.id.frame_focus_six_b);
		frameFSixC = (View) findViewById(R.id.frame_focus_six_c);
		frameFSixD = (View) findViewById(R.id.frame_focus_six_d);
		frameFSixE = (View) findViewById(R.id.frame_focus_six_e);
		frameFSixF = (View) findViewById(R.id.frame_focus_six_f);
		frameFSixG = (View) findViewById(R.id.frame_focus_six_g);
		frameFSixH = (View) findViewById(R.id.frame_focus_six_h);
		frameFSixI = (View) findViewById(R.id.frame_focus_six_i);
		// seven
		vFSevenOne = (View) findViewById(R.id.v_f_seven_one);
		vFSevenTwo = (View) findViewById(R.id.v_f_seven_two);
		hFSevenOne = (View) findViewById(R.id.h_f_seven_one);
		hFSevenTwo = (View) findViewById(R.id.h_f_seven_two);
		frameFSevenA = (View) findViewById(R.id.frame_focus_seven_a);
		frameFSevenB = (View) findViewById(R.id.frame_focus_seven_b);
		frameFSevenC = (View) findViewById(R.id.frame_focus_seven_c);
		frameFSevenD = (View) findViewById(R.id.frame_focus_seven_d);
		frameFSevenE = (View) findViewById(R.id.frame_focus_seven_e);
		frameFSevenF = (View) findViewById(R.id.frame_focus_seven_f);
		frameFSevenG = (View) findViewById(R.id.frame_focus_seven_g);
		frameFSevenH = (View) findViewById(R.id.frame_focus_seven_h);
		frameFSevenI = (View) findViewById(R.id.frame_focus_seven_i);
		// eight
		vFEightOne = (View) findViewById(R.id.v_f_eight_one);
		vFEightTwo = (View) findViewById(R.id.v_f_eight_two);
		hFEightOne = (View) findViewById(R.id.h_f_eight_one);
		hFEightTwo = (View) findViewById(R.id.h_f_eight_two);
		frameFEightA = (View) findViewById(R.id.frame_focus_eight_a);
		frameFEightB = (View) findViewById(R.id.frame_focus_eight_b);
		frameFEightC = (View) findViewById(R.id.frame_focus_eight_c);
		frameFEightD = (View) findViewById(R.id.frame_focus_eight_d);
		frameFEightE = (View) findViewById(R.id.frame_focus_eight_e);
		frameFEightF = (View) findViewById(R.id.frame_focus_eight_f);
		frameFEightG = (View) findViewById(R.id.frame_focus_eight_g);
		frameFEightH = (View) findViewById(R.id.frame_focus_eight_h);
		frameFEightI = (View) findViewById(R.id.frame_focus_eight_i);
		// nine
		vFNineOne = (View) findViewById(R.id.v_f_nine_one);
		vFNineTwo = (View) findViewById(R.id.v_f_nine_two);
		hFNineOne = (View) findViewById(R.id.h_f_nine_one);
		hFNineTwo = (View) findViewById(R.id.h_f_nine_two);
		frameFNineA = (View) findViewById(R.id.frame_focus_nine_a);
		frameFNineB = (View) findViewById(R.id.frame_focus_nine_b);
		frameFNineC = (View) findViewById(R.id.frame_focus_nine_c);
		frameFNineD = (View) findViewById(R.id.frame_focus_nine_d);
		frameFNineE = (View) findViewById(R.id.frame_focus_nine_e);
		frameFNineF = (View) findViewById(R.id.frame_focus_nine_f);
		frameFNineG = (View) findViewById(R.id.frame_focus_nine_g);
		frameFNineH = (View) findViewById(R.id.frame_focus_nine_h);
		frameFNineI = (View) findViewById(R.id.frame_focus_nine_i);

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

		testString = (TextView) findViewById(R.id.test);

		preview = gameFrame;
	}

	public void flipFrames(View oldFrame, View newFrame) {
		FlipAnimation flipAnimation = new FlipAnimation(oldFrame, newFrame);
		if (oldFrame.getVisibility() == View.GONE) {
			flipAnimation.reverse();
		}
		framesRoot.startAnimation(flipAnimation);
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

		// Main
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
		viewFArray[2][1] = frameFTwoA;
		viewFArray[2][2] = frameFTwoB;
		viewFArray[2][3] = frameFTwoC;
		viewFArray[2][4] = frameFTwoD;
		viewFArray[2][5] = frameFTwoE;
		viewFArray[2][6] = frameFTwoF;
		viewFArray[2][7] = frameFTwoG;
		viewFArray[2][8] = frameFTwoH;
		viewFArray[2][9] = frameFTwoI;
		viewFArray[3][1] = frameFThreeA;
		viewFArray[3][2] = frameFThreeB;
		viewFArray[3][3] = frameFThreeC;
		viewFArray[3][4] = frameFThreeD;
		viewFArray[3][5] = frameFThreeE;
		viewFArray[3][6] = frameFThreeF;
		viewFArray[3][7] = frameFThreeG;
		viewFArray[3][8] = frameFThreeH;
		viewFArray[3][9] = frameFThreeI;
		viewFArray[4][1] = frameFFourA;
		viewFArray[4][2] = frameFFourB;
		viewFArray[4][3] = frameFFourC;
		viewFArray[4][4] = frameFFourD;
		viewFArray[4][5] = frameFFourE;
		viewFArray[4][6] = frameFFourF;
		viewFArray[4][7] = frameFFourG;
		viewFArray[4][8] = frameFFourH;
		viewFArray[4][9] = frameFFourI;
		viewFArray[5][1] = frameFFiveA;
		viewFArray[5][2] = frameFFiveB;
		viewFArray[5][3] = frameFFiveC;
		viewFArray[5][4] = frameFFiveD;
		viewFArray[5][5] = frameFFiveE;
		viewFArray[5][6] = frameFFiveF;
		viewFArray[5][7] = frameFFiveG;
		viewFArray[5][8] = frameFFiveH;
		viewFArray[5][9] = frameFFiveI;
		viewFArray[6][1] = frameFSixA;
		viewFArray[6][2] = frameFSixB;
		viewFArray[6][3] = frameFSixC;
		viewFArray[6][4] = frameFSixD;
		viewFArray[6][5] = frameFSixE;
		viewFArray[6][6] = frameFSixF;
		viewFArray[6][7] = frameFSixG;
		viewFArray[6][8] = frameFSixH;
		viewFArray[6][9] = frameFSixI;
		viewFArray[7][1] = frameFSevenA;
		viewFArray[7][2] = frameFSevenB;
		viewFArray[7][3] = frameFSevenC;
		viewFArray[7][4] = frameFSevenD;
		viewFArray[7][5] = frameFSevenE;
		viewFArray[7][6] = frameFSevenF;
		viewFArray[7][7] = frameFSevenG;
		viewFArray[7][8] = frameFSevenH;
		viewFArray[7][9] = frameFSevenI;
		viewFArray[8][1] = frameFEightA;
		viewFArray[8][2] = frameFEightB;
		viewFArray[8][3] = frameFEightC;
		viewFArray[8][4] = frameFEightD;
		viewFArray[8][5] = frameFEightE;
		viewFArray[8][6] = frameFEightF;
		viewFArray[8][7] = frameFEightG;
		viewFArray[8][8] = frameFEightH;
		viewFArray[8][9] = frameFEightI;
		viewFArray[9][1] = frameFNineA;
		viewFArray[9][2] = frameFNineB;
		viewFArray[9][3] = frameFNineC;
		viewFArray[9][4] = frameFNineD;
		viewFArray[9][5] = frameFNineE;
		viewFArray[9][6] = frameFNineF;
		viewFArray[9][7] = frameFNineG;
		viewFArray[9][8] = frameFNineH;
		viewFArray[9][9] = frameFNineI;

		lineFocusedArray = new View[10][5];
		lineFocusedArray[1][1] = vFOneOne;
		lineFocusedArray[1][2] = vFOneTwo;
		lineFocusedArray[1][3] = hFOneOne;
		lineFocusedArray[1][4] = hFTwoTwo;
		lineFocusedArray[2][1] = vFTwoOne;
		lineFocusedArray[2][2] = vFTwoTwo;
		lineFocusedArray[2][3] = hFTwoOne;
		lineFocusedArray[2][4] = hFTwoTwo;
		lineFocusedArray[3][1] = vFTwoOne;
		lineFocusedArray[3][2] = vFThreeTwo;
		lineFocusedArray[3][3] = hFThreeOne;
		lineFocusedArray[3][4] = hFThreeTwo;
		lineFocusedArray[4][1] = vFFourOne;
		lineFocusedArray[4][2] = vFFourTwo;
		lineFocusedArray[4][3] = hFFourOne;
		lineFocusedArray[4][4] = hFFourTwo;
		lineFocusedArray[5][1] = vFFiveOne;
		lineFocusedArray[5][2] = vFFiveTwo;
		lineFocusedArray[5][3] = hFFiveOne;
		lineFocusedArray[5][4] = hFFiveTwo;
		lineFocusedArray[6][1] = vFSixOne;
		lineFocusedArray[6][2] = vFSixTwo;
		lineFocusedArray[6][3] = hFSixOne;
		lineFocusedArray[6][4] = hFSixTwo;
		lineFocusedArray[7][1] = vFSevenOne;
		lineFocusedArray[7][2] = vFSevenTwo;
		lineFocusedArray[7][3] = hFSevenOne;
		lineFocusedArray[7][4] = hFSevenTwo;
		lineFocusedArray[8][1] = vFEightOne;
		lineFocusedArray[8][2] = vFEightTwo;
		lineFocusedArray[8][3] = hFEightOne;
		lineFocusedArray[8][4] = hFEightTwo;
		lineFocusedArray[9][1] = vFNineOne;
		lineFocusedArray[9][2] = vFNineTwo;
		lineFocusedArray[9][3] = hFNineOne;
		lineFocusedArray[9][4] = hFNineTwo;
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
		gameFocusedOne.getLayoutParams().height = gameFrame.getWidth();
		gameFocusedTwo.getLayoutParams().height = gameFrame.getWidth();
		gameFocusedThree.getLayoutParams().height = gameFrame.getWidth();

		int line = gameFrame.getWidth() / 9;
		RelativeLayout.LayoutParams lpLine, lpFrame;

		for (int i = 1; i < 10; i++) {
			lpFrame = (RelativeLayout.LayoutParams) viewArray[i]
					.getLayoutParams();
			lpFrame.height = line * 3;
			lpFrame.width = line * 3;
			viewArray[i].setLayoutParams(lpFrame);
		}

		for (int p = 1; p < 10; p++) {
			for (int j = 1; j < 10; j++) {
				lpFrame = (RelativeLayout.LayoutParams) viewFArray[p][j]
						.getLayoutParams();
				lpFrame.height = line * 3;
				lpFrame.width = line * 3;
				viewFArray[1][j].setLayoutParams(lpFrame);
			}
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

		for (int a = 1; a < 10; a++) {
			for (int b = 1; b < 5; b++) {
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
