package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.dao.custom.StudentDetailsDAO;
import lk.ijse.hibernate.entity.StudentDetails;

import java.sql.SQLException;
import java.util.List;

public class StudentDetailsDAOImpl implements StudentDetailsDAO {
    @Override
    public boolean add(StudentDetails studentDetails) throws SQLException, ClassNotFoundException {
        return false;
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
}
