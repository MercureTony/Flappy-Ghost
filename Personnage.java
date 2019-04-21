public abstract class Personnage {

    protected double x; // Du centre - px
    protected double y; // Du centre - px
    protected int rayon;

    protected int vx; // Vitesse en x (px/s)

    /**
     * Constructeur du Personnage
     *
     * @param x abscisse du Personnage
     * @param y ordonnée du Personnage
     */
    public Personnage(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructeur du Personnage
     *
     * @param x abscisse du Personnage
     * @param y ordonnée du Personnage
     * @param rayon La grandeur du personnage
     */
    public Personnage(double x, double y, int rayon) {
        this.x = x;
        this.y = y;
        this.rayon = rayon;
    }

    /**
     * Constructeur nul du Personnage
     */
    public Personnage() {}

    /**
     *
     * @return le rayon du Personnnage
     */
    public int getRayon() {
        return this.rayon;
    }

    /**
     *
     * @return retourne l'abscisse
     */
    public double getX() {
        return this.x;
    }

    /**
     *
     * @return retourne l'ordonnée
     */
    public double getY() {
        return this.y;
    }

    /**
     * Modifie le rayon
     *
     * @param rayon qui est le nouveau rayon du Personnage
     */
    public void setRayon(int rayon) {
        this.rayon = rayon;
    }

    /**
     * Modifie l'abscisse du Personnage
     *
     * @param x la nouvelle abscisse
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Modifie l'ordonnée du Personnage
     *
     * @param y la nouvelle ordonnée
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     *
     * @return la vitesse en abscisse
     */
    public int getVx() {
        return this.vx;
    }

    /**
     * Modifie la vitesse en abscisse
     *
     * @param vx
     */
    public void setVx(int vx) {
        this.vx = vx;
    }

    /**
     * Méthode qui permet de verifier si deux Personnage s'intersecte
     *
     * @param other qui l'autre Personnage avec qui ont vérfie l'intersection
     * @return un booléen qui vérifie la collision
     */
    public boolean intersect(Personnage other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        double dCarre = Math.pow(dx, 2) + Math.pow(dy, 2);

        return dCarre < Math.pow(this.rayon + other.rayon, 2);
    }
}
