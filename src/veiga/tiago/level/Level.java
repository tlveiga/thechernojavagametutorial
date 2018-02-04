package veiga.tiago.level;

import veiga.tiago.graphics.Screen;
import veiga.tiago.level.tile.Tile;

public class Level {
	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();

	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();

	}

	protected void loadLevel(String path) {
		// TODO Auto-generated method stub

	}

	protected void generateLevel() {
	}

	public void update() {

	}

	private void time() {

	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = ((xScroll + screen.width) >> 4) + 1;
		int y0 = yScroll >> 4;
		int y1 = ((yScroll + screen.height) >> 4) + 1;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}

	}

	// Grass = 0xFF00FF00
	// Rock = 0xFF0000FF
	// Flower = 0xFF7F7F00
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.voidTile;
		Tile tile = null;
		switch (this.tiles[x + y * width]) {
		case 0xFF00FF00:
			tile = Tile.grass;
			break;
		case 0xFF0000FF:
			tile = Tile.rock;
			break;
		case 0xFF7F7F00:
			tile = Tile.flower;
			break;
		default:
			tile = Tile.voidTile;
			break;
		}

		return tile;
	}

}
