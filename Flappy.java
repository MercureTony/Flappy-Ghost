public class Flappy extends Personnage {

    private int vx = 0; // Vitesse en x

    // Gravité px/s^2
    private int ax = 0;
    private int ay = 500;

    // Score de Flappy
    private int score = 0;

    /**
     * Constructeur du joueur Flappy
     *
     * @param x abscisse de Flappy initial
     * @param y ordonnée de Flappy initial
     */
    public Flappy(int x, int y) {
        // Rayon de 30px
        super(x, y, 30);
        this.vy = 120;
    }

    /**
     *
     * @return score
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Incrémente le score
     */
    public void incrementScore() {
        this.score++;
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
     *
     * @return la vitesse en ordonnée
     */
    public int getVy() {
        return this.vy;
    }

    /**
     * Modifie la vitesse en ordonnée
     *
     * @param vy
     */
    public void setVy(int vy) {
        this.vy = vy;
    }

    /**
     *
     * @return l'accélération en abscisse
     */
    public int getAx() {
        return this.ax;
    }

    /**
     * Modifie l'accélération en ordonnée
     *
     * @param ax
     */
    public void setAy(int ax) {
        this.ay = ax;
    }

    /**
     *
     * @return l'accélération en ordonnée
     */
    public int getAy() {
        return this.ay;
    }

    /**
     * Modifie l'accélération en ordonnée
     *
     * @param ay
     */
    public void setAy(int ay) {
        this.ay = ay;
    }

    /**
     * Augmenter la vitesse/accélération après deux obstacles dépassés
     *
     */
    public void update() {
        this.vy += 15;
        this.ay += 15;
        if (this.vy > 300) {
            this.vy = 300;
        }
    }

    /**
     * Augmnenter la vitesse à 300px/s quand le fantôme saute
     *
     * @return La vitesse (300px/s) du fantôme quand il saute
     */
    public int jump() {
        this.vx = 300;
    }

    /**
     * Vérifie si Flappy intersecte un obstacle, si oui, réinitialise son compteur
     * 
     * @param other qui représente les Obstacle
     */
    public void testIntersect(Personnage other) {
        if (intersect(other)) {
            this.score = 0;
            this.setVy(120);
            this.setAy(500);
        }
    }
}
