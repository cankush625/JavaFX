package events_and_event_handlers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField nameField; //Without @FXML annotation this will not work

    @FXML
    public void onButtonClicked() {
        System.out.println("Hello, " + nameField.getText());
    }
}
