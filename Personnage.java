public abstract class Personnage {

    protected int xCoordinate;
    protected int yCoordinate;
    protected int rayon;

    /**
     * Constructeur du Personnage
     *
     * @param xCoordinate abscisse du Personnage
     * @param yCoordinate ordonnée du Personnage
     */
    public Personnage(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    /**
     * Constructeur du Personnage
     *
     * @param xCoordinate abscisse du Personnage
     * @param yCoordinate ordonnée du Personnage
     * @param rayon La grandeur du personnage
     */
    public Personnage(int xCoordinate, int yCoordinate, int rayon) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.rayon = rayon;
    }

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
    public int getXCoordinate() {
        return this.xCoordinate;
    }

    /**
     *
     * @return retourne l'ordonnée
     */
    public int getYCoordinate() {
        return this.yCoordinate;
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
     * @param xCoordinate la nouvelle abscisse
     */
    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    /**
     * Modifie l'ordonnée du Personnage
     *
     * @param yCoordinate la nouvelle ordonnée
     */
    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    /**
     * Méthode qui permet de verifier si deux Personnage s'intersecte
     *
     * @param other qui l'autre Personnage avec qui ont vérfie l'intersection
     * @return un booléen qui vérifie la collision
     */
    public boolean intersect(Personnage other) {
        int dx = this.xCoordinate - other.xCoordinate;
        int dy = this.yCoordinate - other.yCoordinate;
        int dCarre = Math.pow(dx, 2) + Math.pow(dy, 2);

        return dCarre < Math.pow(this.rayon + other.rayon, 2);
    }
}
