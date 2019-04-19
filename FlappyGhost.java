import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class FlappyGhost extends Application {

    // px
    public static final int MAX_WIDTH = 640;
    public static final int MAX_HEIGHT = 440;
    public static final int GAME_HEIGHT = 400;

    // Controleur
    private Controleur controleur = new Controleur(this);

    // Components of the window
    Button pause = new Button("Pause");
    CheckBox debug = new CheckBox("Mode debug");
    Separator[] separator = new Separator[2];
    Text scoreLabel = new Text("Score : ");
    Text score = new Text("");

    String path = "file:images/";

    // Instancier image du fantome
    Image ghost = new Image(path + "ghost.png");
    ImageView fantomeView = new ImageView(ghost);

    // Load images
    Image[] obstacles = new Image[Obstacle.NBR_IMAGES];

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Platform design
        VBox root = new VBox();
        Scene scene = new Scene(root, MAX_WIDTH, MAX_HEIGHT);

        // Background scene
        Pane pane = new Pane();
        root.getChildren().add(pane);
        Canvas gameScene = new Canvas(MAX_WIDTH, GAME_HEIGHT);
        pane.getChildren().add(gameScene);
        GraphicsContext context = gameScene.getGraphicsContext2D();

        // L'arrière-plan
        context.drawImage(new Image(path + "bg.png"), 0, 0);

        // Separator
        for (int i = 0; i < separator.length; i++){
            separator[i] = new Separator();
            separator[i].setOrientation(Orientation.VERTICAL);
            separator[i].setMinHeight(40);
        }

        // Menu
        HBox menu = new HBox(5);
        menu.setAlignment(Pos.CENTER);
        menu.setPadding(new Insets(0, 0, 0, 5));

        menu.getChildren().add(pause);
        menu.getChildren().add(separator[0]);
        menu.getChildren().add(debug);
        menu.getChildren().add(separator[1]);
        menu.getChildren().add(scoreLabel);
        menu.getChildren().add(score);
        root.getChildren().add(1, menu);

        fantomeView.setX(FlappyGhost.MAX_WIDTH / 2.0);
        fantomeView.setY(FlappyGhost.GAME_HEIGHT / 2.0);
        pane.getChildren().add(fantomeView);

        /* Après l’exécution de la fonction, le
           focus va automatiquement au canvas */
        Platform.runLater(() -> {
            gameScene.requestFocus();
        });

        /* Lorsqu’on clique ailleurs sur la scène,
           le focus retourne sur le canvas */
        scene.setOnMouseClicked((event) -> {
            gameScene.requestFocus();
        });

        // Threads du jeu
        scene.setOnKeyPressed(e -> {
            // Sortir du jeu
            if (e.getCode() == KeyCode.ESCAPE) {
                Platform.exit();
            }
            // Faire sauter
            if (e.getCode() == KeyCode.SPACE) {
                controleur.sauterFantome();
            }
        });

        // Activer déroulement de l'arrière-plan
        Thread derouleur = new Thread(() -> {
            controleur.deroulerPlan();
        });
        derouleur.start();

        // Activer la gravité pour Flappy
        Thread gravite = new Thread(() -> {
            controleur.faireGravite();
        });
        gravite.start();

        // Ajouter des monstres
        Thread creerMonstres = new Thread(() -> {
            controleur.creerMonstres();
        });
        creerMonstres.start();

        // Dernières modifications à la scène
        primaryStage.setTitle("Flappy Ghost");
        primaryStage.setScene(scene);

        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void moveGhost(double x, double y) {
        Platform.runLater(() -> {
            fantomeView.setX(x);
            fantomeView.setY(y);
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
