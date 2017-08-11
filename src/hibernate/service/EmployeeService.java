package hibernate.service;



import hibernate.entity.EmployeeEntity;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * Created by Spring on 01.08.2017.
 */
public interface EmployeeService {

    void create(EmployeeEntity employeeEntity);

    EmployeeEntity read(Long id);

    boolean update(EmployeeEntity employeeEntityUpdate);

    boolean delete(EmployeeEntity employeeEntityDelete);

    List<EmployeeEntity> findAll();

    EmployeeEntity checkLoginPassword(String login, String password);

    int getRole(String login, String password);

    ObservableList<EmployeeEntity> getTable();

}
