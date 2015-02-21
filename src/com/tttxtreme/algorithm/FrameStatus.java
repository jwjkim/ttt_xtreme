package com.tttxtreme.algorithm;

public class FrameStatus {
	static int[][][] frame;

	public void initFrame() {
		resetFrame();
	}

	public static void resetFrame() {
		frame = new int[4][4][10];
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				for (int z = 0; z < 10; z++) {
					frame[x][y][z] = 0;
				}
			}
		}
	}

	public static int getFrame(int x, int y, int z) {
		return frame[x][y][z];
	}

	// change = 0 (X)
	// change = 1 (O)
	// change = 2 (empty)
	public static void setFrame(int x, int y, int z, int set) {
		frame[x][y][z] = set;
	}
}
