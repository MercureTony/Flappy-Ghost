public class Flappy extends Personnage {

	// Score de Flappy
	private int score = 0;

	private static final int SCORE_INCREMENT = 5;

	private boolean graviteInverse = false;

	/**
	 * Constructeur du joueur Flappy
	 *
	 * @param x abscisse de Flappy initial
	 * @param y ordonnée de Flappy initial
	 */
	public Flappy(double x, double y) {
		// Rayon de 30px
		super(x, y, 30);
		this.vx = 120;
	}

	/**
	 * Prendre score actuel
	 *
	 * @return score
	 */
	public int getScore() {
		return this.score;
	}

	/**
	 * Incrémente le score par une constante
	 */
	public void incrementScore() {
		this.score += SCORE_INCREMENT;
	}

	/**
	 * Augmenter la vitesse/accélération après deux obstacles dépassés
	 */
	public void update() {
		this.vy += 15;
		this.ay += 15;
		if (this.vy > 300) {
			this.vy = 300;
		}
	}

	/**
	 * Augmnenter la vitesse instantané à 300px/s quand le fantôme saute
	 */
	public void jump() {
		this.graviteInverse = false; // Gravité normal
		this.ay = Math.abs(this.ay);
		this.vy = 300;
	}

	/**
	 * Déplacer Flappy avec la gravité
	 *
	 * @param dt Delta de temps - s
	 */
	@Override
	public void move(double dt) {
		int inverse = this.graviteInverse ? 1 : -1;
		this.vy -= this.ay * dt;
		this.y += inverse * this.vy * dt;
	}

	/**
	 * Toggle direction de la gravité
	 */
	public void toggleGravite() {
		this.graviteInverse = !this.graviteInverse;
		this.ay *= -1;
	}

	/**
	 * Vérifie si Flappy intersecte un obstacle
	 * Si oui, réinitialise son compteur
	 * 
	 * @param other qui représente les Obstacle
	 * @return boolean if intersects
	 */
	public boolean testIntersect(Personnage other) {
		if (intersect(other)) {
			this.score = 0;
			this.setVx(120);
			this.setAy(500);
		}
		return intersect(other);
	}
}
