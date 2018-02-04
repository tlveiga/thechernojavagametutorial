package veiga.tiago.graphics;

import java.util.Random;

import veiga.tiago.level.tile.Tile;

public class Screen {
	public int width;
	public int height;
	public int[] pixels;

	public final int MAP_SIZE = 8;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;

	public int xOffset, yOffset;

	public int[] tiles = new int[64 * 64];
	private Random random = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int[width * height];

		for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}

	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void renderTile(int xp, int yp, Tile tile) {
		xp -= this.xOffset;
		yp -= this.yOffset;

		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < 0 || xa >= width || ya < 0 || ya >= height)
					continue;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
	}

	public void renderPlayer(int xp, int yp, Sprite sprite) {
		xp -= this.xOffset;
		yp -= this.yOffset;

		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < 0 || xa >= width || ya < 0 || ya >= height)
					continue;
				int col = sprite.pixels[x + y * sprite.SIZE];
				if (col != 0xffff00ff)
					pixels[xa + ya * width] = col;
			}
		}
	}

	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
