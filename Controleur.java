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

	private double getXOffset(Personnage p) {
		return p.getX() - p.getRayon();
	}

	private double getYOffset(Personnage p) {
		return p.getY() - p.getRayon();
	}

	public void commencer() {
		fantome.setX((FlappyGhost.MAX_WIDTH - fantome.getRayon()) / 2.0);
		fantome.setY((FlappyGhost.GAME_HEIGHT - fantome.getRayon()) / 2.0);
		app.moveGhost(getXOffset(fantome), getYOffset(fantome),
			fantome.getX(), fantome.getY());
		app.initFlappy(fantome.getRayon());
	}

	/**
	 * Faire sauter le fantome et déplacer l'image
	 * Se fait quand la touche 'espace' est faite
	 */
	public void sauterFantome() {
		fantome.jump();
		app.moveGhost(getXOffset(fantome), getYOffset(fantome),
			fantome.getX(), fantome.getY());
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
				app.moveObstacle(i, getXOffset(obs), getYOffset(obs), obs.getX(), obs.getY());
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
			Obstacle obs;

			int initialRayon = (int) (Math.random() * Obstacle.MAX_RAYON + 1);
        	if (initialRayon < 10) { initialRayon = 10; }

			double initialX = FlappyGhost.MAX_WIDTH + initialRayon / 2.0;
			double initialY = FlappyGhost.GAME_HEIGHT + initialRayon / 2.0;

			double randomNumber = Math.random();
			if (randomNumber < 1/3) {
				obs = new ObstacleSinus(initialX, initialY);
			} else if (randomNumber < 2/3) {
				obs = new ObstacleStatique(initialX, initialY);
			} else {
				obs = new ObstacleQuantique(initialX, initialY);
			}

			obs.setRayon(initialRayon);

			obstacles.add(obs);
			app.ajouterObstacle(getXOffset(obs), getYOffset(obs),
				obs.getX(), obs.getY(), obs.getRayon(), obs.getImageIndex());
		}
	}
}
