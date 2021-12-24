package lk.ijse.hibernate.bo.custom;

import lk.ijse.hibernate.bo.SuperBO;
import lk.ijse.hibernate.dto.StudentDetailsDTO;
import lk.ijse.hibernate.entity.StudentDetails;

import java.sql.SQLException;
import java.util.List;

public interface StudentDetailsBO extends SuperBO {
    boolean addStudentDetails(StudentDetailsDTO studentDetails) throws SQLException, ClassNotFoundException;
    List<Object[]> viewStudentDetails() throws SQLException, ClassNotFoundException;
}
