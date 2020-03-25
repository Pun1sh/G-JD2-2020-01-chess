package by.itacademy.karpuk.chess.service.logic;

import by.itacademy.karpuk.chess.service.logic.board.Board;

public class JChess {
	public static void main(String[] args) {
		Board board = Board.createStandardBoard();
		System.out.println(board.toString());
	}
}
