package sample;

public class Obstacles extends Personnage {
    private int radius;
    public static final int NBR_IMAGES = 46;

    /**
     * Constructeur des obstacles
     *
     * @param x abscisse de l'ennemie
     * @param y ordonnnéé de l'ennemie
     */
    public Obstacles(int x, int y) {
        super(x, y);
    }

    /**
     * Cette méthode permet d'afficher aléatoirement les obstacles du jeu
     *
     * @return l'identifiant de l'image
     */
    public int getImageIndex() {
        return (int) Math.floor(Math.random() * NBR_IMAGES);
    }

    /**
     * Cette méthode permet de générer des rayons aléatoirement pour chaque obstacles
     *
     * @return le rayon de l'obstacle
     */

    @Override
    public int getRadius() {
        radius = (int) Math.floor(Math.random() * NBR_IMAGES);
        if (radius < 10) {
            setRadius(10);
        }
        return radius;
    }
}
