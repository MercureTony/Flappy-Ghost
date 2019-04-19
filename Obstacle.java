public class Obstacle extends Personnage {

    public static final int NBR_IMAGES = 46;

    private int imageIndex;

    protected long lastT = 0; // Dernier temps utilisé

    /**
     * Constructeur des Obstacle
     *
     * @param x abscisse de l'obstacle
     * @param y ordonnnéé de l'obstacle
     * @param t Temps de création
     */
    public Obstacle(int x, int y, long t) {
        super(x, y);
        this.imageIndex = (int) Math.random() * NBR_IMAGES;
        this.lastT = t;
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
        if (rayon == 0) { this.setRayon(); }
        return rayon;
    }

    public void setRayon() {
        this.rayon = (int) Math.random() * NBR_IMAGES;
        if (this.rayon < 10) { this.rayon = 10; }
    }

    /**
     * Déplacer l'obstacle avec une règle par le temps
     *
     * @param t Temps actuel
     */
    public void move(long t) {
        int timeDelta = (int) (t - this.lastT) / 1e9; // ns -> s
        this.x -= timeDelta * this.vx;
        this.lastT = t;
    }
}
