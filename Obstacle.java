public class Obstacle extends Personnage {

	public static final int NBR_IMAGES = 46;
	public static final int MAX_RAYON = 45;

	private int imageIndex;

	private boolean passed = false;
	private boolean intersecting = false;
	private boolean hasIntersected = false;

	/**
	 * Constructeur des Obstacle
	 *
	 * @param x abscisse de l'obstacle
	 * @param y ordonnnéé de l'obstacle
	 */
	public Obstacle(double x, double y) {
		super(x, y);
		this.imageIndex = (int) (Math.random() * NBR_IMAGES);
	}

	/**
	 * Cette méthode permet d'afficher aléatoirement les obstacles du jeu
	 *
	 * @return l'identifiant de l'image
	 */
	public int getImageIndex() {
		return this.imageIndex;
	}

	/**
	 * Cette méthode permet de générer des rayons aléatoirement pour chaque Obstacle
	 *
	 * @return le rayon de l'obstacle
	 */

	@Override
	public int getRayon() {
		return rayon;
	}

	public void setRayon(int rayon) {
		this.rayon = rayon;
	}

	/**
	 * Déplacer l'obstacle avec une règle par le temps
	 *
	 * @param t Temps actuel - s
	 */
	public void move(double dt) {
		this.x -= dt * this.vx;
	}

	public boolean hasPassed() {
		return this.passed;
	}

	public void pass(Flappy f) {
		this.passed = true;
		f.incrementScore();
	}

	public boolean getIntersecting() {
		return this.intersecting;
	}

	public boolean hasIntersected() {
		return this.hasIntersected;
	}

	public void toggleIntersecting() {
		this.intersecting = !this.intersecting;
		this.hasIntersected = true;
	}
}
