package com.tttxtreme.algorithm;

import android.util.Log;

import com.tttxtreme.activities.FrameActivity;

public class TTTAlgorithm {

	public static void checkXWin(int x, int y) { // check();

		if ((frameNumb(x, y, 1) == 1 && frameNumb(x, y, 2) == 1 && frameNumb(x,
				y, 3) == 1)
				|| (frameNumb(x, y, 4) == 1 && frameNumb(x, y, 5) == 1 && frameNumb(
						x, y, 6) == 1)
				|| (frameNumb(x, y, 7) == 1 && frameNumb(x, y, 8) == 1 && frameNumb(
						x, y, 9) == 1)
				|| (frameNumb(x, y, 1) == 1 && frameNumb(x, y, 5) == 1 && frameNumb(
						x, y, 9) == 1)
				|| (frameNumb(x, y, 1) == 1 && frameNumb(x, y, 4) == 1 && frameNumb(
						x, y, 7) == 1)
				|| (frameNumb(x, y, 2) == 1 && frameNumb(x, y, 5) == 1 && frameNumb(
						x, y, 8) == 1)
				|| (frameNumb(x, y, 3) == 1 && frameNumb(x, y, 6) == 1 && frameNumb(
						x, y, 9) == 1)
				|| (frameNumb(x, y, 3) == 1 && frameNumb(x, y, 5) == 1 && frameNumb(
						x, y, 7) == 1)) {
			FrameActivity.setWinner(1);
			FrameStatus.resetFrame();
		} else {
			winAIMove(x, y); // winCheck();
			checkOWin(x, y); // check2();
			drawCheck(x, y); // drawCheck();
		}
	}

	public static void checkOWin(int x, int y) {
		drawCheck(x, y);
		if ((frameNumb(x, y, 1) == 2 && frameNumb(x, y, 2) == 2 && frameNumb(x,
				y, 3) == 2)
				|| (frameNumb(x, y, 4) == 2 && frameNumb(x, y, 5) == 2 && FrameStatus
						.getFrame(x, y, 6) == 2)
				|| (frameNumb(x, y, 7) == 2 && frameNumb(x, y, 8) == 2 && FrameStatus
						.getFrame(x, y, 9) == 2)
				|| (frameNumb(x, y, 1) == 2 && frameNumb(x, y, 5) == 2 && FrameStatus
						.getFrame(x, y, 9) == 2)
				|| (frameNumb(x, y, 1) == 2 && frameNumb(x, y, 4) == 2 && FrameStatus
						.getFrame(x, y, 7) == 2)
				|| (frameNumb(x, y, 2) == 2 && frameNumb(x, y, 5) == 2 && FrameStatus
						.getFrame(x, y, 8) == 2)
				|| (frameNumb(x, y, 3) == 2 && frameNumb(x, y, 6) == 2 && FrameStatus
						.getFrame(x, y, 9) == 2)
				|| (frameNumb(x, y, 3) == 2 && frameNumb(x, y, 5) == 2 && FrameStatus
						.getFrame(x, y, 7) == 2)) {
			FrameActivity.setWinner(2);
			FrameStatus.resetFrame();
		}
	}

	public static void drawCheck(int x, int y) {
		if (0 != frameNumb(x, y, 1) && 0 != frameNumb(x, y, 2)
				&& 0 != frameNumb(x, y, 3) && 0 != frameNumb(x, y, 4)
				&& 0 != frameNumb(x, y, 5) && 0 != frameNumb(x, y, 6)
				&& 0 != frameNumb(x, y, 7) && 0 != frameNumb(x, y, 8)
				&& 0 != frameNumb(x, y, 9)) {
			FrameActivity.setWinner(0);
			FrameStatus.resetFrame();
		}
	}

