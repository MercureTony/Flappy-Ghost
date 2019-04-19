public class ObstacleQuantique extends Obstacle {

	private int lastTeleport = 0;

	private static long TELEPORT_INCREMENT = 2e8; // ns
	private static int MAX_TELEPORT = 30; // px

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
		int timeDelta = (int) t - this.lastT;
		this.x = this.x + timeDelta * this.vx;
		if (t - lastTeleport >= TELEPORT_INCREMENT) {
			int negX = Math.round(Math.random()) == 0 ? -1 : 1;
			int negY = Math.round(Math.random()) == 0 ? -1 : 1;

			this.x += negX * Math.floor(Math.random() * MAX_TELEPORT);
			this.y += negY * Math.floor(Math.random() * MAX_TELEPORT);
			this.lastTeleport = t;
		}
		super(t);
	}
}
