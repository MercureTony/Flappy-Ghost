import java.util.ArrayList;

import javafx.animation.AnimationTimer;
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
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;

public class FlappyGhost extends Application {

    // px
    public static final int MAX_WIDTH = 640;
    public static final int MAX_HEIGHT = 440;
    public static final int GAME_HEIGHT = 400;

    // Controleur
    private Controleur controleur = new Controleur(this);

    // Platform design
    VBox root = new VBox();
    Scene scene = new Scene(root, MAX_WIDTH, MAX_HEIGHT);

    // Background scene
    Pane pane = new Pane();

    // Components of the window
    private Button pause = new Button("Pause");
    private CheckBox debug = new CheckBox("Mode debug");
    private Separator[] separator = new Separator[2];
    private Text scoreLabel = new Text("Score : ");
    private Text score = new Text("");

    private static final String PATH = "file:images/";

    // Instancier image du fantome
    Image ghost = new Image(PATH + "ghost.png");
    ImageView fantomeView = new ImageView(ghost);
    Circle ghostCercle = new Circle();

    // Obstacles
    private ArrayList<ImageView> obstacles = new ArrayList<ImageView>();
    private ArrayList<Circle> obstaclesCercles = new ArrayList<Circle>();

    // Debug?
    private boolean debugMode = false;

    @Override
    public void start(Stage primaryStage) throws Exception {

        root.getChildren().add(pane);
        Canvas gameScene = new Canvas(MAX_WIDTH, GAME_HEIGHT);
        pane.getChildren().add(gameScene);
        GraphicsContext context = gameScene.getGraphicsContext2D();

        // L'arrière-plan
        context.drawImage(new Image(PATH + "bg.png"), 0, 0);

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

        // Dernières modifications à la scène
        primaryStage.setTitle("Flappy Ghost");
        primaryStage.setScene(scene);

        primaryStage.setResizable(false);
        primaryStage.show();

        // Pour commencer jeu
        controleur.commencer();

        AnimationTimer mouvements = new AnimationTimer() {
            private long lastTime = 0; // ns
            private double x = 0, y = 150;

            @Override
            public void start() {
                lastTime = System.nanoTime();
                super.start();
            }

            @Override
            public void handle(long now) {
                double deltaTime = (now - lastTime) * 1e-9; // s

                // Activer déroulement de l'arrière-plan
                controleur.deroulerPlan(deltaTime);

                // Activer la gravité pour Flappy
                controleur.faireGravite(deltaTime);

                // Déplacer les monstres
                controleur.bougerMonstres(deltaTime);

                // Créer des monstres
                controleur.creerMonstres(deltaTime);
            }
        };
        mouvements.start();
    }

    public void initFlappy(int rayon) {
        Platform.runLater(() -> {
            pane.getChildren().add(fantomeView);

            ghostCercle.setRadius(rayon);
            pane.getChildren().add(ghostCercle);

            fantomeView.setVisible(true);
            ghostCercle.setVisible(false);
        });
    }

    public void moveGhost(double xOrigin, double yOrigin, double x, double y) {
        Platform.runLater(() -> {
            fantomeView.setX(xOrigin);
            fantomeView.setY(yOrigin);

            ghostCercle.setCenterX(x);
            ghostCercle.setCenterY(y);
        });
    }

    public void changerScore(String newScore) {
        Platform.runLater(() -> {
            score.setText(newScore);
        });
    }

    public void activateDebugMode() {
        Platform.runLater(() -> {
            for (ImageView obs : obstacles) {
                obs.setVisible(false);
            }

            for (Circle cer : obstaclesCercles) {
                cer.setVisible(true);
            }

            fantomeView.setVisible(false);
            ghostCercle.setVisible(true);
        });
    }

    public void deactivateDebugMode() {
        Platform.runLater(() -> {
            for (ImageView obs : obstacles) {
                obs.setVisible(true);
            }

            for (Circle cer : obstaclesCercles) {
                cer.setVisible(false);
            }

            fantomeView.setVisible(true);
            ghostCercle.setVisible(false);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
