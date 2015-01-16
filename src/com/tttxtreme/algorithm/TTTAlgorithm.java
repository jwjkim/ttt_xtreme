package com.tttxtreme.algorithm;

public class TTTAlgorithm {

	public void checkXWin(int x,int y) { // check();

		if ((frameNumb(x,y,1) == 1 && frameNumb(x,y,2) == 1 && frameNumb(x,y,3) == 1)
				|| (frameNumb(x,y,4) == 1 && frameNumb(x,y,5) == 1 && frameNumb(x,y,6) == 1)
				|| (frameNumb(x,y,7) == 1 && frameNumb(x,y,8) == 1 && frameNumb(x,y,9) == 1)
				|| (frameNumb(x,y,1) == 1 && frameNumb(x,y,5) == 1 && frameNumb(x,y,9) == 1)
				|| (frameNumb(x,y,1) == 1 && frameNumb(x,y,4) == 1 && frameNumb(x,y,7) == 1)
				|| (frameNumb(x,y,2) == 1 && frameNumb(x,y,5) == 1 && frameNumb(x,y,8) == 1)
				|| (frameNumb(x,y,3) == 1 && frameNumb(x,y,6) == 1 && frameNumb(x,y,9) == 1)
				|| (frameNumb(x,y,3) == 1 && frameNumb(x,y,5) == 1 && frameNumb(x,y,7) == 1)) {
			// user wins
			FrameStatus.resetFrame();
		} else {
			winAIMove(x,y); // winCheck();
			checkOWin(x,y); // check2();
			drawCheck(x,y); // drawCheck();
		}
	}

	public void checkOWin(int x,int y) {
		drawCheck(x,y);
		if ((frameNumb(x,y,1) == 2 && frameNumb(x,y,2) == 2 && frameNumb(x,y,3) == 2)
				|| (frameNumb(x,y,4) == 2 && frameNumb(x,y,5) == 2 && FrameStatus.getFrame(x,y,6) == 2)
				|| (frameNumb(x,y,7) == 2 && frameNumb(x,y,8) == 2 && FrameStatus.getFrame(x,y,9) == 2)
				|| (frameNumb(x,y,1) == 2 && frameNumb(x,y,5) == 2 && FrameStatus.getFrame(x,y,9) == 2)
				|| (frameNumb(x,y,1) == 2 && frameNumb(x,y,4) == 2 && FrameStatus.getFrame(x,y,7) == 2)
				|| (frameNumb(x,y,2) == 2 && frameNumb(x,y,5) == 2 && FrameStatus.getFrame(x,y,8) == 2)
				|| (frameNumb(x,y,3) == 2 && frameNumb(x,y,6) == 2 && FrameStatus.getFrame(x,y,9) == 2)
				|| (frameNumb(x,y,3) == 2 && frameNumb(x,y,5) == 2 && FrameStatus.getFrame(x,y,7) == 2)) {
			// cpu wins
			FrameStatus.resetFrame();
		}
	}

	public void drawCheck(int x,int y) {
		if (0 != frameNumb(x,y,1) && 0 != frameNumb(x,y,2) && 0 != frameNumb(x,y,3)
				&& 0 != frameNumb(x,y,4) && 0 != frameNumb(x,y,5) && 0 != frameNumb(x,y,6)
				&& 0 != frameNumb(x,y,7) && 0 != frameNumb(x,y,8) && 0 != frameNumb(x,y,9)) {
			FrameStatus.resetFrame();
		}
	}

