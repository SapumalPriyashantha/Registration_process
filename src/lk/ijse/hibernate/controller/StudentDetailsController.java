package lk.ijse.hibernate.controller;

import lk.ijse.hibernate.Util.FactoryConfiguration;
import lk.ijse.hibernate.entity.Programme;
import lk.ijse.hibernate.entity.Student;
import lk.ijse.hibernate.entity.StudentDetails;
import lk.ijse.hibernate.entity.TM.StudentdetailsView;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

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

    public List<StudentdetailsView> viewStudentDetails() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<String> ids = new ArrayList<>();

        String sql="SELECT s.studentId, s.studentName, s.studentPhoneNumber ,p.programmeName, sd.registrationDate FROM Student AS s INNER JOIN StudentDetails AS sd ON s.studentId = sd.student StudentDetails AS sd INNER JOIN Programme AS p ON sd.programme = p.programmeId";
        NativeQuery query = session.createSQLQuery(sql);
        query.addEntity(Student.class);
                query.addEntity(StudentDetails.class);
                query.addEntity(Programme.class);
        List<StudentdetailsView> list = query.list();

//        for (Programme i:rst) {
//            ids.add(i.getProgrammeName());
//        }

        transaction.commit();
        session.close();
        return list;
    }
}
