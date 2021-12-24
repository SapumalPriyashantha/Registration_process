package lk.ijse.hibernate.bo;

import lk.ijse.hibernate.bo.custom.impl.ProgrammeBOImpl;
import lk.ijse.hibernate.bo.custom.impl.StudentBOImpl;
import lk.ijse.hibernate.bo.custom.impl.StudentDetailsBOImpl;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory() {
    }

    public static BoFactory getBOFactory() {
        if (boFactory == null) {
            boFactory = new BoFactory();
        }
        return boFactory;
    }

    public SuperBO getBO(BoTypes types) {
        switch (types) {
            case PROGRAMME:
                return new ProgrammeBOImpl();
            case STUDENT:
                return new StudentBOImpl();
            case STUDENTDETAILS:
                return new StudentDetailsBOImpl();
            default:
                return null;
        }
    }

    public enum BoTypes {
        PROGRAMME, STUDENT, STUDENTDETAILS,
    }
}
