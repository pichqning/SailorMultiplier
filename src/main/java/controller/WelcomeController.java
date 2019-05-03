package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import program.ChangePageManager;

public class WelcomeController {

    @FXML
    private Button welcomeButton;

    @FXML
    private void initialize() {

    }

    @FXML
    private void handleWelcomeButton() {
        ChangePageManager.setUI(this.getClass(), "/UI/LoginUI.fxml");
    }

}
