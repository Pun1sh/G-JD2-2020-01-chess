package by.itacademy.karpuk.chess.service.logic.pieces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.collect.ImmutableList;

import by.itacademy.karpuk.chess.service.logic.Alliance;
import by.itacademy.karpuk.chess.service.logic.board.Board;
import by.itacademy.karpuk.chess.service.logic.board.BoardUtils;
import by.itacademy.karpuk.chess.service.logic.board.Move;

public class Pawn extends Piece {
	private final static int[] CANDIDATE_MOVE_COORDINATE = { 8, 16, 7, 9 };

	public Pawn(final Alliance pieceAlliance, final int piecePosition) {
		super(PieceType.PAWN, pieceAlliance, piecePosition);
	}

	@Override
	public Collection<Move> calculateLegalMoves(Board board) {
		final List<Move> legalMoves = new ArrayList<>();
		for (int currentCandidateOffset : CANDIDATE_MOVE_COORDINATE) {
			int candidateDestinationCoordinate = this.piecePosition
					+ (this.getPieceAlliance().getDirection() * currentCandidateOffset);
			if (!BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
				continue;
			}
			if (currentCandidateOffset == 8 && !board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
				legalMoves.add(new Move.MajorMove(board, this, candidateDestinationCoordinate));
			} else if (currentCandidateOffset == 16 && this.isFirstMove()
					&& (BoardUtils.SECOND_ROW[this.piecePosition] && this.getPieceAlliance().isBlack())
					&& (BoardUtils.SEVENTH_ROW[this.piecePosition] && this.getPieceAlliance().isWhite())) {
				final int behindCandidateDestinationCoordinate = this.piecePosition
						+ (this.pieceAlliance.getDirection() + 8);
				if (!board.getTile(behindCandidateDestinationCoordinate).isTileOccupied()
						&& !board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
					legalMoves.add(new Move.MajorMove(board, this, candidateDestinationCoordinate));

				}

			} else if (currentCandidateOffset == 7
					&& !((BoardUtils.EIGHTH_COLUMN[this.piecePosition] && this.pieceAlliance.isWhite()
							|| (BoardUtils.FIRST_COLUMN[this.piecePosition] && this.pieceAlliance.isBlack())))) {
				if (board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
					final Piece pieceOnCandidate = board.getTile(candidateDestinationCoordinate).getPiece();
					if (this.pieceAlliance != pieceOnCandidate.getPieceAlliance()) {
						legalMoves.add(new Move.MajorMove(board, this, candidateDestinationCoordinate));

					}

				}

			} else if (currentCandidateOffset == 9
					&& !((BoardUtils.FIRST_COLUMN[this.piecePosition] && this.pieceAlliance.isWhite()
							|| (BoardUtils.EIGHTH_COLUMN[this.piecePosition] && this.pieceAlliance.isBlack())))) {
				if (board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
					final Piece pieceOnCandidate = board.getTile(candidateDestinationCoordinate).getPiece();
					if (this.pieceAlliance != pieceOnCandidate.getPieceAlliance()) {
						legalMoves.add(new Move.MajorMove(board, this, candidateDestinationCoordinate));

					}

				}
			}
		}

		return ImmutableList.copyOf(legalMoves);
	}

	@Override
	public String toString() {
		return PieceType.PAWN.toString();
	}

}