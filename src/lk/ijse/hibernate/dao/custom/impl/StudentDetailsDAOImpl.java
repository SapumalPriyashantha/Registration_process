package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.Util.FactoryConfiguration;
import lk.ijse.hibernate.dao.custom.StudentDetailsDAO;
import lk.ijse.hibernate.entity.StudentDetails;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class StudentDetailsDAOImpl implements StudentDetailsDAO {
    @Override
    public boolean add(StudentDetails studentDetails) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(studentDetails);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(StudentDetails studentDetails) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public StudentDetails search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<Object[]> viewStudentDetails() throws SQLException, ClassNotFoundException {
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
