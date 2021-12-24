package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.Util.FactoryConfiguration;
import lk.ijse.hibernate.dao.custom.ProgrammerDAO;
import lk.ijse.hibernate.entity.Programme;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgrammeDAOImpl implements ProgrammerDAO {
    @Override
    public boolean add(Programme programme) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.save(programme);

        transaction.commit();
        session.close();
        return true;
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

    @Override
    public String setProgrammeId() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql="SELECT programmeId FROM Programme ORDER BY programmeId DESC";
        Query query = session.createQuery(hql);
        query.setMaxResults(1);
        List<String> rst = query.list();

        transaction.commit();
        session.close();

        if (! rst.isEmpty()){

            int tempId = Integer.
                    parseInt(rst.get(0).split("-")[1]);
            tempId=tempId+1;
            if (tempId<=9){
                return "P-00"+tempId;
            }else if(tempId<99){
                return "P-0"+tempId;
            }else{
                return "P-"+tempId;
            }

        }else{
            return "P-001";
        }
    }

    @Override
    public List<Programme> getTrainingProgrammeId(String programmeName) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Programme WHERE programmeName = : programme_name";
        Query query = session.createQuery(hql);
        query.setParameter("programme_name",programmeName);
        List<Programme> rst = query.list();

        transaction.commit();
        session.close();
        return rst ;
    }

    @Override
    public List<String> getAllTrainingProgrammeIds() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<String> ids = new ArrayList<>();

        String hql="FROM Programme ";
        Query query = session.createQuery(hql);
        List<Programme> rst = query.list();

        for (Programme i:rst) {
            ids.add(i.getProgrammeName());
        }

        transaction.commit();
        session.close();
        return ids;
    }
}
