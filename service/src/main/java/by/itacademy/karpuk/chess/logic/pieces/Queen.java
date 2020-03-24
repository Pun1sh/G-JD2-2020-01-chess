package by.itacademy.karpuk.chess.logic.pieces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.collect.ImmutableList;

import by.itacademy.karpuk.chess.logic.Alliance;
import by.itacademy.karpuk.chess.logic.board.Board;
import by.itacademy.karpuk.chess.logic.board.BoardUtils;
import by.itacademy.karpuk.chess.logic.board.Move;
import by.itacademy.karpuk.chess.logic.board.Tile;

public class Queen extends Piece {
	private final static int[] CANDIDATE_MOVE_VECTOR_COORDINATES = { -9, -8, -7, -1, 1, 7, 8, 9 };

	public Queen(final Alliance pieceAlliance, final int piecePosition) {
		super(pieceAlliance, piecePosition);
	}

	@Override
	public Collection<Move> calculateLegalMoves(Board board) {
		final List<Move> legalMoves = new ArrayList<>();
		for (int candidateCoordinateOffset : CANDIDATE_MOVE_VECTOR_COORDINATES) {
			int candidateDestinationCoordinate = this.piecePosition;
			while (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
				if (isFirstColumnExclusion(candidateDestinationCoordinate, candidateCoordinateOffset)
						|| isEighthColumnExclusion(candidateDestinationCoordinate, candidateCoordinateOffset)) {
					break;
				}
				candidateDestinationCoordinate += candidateCoordinateOffset;
				if (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
					final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
					if (!candidateDestinationTile.isTileOccupied()) {
						legalMoves.add(new Move.MajorMove(board, this, candidateDestinationCoordinate));

					} else {
						final Piece pieceAtDestination = candidateDestinationTile.getPiece();
						final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();
						if (this.pieceAlliance != pieceAlliance) {
							legalMoves.add(new Move.AttackMove(board, this, candidateDestinationCoordinate,
									pieceAtDestination));
						}
						break;
					}

				}
			}
		}
		return ImmutableList.copyOf(legalMoves);
	}

	@Override
	public String toString() {
		return PieceType.QUEEN.toString();
	}

	private static boolean isFirstColumnExclusion(final int currentPosition, final int candidateOffset) {
		return BoardUtils.FIRST_COLUMN[currentPosition]
				&& (candidateOffset == -1 || candidateOffset == -9 || candidateOffset == 7);
	}

	private static boolean isEighthColumnExclusion(final int currentPosition, final int candidateOffset) {
		return BoardUtils.EIGHTH_COLUMN[currentPosition]
				&& (currentPosition == -7 || currentPosition == 1 || currentPosition == 9);
	}

}
