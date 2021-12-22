package lk.ijse.hibernate.Util;

import lk.ijse.hibernate.entity.Programme;
import lk.ijse.hibernate.entity.Student;
import lk.ijse.hibernate.entity.StudentDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(Programme.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(StudentDetails.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration()
                : factoryConfiguration;
    }
    public Session getSession() {
        return sessionFactory.openSession();
    }
}