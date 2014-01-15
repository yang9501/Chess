import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;



public class ModelTest {

	@Test
	public void testUndo() {
		Model test = new Model();
		
		test.move(new Point(4, 6), new Point(4, 4));
		test.undo();
		assertTrue(test.getBoard().getSquare(new Point(4, 6)).getOccupier() != null);
		assertTrue(test.getBoard().getSquare(new Point(4, 4)).getOccupier() == null);
		assertTrue(test.getCommands().isEmpty());
	}

	@Test
	public void testMove() {
		Model test = new Model();
		
		Point from = new Point(4, 6);
		Point to = new Point(4, 4);
		assertTrue(test.getBoard().getSquare(from).getOccupier() != null);
		assertTrue(test.getCommands().isEmpty());
		test.move(from, to);
		assertTrue(test.getBoard().getSquare(from).getOccupier() == null);
		assertTrue(test.getBoard().getSquare(to).getOccupier() != null);
		assertTrue(!test.getCommands().isEmpty());
		Command com = test.getCommands().pop();
		assertTrue(com.getFrom().equals(from));
		assertTrue(com.getTo().equals(to));
		assertTrue(com.getMoved() == test.getBoard().getSquare(to).getOccupier());
		assertTrue(com.getTaken() == null);
	}

}
