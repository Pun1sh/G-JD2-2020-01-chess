package by.itacademy.karpuk.chess.service.logic.player;

import java.util.Collection;

import by.itacademy.karpuk.chess.service.logic.Alliance;
import by.itacademy.karpuk.chess.service.logic.board.Board;
import by.itacademy.karpuk.chess.service.logic.board.Move;
import by.itacademy.karpuk.chess.service.logic.pieces.Piece;

public class WhitePlayer extends Player {

	public WhitePlayer(Board board, Collection<Move> whiteStandartLegalMoves,
			Collection<Move> blackStandartLegalMoves) {
		super(board, whiteStandartLegalMoves, blackStandartLegalMoves);
	}

	@Override
	public Collection<Piece> getActivePieces() {
		return this.board.getWhitePieces();
	}

	@Override
	public Alliance getAlliance() {
		return Alliance.WHITE;
	}

	@Override
	public Player getOpponent() {
		return this.board.blackPlayer();
	}

}
