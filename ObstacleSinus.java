public class ObstacleSinus extends Obstacle {

	private int initialY;

	public ObstacleSinus(int x, int y, long t) {
		super(x, y, t);
		this.initialY = y;
	}

	/**
	 * Déplacer le personnage avec une onde sinus
	 *
	 * @param t Temps actuel
	 */
	@Override
	public void move(long t) {
		
	}
}
