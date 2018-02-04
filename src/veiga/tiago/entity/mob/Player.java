package veiga.tiago.entity.mob;

import veiga.tiago.graphics.Screen;
import veiga.tiago.graphics.Sprite;
import veiga.tiago.input.Keyboard;

public class Player extends Mob {
	private Keyboard input;
	private int anim = 0;
	private boolean walking = false;

	private Sprite[] forward = new Sprite[3];
	private Sprite[] back = new Sprite[3];
	private Sprite[] left = new Sprite[3];
	private Sprite[] right = new Sprite[3];

	public Player(Keyboard input) {
		this.input = input;
		this.forward[0] = Sprite.player_forward;
		this.forward[1] = Sprite.player_forward_1;
		this.forward[2] = Sprite.player_forward_2;

		this.back[0] = Sprite.player_back;
		this.back[1] = Sprite.player_back_1;
		this.back[2] = Sprite.player_back_2;

		this.left[0] = Sprite.player_left;
		this.left[1] = Sprite.player_left_1;
		this.left[2] = Sprite.player_left_2;

		this.right[0] = Sprite.player_right;
		this.right[1] = Sprite.player_right_1;
		this.right[2] = Sprite.player_right_2;
	}

	public Player(int x, int y, Keyboard input) {
		this(input);
		this.x = x;
		this.y = y;
	}

	public void update() {
		int xa = 0, ya = 0;

		if (input.down)
			ya++;
		if (input.up)
			ya--;
		if (input.right)
			xa++;
		if (input.left)
			xa--;

		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
			if (anim > 6000)
				anim = 0;
			else
				anim++;
		} else {
			walking = false;
		}
	}

	public void render(Screen screen) {
		Sprite[] anim = null;
		switch (dir) {
		case NORTH:
			anim = this.back;
			break;
		case SOUTH:
			anim = this.forward;
			break;
		case EAST:
			anim = this.right;
			break;
		case WEST:
			anim = this.left;
			break;
		}

		sprite = anim[this.anim % 30 / 10];

		screen.renderPlayer(x, y, sprite);
	}
}
