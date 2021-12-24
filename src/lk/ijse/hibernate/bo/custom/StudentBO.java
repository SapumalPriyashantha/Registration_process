package lk.ijse.hibernate.bo.custom;

import lk.ijse.hibernate.bo.SuperBO;
import lk.ijse.hibernate.dto.StudentDTO;
import lk.ijse.hibernate.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentBO extends SuperBO {
    boolean addStudent(StudentDTO student) throws SQLException, ClassNotFoundException;
//    List<String> getAllTrainingProgrammeIds() throws SQLException, ClassNotFoundException;
    String setStudentId() throws SQLException, ClassNotFoundException;
    List<StudentDTO> searchStudents(String text) throws SQLException, ClassNotFoundException;
}
