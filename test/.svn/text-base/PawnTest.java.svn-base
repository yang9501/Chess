import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;


public class PawnTest {

	public void boardInit(Board b) {
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				b.chessBoard[x][y] = new Square(b, new Point(x, y));
			}
		}
	}
	
	@Test
	public void testMove() {
		Board test = new Board(false);
		boardInit(test);
		Piece p = new Pawn(test.chessBoard[0][1], "black");
		Piece tryBeEaten = new Pawn(test.chessBoard[1][4], "black");
		Piece toBeEaten = new Pawn(test.chessBoard[1][5], "white");
		Piece cantMove = new Pawn(test.chessBoard[0][7], "black");
		Piece blocker = new Pawn(test.chessBoard[1][6], "black");
		
		test.chessBoard[0][1].setOccupier(p);
		test.chessBoard[1][4].setOccupier(tryBeEaten);
		test.chessBoard[1][5].setOccupier(toBeEaten);
		test.chessBoard[0][7].setOccupier(cantMove);
		test.chessBoard[1][6].setOccupier(blocker);
		
		assertFalse("1", test.move(new Point(0, 7), new Point(-1, 7))); //test out-of-bounds movement request (illegal)
		assertFalse("2", test.move(new Point(0, 1), new Point(1, 2)));  //test diagonal attack onto nothing (illegal)
		assertTrue("3", test.move(new Point(0, 1), new Point(0, 3)));   //test double jump (legal)
		assertFalse("4", test.move(new Point(0, 3), new Point(1, 4)));  //test attack friendly piece (illegal)
		assertFalse("5", test.move(new Point(0, 3), new Point(0, 5)));  //test double jump after initial movement (illegal)
		assertTrue("6", test.move(new Point(0, 3), new Point(0, 4)));   //test single square movement (legal)
		assertFalse("7", test.move(new Point(0, 4), new Point(0, 3)));  //test backwards movement (illegal)
		assertTrue("8", test.move(new Point(0, 4), new Point(1, 5)));   //test legitimate attack on enemy piece (legal)
		assertFalse("9", test.move(new Point(1, 5), new Point(1, 6)));  //test forwards movement on friendly piece (illegal)
	
	}
}
