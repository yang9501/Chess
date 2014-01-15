import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class BoardTest {
	
	public void boardInit(Board b) {
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				b.chessBoard[x][y] = new Square(b, new Point(x, y));
			}
		}
	}

	

	@Test
	public void testTestSelfCheck() {
		Board test = new Board(false);
		boardInit(test);
		
		Piece king = new King(test.chessBoard[0][0], "white");
		Piece moverRook = new Rook(test.chessBoard[1][0], "white");
		Piece threatenerRook = new Rook(test.chessBoard[5][0], "black");
		
		test.chessBoard[0][0].setOccupier(king);
		test.chessBoard[1][0].setOccupier(moverRook);
		test.chessBoard[5][0].setOccupier(threatenerRook);
		
		assertTrue(test.testSelfCheck(test.getSquare(1, 0), test.getSquare(1, 1)));
		assertTrue(test.chessBoard[1][0].getOccupier().equals(moverRook));  //testPiece is moved back to original position
		assertTrue(test.chessBoard[1][1].getOccupier() == null);			//position where the test Piece was tested is restored
	}

	@Test
	public void testGetSquareIntInt() {
		Board test = new Board(false);
		boardInit(test);
		
		assertNull(test.getSquare(0, 8));
		assertNull(test.getSquare(3, 3).getOccupier());
		
		Piece king = new King(test.chessBoard[3][3], "white");
		test.chessBoard[3][3].setOccupier(king);
		
		assertTrue(test.getSquare(3, 3).getOccupier().getClass().equals(King.class));
	}

	@Test
	public void testIsChecked() {
		Board test = new Board(false);
		boardInit(test);
		
		Piece king = new King(test.chessBoard[0][0], "white");
		test.chessBoard[0][0].setOccupier(king);
		
		assertFalse(test.isChecked("white"));
		
		Piece threatenerRook = new Rook(test.chessBoard[5][0], "black");
		test.chessBoard[5][0].setOccupier(threatenerRook);
		
		assertTrue(test.isChecked("white"));
	}

	@Test
	public void testHasMoves() {
		Board test = new Board(false);
		boardInit(test);
		
		Piece king = new King(test.chessBoard[0][0], "white");
		test.chessBoard[0][0].setOccupier(king);
		
		assertTrue(test.hasMoves("white"));
		
		Piece threatenerRook1 = new Rook(test.chessBoard[1][1], "black");
		test.chessBoard[1][1].setOccupier(threatenerRook1);
		
		assertTrue(test.hasMoves("white"));
		
		test.chessBoard[1][1].setOccupier(null);
		Piece threatenerRook2 = new Rook(test.chessBoard[1][7], "black");
		test.chessBoard[1][7].setOccupier(threatenerRook2);
		Piece threatenerRook3 = new Rook(test.chessBoard[7][1], "black");
		test.chessBoard[7][1].setOccupier(threatenerRook3);
		
		assertFalse(test.hasMoves("white"));
		
		Piece whiteKnight = new Knight(test.chessBoard[3][3], "white");
		test.chessBoard[3][3].setOccupier(whiteKnight);	
		
		assertTrue(test.hasMoves("white"));
	}

	@Test
	public void testKingLocation() {
		Board test = new Board(false);
		boardInit(test);
		
		Piece king = new King(test.chessBoard[0][0], "white");
		test.chessBoard[0][0].setOccupier(king);
		assertFalse(test.kingLocation("white").equals(new Point(1, 1)));
		assertFalse(test.kingLocation("black").equals(new Point(0, 0)));
		assertTrue(test.kingLocation("white").equals(new Point(0, 0)));
	}

	@Test
	public void testEndGameStatus() {
		Board test = new Board(false);
		boardInit(test);
		
		Piece king = new King(test.chessBoard[0][0], "white");
		test.chessBoard[0][0].setOccupier(king);
		
		assertFalse(test.isStalemate("white"));
		assertFalse(test.isCheckmate("white"));
		
		Piece threatenerRook1 = new Rook(test.chessBoard[1][7], "black");
		test.chessBoard[1][7].setOccupier(threatenerRook1);
		Piece threatenerRook2 = new Rook(test.chessBoard[7][1], "black");
		test.chessBoard[7][1].setOccupier(threatenerRook2);
		
		assertTrue(test.isStalemate("white"));
		
		Piece threatenerRook3 = new Rook(test.chessBoard[7][0], "black");
		test.chessBoard[7][0].setOccupier(threatenerRook3);
		
		assertTrue(test.isCheckmate("white"));
	}

}
