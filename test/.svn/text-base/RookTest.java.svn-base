import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;


public class RookTest {
	public void boardInit(Board b) {
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				b.chessBoard[x][y] = new Square(b, new Point(x, y));
			}
		}
	}
	
	
	@Test
	public void testLeft() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Rook(test.chessBoard[3][3], "white");
		
		test.chessBoard[3][3].setOccupier(p);
		
		assertTrue("Left", test.move(new Point(3, 3), new Point(1, 3)));
	
	}
	
	@Test
	public void testRight() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Rook(test.chessBoard[3][3], "white");
		
		test.chessBoard[3][3].setOccupier(p);
		
		assertTrue("Right", test.move(new Point(3, 3), new Point(5, 3)));
	
	}
	
	@Test
	public void testDown() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Rook(test.chessBoard[3][3], "white");
		
		test.chessBoard[3][3].setOccupier(p);
		
		assertTrue("Down", test.move(new Point(3, 3), new Point(3, 1)));
	
	}
	
	@Test
	public void testUp() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Rook(test.chessBoard[3][3], "white");
		
		test.chessBoard[3][3].setOccupier(p);
		
		assertTrue("Up", test.move(new Point(3, 3), new Point(3, 5)));
	
	}
	
	@Test
	public void testOutOfBoundsMove() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Rook(test.chessBoard[0][7], "white");
		
		test.chessBoard[0][7].setOccupier(p);
		
		assertFalse("DiagOutOfBoundsMove", test.move(new Point(0, 7), new Point(0, 9)));
	
	}
	
	@Test
	public void testAttackEnemy() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Rook(test.chessBoard[3][3], "white");
		Piece enemy = new Rook(test.chessBoard[3][5], "black");
		
		test.chessBoard[3][3].setOccupier(p);
		test.chessBoard[3][5].setOccupier(enemy);
		
		assertTrue("AttackEnemy", test.move(new Point(3, 3), new Point(3, 5)));
	
	}
	
	@Test
	public void testAttackFriendly() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Rook(test.chessBoard[3][3], "white");
		Piece friendly = new Rook(test.chessBoard[3][5], "white");
		
		test.chessBoard[3][3].setOccupier(p);
		test.chessBoard[3][5].setOccupier(friendly);
		
		assertFalse("AttackFriendly", test.move(new Point(3, 3), new Point(3, 5)));
	
	}
	
}
