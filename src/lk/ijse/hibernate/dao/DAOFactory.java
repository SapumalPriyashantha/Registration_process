package lk.ijse.hibernate.dao;

import lk.ijse.hibernate.dao.custom.impl.ProgrammeDAOImpl;
import lk.ijse.hibernate.dao.custom.impl.StudentDAOImpl;
import lk.ijse.hibernate.dao.custom.impl.StudentDetailsDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDAOFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    //factory method
    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case PROGRAMME:
                return new ProgrammeDAOImpl();
            case STUDENT:
                return new StudentDAOImpl();
            case STUDENTDETAILS:
                return new StudentDetailsDAOImpl();
            default:
                return null;
        }
    }

    public enum DAOTypes {
        PROGRAMME, STUDENT, STUDENTDETAILS
    }
}
