package lk.ijse.hibernate.controller;

import lk.ijse.hibernate.Util.FactoryConfiguration;
import lk.ijse.hibernate.entity.Programme;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TrainingProgrammecontroller {
    public boolean addTrainingProgramme(Programme p1) {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        session.save(p1);

        transaction.commit();
        session.close();
        return true;
    }

    public String setProgrammeId() {
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

    public List<Programme> getTrainingProgrammeId(String programmeName) {
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
}
