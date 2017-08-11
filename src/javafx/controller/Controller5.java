package javafx.controller;

import hibernate.entity.EmployeeEntity;
import hibernate.service.EmployeeService;
import hibernate.service.EmployeeServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.utilfx.MainController;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by Spring on 07.08.2017.
 */
public class Controller5 {

    @FXML
    private TextField txtFldLogin;

    @FXML
    private TextField txtFldPassword;

    @FXML
    private CheckBox cbAuto;

    @FXML
    private Button btnGenerate;

    @FXML
    private Button btnClose;

    @FXML
    void onActionGenerate(ActionEvent event) {
        EmployeeService servicex = new EmployeeServiceImpl();
        EmployeeEntity employeeEntity = Controller2.employeeEntity;
        String name = employeeEntity.getName();
        String surname = employeeEntity.getSurname();
        String password = passwordGenerator();
        txtFldLogin.setText(Controller2.loginGenerator(name,surname));
        txtFldPassword.setText(password);
        employeeEntity.setLogin(Controller2.loginGenerator(name,surname));
        employeeEntity.setPassword(passwordGenerator());
        servicex.update(employeeEntity);
    }

    private String passwordGenerator(){
        String alphabet =
                new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
        String result = new String();
        Random r = new Random();
        for (int i=0; i<7; i++)
            result = result + alphabet.charAt(r.nextInt(alphabet.length()));
        return result;

    }

    @FXML
    void onActionClose(ActionEvent event)throws IOException {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
        MainController.mainController  = new MainController();
        MainController.mainController.newScene("/javafx/window2.fxml");

    }

    public void setLogin(String login){
        txtFldLogin.setText(login);
    }
    public void setPassword(String password){
        txtFldPassword.setText(password);
    }
}
