package javafx.controller;

import hibernate.service.EmployeeService;
import hibernate.service.EmployeeServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.utilfx.MainController;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.io.IOException;

/**
 * Created by Spring on 03.08.2017.
 */
public class Controller1 {

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtFieldLogin;

    @FXML
    private TextField txtFieldPassword;

    @FXML
    private Label lblError;

    @FXML
    void onActionLogin(ActionEvent event) throws IOException {

        String a = txtFieldLogin.getText();
        String b = txtFieldPassword.getText();

        EmployeeService servicex = new EmployeeServiceImpl();
        MainController mainController = new MainController();
        try {
            if (servicex.checkLoginPassword(a, b) != null && servicex.getRole(a,b) == 0) {
                mainController.changeScene("/javafx/window2.fxml");
            }
            else if(servicex.checkLoginPassword(a, b) != null && servicex.getRole(a,b) == 1) {
                Stage stage = (Stage) btnLogin.getScene().getWindow();
                stage.close();
                mainController.newScene("/javafx/window6.fxml");
            }
        } catch (NoResultException bb) {
            lblError.setText("USER NOT FOUND!!!");
        }
    }
}
