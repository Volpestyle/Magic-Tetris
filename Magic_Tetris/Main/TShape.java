package Main;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

/**
 * Concrete class "TShape" that extends the abstract class AbstractShape
 * 
 * @author JamesVolpe
 */

public class TShape extends AbstractShape {
	
	/**
	 * Constructs an TShape with the given position and magic state.
	 * @param p
	 * @param magic
	 */
	public TShape(Position p, boolean magic) {
		super(p);
		Cell[] temp = new Cell[4];
		temp[0] = new Cell(new Block(Color.MAGENTA, magic), new Position(p.row() - 1, p.col()));
		temp[1] = new Cell(new Block(Color.MAGENTA, false), new Position(p.row(), p.col() - 1));
		temp[2] = new Cell(new Block(Color.MAGENTA, false), p);
		temp[3] = new Cell(new Block(Color.MAGENTA, false), new Position(p.row(), p.col() + 1));
		setCells(temp);
	}
}