package veiga.tiago.level.tile;

import veiga.tiago.graphics.Screen;
import veiga.tiago.graphics.Sprite;

public class Tile {
	public int x, y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass_0, Sprite.grass_1);
	public static Tile rock = new RockTile(Sprite.rock_0, Sprite.rock_1);
	public static Tile flower = new FlowerTile(Sprite.flower_0);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean solid() {
		return false;
	}
}
