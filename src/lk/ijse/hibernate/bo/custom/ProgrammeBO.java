package lk.ijse.hibernate.bo.custom;

import lk.ijse.hibernate.bo.SuperBO;
import lk.ijse.hibernate.dto.ProgrammeDTO;
import lk.ijse.hibernate.entity.Programme;

import java.sql.SQLException;
import java.util.List;

public interface ProgrammeBO extends SuperBO {
    boolean addProgramme(ProgrammeDTO programme) throws SQLException, ClassNotFoundException;
    String setProgrammeId() throws SQLException, ClassNotFoundException;
    List<ProgrammeDTO> getTrainingProgrammeId(String programmeName) throws SQLException, ClassNotFoundException;
    List<String> getAllTrainingProgrammeIds() throws SQLException, ClassNotFoundException;
}
