package by.itacademy.karpuk.chess.dao.api.entity.enums;

public enum Piece {

	w_pawn1(PieceColor.white), w_pawn2(PieceColor.white), w_pawn3(PieceColor.white), w_pawn4(PieceColor.white),
	w_pawn5(PieceColor.white), w_pawn6(PieceColor.white), w_pawn7(PieceColor.white), w_pawn8(PieceColor.white),
	w_king(PieceColor.white), w_queen(PieceColor.white), w_knight(PieceColor.white), w_bishop(PieceColor.white),
	w_rook(PieceColor.white),

	b_pawn1(PieceColor.black), b_pawn2(PieceColor.black), b_pawn3(PieceColor.black), b_pawn4(PieceColor.black),
	b_pawn5(PieceColor.black), b_pawn6(PieceColor.black), b_pawn7(PieceColor.black), b_pawn8(PieceColor.black),
	b_king(PieceColor.black), b_queen(PieceColor.black), b_knight(PieceColor.black), b_bishop(PieceColor.black),
	b_rook(PieceColor.black);

	private PieceColor color;

	Piece(PieceColor color) {
		this.color = color;
	}

	public PieceColor getColor() {
		return color;
	}

}
