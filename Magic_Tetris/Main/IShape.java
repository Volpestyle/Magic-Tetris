package Main;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

/**
 * Concrete class "IShape" that extends the abstract class AbstractShape
 * 
 * @author JamesVolpe
 */

public class IShape extends AbstractShape {

	/**
	 * Constructs an IShape with the given position and magic state.
	 * @param p
	 * @param magic
	 */
	public IShape(Position p, boolean magic) {
		super(p);
		Cell[] temp = new Cell[3];
		temp[0] = new Cell(new Block(Color.CYAN, magic), p);
		temp[1] = new Cell(new Block(Color.CYAN, false), new Position(p.row() + 1, p.col()));
		temp[2] = new Cell(new Block(Color.CYAN, false), new Position(p.row() + 2, p.col()));
		setCells(temp);
	}
}
