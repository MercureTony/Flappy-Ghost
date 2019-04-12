package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;

public class FlappyGhost extends Application {

    Button pause;
    Text score;
    CheckBox debug;
    Separator separator = new Separator();

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox root = new VBox();
        Scene scene = new Scene(root, 640, 440);

        // Load images
        Image bg = new Image("file:src/sample/images/bg.png");
        Image ghost = new Image("file:src/sample/images/ghost.png");
        Image[] obstacle = new Image[27];

        // Load obstacles
        for (int i = 0; i < 27; i++){
            String path = "file:src/sample/images/";
            obstacle[i] = new Image(path+i+".png");
        }


        // Background scene
        VBox  gameScene =  new VBox();
        gameScene.setPrefHeight(400);
        gameScene.setPrefWidth(640);
        root.getChildren().add(gameScene);

        try {
            ImageView imgView = new ImageView();
            imgView.setImage(bg);
            gameScene.getChildren().add(imgView);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // Menu
        HBox menu = new HBox();
        menu.setAlignment(Pos.CENTER);
        menu.setPrefHeight(40);
        menu.setPrefWidth(640);
        menu.setPadding(new Insets(6,0,0,10));

        // Items of the menu
        pause = new Button("Pause");
        debug = new CheckBox("Mode debug");
        score = new Text("Score:");
        separator.setOrientation(Orientation.VERTICAL);
            menu.getChildren().add(pause);
            menu.getChildren().add(separator);
            menu.getChildren().add(debug);
            menu.getChildren().add(score);

        gameScene.getChildren().add(menu);

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
