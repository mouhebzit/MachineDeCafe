package com.dispensermachine.dispensermachine.DAO;
import com.dispensermachine.dispensermachine.Model.Sales;
import com.dispensermachine.dispensermachine.Service.EntityMangerProducer;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

import jakarta.persistence.*;

@ApplicationScoped
public class SalesRepository {

    private EntityManager entityManager = EntityMangerProducer.createEntityManager();

    public List<Sales> findAll() {
        return entityManager.createNamedQuery("Sales.findAll", Sales.class)
                .getResultList();
    }

    public List<Sales> findSalesById(Integer id) {
        String sql = "SELECT S " +
                "FROM Sales S " +
                "WHERE S.salesDispenserID="+id;
        return entityManager.createQuery(sql, Sales.class)
                .getResultList();
    }

}
