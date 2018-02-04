package veiga.tiago.level.tile;

import veiga.tiago.graphics.Screen;
import veiga.tiago.graphics.Sprite;

public class RockTile extends Tile {

	public RockTile(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}

	public boolean solid() {
		return false;
	}
}
