package javafx.controller;

import hibernate.entity.EmployeeEntity;
import hibernate.enumtypes.Role;
import hibernate.service.EmployeeService;
import hibernate.service.EmployeeServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.utilfx.MainController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


/**
 * Created by Spring on 06.08.2017.
 */
public class Controller4 {

    @FXML
    private ChoiceBox roleSt;

    @FXML
    private Button btnUpdate;

    @FXML
    private TextField txtFieldSurname;

    @FXML
    private TextField txtFieldName;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField txtFieldAge;

    @FXML
    private Button btnCancel;

    @FXML
    void onActionUpdate(ActionEvent event) throws IOException {
        EmployeeService servicex = new EmployeeServiceImpl();
        EmployeeEntity employeeEntity = Controller2.employeeEntity;
        System.out.println(employeeEntity.toString());
        employeeEntity.setName(txtFieldName.getText());
        employeeEntity.setSurname(txtFieldSurname.getText());
        employeeEntity.setAge(Integer.parseInt(txtFieldAge.getText()));
        Date date = Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        employeeEntity.setEmployedDate(date);
        employeeEntity.setRole(Role.valueOf(roleSt.getValue().toString()));
        servicex.update(Controller2.employeeEntity);
        Stage stage = (Stage) btnUpdate.getScene().getWindow();
        stage.close();
        MainController.mainController.changeScene("/javafx/window2.fxml");
    }

    @FXML
    void onActionCancel(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
        MainController.mainController.newScene("/javafx/window2.fxml");
    }

    ObservableList<String> roleStatus = FXCollections.observableArrayList("ADMIN","MANAGER","STOREKEEPER","CASHIER");

    public ChoiceBox getRoleSt() {
        return roleSt;
    }

   public void setNameEdit(String text){
       txtFieldName.setText(text);
   }

    public void setSurnameEdit(String text){
        txtFieldSurname.setText(text);
    }
    public void setAgeEdit(int age){
        txtFieldAge.setText(String.valueOf(age));
    }

    public void setDatePicker(Date date){
        LocalDate localDate = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(date));
        datePicker.setValue(localDate);
    }

    public void setRole(String role){
        roleSt.setValue(role);
        roleSt.setItems(roleStatus);
    }
}
