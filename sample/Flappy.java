package sample;

public class Flappy extends Personnage {
    public static final int radius = 30;
    // Vitesse de 120 px/s en ordonnée au début du jeu
    private int vy = 120;
    private int vx = 0;

    // Gravité (en accélération) au début du jeu
    private int ax = 0;
    private int ay = 500;

    // Score de Flappy
    private int score = 0;

    /**
     * Constructeur du joueur Flappy
     *
     * @param x abscisse de Flappy
     * @param y ordonnée de Flappy
     */
    public Flappy(int x, int y){
        super(x,y);
    }

    /**
     *
     * @return le score actuel à l'instant t
     */
    public int getScore() {
        return score;
    }

    /**
     * Modifie le score
     *
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     *
     * @return la vitesse en abscisse
     */
    public int getVx() {
        return vx;
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
        return vy;
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
        return ax;
    }

    /**
     *
     * @return l'accélération en ordonnée
     */
    public int getAy() {
        return ay;
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
     * Méthode qui permet de c'augmenter la vitesse/accélération après deux obstacles dépassés
     *
     */
    public void update(){
        vy += 15;
        ay += 15;
        if (vy > 300){
            vy = 300;
        }
    }

    /**
     * Cette méthode permet d'augmnenter la vitesse à 300px/s quand le fantôme saute
     *
     * @return La vitesse (300px/s) du fantôme quand il saute
     */
    public int jump(){
        return vx = 300;
    }

    public void testIntersect(Personnage other) {
        if (intersect(other)) {
            setScore(0);
            setVy(120);
            setAy(500);
        }
    }
}
