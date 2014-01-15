import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;


public class KnightTest {

	public void boardInit(Board b) {
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				b.chessBoard[x][y] = new Square(b, new Point(x, y));
			}
		}
	}
	
	@Test
	public void testUpRight1() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Knight(test.chessBoard[3][3], "white");
		
		test.chessBoard[3][3].setOccupier(p);
		
		assertTrue("UpRight1", test.move(new Point(3, 3), new Point(4, 5)));
	
	}
	
	@Test
	public void testUpRight2() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Knight(test.chessBoard[3][3], "white");
		
		test.chessBoard[3][3].setOccupier(p);
		
		assertTrue("UpRight2", test.move(new Point(3, 3), new Point(5, 4)));
	
	}
	
	@Test
	public void testDownRight1() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Knight(test.chessBoard[3][3], "white");
		
		test.chessBoard[3][3].setOccupier(p);
		
		assertTrue("DownRight1", test.move(new Point(3, 3), new Point(2, 5)));
	
	}
	
	@Test
	public void testDownRight2() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Knight(test.chessBoard[3][3], "white");
		
		test.chessBoard[3][3].setOccupier(p);
		
		assertTrue("DownRight2", test.move(new Point(3, 3), new Point(1, 4)));
	
	}
	
	@Test
	public void testDownLeft1() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Knight(test.chessBoard[3][3], "white");
		
		test.chessBoard[3][3].setOccupier(p);
		
		assertTrue("DownLeft1", test.move(new Point(3, 3), new Point(1, 2)));
	
	}
	
	@Test
	public void testDownLeft2() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Knight(test.chessBoard[3][3], "white");
		
		test.chessBoard[3][3].setOccupier(p);
		
		assertTrue("DownLeft2", test.move(new Point(3, 3), new Point(2, 1)));
	
	}
	
	@Test
	public void testUpLeft1() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Knight(test.chessBoard[3][3], "white");
		
		test.chessBoard[3][3].setOccupier(p);
		
		assertTrue("UpLeft1", test.move(new Point(3, 3), new Point(4, 1)));
	
	}
	
	@Test
	public void testUpLeft2() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Knight(test.chessBoard[3][3], "white");
		
		test.chessBoard[3][3].setOccupier(p);
		
		assertTrue("UpLeft2", test.move(new Point(3, 3), new Point(5, 2)));
	
	}
	
	@Test
	public void testOutOfBoundsMove() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Knight(test.chessBoard[0][7], "white");
		
		test.chessBoard[0][7].setOccupier(p);
		
		assertFalse("DiagOutOfBoundsMove", test.move(new Point(0, 7), new Point(1, 9)));
	
	}
	
	@Test
	public void testAttackEnemy() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Knight(test.chessBoard[3][3], "white");
		Piece enemy = new Knight(test.chessBoard[4][5], "black");
		
		test.chessBoard[3][3].setOccupier(p);
		test.chessBoard[4][5].setOccupier(enemy);
		
		assertTrue("AttackEnemy", test.move(new Point(3, 3), new Point(4, 5)));
	
	}
	
	@Test
	public void testAttackFriendly() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Knight(test.chessBoard[3][3], "white");
		Piece friendly = new Knight(test.chessBoard[4][5], "white");
		
		test.chessBoard[3][3].setOccupier(p);
		test.chessBoard[4][5].setOccupier(friendly);
		
		assertFalse("AttackFriendly", test.move(new Point(3, 3), new Point(4, 5)));
	
	}
	
}
