package lk.ijse.hibernate.dao.custom;

import lk.ijse.hibernate.dao.CrudDAO;
import lk.ijse.hibernate.entity.Programme;

import java.sql.SQLException;

public interface ProgrammerDAO extends CrudDAO<Programme, String> {
//    Programme getProgramme(String programmeID) throws SQLException, ClassNotFoundException;
}
//public interface CustomerDAO extends CrudDAO<Customer, String> {
//    Customer getCustomer(String customerID) throws SQLException, ClassNotFoundException;
//}