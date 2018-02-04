package veiga.tiago.level.tile;

import veiga.tiago.graphics.Screen;
import veiga.tiago.graphics.Sprite;

public class Tile {
	public int x, y;
	public Sprite sprite;
	
	public static Tile grass_0 = new GrassTile(Sprite.grass_0);
	public static Tile grass_1 = new GrassTile(Sprite.grass_1);
	public static Tile rock_0 = new RockTile(Sprite.rock_0);
	public static Tile rock_1 = new RockTile(Sprite.rock_1);
	public static Tile flower_0 = new FlowerTile(Sprite.flower_0);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
		
	}
	
	public boolean solid() {
		return false;
	}
}
