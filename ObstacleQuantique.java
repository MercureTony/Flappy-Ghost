public class ObstacleQuantique extends Obstacle {

	private double teleportTime = 0; // Accumulateur de temps à l'incrément

	private static final int MAX_TELEPORT = 30; // px
	private static final double TELEPORT_INCREMENT = 0.2 // s

	public ObstacleQuantique(int x, int y) {
		super(x, y);
	}

	/**
	 * Déplacer le personnage à chaque 0.2s à une position aléatoire
	 *
	 * @param dt Delta de temps
	 */
	@Override
	public void move(double dt) {
		super(dt);

		teleportTime += dt;
		if (teleportTime >= TELEPORT_INCREMENT) {
			int negX = Math.round(Math.random()) == 0 ? -1 : 1;
			int negY = Math.round(Math.random()) == 0 ? -1 : 1;

			this.x += negX * (int) (Math.random() * MAX_TELEPORT);
			this.y += negY * (int) (Math.random() * MAX_TELEPORT);
			this.lastTeleport = t;
		}
	}
}
