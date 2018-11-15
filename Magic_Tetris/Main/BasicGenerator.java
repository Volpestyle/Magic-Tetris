
package Main;

import java.util.Random;

import api.Generator;
import api.Position;
import api.Shape;

/**
 * Generator for Shape objects in MagicTetris.  All six shapes
 * are equally likely, and the generated shape is magic with
 * 20% probability.
 * 
 * @author JamesVolpe
 */
public class BasicGenerator implements Generator
{
	
	@Override
	public Shape getNext(int width)
	{
		boolean isMagic;
		int mid = width/2;
		int num = new Random().nextInt(6) + 1;
		int num2 = new Random().nextInt(100) + 1;
		
		if (num2 <= 20) {
			isMagic = true;
		}
		else {
			isMagic = false;
		}
		
		if (num == 1) {
			return new LShape(new Position(-1, mid + 1), isMagic);
		}
		else if (num == 2) {
			return new JShape(new Position(-1, mid), isMagic);
		}
		else if (num == 3) {
			return new IShape(new Position(-2, mid), isMagic);
		}
		else if (num == 4) {
			return new OShape(new Position(-1, mid), isMagic);
		}
		else if (num == 5) {
			return new TShape(new Position(0, mid), isMagic);
		}
		else if (num == 6) {
			return new SZShape(new Position(-1, mid), isMagic);
		}
		else {
		return null;
		}
  }
}
