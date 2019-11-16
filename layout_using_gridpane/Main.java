package layout_using_gridpane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setTitle("Hello JavaFX!"); //Title for the application to display in the title bar
        primaryStage.setScene(new Scene(root, 500, 275)); //Setting height and width for the application screen

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

//by Ankush Chavan