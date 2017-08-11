package hibernate.utilHibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Created by Spring on 31.07.2017.
 */
public class UtilHibernate {

    private static final SessionFactory factory = build();
    private static StandardServiceRegistry registy;

    private static SessionFactory build(){

        registy = new StandardServiceRegistryBuilder().configure("hibernate/hibernate.cfg.xml").build();
        return  new MetadataSources(registy).buildMetadata().buildSessionFactory();

    }

    public static SessionFactory getFactory(){
        return factory;
    }

}