	public static void winAIMove(int x, int y) {
		checkOWin(x, y);
		int turn = StatusUpdate.currentTurn();
		if (2 == turn) {
			if (frameNumb(x, y, 1) == 2 && frameNumb(x, y, 2) == 2
					&& frameNumb(x, y, 3) == 0) {
				FrameStatus.setFrame(x, y, 3, 2);
				FrameActivity.playerSelected(3, 1, 2);
			} else if (frameNumb(x, y, 2) == 2 && frameNumb(x, y, 3) == 2
					&& frameNumb(x, y, 1) == 0) {
				FrameStatus.setFrame(x, y, 1, 2);
				FrameActivity.playerSelected(1, 1, 2);
			} else if (frameNumb(x, y, 4) == 2 && frameNumb(x, y, 5) == 2
					&& frameNumb(x, y, 6) == 0) {
				FrameStatus.setFrame(x, y, 6, 2);
				FrameActivity.playerSelected(6, 1, 2);
			} else if (frameNumb(x, y, 5) == 2 && frameNumb(x, y, 6) == 2
					&& frameNumb(x, y, 4) == 0) {
				FrameStatus.setFrame(x, y, 4, 2);
				FrameActivity.playerSelected(4, 1, 2);
			} else if (frameNumb(x, y, 7) == 2 && frameNumb(x, y, 8) == 2
					&& frameNumb(x, y, 9) == 0) {
				FrameStatus.setFrame(x, y, 9, 2);
				FrameActivity.playerSelected(9, 1, 2);
			} else if (frameNumb(x, y, 8) == 2 && frameNumb(x, y, 9) == 2
					&& frameNumb(x, y, 7) == 0) {
				FrameStatus.setFrame(x, y, 7, 2);
				FrameActivity.playerSelected(7, 1, 2);
			} else if (frameNumb(x, y, 1) == 2 && frameNumb(x, y, 5) == 2
					&& frameNumb(x, y, 9) == 0) {
				FrameStatus.setFrame(x, y, 9, 2);
				FrameActivity.playerSelected(9, 1, 2);
			} else if (frameNumb(x, y, 5) == 2 && frameNumb(x, y, 9) == 2
					&& frameNumb(x, y, 1) == 0) {
				FrameStatus.setFrame(x, y, 1, 2);
				FrameActivity.playerSelected(1, 1, 2);
			} else if (frameNumb(x, y, 3) == 2 && frameNumb(x, y, 5) == 2
					&& frameNumb(x, y, 7) == 0) {
				FrameStatus.setFrame(x, y, 7, 2);
				FrameActivity.playerSelected(7, 1, 2);
			} else if (frameNumb(x, y, 7) == 2 && frameNumb(x, y, 5) == 2
					&& frameNumb(x, y, 3) == 0) {
				FrameStatus.setFrame(x, y, 3, 2);
				FrameActivity.playerSelected(3, 1, 2);
			} else if (frameNumb(x, y, 1) == 2 && frameNumb(x, y, 3) == 2
					&& frameNumb(x, y, 2) == 0) {
				FrameStatus.setFrame(x, y, 2, 2);
				FrameActivity.playerSelected(2, 1, 2);
			} else if (frameNumb(x, y, 4) == 2 && frameNumb(x, y, 6) == 2
					&& frameNumb(x, y, 5) == 0) {
				FrameStatus.setFrame(x, y, 5, 2);
				FrameActivity.playerSelected(5, 1, 2);
			} else if (frameNumb(x, y, 7) == 2 && frameNumb(x, y, 9) == 2
					&& frameNumb(x, y, 8) == 0) {
				FrameStatus.setFrame(x, y, 8, 2);
				FrameActivity.playerSelected(8, 1, 2);
			} else if (frameNumb(x, y, 1) == 2 && frameNumb(x, y, 7) == 2
					&& frameNumb(x, y, 4) == 0) {
				FrameStatus.setFrame(x, y, 4, 2);
				FrameActivity.playerSelected(4, 1, 2);
			} else if (frameNumb(x, y, 2) == 2 && frameNumb(x, y, 8) == 2
					&& frameNumb(x, y, 5) == 0) {
				FrameStatus.setFrame(x, y, 5, 2);
				FrameActivity.playerSelected(5, 1, 2);
			} else if (frameNumb(x, y, 3) == 2 && frameNumb(x, y, 9) == 2
					&& frameNumb(x, y, 6) == 0) {
				FrameStatus.setFrame(x, y, 6, 2);
				FrameActivity.playerSelected(6, 1, 2);
			} else if (frameNumb(x, y, 1) == 2 && frameNumb(x, y, 5) == 2
					&& frameNumb(x, y, 9) == 0) {
				FrameStatus.setFrame(x, y, 9, 2);
				FrameActivity.playerSelected(9, 1, 2);
			} else if (frameNumb(x, y, 4) == 2 && frameNumb(x, y, 7) == 2
					&& frameNumb(x, y, 1) == 0) {
				FrameStatus.setFrame(x, y, 1, 2);
				FrameActivity.playerSelected(1, 1, 2);
			} else if (frameNumb(x, y, 5) == 2 && frameNumb(x, y, 8) == 2
					&& frameNumb(x, y, 2) == 0) {
				FrameStatus.setFrame(x, y, 2, 2);
				FrameActivity.playerSelected(2, 1, 2);
			} else if (frameNumb(x, y, 6) == 2 && frameNumb(x, y, 9) == 2
					&& frameNumb(x, y, 3) == 0) {
				FrameStatus.setFrame(x, y, 3, 2);
				FrameActivity.playerSelected(3, 1, 2);
			} else if (frameNumb(x, y, 1) == 2 && frameNumb(x, y, 4) == 2
					&& frameNumb(x, y, 7) == 0) {
				FrameStatus.setFrame(x, y, 7, 2);
				FrameActivity.playerSelected(7, 1, 2);
			} else if (frameNumb(x, y, 2) == 2 && frameNumb(x, y, 5) == 2
					&& frameNumb(x, y, 8) == 0) {
				FrameStatus.setFrame(x, y, 8, 2);
				FrameActivity.playerSelected(8, 1, 2);
			} else if (frameNumb(x, y, 3) == 2 && frameNumb(x, y, 6) == 2
					&& frameNumb(x, y, 9) == 0) {
				FrameStatus.setFrame(x, y, 9, 2);
				FrameActivity.playerSelected(9, 1, 2);
			} else if (frameNumb(x, y, 1) == 2 && frameNumb(x, y, 9) == 2
					&& frameNumb(x, y, 5) == 0) {
				FrameStatus.setFrame(x, y, 5, 2);
				FrameActivity.playerSelected(5, 1, 2);
			} else if (frameNumb(x, y, 3) == 2 && frameNumb(x, y, 7) == 2
					&& frameNumb(x, y, 5) == 0) {
				FrameStatus.setFrame(x, y, 5, 2);
				FrameActivity.playerSelected(5, 1, 2);
			} else {
				computer(x, y);
			}
		}
		checkOWin(x, y);
	}

