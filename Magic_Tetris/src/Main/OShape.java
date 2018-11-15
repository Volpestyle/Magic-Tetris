package Main;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

/**
 * Concrete class "OShape" that extends the abstract class AbstractShape
 * 
 * @author JamesVolpe
 */

public class OShape extends AbstractShape {

	/**
	 * Constructs an OShape with the given position and magic state.
	 * @param p
	 * @param magic
	 */
	public OShape(Position p, boolean magic) {
		super(p);
		Cell[] temp = new Cell[4];
		temp[0] = new Cell(new Block(Color.YELLOW, magic), p);
		temp[1] = new Cell(new Block(Color.YELLOW, false), new Position(p.row(), p.col() + 1));
		temp[2] = new Cell(new Block(Color.YELLOW, false), new Position(p.row() + 1, p.col()));
		temp[3] = new Cell(new Block(Color.YELLOW, false), new Position(p.row() + 1, p.col() + 1));
		setCells(temp);
	}
	
	@Override
	public void transform() {
		//do nothing
	}
}