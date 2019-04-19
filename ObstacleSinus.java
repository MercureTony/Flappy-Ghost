public class ObstacleSinus extends Obstacle {

	private static final int AMPLITUDE = 50; // px

	public ObstacleSinus(int x, int y, long t) {
		super(x, y, t);
	}

	/**
	 * Déplacer le personnage avec une onde sinus
	 *
	 * @param t Temps actuel
	 */
	@Override
	public void move(long t) {
		this.y = AMPLITUDE / 2 * Math.sin(this.x);
	}
}
