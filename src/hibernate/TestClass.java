package hibernate;

import hibernate.entity.EmployeeEntity;
import hibernate.enumtypes.Role;
import hibernate.service.EmployeeService;
import hibernate.service.EmployeeServiceImpl;
import java.util.Date;


/**
 * Created by Spring on 03.08.2017.
 */
public class TestClass {
    public static void main(String[] args) {
//
//      SessionFactory factory = UtilHibernate.getFactory();
//        EmployeeService servicex = new EmployeeServiceImpl();
//        EmployeeEntity employeeEntity = new EmployeeEntity("admin","admin", 15, new Date(), "admin", "admin", Role.ADMIN);
//        servicex.create(employeeEntity);


            StringBuilder sb = new StringBuilder("Кошка");
            System.out.println(sb.toString());
            sb.deleteCharAt(sb.length()-1);
             System.out.println(sb);

//        EmployeeEntity a = servicex.read(2L);
//        servicex.delete(a);


//        List<EmployeeEntity> a =  servicex.findAll();
//        for(EmployeeEntity b : a){
//            System.out.println(a);
//        }

    }
}