	public void winAIMove(int x,int y) {
		checkOWin(x,y);
		int turn = StatusUpdate.currentTurn();
		if (2 == turn) {
			if (frameNumb(x,y,1) == 2 && frameNumb(x,y,2) == 2 && frameNumb(x,y,3) == 0) {
				FrameStatus.setFrame(x,y,3,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,2) == 2 && frameNumb(x,y,3) == 2 && frameNumb(x,y,1) == 0) {
				FrameStatus.setFrame(x,y,1,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,4) == 2 && frameNumb(x,y,5) == 2 && frameNumb(x,y,6) == 0) {
				FrameStatus.setFrame(x,y,6,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,5) == 2 && frameNumb(x,y,6) == 2 && frameNumb(x,y,4) == 0) {
				FrameStatus.setFrame(x,y,4,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,7) == 2 && frameNumb(x,y,8) == 2 && frameNumb(x,y,9) == 0) {
				FrameStatus.setFrame(x,y,9,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,8) == 2 && frameNumb(x,y,9) == 2 && frameNumb(x,y,7) == 0) {
				FrameStatus.setFrame(x,y,7,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,1) == 2 && frameNumb(x,y,5) == 2 && frameNumb(x,y,9) == 0) {
				FrameStatus.setFrame(x,y,9,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,5) == 2 && frameNumb(x,y,9) == 2 && frameNumb(x,y,1) == 0) {
				FrameStatus.setFrame(x,y,1,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,3) == 2 && frameNumb(x,y,5) == 2 && frameNumb(x,y,7) == 0) {
				FrameStatus.setFrame(x,y,7,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,7) == 2 && frameNumb(x,y,5) == 2 && frameNumb(x,y,3) == 0) {
				FrameStatus.setFrame(x,y,3,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,1) == 2 && frameNumb(x,y,3) == 2 && frameNumb(x,y,2) == 0) {
				FrameStatus.setFrame(x,y,2,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,4) == 2 && frameNumb(x,y,6) == 2 && frameNumb(x,y,5) == 0) {
				FrameStatus.setFrame(x,y,5,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,7) == 2 && frameNumb(x,y,9) == 2 && frameNumb(x,y,8) == 0) {
				FrameStatus.setFrame(x,y,8,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,1) == 2 && frameNumb(x,y,7) == 2 && frameNumb(x,y,4) == 0) {
				FrameStatus.setFrame(x,y,4,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,2) == 2 && frameNumb(x,y,8) == 2 && frameNumb(x,y,5) == 0) {
				FrameStatus.setFrame(x,y,5,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,3) == 2 && frameNumb(x,y,9) == 2 && frameNumb(x,y,6) == 0) {
				FrameStatus.setFrame(x,y,6,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,1) == 2 && frameNumb(x,y,5) == 2 && frameNumb(x,y,9) == 0) {
				FrameStatus.setFrame(x,y,9,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,4) == 2 && frameNumb(x,y,7) == 2 && frameNumb(x,y,1) == 0) {
				FrameStatus.setFrame(x,y,1,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,5) == 2 && frameNumb(x,y,8) == 2 && frameNumb(x,y,2) == 0) {
				FrameStatus.setFrame(x,y,2,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,6) == 2 && frameNumb(x,y,9) == 2 && frameNumb(x,y,3) == 0) {
				FrameStatus.setFrame(x,y,3,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,1) == 2 && frameNumb(x,y,4) == 2 && frameNumb(x,y,7) == 0) {
				FrameStatus.setFrame(x,y,7,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,2) == 2 && frameNumb(x,y,5) == 2 && frameNumb(x,y,8) == 0) {
				FrameStatus.setFrame(x,y,8,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,3) == 2 && frameNumb(x,y,6) == 2 && frameNumb(x,y,9) == 0) {
				FrameStatus.setFrame(x,y,9,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,1) == 2 && frameNumb(x,y,9) == 2 && frameNumb(x,y,5) == 0) {
				FrameStatus.setFrame(x,y,5,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,3) == 2 && frameNumb(x,y,7) == 2 && frameNumb(x,y,5) == 0) {
				FrameStatus.setFrame(x,y,5,2);
				StatusUpdate.changeTurn(1);
			} else {
				computer(x,y);
			}
		}
		checkOWin(x,y);
	}

