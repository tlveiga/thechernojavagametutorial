package veiga.tiago.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import veiga.tiago.level.tile.Tile;

public class SpawnLevel extends Level {

	public SpawnLevel(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	public void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			this.width = image.getWidth();
			this.height = image.getHeight();
			tiles = new int[this.width * this.height];
			image.getRGB(0, 0, this.width, this.height, tiles, 0, this.width);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void generateLevel() {
	}
}
