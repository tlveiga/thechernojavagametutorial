package veiga.tiago.graphics;

public class Sprite {
	public final int SIZE;
	private int x, y;
	public int[] pixels;

	private SpriteSheet sheet;
	
	private boolean flipX= false, flipY= false;

	public static Sprite grass_0 = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite grass_1 = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite rock_0 = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite rock_1 = new Sprite(16, 3, 0, SpriteSheet.tiles);
	public static Sprite flower_0 = new Sprite(16, 4, 0, SpriteSheet.tiles);
	
	public static Sprite voidSprite = new Sprite(16, 0);

	public static Sprite player_forward = new Sprite(16, 0, 1, SpriteSheet.tiles);
	public static Sprite player_forward_1 = new Sprite(16, 1, 1, SpriteSheet.tiles);
	public static Sprite player_forward_2 = new Sprite(16, 2, 1, SpriteSheet.tiles);
	
	public static Sprite player_back = new Sprite(16, 0, 3, SpriteSheet.tiles);
	public static Sprite player_back_1 = new Sprite(16, 1, 3, SpriteSheet.tiles);
	public static Sprite player_back_2 = new Sprite(16, 2, 3, SpriteSheet.tiles);
	
	public static Sprite player_left = new Sprite(16, 0, 2, SpriteSheet.tiles, true, false);
	public static Sprite player_left_1 = new Sprite(16, 1, 2, SpriteSheet.tiles, true, false);
	public static Sprite player_left_2 = new Sprite(16, 2, 2, SpriteSheet.tiles, true, false);
	
	public static Sprite player_right = new Sprite(16, 0, 2, SpriteSheet.tiles);
	public static Sprite player_right_1 = new Sprite(16, 1, 2, SpriteSheet.tiles);
	public static Sprite player_right_2 = new Sprite(16, 2, 2, SpriteSheet.tiles);

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		this.SIZE = size;
		this.pixels = new int[size * size];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int size, int x, int y, SpriteSheet sheet, boolean flipX, boolean flipY) {
		this.SIZE = size;
		this.pixels = new int[size * size];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		this.flipX = flipX;
		this.flipY = flipY;
		load();
	}

	public Sprite(int size, int colour) {
		SIZE = size;
		this.pixels = new int[size * size];
		setColour(colour);
	}

	private void setColour(int colour) {
		for (int i = 0; i < SIZE * SIZE; i++) {
			pixels[i] = colour;
		}
	}

	private void load() {
		for (int x = 0; x < SIZE; x++) {
			int xs = !flipX ? x : SIZE - 1 - x;
			for (int y = 0; y < SIZE; y++) {
				int ys = !flipY ? y : SIZE - 1 - y;
				pixels[xs + ys * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}

}
