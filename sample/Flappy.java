package sample;

public class Flappy extends Personnage {
    public static final int radius = 30;
    // Vitesse de 120 px/s en ordonnée au début du jeu
    private int vy = 120;
    private int vx = 0;

    // Gravité (en accélération) au début du jeu
    private int ax = 0;
    private int ay = 500;

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
     * @return la vitesse en abscisse
     */
    public int getVx() {
        return vx;
    }

    /**
     *
     * @return la vitesse en ordonnée
     */
    public int getVy() {
        return vy;
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
     * Méthode qui permet de c'augmenter la vitesse/accélération après deux obstacles dépassés
     *
     */
    public void update(){
        vy += 15;
        ay += 15;
        if (ay > 300){
            ay = 300;
        }
    }

    /**
     * Cette méthode permet d'augmnenter la vitesse à 150px/s quand le fantôme saute
     *
     * @return La vitesse (150px/s) du fantôme quand il saute
     */
    public int jump(){
        return ax = 150;
    }
}