	public void computer(int x,int y) {
		checkOWin(x,y);
		int turn = StatusUpdate.currentTurn();
		if (2 == turn) {
			if (frameNumb(x,y,1) == 1 && frameNumb(x,y,2) == 1 && frameNumb(x,y,3) == 0) {
				FrameStatus.setFrame(x,y,3,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,2) == 1 && frameNumb(x,y,3) == 1 && frameNumb(x,y,1) == 0) {
				FrameStatus.setFrame(x,y,1,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,4) == 1 && frameNumb(x,y,5) == 1 && frameNumb(x,y,6) == 0) {
				FrameStatus.setFrame(x,y,6,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,5) == 1 && frameNumb(x,y,6) == 1 && frameNumb(x,y,4) == 0) {
				FrameStatus.setFrame(x,y,4,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,7) == 1 && frameNumb(x,y,8) == 1 && frameNumb(x,y,9) == 0) {
				FrameStatus.setFrame(x,y,9,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,8) == 1 && frameNumb(x,y,9) == 1 && frameNumb(x,y,7) == 0) {
				FrameStatus.setFrame(x,y,7,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,1) == 1 && frameNumb(x,y,5) == 1 && frameNumb(x,y,9) == 0) {
				FrameStatus.setFrame(x,y,9,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,5) == 1 && frameNumb(x,y,9) == 1 && frameNumb(x,y,1) == 0) {
				FrameStatus.setFrame(x,y,1,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,3) == 1 && frameNumb(x,y,5) == 1 && frameNumb(x,y,7) == 0) {
				FrameStatus.setFrame(x,y,7,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,7) == 1 && frameNumb(x,y,5) == 1 && frameNumb(x,y,3) == 0) {
				FrameStatus.setFrame(x,y,3,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,1) == 1 && frameNumb(x,y,3) == 1 && frameNumb(x,y,2) == 0) {
				FrameStatus.setFrame(x,y,2,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,4) == 1 && frameNumb(x,y,6) == 1 && frameNumb(x,y,5) == 0) {
				FrameStatus.setFrame(x,y,5,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,7) == 1 && frameNumb(x,y,9) == 1 && frameNumb(x,y,8) == 0) {
				FrameStatus.setFrame(x,y,8,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,1) == 1 && frameNumb(x,y,7) == 1 && frameNumb(x,y,4) == 0) {
				FrameStatus.setFrame(x,y,4,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,2) == 1 && frameNumb(x,y,8) == 1 && frameNumb(x,y,5) == 0) {
				FrameStatus.setFrame(x,y,5,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,3) == 1 && frameNumb(x,y,9) == 1 && frameNumb(x,y,6) == 0) {
				FrameStatus.setFrame(x,y,6,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,1) == 1 && frameNumb(x,y,5) == 1 && frameNumb(x,y,9) == 0) {
				FrameStatus.setFrame(x,y,9,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,4) == 1 && frameNumb(x,y,7) == 1 && frameNumb(x,y,1) == 0) {
				FrameStatus.setFrame(x,y,1,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,5) == 1 && frameNumb(x,y,8) == 1 && frameNumb(x,y,2) == 0) {
				FrameStatus.setFrame(x,y,2,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,6) == 1 && frameNumb(x,y,9) == 1 && frameNumb(x,y,3) == 0) {
				FrameStatus.setFrame(x,y,3,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,1) == 1 && frameNumb(x,y,4) == 1 && frameNumb(x,y,7) == 0) {
				FrameStatus.setFrame(x,y,7,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,2) == 1 && frameNumb(x,y,5) == 1 && frameNumb(x,y,8) == 0) {
				FrameStatus.setFrame(x,y,8,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,3) == 1 && frameNumb(x,y,6) == 1 && frameNumb(x,y,9) == 0) {
				FrameStatus.setFrame(x,y,9,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,1) == 1 && frameNumb(x,y,9) == 1 && frameNumb(x,y,5) == 0) {
				FrameStatus.setFrame(x,y,5,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,3) == 1 && frameNumb(x,y,7) == 1 && frameNumb(x,y,5) == 0) {
				FrameStatus.setFrame(x,y,5,2);
				StatusUpdate.changeTurn(1);
			} else {
				turnAI(x,y);
			}
		}
		checkOWin(x,y);
	}

	public void turnAI(int x,int y) {
		int turn = StatusUpdate.currentTurn();

		if (turn == 2) {
			if (frameNumb(x,y,5) == 0) {
				FrameStatus.setFrame(x,y,5,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,1) == 0) {
				FrameStatus.setFrame(x,y,1,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,9) == 0) {
				FrameStatus.setFrame(x,y,9,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,6) == 0) {
				FrameStatus.setFrame(x,y,6,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,2) == 0) {
				FrameStatus.setFrame(x,y,2,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,8) == 0) {
				FrameStatus.setFrame(x,y,8,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,3) == 0) {
				FrameStatus.setFrame(x,y,3,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,7) == 0) {
				FrameStatus.setFrame(x,y,7,2);
				StatusUpdate.changeTurn(1);
			} else if (frameNumb(x,y,4) == 0) {
				FrameStatus.setFrame(x,y,4,2);
				StatusUpdate.changeTurn(1);
			}
		}
		checkOWin(x,y);
	}

	private int frameNumb(int x,int y,int frame) {
		return FrameStatus.getFrame(x,y,frame);
	}
}
