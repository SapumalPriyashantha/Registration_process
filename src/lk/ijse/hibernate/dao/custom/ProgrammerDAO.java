package lk.ijse.hibernate.dao.custom;

import lk.ijse.hibernate.dao.CrudDAO;
import lk.ijse.hibernate.entity.Programme;

import java.sql.SQLException;
import java.util.List;

public interface ProgrammerDAO extends CrudDAO<Programme, String> {
    String setProgrammeId() throws SQLException, ClassNotFoundException;
    List<Programme> getTrainingProgrammeId(String programmeName) throws SQLException, ClassNotFoundException;
    List<String> getAllTrainingProgrammeIds() throws SQLException, ClassNotFoundException;
}
