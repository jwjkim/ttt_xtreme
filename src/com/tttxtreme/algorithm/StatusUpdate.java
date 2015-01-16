package com.tttxtreme.algorithm;

public class StatusUpdate {
	
	static int player;

	static int currentTurn() {
		return player;
	}
	
	public static void changeTurn(int turn) {
		player = turn;
	}

}
