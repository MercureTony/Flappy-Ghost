package sample;

public class Obstacles extends Personnage {
    private int x_Coordinate;
    private int y_Coordinate;
    private int radius;
    public static final int NBR_IMAGES = 46;

    public Obstacles(int x, int y) {
        super(x, y);
        this.x_Coordinate = x;
        this.y_Coordinate = y;
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
    public void setRadius(int radius) {
        radius = (int) Math.floor(Math.random() * NBR_IMAGES);
        if (radius < 10) {
            radius = 10;
        }
    }
}