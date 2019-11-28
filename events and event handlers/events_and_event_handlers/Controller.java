package events_and_event_handlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField nameField; //Without @FXML annotation this will not work
    @FXML
    private Button helloButton;
    @FXML
    private Button byeButton;

    /**
     *
     */
    @FXML
    public void initialize() {
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    /**
     *
     * @param e getting the ActionEvent
     */
//    @FXML
//    public void onButtonClicked(ActionEvent e) { //Using ActionEvent to get the control associated with method
//        System.out.println("Hello, " + nameField.getText());
//        System.out.println("Following button was pressed: " + e.getSource());
//    }

    @FXML
    public void onButtonClicked(ActionEvent e) {
        if (e.getSource().equals(helloButton)) {
            System.out.println("Hello, " + nameField.getText());
        } else if (e.getSource().equals(byeButton)) {
            System.out.println("Bye, " + nameField.getText());
        }
    }

    /**
     * This method is written to disable the buttons when the text field is empty
     */
    @FXML
    public void handleKeyRelease() {
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty(); //.trim() is used to set the button disable for space input
        helloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }
}
