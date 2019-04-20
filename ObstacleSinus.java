public class ObstacleSinus extends Obstacle {

	private static final int AMPLITUDE = 50; // px

	private int yInitial;

	public ObstacleSinus(int x, int y) {
		super(x, y);
		this.yInitial = y;
	}

	/**
	 * Déplacer le personnage avec une onde sinus
	 *
	 * @param dt Delta de temps
	 */
	@Override
	public void move(double dt) {
		super(dt);
		this.y = AMPLITUDE / 2 * (int) Math.sin(this.x) + this.yInitial;
	}
}
