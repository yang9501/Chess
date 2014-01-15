import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;


public class SoldierTest {

	public void boardInit(Board b) {
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				b.chessBoard[x][y] = new Square(b, new Point(x, y));
			}
		}
	}
	
	@Test
	public void testForwards() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Soldier(test.chessBoard[3][3], "white");
		
		test.chessBoard[3][3].setOccupier(p);
		
		assertTrue("Forwards", test.move(new Point(3, 3), new Point(3, 2)));
	
	}
	
	@Test
	public void testBackwards() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Soldier(test.chessBoard[3][3], "white");
		
		test.chessBoard[3][3].setOccupier(p);
		
		assertFalse("Backwards", test.move(new Point(3, 3), new Point(3, 4)));
	
	}
	
	@Test
	public void testIllegalSideMove() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Soldier(test.chessBoard[4][4], "white");
		
		test.chessBoard[4][4].setOccupier(p);
		
		assertFalse("IllegalSideMove", test.move(new Point(4, 4), new Point(5, 4)));
	
	}
	
	@Test
	public void testLegalSideMove() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Soldier(test.chessBoard[3][3], "white");
		
		test.chessBoard[3][3].setOccupier(p);
		
		assertTrue("LegalSideMove", test.move(new Point(3, 3), new Point(4, 3)));
	
	}
	
	@Test
	public void testOutOfBoundsMove() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Soldier(test.chessBoard[0][7], "white");
		
		test.chessBoard[0][7].setOccupier(p);
		
		assertFalse("OutOfBoundsMove", test.move(new Point(0, 7), new Point(0, 8)));
	
	}
	
	@Test
	public void testAttackEnemy() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Soldier(test.chessBoard[4][4], "white");
		Piece enemy = new Soldier(test.chessBoard[4][3], "black");
		
		test.chessBoard[4][4].setOccupier(p);
		test.chessBoard[4][3].setOccupier(enemy);
		
		assertTrue("AttackEnemy", test.move(new Point(4, 4), new Point(4, 3)));
	
	}
	
	@Test
	public void testAttackFriendly() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Soldier(test.chessBoard[3][3], "white");
		Piece friendly = new Soldier(test.chessBoard[3][4], "white");
		
		test.chessBoard[3][3].setOccupier(p);
		test.chessBoard[3][4].setOccupier(friendly);
		
		assertFalse("AttackFriendly", test.move(new Point(3, 3), new Point(3, 4)));
	
	}
}
