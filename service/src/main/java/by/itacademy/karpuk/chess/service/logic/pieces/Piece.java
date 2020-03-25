package by.itacademy.karpuk.chess.service.logic.pieces;

import java.util.Collection;

import by.itacademy.karpuk.chess.service.logic.Alliance;
import by.itacademy.karpuk.chess.service.logic.board.Board;
import by.itacademy.karpuk.chess.service.logic.board.Move;

public abstract class Piece {
	protected final int piecePosition;
	protected final Alliance pieceAlliance;
	protected final boolean isFirstMove;

	Piece(final Alliance pieceAlliance, final int piecePosition) {
		this.pieceAlliance = pieceAlliance;
		this.piecePosition = piecePosition;
		this.isFirstMove = false;

	}

	public int getPiecePosition() {
		return this.piecePosition;
	}

	public Alliance getPieceAlliance() {
		return this.pieceAlliance;
	}

	public boolean isFirstMove() {
		return this.isFirstMove;

	}

	public abstract Collection<Move> calculateLegalMoves(final Board board);

	public enum PieceType {

		PAWN("P"),

		KNIGHT("N"),

		BISHOP("B"),

		ROOK("R"),

		QUEEN("Q"),

		KING("K");

		private final String pieceName;

		@Override
		public String toString() {
			return this.pieceName;
		}

		PieceType(final String pieceName) {
			this.pieceName = pieceName;
		}
	}
}
