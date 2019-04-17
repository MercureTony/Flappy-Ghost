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

import java.awt.*;

public class FlappyGhost extends Application {
    // Components of the window
    Button pause;
    Text score;
    CheckBox debug;
    Separator[] separator = new Separator[2];
    final int MAX_WIDTH = 640;
    final int MAX_HEIGHT = 440;
    String path = "file:images/";
    // Flappy
    Flappy flappy = new Flappy(340,400);

    @Override
    public void start(Stage primaryStage) throws Exception{
        /**
         * Platform design
         *
         */
        VBox root = new VBox();
        Scene scene = new Scene(root, MAX_WIDTH, MAX_HEIGHT);
        // Stage Key Events
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                Platform.exit();
            }
        });

        // Load images
        Image bg = new Image(path+"bg.png");
        Image ghost = new Image(path+"ghost.png");
        Image[] obstacle = new Image[Obstacle.NBR_IMAGES];

        // Load Obstacle
        for (int i = 0; i < Obstacle.NBR_IMAGES; i++){
            obstacle[i] = new Image(path+i+".png");
        }

        // Background scene
        Pane pane = new Pane();
        root.getChildren().add(pane);
        Canvas gameScene = new Canvas(MAX_WIDTH,400);
        pane.getChildren().add(gameScene);
        GraphicsContext context = gameScene.getGraphicsContext2D();
        ImageView imgView = new ImageView();
        imgView.setImage(bg);
        context.drawImage(bg,0,0);

        // Separator
        for (int i = 0; i < separator.length; i++){
            separator[i] = new Separator();
            separator[i].setOrientation(Orientation.VERTICAL);
            separator[i].setMinHeight(40);
        }

        // Menu
        HBox menu = new HBox(5);
        menu.setAlignment(Pos.CENTER);
        menu.setPadding(new Insets(0,0,0,5));
        // Items of the menu
        pause = new Button("Pause");
        debug = new CheckBox("Mode debug");
        score = new Text("Score:");
        score.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
        // Set of the items
        menu.getChildren().add(pause);
        menu.getChildren().add(separator[0]);
        menu.getChildren().add(debug);
        menu.getChildren().add(separator[1]);
        menu.getChildren().add(score);
        root.getChildren().add(1,menu);

        /**
         * Game code
         */
        scene.setOnMouseClicked((event) -> {
            System.out.println("Clic en : (" +
                    event.getX() + ", " + event.getY() +
                    ")");
        });

        /**
         * Window Launcher
         */
        // Title of game
        primaryStage.setTitle("Flappy Ghost");
        // Icon of the game
        primaryStage.getIcons().add(ghost);

        primaryStage.setScene(scene);
        // Disabled window resize
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
