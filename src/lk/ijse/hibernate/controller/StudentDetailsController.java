package lk.ijse.hibernate.controller;

import lk.ijse.hibernate.Util.FactoryConfiguration;
import lk.ijse.hibernate.entity.StudentDetails;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDetailsController {
    public boolean AddStudentDetails(StudentDetails studentDetails) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(studentDetails);

        transaction.commit();
        session.close();
        return true;
    }
}
