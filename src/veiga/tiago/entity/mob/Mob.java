package veiga.tiago.entity.mob;

import veiga.tiago.entity.Entity;
import veiga.tiago.graphics.Sprite;

public abstract class Mob extends Entity {
	protected enum Direction {
		NORTH, EAST, SOUTH, WEST
	}

	
	protected Sprite sprite;

	protected Direction dir = Direction.NORTH;
	protected boolean moving = false;

	public void move(int xa, int ya) {
		if (xa > 0) dir = Direction.EAST;
		if (xa < 0) dir = Direction.WEST;
		if (ya > 0) dir = Direction.SOUTH;
		if (ya < 0) dir = Direction.NORTH;
		
		if (!collision()) {
			x += xa * 5;
			y += ya;
		}

	}

	public void update() {

	}

	public void render() {

	}

	protected boolean collision() {
		return false;
	}
}
