package events_and_event_handlers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

public class Controller {
    @FXML
    private TextField nameField; //Without @FXML annotation this will not work
    @FXML
    private Button helloButton;
    @FXML
    private Button byeButton;
    @FXML
    private CheckBox ourCheckBox;
    @FXML
    private Label ourLabel;

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

    /**
     *
     * @param e getting the ActionEvent
     */
    @FXML
    public void onButtonClicked(ActionEvent e) {
        if (e.getSource().equals(helloButton)) {
            System.out.println("Hello, " + nameField.getText());
        } else if (e.getSource().equals(byeButton)) {
            System.out.println("Bye, " + nameField.getText());
        }

        // If we make the thread to sleep directly it will halt the whole program for that sleep time
        // The better way to handle this is running the thread in the background
        // Setting up the process to run in the background by implementing runnable
        Runnable task = new Runnable() {
            @Override
            public void run() { // This is running in background thread, so unable to update label
                try{
                    Thread.sleep(5000);
                    // To get rid of the Exception lets run the label updating after process is get completing. So that is label is
                    // getting updated on the UI Thread and we don't get any exception
                    Platform.runLater(new Runnable() { // Opening new Runnable to update the label
                        @Override
                        public void run() { // This is running in the UI Thread so updating the label
                            ourLabel.setText("We did something");
                        }
                    });
                } catch (InterruptedException e) {
                    // We don't care about this
                }
            }
        };

        // Starting the above task
        new Thread(task).start();

        if (ourCheckBox.isSelected()) {
            nameField.clear();
            helloButton.setDisable(true);
            byeButton.setDisable(true);
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

    @FXML
    public void handleChange() {
        System.out.println("The checkbox is " + (ourCheckBox.isSelected() ? "checked" : "not checked"));
    }
}

//by Ankush Chavan