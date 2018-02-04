package veiga.tiago.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import veiga.tiago.level.tile.Tile;

public class SpawnLevel extends Level {
	private int[] levelPixels;

	public SpawnLevel(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	public void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			tiles = new Tile[w * h];
			levelPixels = new int[w * h];
			image.getRGB(0, 0, w, h, levelPixels, 0, w);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Grass = 0x00FF00
	// Rock = 0x0000FF
	// Flower = 0x7F7F00
	protected void generateLevel() {
		int h = 0xFF00FF00;
		for (int i = 0; i < levelPixels.length; i++) {
			Tile tile;
			switch (levelPixels[i]) {
			case 0xFF00FF00:
				tile = Tile.grass_0;
				break;
			case 0xFF0000FF:
				tile = Tile.rock_0;
				break;
			case 0xFF7F7F00:
				tile = Tile.flower_0;
				break;
			default:
				tile = Tile.voidTile;
				break;
			}
			tiles[i] = tile;
		}
	}
}
