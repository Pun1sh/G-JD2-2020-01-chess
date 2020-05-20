package by.itacademy.karpuk.chess.web.dto;

public class BoardDTO {
	private Integer gameId;
	private String fen;

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public String getFen() {
		return fen;
	}

	public void setFen(String fen) {
		this.fen = fen;
	}
}
