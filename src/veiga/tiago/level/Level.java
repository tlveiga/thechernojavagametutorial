package veiga.tiago.level;

import veiga.tiago.graphics.Screen;
import veiga.tiago.level.tile.Tile;

public class Level {
	protected int width, height;
	protected int[] tilesInt;
	protected Tile[] tiles;

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
				// getTile(x, y).render(x, y, screen);
				int pos = x + y * 16;
				if (pos < 0 || pos >= 256)
					Tile.voidTile.render(x, y, screen);
				else
					tiles[pos].render(x, y, screen);
			}
		}

	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.voidTile;
		Tile tile = null;
		switch (this.tilesInt[x + y * width]) {
		case 0:
			tile = Tile.grass_0;
			break;
		case 1:
			tile = Tile.grass_1;
			break;
		case 2:
			tile = Tile.rock_0;
			break;
		case 3:
			tile = Tile.rock_1;
			break;
		case 4:
			tile = Tile.flower_0;
			break;
		default:
			tile = Tile.voidTile;
			break;
		}

		return tile;
	}

}
