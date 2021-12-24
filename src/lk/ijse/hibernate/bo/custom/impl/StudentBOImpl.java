package lk.ijse.hibernate.bo.custom.impl;

import lk.ijse.hibernate.bo.custom.StudentBO;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.custom.ProgrammerDAO;
import lk.ijse.hibernate.dao.custom.StudentDAO;
import lk.ijse.hibernate.dto.StudentDTO;
import lk.ijse.hibernate.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public boolean addStudent(StudentDTO s) throws SQLException, ClassNotFoundException {
        return studentDAO.add(new Student(s.getStudentId(),s.getStudentName(),
                s.getStudentAddress(),s.getStudentPhoneNumber()));
    }

    @Override
    public String setStudentId() throws SQLException, ClassNotFoundException {
        return studentDAO.setStudentId();
    }

    @Override
    public List<StudentDTO> searchStudents(String text) throws SQLException, ClassNotFoundException {
        ArrayList<StudentDTO> AllStudent=new ArrayList<>();
        List<Student> students = studentDAO.searchStudents(text);
        for (Student s : students) {
            AllStudent.add(new StudentDTO(s.getStudentId(),s.getStudentName(),
                    s.getStudentAddress(),s.getStudentPhoneNumber()));
        }
        return AllStudent;
    }
}