	public static void computer(int x, int y) {
		checkOWin(x, y);
		int turn = StatusUpdate.currentTurn();
		if (2 == turn) {
			if (frameNumb(x, y, 1) == 1 && frameNumb(x, y, 2) == 1
					&& frameNumb(x, y, 3) == 0) {
				FrameStatus.setFrame(x, y, 3, 2);
				FrameActivity.playerSelected(3, 1, 2);
			} else if (frameNumb(x, y, 2) == 1 && frameNumb(x, y, 3) == 1
					&& frameNumb(x, y, 1) == 0) {
				FrameStatus.setFrame(x, y, 1, 2);
				FrameActivity.playerSelected(1, 1, 2);
			} else if (frameNumb(x, y, 4) == 1 && frameNumb(x, y, 5) == 1
					&& frameNumb(x, y, 6) == 0) {
				FrameStatus.setFrame(x, y, 6, 2);
				FrameActivity.playerSelected(6, 1, 2);
			} else if (frameNumb(x, y, 5) == 1 && frameNumb(x, y, 6) == 1
					&& frameNumb(x, y, 4) == 0) {
				FrameStatus.setFrame(x, y, 4, 2);
				FrameActivity.playerSelected(4, 1, 2);
			} else if (frameNumb(x, y, 7) == 1 && frameNumb(x, y, 8) == 1
					&& frameNumb(x, y, 9) == 0) {
				FrameStatus.setFrame(x, y, 9, 2);
				FrameActivity.playerSelected(9, 1, 2);
			} else if (frameNumb(x, y, 8) == 1 && frameNumb(x, y, 9) == 1
					&& frameNumb(x, y, 7) == 0) {
				FrameStatus.setFrame(x, y, 7, 2);
				FrameActivity.playerSelected(7, 1, 2);
			} else if (frameNumb(x, y, 1) == 1 && frameNumb(x, y, 5) == 1
					&& frameNumb(x, y, 9) == 0) {
				FrameStatus.setFrame(x, y, 9, 2);
				FrameActivity.playerSelected(9, 1, 2);
			} else if (frameNumb(x, y, 5) == 1 && frameNumb(x, y, 9) == 1
					&& frameNumb(x, y, 1) == 0) {
				FrameStatus.setFrame(x, y, 1, 2);
				FrameActivity.playerSelected(1, 1, 2);
			} else if (frameNumb(x, y, 3) == 1 && frameNumb(x, y, 5) == 1
					&& frameNumb(x, y, 7) == 0) {
				FrameStatus.setFrame(x, y, 7, 2);
				FrameActivity.playerSelected(7, 1, 2);
			} else if (frameNumb(x, y, 7) == 1 && frameNumb(x, y, 5) == 1
					&& frameNumb(x, y, 3) == 0) {
				FrameStatus.setFrame(x, y, 3, 2);
				FrameActivity.playerSelected(3, 1, 2);
			} else if (frameNumb(x, y, 1) == 1 && frameNumb(x, y, 3) == 1
					&& frameNumb(x, y, 2) == 0) {
				FrameStatus.setFrame(x, y, 2, 2);
				FrameActivity.playerSelected(2, 1, 2);
			} else if (frameNumb(x, y, 4) == 1 && frameNumb(x, y, 6) == 1
					&& frameNumb(x, y, 5) == 0) {
				FrameStatus.setFrame(x, y, 5, 2);
				FrameActivity.playerSelected(5, 1, 2);
			} else if (frameNumb(x, y, 7) == 1 && frameNumb(x, y, 9) == 1
					&& frameNumb(x, y, 8) == 0) {
				FrameStatus.setFrame(x, y, 8, 2);
				FrameActivity.playerSelected(8, 1, 2);
			} else if (frameNumb(x, y, 1) == 1 && frameNumb(x, y, 7) == 1
					&& frameNumb(x, y, 4) == 0) {
				FrameStatus.setFrame(x, y, 4, 2);
				FrameActivity.playerSelected(4, 1, 2);
			} else if (frameNumb(x, y, 2) == 1 && frameNumb(x, y, 8) == 1
					&& frameNumb(x, y, 5) == 0) {
				FrameStatus.setFrame(x, y, 5, 2);
				FrameActivity.playerSelected(5, 1, 2);
			} else if (frameNumb(x, y, 3) == 1 && frameNumb(x, y, 9) == 1
					&& frameNumb(x, y, 6) == 0) {
				FrameStatus.setFrame(x, y, 6, 2);
				FrameActivity.playerSelected(6, 1, 2);
			} else if (frameNumb(x, y, 1) == 1 && frameNumb(x, y, 5) == 1
					&& frameNumb(x, y, 9) == 0) {
				FrameStatus.setFrame(x, y, 9, 2);
				FrameActivity.playerSelected(9, 1, 2);
			} else if (frameNumb(x, y, 4) == 1 && frameNumb(x, y, 7) == 1
					&& frameNumb(x, y, 1) == 0) {
				FrameStatus.setFrame(x, y, 1, 2);
				FrameActivity.playerSelected(1, 1, 2);
			} else if (frameNumb(x, y, 5) == 1 && frameNumb(x, y, 8) == 1
					&& frameNumb(x, y, 2) == 0) {
				FrameStatus.setFrame(x, y, 2, 2);
				FrameActivity.playerSelected(2, 1, 2);
			} else if (frameNumb(x, y, 6) == 1 && frameNumb(x, y, 9) == 1
					&& frameNumb(x, y, 3) == 0) {
				FrameStatus.setFrame(x, y, 3, 2);
				FrameActivity.playerSelected(3, 1, 2);
			} else if (frameNumb(x, y, 1) == 1 && frameNumb(x, y, 4) == 1
					&& frameNumb(x, y, 7) == 0) {
				FrameStatus.setFrame(x, y, 7, 2);
				FrameActivity.playerSelected(7, 1, 2);
			} else if (frameNumb(x, y, 2) == 1 && frameNumb(x, y, 5) == 1
					&& frameNumb(x, y, 8) == 0) {
				FrameStatus.setFrame(x, y, 8, 2);
				FrameActivity.playerSelected(8, 1, 2);
			} else if (frameNumb(x, y, 3) == 1 && frameNumb(x, y, 6) == 1
					&& frameNumb(x, y, 9) == 0) {
				FrameStatus.setFrame(x, y, 9, 2);
				FrameActivity.playerSelected(9, 1, 2);
			} else if (frameNumb(x, y, 1) == 1 && frameNumb(x, y, 9) == 1
					&& frameNumb(x, y, 5) == 0) {
				FrameStatus.setFrame(x, y, 5, 2);
				FrameActivity.playerSelected(5, 1, 2);
			} else if (frameNumb(x, y, 3) == 1 && frameNumb(x, y, 7) == 1
					&& frameNumb(x, y, 5) == 0) {
				FrameStatus.setFrame(x, y, 5, 2);
				FrameActivity.playerSelected(5, 1, 2);
			} else {
				turnAI(x, y);
			}
		}
		checkOWin(x, y);
	}

