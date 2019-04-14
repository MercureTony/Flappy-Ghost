package sample;

public abstract class Personnage {
    protected double xCoordinate;
    protected double yCoordinate;
    protected int radius;

    /**
     * Constructeur du Personnage
     *
     * @param xCoordinate abscisse du Personnage
     * @param yCoordinate ordonnée du Personnage
     */
    public Personnage(int xCoordinate,int yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    /**
     *
     * @return le rayon du Personnnage
     */
    public int getRadius() {
        return radius;
    }

    /**
     *
     * @return retourne l'abscisse
     */
    public double getXCoordinate() {
        return xCoordinate;
    }

    /**
     *
     * @return retourne l'ordonnée
     */
    public double getYCoordinate() {
        return yCoordinate;
    }

    /**
     * Modifie le rayon
     *
     * @param radius qui est le nouveau rayon du Personnage
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * Modifie l'abscisse du Personnage
     *
     * @param xCoordinate la nouvelle abscisse
     */
    public void setXCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    /**
     * Modifie l'ordonnée du Personnage
     *
     * @param yCoordinate la nouvelle ordonnée
     */
    public void setYCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    /**
     * Méthode qui permet de verifier si deux Personnage s'intersecte
     *
     * @param other qui l'autre Personnage avec qui ont vérfie l'intersection
     * @return un booléen qui vérifie la collision
     */
    public boolean intersect(Personnage other){
        double dx = this.xCoordinate - other.xCoordinate;
        double dy = this.yCoordinate - other.yCoordinate;
        double dCarre = Math.pow(dx,2)+Math.pow(dy,2);

        return dCarre < Math.pow(this.xCoordinate+other.xCoordinate,2);
    }
}
