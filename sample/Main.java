package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        //Manual code for replacing the starting code in sample.fxml file
//        GridPane root = new GridPane();
//        root.setAlignment(Pos.CENTER); //Aligning to the centre
//        root.setVgap(10); //Vertical gap
//        root.setHgap(10); //Horizontal gap

        primaryStage.setTitle("Hello JavaFX!"); //Title for the application to display in the title bar
        primaryStage.setScene(new Scene(root, 300, 275)); //Setting height and width for the application screen

        //Adding label for welcoming to the application
//        Label greeting = new Label("Welcome to JavaFX!");
//        greeting.setTextFill(Color.GREEN); //Setting the color of the text to green
//        greeting.setFont(Font.font("Times New Roman", FontWeight.BOLD, 40)); //Setting the font properties
//
//        root.getChildren().add(greeting); //Adding controller

        //Showing the application
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

//by Ankush Chavan