package Main;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

/**
 * Concrete class "SZShape" that extends the abstract class AbstractShape
 * 
 * @author JamesVolpe
 */

public class SZShape extends AbstractShape {
	
	/**
	 * Keeps track of whether or not the instance has been transformed
	 */
	private boolean flipped = false;
	
	/**
	 * Constructs an SZShape with the given position and magic state.
	 * @param p
	 * @param magic
	 */
	public SZShape(Position p, boolean magic) {
		super(p);
		Cell[] temp = new Cell[4];
		temp[0] = new Cell(new Block(Color.GREEN, magic), p);
		temp[1] = new Cell(new Block(Color.GREEN, false), new Position(p.row() + 1, p.col()));
		temp[2] = new Cell(new Block(Color.GREEN, false), new Position(p.row() + 1, p.col() + 1));
		temp[3] = new Cell(new Block(Color.GREEN, false), new Position(p.row() + 2, p.col() + 1));
		setCells(temp);
	}
	
	@Override
	public void transform() {
		Cell[] temp = getCells();
		if (!(flipped)) {
			temp[0].setCol(temp[0].getCol() + 1);
			temp[1].setCol(temp[1].getCol() + 1);
			temp[2].setCol(temp[2].getCol() - 1);
			temp[3].setCol(temp[3].getCol() - 1);
			flipped = true;
			for (int i = 0; i < temp.length; i++) { //Set new color
				  temp[i].setBlock(new Block(Color.RED, temp[i].getBlock().isMagic()));
			  }
			setCells(temp);
		}
		else {
			temp[0].setCol(temp[0].getCol() - 1);
			temp[1].setCol(temp[1].getCol() - 1);
			temp[2].setCol(temp[2].getCol() + 1);
			temp[3].setCol(temp[3].getCol() + 1);
			flipped = false;
			for (int i = 0; i < temp.length; i++) { //Set new color
				  temp[i].setBlock(new Block(Color.GREEN, temp[i].getBlock().isMagic()));
			  }
			setCells(temp);
		}
	  }
}