public class ObstacleQuantique extends Obstacle {

	private long lastTeleport = 0;

	private static final long TELEPORT_INCREMENT = 2e8; // ns
	private static final int MAX_TELEPORT = 30; // px

	public ObstacleQuantique(int x, int y, long t) {
		super(x, y, t);
	}

	/**
	 * Déplacer le personnage à chaque 0.2s à une position aléatoire
	 *
	 * @param t Temps actuel
	 */
	@Override
	public void move(long t) {
		super(t);
		if (t - lastTeleport >= TELEPORT_INCREMENT) {
			int negX = Math.round(Math.random()) == 0 ? -1 : 1;
			int negY = Math.round(Math.random()) == 0 ? -1 : 1;

			this.x += negX * (int) (Math.random() * MAX_TELEPORT);
			this.y += negY * (int) (Math.random() * MAX_TELEPORT);
			this.lastTeleport = t;
		}
	}
}
