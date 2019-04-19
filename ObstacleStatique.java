public class ObstacleStatique extends Obstacle {

	public ObstacleStatique(int x, int y, long t) {
		super(x, y, t);
	}

	/**
	 * Déplacer l'obstacle en ligne droite
	 *
	 * @param t Temps actuel
	 */
	@Override
	public void move(long t) {
		int timeDelta = (int) t - this.lastT;
		this.x = this.x + (t - this.lastT) * this.vx;
		super(t);
	}
}
