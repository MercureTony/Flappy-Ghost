public class ObstacleSinus extends Obstacle {

	private static final int AMPLITUDE = 50; // px

	private int yInitial;

	public ObstacleSinus(int x, int y, long t) {
		super(x, y, t);
		this.yInitial = y;
	}

	/**
	 * Déplacer le personnage avec une onde sinus
	 *
	 * @param t Temps actuel
	 */
	@Override
	public void move(long t) {
		super(t);
		this.y = AMPLITUDE / 2 * (int) Math.sin(this.x) + this.yInitial;
	}
}
