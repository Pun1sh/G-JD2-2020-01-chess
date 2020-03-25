package by.itacademy.karpuk.chess.service.logic.player;

import java.util.Collection;

import by.itacademy.karpuk.chess.service.logic.Alliance;
import by.itacademy.karpuk.chess.service.logic.board.Board;
import by.itacademy.karpuk.chess.service.logic.board.Move;
import by.itacademy.karpuk.chess.service.logic.pieces.King;
import by.itacademy.karpuk.chess.service.logic.pieces.Piece;

public abstract class Player {
	protected final Board board;
	protected final King playerKing;
	protected final Collection<Move> legalMoves;

	Player(Board board, Collection<Move> legalMoves, Collection<Move> opponentMoves) {
		this.board = board;
		this.playerKing = establishKing();
		this.legalMoves = legalMoves;
	}

	private King establishKing() {
		for (Piece piece : getActivePieces()) {
			if (piece.getPieceType().isKing()) {
				return (King) piece;

			}
		}
		throw new RuntimeException();

	}

	public boolean isMoveLegal(final Move move) {
		return this.legalMoves.contains(move);
	}

	public boolean isInCheck() {
		return false;
	}

	public boolean isInCheckMate() {
		return false;
	}

	public boolean isInStaleMate() {
		return false;
	}

	public boolean isCastled() {
		return false;
	}

	public MoveTransition makeMove(final Move move) {
		return null;
	}

	public abstract Collection<Piece> getActivePieces();

	public abstract Alliance getAlliance();

	public abstract Player getOpponent();
}
