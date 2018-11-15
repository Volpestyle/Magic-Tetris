package Main;

import java.util.ArrayList;
import java.util.List;

import api.AbstractGame;
import api.Position;

/**
 * MagicTetris implementation.
 * 
 * @author JamesVolpe
 */
public class MagicTetris extends AbstractGame
{
  /**
  * Indicates if this MagicTetris Game is in "Magic mode"
  */
  private Boolean magicMode = false;
  
  /**
  * Keeps track of the score of this game.
  */
  private int score = 0;
 
  /**
   * Constructs a game with the given width (columns) and height (rows).
   * This game will use a new instance of BasicGenerator to 
   * generate new shapes.
   * @param width
   *   width of the game grid (number of columns)
   * @param height
   *   height of the game grid (number of rows)
   */
  public MagicTetris(int width, int height)
  {
    super(width, height, new BasicGenerator());
  }

  @Override
  public List<Position> determinePositionsToCollapse()
  {
	List<Position> list = new ArrayList<Position>();
	int occupiedCells = 0;
	int magicBlocks = 0;
	int i = 0;
	int j = 0;
	int k = 0;
	
	if (magicMode) {
		for (i = getHeight() - 1; i >= 0; i--) { //Iterates through starting at the bottom right corner
			for (j = 0; j < getWidth(); j++) {
				if (getBlock(i, j) == null) { //Once an empty block is reach, iterate up the column
					for (k = i; k >= 0; k--) {
						if (getBlock(k, j) != null) { //Once a filled block is reached, iterate down the column
							for (k = k + 1; k <= i; k++) {
								list.add(new Position(k, j));
							}
							break; //Move to next column
						}
					}
				}
			}
		}
		magicMode = false;
		return list;
	}
	else {
		for (i = getHeight() - 1; i >= 0; i--) {
			occupiedCells = 0;
			magicBlocks = 0;
	    		
			for (j = 0; j < getWidth(); j++) {
	    			if (getBlock(i, j) != null) {
	    				occupiedCells += 1;
	    				if (getBlock(i, j).isMagic()) {
	        				magicBlocks += 1;
	        			}
	    			}
	    		}
	    		
			if (occupiedCells == getWidth()) { //If a row is completed:
				if (magicBlocks >= 3) {
					magicMode = true;
				}
	    			for (j = 0; j < getWidth(); j++) {
	    				list.add(new Position(i, j));
	    			}
	    			score = (int) (score + (Math.pow(2, magicBlocks))); 
	    			return list;
	    		}
		}
	    return list;
	}
  }

  @Override
  public int determineScore()
  {
    return score;
  }

}
