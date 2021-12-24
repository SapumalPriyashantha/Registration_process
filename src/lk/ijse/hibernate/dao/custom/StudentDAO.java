package lk.ijse.hibernate.dao.custom;

import lk.ijse.hibernate.dao.CrudDAO;
import lk.ijse.hibernate.entity.Programme;
import lk.ijse.hibernate.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO extends CrudDAO<Student, String> {
//    List<String> getAllTrainingProgrammeIds()throws SQLException, ClassNotFoundException;
    String setStudentId() throws SQLException, ClassNotFoundException;
    List<Student> searchStudents(String text)throws SQLException, ClassNotFoundException;
}