	public static void turnAI(int x, int y) {
		int turn = StatusUpdate.currentTurn();

		if (turn == 2) {
			if (frameNumb(x, y, 5) == 0) {
				FrameStatus.setFrame(x, y, 5, 2);
				FrameActivity.playerSelected(5, 1, 2);
			} else if (frameNumb(x, y, 1) == 0) {
				FrameStatus.setFrame(x, y, 1, 2);
				FrameActivity.playerSelected(1, 1, 2);
			} else if (frameNumb(x, y, 9) == 0) {
				FrameStatus.setFrame(x, y, 9, 2);
				FrameActivity.playerSelected(9, 1, 2);
			} else if (frameNumb(x, y, 6) == 0) {
				FrameStatus.setFrame(x, y, 6, 2);
				FrameActivity.playerSelected(6, 1, 2);
			} else if (frameNumb(x, y, 2) == 0) {
				FrameStatus.setFrame(x, y, 2, 2);
				FrameActivity.playerSelected(2, 1, 2);
			} else if (frameNumb(x, y, 8) == 0) {
				FrameStatus.setFrame(x, y, 8, 2);
				FrameActivity.playerSelected(8, 1, 2);
			} else if (frameNumb(x, y, 3) == 0) {
				FrameStatus.setFrame(x, y, 3, 2);
				FrameActivity.playerSelected(3, 1, 2);
			} else if (frameNumb(x, y, 7) == 0) {
				FrameStatus.setFrame(x, y, 7, 2);
				FrameActivity.playerSelected(7, 1, 2);
			} else if (frameNumb(x, y, 4) == 0) {
				FrameStatus.setFrame(x, y, 4, 2);
				FrameActivity.playerSelected(4, 1, 2);
			}
		}
		checkOWin(x, y);
	}

	private static int frameNumb(int x, int y, int frame) {
		return FrameStatus.getFrame(x, y, frame);
	}
}
