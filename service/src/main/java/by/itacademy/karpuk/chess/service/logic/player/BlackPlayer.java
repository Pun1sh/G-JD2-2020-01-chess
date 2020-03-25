package by.itacademy.karpuk.chess.service.logic.player;

import java.util.Collection;

import by.itacademy.karpuk.chess.service.logic.Alliance;
import by.itacademy.karpuk.chess.service.logic.board.Board;
import by.itacademy.karpuk.chess.service.logic.board.Move;
import by.itacademy.karpuk.chess.service.logic.pieces.Piece;

public class BlackPlayer extends Player {

	public BlackPlayer(Board board, Collection<Move> whiteStandartLegalMoves,
			Collection<Move> blackStandartLegalMoves) {
		super(board, blackStandartLegalMoves, whiteStandartLegalMoves);
	}

	@Override
	public Collection<Piece> getActivePieces() {
		return this.board.getBlackPieces();
	}

	@Override
	public Alliance getAlliance() {
		return Alliance.BLACK;
	}

	@Override
	public Player getOpponent() {
		return this.board.whitePlayer();
	}

}
