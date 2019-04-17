public class Obstacle extends Personnage {
    private int radius;
    public static final int NBR_IMAGES = 46;

    /**
     * Constructeur des Obstacle
     *
     * @param x abscisse de l'ennemie
     * @param y ordonnnéé de l'ennemie
     */
    public Obstacle(int x, int y) {
        super(x, y);
    }

    /**
     * Cette méthode permet d'afficher aléatoirement les Obstacle du jeu
     *
     * @return l'identifiant de l'image
     */
    public int getImageIndex() {
        return (int) Math.floor(Math.random() * NBR_IMAGES);
    }

    /**
     * Cette méthode permet de générer des rayons aléatoirement pour chaque Obstacle
     *
     * @return le rayon de l'obstacle
     */

    @Override
    public int getRadius() throws NullPointerException {
        if (radius == 0) {
            throw new NullPointerException("Le rayon n'a pas été défini");
        }
        return radius;
    }

    public void setRadius() {
        this.radius = (int) Math.floor(Math.random() * NBR_IMAGES);
        if (this.radius < 10){
            radius = 10;
        }
    }
}
