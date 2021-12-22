package lk.ijse.hibernate.controller;

import lk.ijse.hibernate.Util.FactoryConfiguration;
import lk.ijse.hibernate.entity.Programme;
import lk.ijse.hibernate.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentController {
    public List<String> getAllTrainingProgrammeIds() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<String> ids = new ArrayList<>();

        String hql="FROM Programme ";
        Query query = session.createQuery(hql);
        List<Programme> rst = query.list();

        for (Programme i:rst) {
            ids.add(i.getProgrammeName());
        }

        transaction.commit();
        session.close();
        return ids;
    }

    public String setStudentId() {
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

    public boolean addStudents(Student s2) {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.save(s2);

        transaction.commit();
        session.close();
        return true;
    }

    public List<Student> searchStudents(String text) {

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


    public boolean changeStudentId(String oldStudentId, String newStudentIO) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "UPDATE Student SET studentId=:New_student_Id WHERE studentId=:Old_student_Id";
        Query query = session.createQuery(hql);
        query.setParameter("New_student_Id",newStudentIO);
        query.setParameter("Old_student_Id",oldStudentId);

        if (query.executeUpdate()>0) {
            transaction.commit();
            session.close();
            return true;
        }else {
            transaction.commit();
            session.close();
            return false;
        }
    }

    public boolean changeStudentDetailId(String oldStudentId, String newStudentIO) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "UPDATE StudentDetails SET student.studentId=:New_student_Id WHERE student.studentId=:Old_student_Id";
        Query query = session.createQuery(hql);
        query.setParameter("New_student_Id",newStudentIO);
        query.setParameter("Old_student_Id",oldStudentId);

        if (query.executeUpdate()>0) {
            transaction.commit();
            session.close();
            return true;
        }else {
            transaction.commit();
            session.close();
            return false;
        }
    }
}
