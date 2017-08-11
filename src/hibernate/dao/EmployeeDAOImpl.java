package hibernate.dao;


import hibernate.entity.EmployeeEntity;
import hibernate.utilHibernate.UtilHibernate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.List;


/**
 * Created by Spring on 01.08.2017.
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    SessionFactory sessionFactory;

    public EmployeeDAOImpl(){
        sessionFactory = UtilHibernate.getFactory();
    }

    public Long create(EmployeeEntity employeeEntity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Long id = (Long) session.save(employeeEntity);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    public EmployeeEntity read(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        EmployeeEntity employeeEntity = session.get(EmployeeEntity.class, id);
        session.close();
        return employeeEntity;
    }

    public boolean update(EmployeeEntity employeeEntityUpdate) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("update EmployeeEntity set name =:name, surname =:surname, age = :age, employedDate =:employedDate, login =:login, password = :password, role= :role where id = :id");
            query.setParameter("name", employeeEntityUpdate.getName());
            query.setParameter("surname", employeeEntityUpdate.getSurname());
            query.setParameter("age", employeeEntityUpdate.getAge());
            query.setParameter("employedDate", employeeEntityUpdate.getEmployedDate());
            query.setParameter("login", employeeEntityUpdate.getLogin());
            query.setParameter("password", employeeEntityUpdate.getPassword());
            query.setParameter("role", employeeEntityUpdate.getRole());
            query.setParameter("id", employeeEntityUpdate.getId());

            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            return true;
        }
        catch (HibernateException exc) {
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean delete(EmployeeEntity employeeDelete) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(employeeDelete);
            //Query query = session.createQuery("delete from EmployeeEntity where id =:id");
           // query.setParameter("id", employeeDelete.getId());
            session.getTransaction().commit();
            return true;
        }
        catch (HibernateException exc) {
            session.getTransaction().rollback();
            return false;
        }
    }

    public List<EmployeeEntity> getAll() {
        return sessionFactory.openSession().createQuery("from EmployeeEntity").list();
    }

    @Override
    public int getRole(String login, String password) {
        Object object =  sessionFactory.openSession().createQuery("from EmployeeEntity where login = :login AND password = :password").setParameter("login",login).setParameter("password",password).getSingleResult();
        EmployeeEntity employeeEntity = (EmployeeEntity)object;
        return employeeEntity.getRole().ordinal();
    }

    @Override
    public EmployeeEntity checkLoginPass(String login, String password) {
        Object object =  sessionFactory.openSession().createQuery("from EmployeeEntity where login = :login AND password = :password").setParameter("login",login).setParameter("password",password).getSingleResult();
        return (EmployeeEntity)object;
            }

    @Override
    public ObservableList<EmployeeEntity> getTable() {
        Query query = sessionFactory.openSession().createQuery("from EmployeeEntity");
        ObservableList<EmployeeEntity> list = FXCollections.observableList(query.list());
        return list;
    }
}
