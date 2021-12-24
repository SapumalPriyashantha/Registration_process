package lk.ijse.hibernate.bo.custom.impl;

import lk.ijse.hibernate.Util.FactoryConfiguration;
import lk.ijse.hibernate.bo.custom.StudentDetailsBO;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.custom.StudentDAO;
import lk.ijse.hibernate.dao.custom.StudentDetailsDAO;
import lk.ijse.hibernate.dto.StudentDetailsDTO;
import lk.ijse.hibernate.entity.Programme;
import lk.ijse.hibernate.entity.Student;
import lk.ijse.hibernate.entity.StudentDetails;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class StudentDetailsBOImpl implements StudentDetailsBO {
    private final StudentDetailsDAO studentDetailsDAO = (StudentDetailsDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENTDETAILS);

    @Override
    public boolean addStudentDetails(StudentDetailsDTO sd) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Programme programme = session.get(Programme.class,sd.getProgramme_id());
        Student customer = session.get(Student.class,sd.getStudent_id());
        transaction.commit();
        session.close();
        return studentDetailsDAO.add(new StudentDetails(programme,customer, sd.getRegistrationDate()));
    }

    @Override
    public List<Object[]> viewStudentDetails() throws SQLException, ClassNotFoundException {
        return studentDetailsDAO.viewStudentDetails();
    }
}
