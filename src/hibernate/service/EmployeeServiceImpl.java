package hibernate.service;


import hibernate.dao.EmployeeDAO;
import hibernate.dao.EmployeeDAOImpl;
import hibernate.entity.EmployeeEntity;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * Created by Spring on 01.08.2017.
 */
public class EmployeeServiceImpl implements EmployeeService {



    private EmployeeDAO dao;

    public EmployeeServiceImpl() {
        dao = new EmployeeDAOImpl();
    }

    public void create(EmployeeEntity employeeEntity) {
        if(employeeEntity !=null){
            employeeEntity.setId(dao.create(employeeEntity));
        }
    }

    public EmployeeEntity read(Long id) {
        if(id !=0){
            return  dao.read(id);
        }
        return null;
    }

    public boolean update(EmployeeEntity employeeEntityUpdate) {
        dao.update(employeeEntityUpdate);
        return false;
    }

    @Override
    public EmployeeEntity checkLoginPassword(String login, String password) {
        return dao.checkLoginPass(login,password);
    }

    public boolean delete(EmployeeEntity employeeEntityDelete) {
        dao.delete(employeeEntityDelete);
        return true;
    }

    public List<EmployeeEntity> findAll() {
        return dao.getAll();
    }

    @Override
    public int getRole(String login, String password) {
        return dao.getRole(login,password);
    }

    @Override
    public ObservableList<EmployeeEntity> getTable() {
        return dao.getTable();
    }
}
