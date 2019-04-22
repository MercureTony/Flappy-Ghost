import java.util.ArrayList;

public class Controleur {

	private FlappyGhost app;

	private Flappy fantome = new Flappy(0, 0);
	private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

	private boolean debug = false;

	private static final double SPAWN_OBSTACLE = 3.0; // s
	private double accuCreate = 0; // s

	public Controleur(FlappyGhost app) {
		this.app = app;
	}

	/**
	 * Créer Flappy au début du jeu
	 */
	public void commencer() {
		fantome.setX((FlappyGhost.MAX_WIDTH - fantome.getRayon()) / 2.0);
		fantome.setY((FlappyGhost.GAME_HEIGHT - fantome.getRayon()) / 2.0);
		app.initFlappy(fantome.getRayon());
		app.moveGhost(fantome.getX(), fantome.getY());
		app.changerScore(Integer.toString(fantome.getScore()));
	}

	/**
	 * Faire sauter le fantome et déplacer l'image
	 * Se fait quand la touche 'espace' est faite
	 */
	public void sauterFantome() {
		fantome.jump();
		app.moveGhost(fantome.getX(), fantome.getY());
	}

	/**
	 *  Vitesse à l'abscisse de Flappy
	 */
	public int flappyVx(){
		return fantome.getVx();
	}

	/**
	 * Faire dérouler l'arrière-plan
	 * dépendant sur la vitesse de Flappy
	 * Thread active durant tout le jeu
	 *
	 * @param dt Delta de temps
	 */
	public void deroulerPlan(double dt) {}

	/**
	 * Faire subir Flappy à la gravité
	 * Thread active durant tout le jeu
	 *
	 * @param dt Delta de temps
	 */
	public void faireGravite(double dt) {}

	/**
	 * Faire déplacer les monstres
	 * Thread active durant tout le jeu
	 *
	 * @param dt Delta de temps
	 */
	public void bougerMonstres(double dt) {
		for (int i = 0; i < obstacles.size(); i++) {
			Obstacle obs = obstacles.get(i);
			if (obs != null) {
				obs.move(dt);

				// S'assurer qu'il est pas hors en y
				double curY = obs.getY();
				if (curY - obs.getRayon() < 0) {
					obs.setY(Math.abs(curY) + obs.getRayon());
				} else if (curY + obs.getRayon() > FlappyGhost.GAME_HEIGHT) {
					obs.setY(FlappyGhost.GAME_HEIGHT - obs.getRayon());
				}

				app.moveObstacle(i, obs.getX(), obs.getY());

				// Tester si Flappy l'a passé
				double dist = obs.getX() + (obs.getRayon() + fantome.getRayon()) / 2.0;
				if (!obs.hasPassed() && !obs.hasIntersected() && dist < fantome.getX()) {
					obs.pass(fantome);
					app.changerScore(Integer.toString(fantome.getScore()));
				}

				// Tester si intersecte
				if (fantome.testIntersect(obs) != obs.getIntersecting()) {
					obs.toggleIntersecting();
					app.changerScore(Integer.toString(fantome.getScore()));
					app.colourierIntersection(i, obs.getIntersecting());
				}

				// Tester si hors de l'écran (x)
				if (obs.getX() + obs.getRayon() <= 0) {
					obstacles.remove(i);
					app.enleverObstacle(i);
				}
			}
		}
	}

	/**
	 * Créer les monstres
	 * Thread active durant tout le jeu
	 *
	 * @param dt Delta de temps - s
	 */
	public void creerMonstres(double dt) {
		accuCreate += dt;
		if (accuCreate > SPAWN_OBSTACLE) {
			accuCreate = 0.0;
			Obstacle obs = null;

			int initialRayon = (int) (Math.random() * Obstacle.MAX_RAYON + 1);
			if (initialRayon < 10) { initialRayon = 10; }

			double initialX = FlappyGhost.MAX_WIDTH + initialRayon / 2.0;
			double initialY = Math.random() * (FlappyGhost.GAME_HEIGHT - initialRayon);

			int randomType = (int) (Math.random() * 3); // Nombre de types d'obstacles
			switch (randomType) {
				case 0:
					double minY = ObstacleSinus.AMPLITUDE / 2.0 + initialRayon;
					double maxY = FlappyGhost.GAME_HEIGHT - ObstacleSinus.AMPLITUDE / 2.0 - initialRayon;
					if (initialY > maxY) { initialY = maxY; } else if (initialY < minY) { initialY = minY; }

					obs = new ObstacleSinus(initialX, initialY);
					break;
				case 1:
					obs = new ObstacleStatique(initialX, initialY);
					break;
				case 2:
					obs = new ObstacleQuantique(initialX, initialY);
					break;
			}

			obs.setRayon(initialRayon);

			obstacles.add(obs);
			app.ajouterObstacle(obs.getX(), obs.getY(), obs.getRayon(), obs.getImageIndex());
		}
	}
}
