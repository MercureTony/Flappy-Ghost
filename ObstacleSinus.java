public class ObstacleSinus extends Obstacle {

	private static final int AMPLITUDE = 50; // px

	private double yInitial;

	public ObstacleSinus(double x, double y) {
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
		super.move(dt);
		this.y = AMPLITUDE / 2 * Math.sin(this.x) + this.yInitial;
	}
}
