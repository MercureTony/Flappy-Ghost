public class Controleur {

	private Flappy fantome = new Flappy(FlappyGhost.MAX_WIDTH / 2, FlappyGhost.GAME_HEIGHT / 2);

	private FlappyGhost app;

    public Controleur(FlappyGhost app) {
    	this.app = app;
    }

    /**
     * Faire sauter le fantome et déplacer l'image
     *
     * Se fait quand la touche 'espace' est faite
     */
    public void sauterFantome() {
        fantome.jump();
        app.moveGhost(fantome.getX(), fantome.getY());
    }

    /**
     * Faire dérouler l'arrière-plan
     * dépendant sur la vitesse de Flappy
     *
     * Thread active durant tout le jeu
     */
    public void deroulerPlan() {}

    /**
     * Faire subir Flappy à la gravité
     *
     * Thread active durant tout le jeu
     */
    public void faireGravite() {}

    /**
     * Gère les monstres
     * Les créer, détruire, et les faire déplacer
     *
     * Thread active durant tout le jeu
     */
    public void creerMonstres() {}

    /**
     * Mettre en mode déboggage
     * Montrer tout les personnages en cercles
     *
     * Quand la boite debug est activée
     */
    public void activerDebug() {}

    /**
     * Enlèver du mode déboggage
     * Montrer tout les personnages en images
     *
     * Quand la boite debug est désactivée
     */
    public void desactiverDebug() {}
}
