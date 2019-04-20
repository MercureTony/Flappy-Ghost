public class Obstacle extends Personnage {

    public static final int NBR_IMAGES = 46;

    private int imageIndex;

    /**
     * Constructeur des Obstacle
     *
     * @param x abscisse de l'obstacle
     * @param y ordonnnéé de l'obstacle
     */
    public Obstacle(int x, int y) {
        super(x, y);
        this.imageIndex = (int) Math.random() * NBR_IMAGES;
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
    public void move(double dt) {
        this.x -= dt * this.vx;
    }
}
