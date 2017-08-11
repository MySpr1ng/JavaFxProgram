package hibernate.dao;


import hibernate.entity.EmployeeEntity;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * Created by Spring on 01.08.2017.
 */
public interface EmployeeDAO {


    Long create(EmployeeEntity employeeEntity);
    EmployeeEntity read(Long id);
    boolean update(EmployeeEntity employeeEntityUpdate);
    boolean delete(EmployeeEntity employeelete);

    List<EmployeeEntity> getAll();

    EmployeeEntity checkLoginPass(String login, String password);

    int getRole(String login, String password);

    ObservableList<EmployeeEntity> getTable();
}
