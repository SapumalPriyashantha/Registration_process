package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.dao.custom.ProgrammerDAO;
import lk.ijse.hibernate.entity.Programme;

import java.sql.SQLException;
import java.util.List;

public class ProgrammeDAOImpl implements ProgrammerDAO {
    @Override
    public boolean add(Programme programme) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Programme programme) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Programme search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
