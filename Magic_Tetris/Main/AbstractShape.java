package Main;

import api.Block;
import api.Cell;
import api.Position;
import api.Shape;


/**
 * Abstract superclass for implementations of the Shape interface.
 * 
 * @author JamesVolpe
 */

public abstract class AbstractShape implements Shape
{
	
  /**
  * Stores the blocks of each shape.
  */
  private Cell[] cells = new Cell[3];
 
  /**
   * Stores the position of each shape.
   */
  private Position position;
  
  /**
   * Constructs an AbstractShape with the given position.
   * @param p
   */
  protected AbstractShape(Position p) {
	  position = p;
  }
  
  @Override
  public void shiftDown() {
	  position.setRow(position.row() + 1);
	  for (Cell c : cells) {
		  c.setRow(c.getRow() + 1);
	  }
  }

  @Override
  public void shiftRight() {
	  position.setCol(position.col() + 1);
	  for (Cell c : cells) {
		  c.setCol(c.getCol() + 1);
	  }
	  
  }
  
  @Override
  public void shiftLeft() {
	  position.setCol(position.col() - 1);
	  for (Cell c : cells) {
		  c.setCol(c.getCol() - 1);
	  }
  }

  @Override
  public void transform() {
	  int tempCellRow;
	  int PosRow = position.row();
	  int PosCol = position.col();
	  for (Cell c : cells) { //Move cell to be centered around origin
		  c.setRow(c.getRow() - PosRow);
		  c.setCol(c.getCol() - PosCol);
		  
		  tempCellRow = c.getRow(); //Rotate 90 degrees
		  c.setRow(- (c.getCol()));
		  c.setCol(tempCellRow);
		  
		  c.setRow(c.getRow() + PosRow); //Move cell back in place
		  c.setCol(c.getCol() + PosCol);
	  }
  }


  @Override
  public void cycle() {
	  Block temp = cells[0].getBlock();
	  cells[0].setBlock(cells[cells.length - 1].getBlock());
	  for (int i = cells.length - 1; i > 1; i--) { //since we are shifting right, start from right and shift until index 2 because 1's value is in temp
		  cells[i].setBlock(cells[i-1].getBlock());
	  }
	  cells[1].setBlock(temp);
  }
  
  @Override
  public Cell[] getCells() {
	Cell[] copy = new Cell[cells.length];
	for (int i = 0; i < cells.length; i++) {
		copy[i] = new Cell(cells[i]);
	}
	return copy;
  }
  
/**
 * Sets the cells that represent the blocks in this shape.
 * @param cellToCopy
 */
  protected void setCells(Cell[] cellToCopy) { //So that the concrete classes are able to modify cells with "cells" still being private
	  cells = cellToCopy;
  }
  
  @Override
  public Shape clone()
  {
    try
    {
      AbstractShape s = (AbstractShape) super.clone();
      s.position = new Position(position);
      s.cells = new Cell[cells.length];
      
      for (int i = 0; i < cells.length; i++) {
  		s.cells[i] = new Cell(cells[i]);
      }
      
      return s;
    }
    catch (CloneNotSupportedException e)
    {
      // can't happen
      return null;
    }
  }
}


