package lk.ijse.hibernate.bo.custom.impl;

import lk.ijse.hibernate.bo.custom.ProgrammeBO;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.custom.ProgrammerDAO;
import lk.ijse.hibernate.dto.ProgrammeDTO;
import lk.ijse.hibernate.dto.StudentDTO;
import lk.ijse.hibernate.entity.Programme;
import lk.ijse.hibernate.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgrammeBOImpl implements ProgrammeBO {
    private final ProgrammerDAO programmeDAO = (ProgrammerDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.PROGRAMME);

    @Override
    public boolean addProgramme(ProgrammeDTO p) throws SQLException, ClassNotFoundException {
        return programmeDAO.add(new Programme(p.getProgrammeId(),p.getProgrammeName(),
                p.getDuration(),p.getFee()));
    }

    @Override
    public String setProgrammeId() throws SQLException, ClassNotFoundException {
        return programmeDAO.setProgrammeId();
    }

    @Override
    public List<ProgrammeDTO> getTrainingProgrammeId(String programmeName) throws SQLException, ClassNotFoundException {
        ArrayList<ProgrammeDTO> programmeId=new ArrayList<>();
        List<Programme> programme = programmeDAO.getTrainingProgrammeId(programmeName);
        for (Programme p : programme) {
            programmeId.add(new ProgrammeDTO(p.getProgrammeId(),p.getProgrammeName(),
                    p.getDuration(),p.getFee()));
        }
        return programmeId;
    }

    @Override
    public List<String> getAllTrainingProgrammeIds() throws SQLException, ClassNotFoundException {
        return programmeDAO.getAllTrainingProgrammeIds();
    }
}
