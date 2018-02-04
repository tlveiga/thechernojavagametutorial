package veiga.tiago.level.tile;

import veiga.tiago.graphics.Screen;
import veiga.tiago.graphics.Sprite;

public class RockTile extends MultiSpriteTile {

	public RockTile(Sprite... sprites) {
		super(sprites);
		// TODO Auto-generated constructor stub
	}

	public boolean solid() {
		return false;
	}
}
