import java.util.ArrayList;

public class Controleur {

	private Flappy fantome = new Flappy(0, 0);
	private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

	private FlappyGhost app;

	private boolean debug = false;

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
    public void bougerMonstres(double dt) {}

    /**
     * Créer les monstres
     * Thread active durant tout le jeu
     *
     * @param dt Delta de temps
     */
    public void creerMonstres(double dt) {}

    /**
     * Mettre en mode déboggage
     * Montrer tout les personnages en cercles
     * Quand la boite debug est activée
     */
    public void activerDebug() {}

    /**
     * Enlèver du mode déboggage
     * Montrer tout les personnages en images
     * Quand la boite debug est désactivée
     */
    public void desactiverDebug() {}
}
