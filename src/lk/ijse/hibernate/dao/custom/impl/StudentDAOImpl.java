package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.Util.FactoryConfiguration;
import lk.ijse.hibernate.dao.custom.StudentDAO;
import lk.ijse.hibernate.entity.Programme;
import lk.ijse.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean add(Student student) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.save(student);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Student student) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Student search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

//    @Override
//    public List<String> getAllTrainingProgrammeIds() throws SQLException, ClassNotFoundException {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        List<String> ids = new ArrayList<>();
//
//        String hql="FROM Programme ";
//        Query query = session.createQuery(hql);
//        List<Programme> rst = query.list();
//
//        for (Programme i:rst) {
//            ids.add(i.getProgrammeName());
//        }
//
//        transaction.commit();
//        session.close();
//        return ids;
//    }

    @Override
    public String setStudentId() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql="SELECT studentId FROM Student ORDER BY studentId DESC";
        Query query = session.createQuery(hql);
        query.setMaxResults(1);
        List<String> rst = query.list();

        transaction.commit();
        session.close();

        if (! rst.isEmpty()){

            int tempId = Integer.
                    parseInt(rst.get(0).split("-")[1]);
            tempId=tempId+1;
            if (tempId<=9){
                return "S-00"+tempId;
            }else if(tempId<99){
                return "S-0"+tempId;
            }else{
                return "S-"+tempId;
            }

        }else{
            return "S-001";
        }
    }

    @Override
    public List<Student> searchStudents(String text) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql="SELECT stud FROM Student stud WHERE stud.studentName like : customer_id";

        Query query=session.createQuery(hql);

        query.setParameter("customer_id","%"+text+"%");

        List list = query.list();

        transaction.commit();
        session.close();
        return list;
    }
}
