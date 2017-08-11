package javafx.utilfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Spring on 03.08.2017.
 */
public class MainController extends Application {
    public static Stage stage;
    public static MainController mainController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("Project");
        Parent root = FXMLLoader.load(getClass().getResource("/javafx/window0.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void changeScene(String sceneName) throws IOException {
        Parent root = FXMLLoader.load(MainController.class.getResource(sceneName));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void newScene(String sceneName) throws IOException{
        stage = new Stage();
        stage.setTitle("Window");
        Parent root = FXMLLoader.load(getClass().getResource(sceneName));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
