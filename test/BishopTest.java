import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;


public class BishopTest {

	public void boardInit(Board b) {
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				b.chessBoard[x][y] = new Square(b, new Point(x, y));
			}
		}
	}
	
	@Test
	public void testDiagUpLeft() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Bishop(test.chessBoard[3][3], "white");
		
		test.chessBoard[3][3].setOccupier(p);
		
		assertTrue("DiagUpLeft", test.move(new Point(3, 3), new Point(1, 5)));
	
	}
	
	@Test
	public void testDiagUpRight() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Bishop(test.chessBoard[3][3], "white");
		
		test.chessBoard[3][3].setOccupier(p);
		
		assertTrue("DiagUpRight", test.move(new Point(3, 3), new Point(5, 5)));
	
	}
	
	@Test
	public void testDiagDownRight() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Bishop(test.chessBoard[3][3], "white");
		
		test.chessBoard[3][3].setOccupier(p);
		
		assertTrue("DiagDownRight", test.move(new Point(3, 3), new Point(5, 1)));
	
	}
	
	@Test
	public void testDiagDownLeft() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Bishop(test.chessBoard[3][3], "white");
		
		test.chessBoard[3][3].setOccupier(p);
		
		assertTrue("DiagDownLeft", test.move(new Point(3, 3), new Point(1, 1)));
	
	}
	
	@Test
	public void testOutOfBoundsMove() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Bishop(test.chessBoard[0][7], "white");
		
		test.chessBoard[0][7].setOccupier(p);
		
		assertFalse("DiagOutOfBoundsMove", test.move(new Point(0, 7), new Point(2, 9)));
	
	}
	
	@Test
	public void testAttackEnemy() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Bishop(test.chessBoard[3][3], "white");
		Piece enemy = new Bishop(test.chessBoard[5][5], "black");
		
		test.chessBoard[3][3].setOccupier(p);
		test.chessBoard[5][5].setOccupier(enemy);
		
		assertTrue("AttackEnemy", test.move(new Point(3, 3), new Point(5, 5)));
	
	}
	
	@Test
	public void testAttackFriendly() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Bishop(test.chessBoard[3][3], "white");
		Piece friendly = new Bishop(test.chessBoard[5][5], "white");
		
		test.chessBoard[3][3].setOccupier(p);
		test.chessBoard[5][5].setOccupier(friendly);
		
		assertFalse("AttackFriendly", test.move(new Point(3, 3), new Point(5, 5)));
	
	}
	
}
