import javafx.application.Application;
import javafx.scene.image.ImageView;

public class Controleur {

	private Flappy fantome = new Flappy(FlappyGhost.MAX_WIDTH / 2, FlappyGhost.GAME_HEIGHT / 2);

	private Application app;

    public Controleur(Application app) {
    	this.app = app;
    }

    public void sauterFantome(ImageView img) {
        fantome.jump();
        img.setX(fantome.getX());
        img.setY(fantome.getY());
    }

    public void jouer() {}

}
