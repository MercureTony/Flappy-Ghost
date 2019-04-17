import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class FlappyGhost extends Application {

    final int MAX_WIDTH = 640;
    final int MAX_HEIGHT = 440;

    // Controleur
    Controleur controleur = new Controleur();

    // Components of the window
    Button pause;
    CheckBox debug;
    Separator[] separator = new Separator[2];
    Text score;

    String path = "file:images/";

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Platform design
        VBox root = new VBox();
        Scene scene = new Scene(root, MAX_WIDTH, MAX_HEIGHT);

        // Load images
        Image bg = new Image(path + "bg.png");
        Image ghost = new Image(path + "ghost.png");
        Image[] obstacle = new Image[Obstacle.NBR_IMAGES];

        // Load Obstacles
        for (int i = 0; i < Obstacle.NBR_IMAGES; i++){
            obstacle[i] = new Image(path + i + ".png");
        }

        // Background scene
        Pane pane = new Pane();
        root.getChildren().add(pane);
        Canvas gameScene = new Canvas(MAX_WIDTH, 400);
        pane.getChildren().add(gameScene);
        GraphicsContext context = gameScene.getGraphicsContext2D();
        ImageView imgView = new ImageView();
        imgView.setImage(bg);
        context.drawImage(bg, 0, 0);

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

        pause = new Button("Pause");
        debug = new CheckBox("Mode debug");
        score = new Text("Score :");

        menu.getChildren().add(pause);
        menu.getChildren().add(separator[0]);
        menu.getChildren().add(debug);
        menu.getChildren().add(separator[1]);
        menu.getChildren().add(score);
        root.getChildren().add(1,menu);

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

        primaryStage.setTitle("Flappy Ghost");
        primaryStage.setScene(scene);

        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
