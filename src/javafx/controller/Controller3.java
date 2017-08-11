package javafx.controller;

import hibernate.entity.EmployeeEntity;
import hibernate.enumtypes.Role;
import hibernate.service.EmployeeService;
import hibernate.service.EmployeeServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.utilfx.MainController;
import java.io.IOException;


/**
 * Created by Spring on 05.08.2017.
 */
public class Controller3 {

    @FXML
    private Button btnSave;

    @FXML
    private ChoiceBox roleSt;

    @FXML
    private TextField txtFieldName;

    @FXML
    private TextField txtFieldSurname;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField txtFieldAge;

    @FXML
    private Button btnCancel;

    EmployeeService servicex = new EmployeeServiceImpl();

    @FXML
    void onActionCancel(ActionEvent event)throws IOException {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
        MainController.mainController.newScene("/javafx/window2.fxml");
    }

    @FXML
    void onActionSave(ActionEvent event) throws IOException{

        if(txtFieldName.getLength() >0 && txtFieldSurname.getLength() >0 && txtFieldAge.getLength() >0  && datePicker.getValue() !=null){
            Stage stage = (Stage) btnSave.getScene().getWindow();
            stage.close();
            int a = Integer.parseInt(txtFieldAge.getText());
            java.sql.Date gettedDatePickerDate = java.sql.Date.valueOf(datePicker.getValue()); // return date
            EmployeeEntity employeeEntity = new EmployeeEntity(txtFieldName.getText(),txtFieldSurname.getText(),a,gettedDatePickerDate,"","", Role.valueOf(roleSt.getValue().toString()));
            servicex.create(employeeEntity);
            MainController.mainController.newScene("/javafx/window2.fxml");
        }
        else {
            MainController mainController = new MainController();
            mainController.newScene("/javafx/windowError.fxml");
        }
        }

    ObservableList<String> roleStatus = FXCollections.observableArrayList("ADMIN","MANAGER","STOREKEEPER","CASHIER");

    public void initialize(){
        roleSt.setValue("MANAGER");
        roleSt.setItems(roleStatus);
    }
}
