package Main;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

/**
 * Concrete class "LShape" that extends the abstract class AbstractShape
 * 
 * @author JamesVolpe
 */

public class LShape extends AbstractShape {
	
	/**
	 * Constructs an LShape with the given position and magic state.
	 * @param p
	 * @param magic
	 */
	public LShape(Position p, boolean magic) {
		super(p);
		Cell[] temp = new Cell[4];
		temp[0] = new Cell(new Block(Color.ORANGE, magic), p);
		temp[1] = new Cell(new Block(Color.ORANGE, false), new Position(p.row() + 1, p.col() - 2));
		temp[2] = new Cell(new Block(Color.ORANGE, false), new Position(p.row() + 1, p.col() - 1));
		temp[3] = new Cell(new Block(Color.ORANGE, false), new Position(p.row() + 1, p.col()));
		setCells(temp);
	}
}