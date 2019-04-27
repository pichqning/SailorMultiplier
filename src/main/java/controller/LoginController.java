package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import orm.DatabaseManager;
import orm.UserDAO;
import program.ChangePageManager;
import program.User;


public class LoginController {

    @FXML
    private TableColumn<User, String> username;

    @FXML
    private TableView<User> showUsername;

    @FXML
    private Button loginButton, deleteUserButton;

    private ObservableList<User> observableList = null;

    private DatabaseManager db;

    private UserDAO userDAO;

    private static User userLogin;

    private String usernameToLogin = "", usernameToDelete = "";
    private Stage stage;

    @FXML
    private void initialize() {
        db = DatabaseManager.getInstance();
        userDAO = db.getUserDao();
        showUsername.setItems(null);
        showUsernameList();
        observableList = null;
    }

    @FXML
    private void handleLoginButton() {
        if(checkChosenUser()){
        observableList = showUsername.getSelectionModel().getSelectedItems();
        usernameToLogin = observableList.get(0).getUsername();
            userLogin = userDAO.getUserFromUsername(usernameToLogin);
            Stage stage = new Stage();
            ChangePageManager.changePage(LoginController.class, stage, "/UI/SelectQuestionUI.fxml");
        }
    }

    @FXML
    private void handleCreateUserButton(){
        stage = new Stage();
        ChangePageManager.changePage(LoginController.class, stage, "/UI/CreateUserUI.fxml");
    }

    @FXML
    private void handleDeleteUserButton() {
        observableList = showUsername.getSelectionModel().getSelectedItems();
        usernameToDelete = observableList.get(0).getUsername();
        userDAO.deleteUser(usernameToDelete);
        stage = new Stage();
        ChangePageManager.changePage(LoginController.class, stage, "/UI/LoginUI.fxml");
    }

    public void showUsernameList() {
        observableList = FXCollections.observableArrayList();
        for(User u: userDAO){
            observableList.add(u);
        }

        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        showUsername.setItems(observableList);
    }

    private boolean checkChosenUser(){
        if(showUsername.getSelectionModel().getSelectedItems().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Please, choose user for login");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    public static User getUser() {
        return userLogin;
    }
}
