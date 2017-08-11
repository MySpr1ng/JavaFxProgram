package javafx.controller;



import hibernate.entity.EmployeeEntity;
import hibernate.service.EmployeeService;
import hibernate.service.EmployeeServiceImpl;
import hibernate.utilHibernate.UtilHibernate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.utilfx.MainController;
import org.hibernate.Session;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.utilfx.MainController.mainController;


/**
 * Created by Spring on 03.08.2017.
 */
public class Controller2 implements Initializable{
    private static int count = 0;

    public Controller2() {
    }

    public static EmployeeEntity employeeEntity;
    private EmployeeEntity employeeEntity1;

    @FXML
    private TableView<EmployeeEntity> tableView;

    @FXML
    private TableColumn nameColumn;

    @FXML
    private TableColumn lastNameColumn;

    @FXML
    private TableColumn ageColumn;

    @FXML
    private Button btnCreate;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnGenerateAccount;


    @FXML
    void onActionGenerateAccount(ActionEvent event)throws IOException {
        mainController = new MainController();
        employeeEntity = tableView.getSelectionModel().getSelectedItem();
        employeeEntity1 = tableView.getSelectionModel().getSelectedItem();
        if (employeeEntity1 == null) {
            mainController.newScene("/javafx/employeeNotChosenError.fxml");
        }
        else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/javafx/accountGeneration.fxml"));
            Parent root = loader.load();
            Controller5 controller5 = loader.getController();
            controller5.setLogin(employeeEntity1.getLogin());
            controller5.setPassword(employeeEntity1.getPassword());
            Stage stage = (Stage) btnCreate.getScene().getWindow();
            stage.close();
            mainController.newScene("/javafx/accountGeneration.fxml");
        }
    }

    public static String loginGenerator(String name, String surname){
        String surname1 = "";
        StringBuilder stringBuilder = new StringBuilder().append(name.charAt(0)).append(".").append(surname);
        String finalLogin = stringBuilder.toString();
        EmployeeService employeeService = new EmployeeServiceImpl();
        List<EmployeeEntity> list = employeeService.findAll();
        for(EmployeeEntity a: list){
            if(a.getLogin().equals(finalLogin)) {
                count++;
                if (count == 1) {
                    StringBuilder sb = new StringBuilder(surname).append("_").append(count);
                    surname1 = sb.toString();
                }
                if (count > 1) {
                    StringBuilder sb = new StringBuilder(surname);
                    sb.delete(sb.length()-2, sb.length());
                    sb.append("_");
                    sb.append(count);
                    surname1 = sb.toString();
                }
                return loginGenerator(name, surname1);
            }
        }
        count =0;
        return finalLogin;
    }


    @FXML
    void onActionCreate(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnCreate.getScene().getWindow();
        stage.close();
        mainController = new MainController();
        mainController.newScene("/javafx/windowCreate.fxml");
    }

    @FXML
    void onActionEdit(ActionEvent event) throws IOException {
        mainController = new MainController();
        employeeEntity = tableView.getSelectionModel().getSelectedItem();
        if (employeeEntity == null) {
            mainController.newScene("/javafx/employeeNotChosenError.fxml");
        }
        else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/javafx/windowEdit.fxml"));
            Parent root = loader.load();
            Controller4 controller4 = loader.getController();
            controller4.setNameEdit(employeeEntity.getName());
            controller4.setSurnameEdit(employeeEntity.getSurname());
            controller4.setAgeEdit(employeeEntity.getAge());
            controller4.setDatePicker(employeeEntity.getEmployedDate());
            controller4.setRole(employeeEntity.getRole().toString());
            btnEdit.getScene().setRoot(root);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<EmployeeEntity, String>("name")); // название колонки из базы данных
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<EmployeeEntity, String>("surname"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<EmployeeEntity, Integer>("age"));
        tableView.setItems(getEmployeeEnt());
    }

    public ObservableList<EmployeeEntity>getEmployeeEnt() {
        ObservableList<EmployeeEntity> employeeEntitiesList = FXCollections.observableArrayList();
      Session session = UtilHibernate.getFactory().openSession();
        List<EmployeeEntity> eList = session.createCriteria(EmployeeEntity.class).list();
        for(EmployeeEntity aa: eList){
            employeeEntitiesList.add(aa);
        }
        return employeeEntitiesList;
    }

    public EmployeeEntity getEmployeeEntity1() {
        return employeeEntity1;
    }

    public void setEmployeeEntity1(EmployeeEntity employeeEntity1) {
        this.employeeEntity1 = employeeEntity1;
    }
}
