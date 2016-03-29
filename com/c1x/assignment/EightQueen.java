package com.c1x.assignment;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EightQueen {

	public static void main(String[] args) throws Exception {
		System.out.println("Enter board configuration:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		QueenBoard test = new QueenBoard(8);
		test.setToGoal(input);
		boolean testGoal = test.canAttack(test.getQueens());
		if (testGoal) {
			System.out.println("No queens attack each other!");
		} else {
			System.out.println("Queens attack each other!");
		}
	}

	public static class QueenBoard {
		private int[][] board;
		private int[] queens;
		private int nSize = 0;

		public QueenBoard(int n) {
			board = new int[n][n];
			queens = new int[n];
			nSize = n;
		}

		private void setToGoal(int input) {
			for (int i = 7; i >= 0; i--) {
				queens[i] = input % 10;
				input = input / 10;
			}
			this.convertQueensToBoard();
		}

		private int[] getQueens() {
			return queens;
		}

		private boolean canAttackDiagonally(int row, int col) {
			int i = 0, j = 0, k = 0;
			for (i = row + 1, j = col + 1; i < nSize && j < nSize; i++, j++) {
				if (board[i][j] == 1) {
					return true;
				}
			}
			
			for (i = row - 1, j = col + 1; i >= 0 && j < nSize; i--, j++) {
				if (board[i][j] == 1) {
					return true;
				}
			}
			
			for (i = row + 1, k = col - 1; i < nSize && k >= 0; i++, k--) {
				if (board[i][k] == 1) {
					return true;
				}
			}
			
			for (i = row - 1, k = col - 1; i >= 0 && k >= 0; i--, k--) {
				if (board[i][k] == 1) {
					return true;
				}
			}
			return false;
		}

		private boolean canAttack(int[] state) {
			boolean goal = false;
			if (isSameColumn(state)) {
				return goal;
			}
			for (int i = 0; i < nSize; i++) {
				if (canAttackDiagonally(i, state[i])) { // returns true means queen can attack
					return goal;
				}
			}
			return true;
		}

		private boolean isSameColumn(int[] state) {
			for (int i = 0; i < nSize; i++) {
				for (int j = i + 1; j < nSize; j++) {
					if (state[i] == state[j]) {
						return true;
					}
				}
			}
			return false;

		}

		private void convertQueensToBoard() {
			for (int i = 0; i < nSize; i++) {
				for (int j = 0; j < nSize; j++) {
					if (queens[i] == j)
						board[i][j] = 1;
					else
						board[i][j] = 0;
				}
			}
		}
	}

}