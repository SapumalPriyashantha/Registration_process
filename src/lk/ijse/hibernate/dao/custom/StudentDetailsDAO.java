package lk.ijse.hibernate.dao.custom;

import lk.ijse.hibernate.dao.CrudDAO;
import lk.ijse.hibernate.entity.Programme;
import lk.ijse.hibernate.entity.StudentDetails;

import java.sql.SQLException;
import java.util.List;

public interface StudentDetailsDAO extends CrudDAO<StudentDetails, String> {
    List<Object[]> viewStudentDetails() throws SQLException, ClassNotFoundException;
}
