package lk.ijse.hibernate.controller;

import lk.ijse.hibernate.Util.FactoryConfiguration;
import lk.ijse.hibernate.entity.Programme;
import lk.ijse.hibernate.entity.Student;
import lk.ijse.hibernate.entity.StudentDetails;
import lk.ijse.hibernate.entity.TM.StudentdetailsView;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class StudentDetailsController {
    public boolean AddStudentDetails(StudentDetails studentDetails) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(studentDetails);

        transaction.commit();
        session.close();
        return true;
    }

    public List<Object[]> viewStudentDetails() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql="SELECT s.studentId, s.studentName, s.studentPhoneNumber ,p.programmeName, sd.registrationDate " +
                "FROM Student s,StudentDetails sd,Programme p WHERE s.studentId = sd.student " +
                "AND sd.programme = p.programmeId";
        Query query = session.createQuery(hql);

        List<Object[]> list = query.list();

        transaction.commit();
        session.close();
        return list;
    }
}
