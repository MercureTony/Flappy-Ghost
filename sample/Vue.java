package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

public class Vue extends Application {

    // Éléments graphiques
    private TextField input;
    private Button btn;
    private Text output;

    // Contrôleur de l'application
    private Controleur controleur;

    public static void main(String[] args) {
        Vue.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox root = new VBox();
        Scene scene = new Scene(root, 640, 400);

        Image img = new Image("/bg.png");
        ImageView imageView = new ImageView(img);
        root.getChildren().add(imageView);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Flappy Ghost");
        primaryStage.show();
    }

}
