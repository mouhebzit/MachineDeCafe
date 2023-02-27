package com.dispensermachine.dispensermachine.DAO;
import com.dispensermachine.dispensermachine.Model.Dispenser;
import com.dispensermachine.dispensermachine.Model.DispenserReport;
import com.dispensermachine.dispensermachine.Service.EntityMangerProducer;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.StringReader;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class ReportRepository {

    private EntityManager entityManager = EntityMangerProducer.createEntityManager();
    public List<DispenserReport> findAll() {
        return entityManager.createNamedQuery("DispenserReport.findAll", DispenserReport.class)
                .getResultList();
    }

    public List<DispenserReport> findAllByDispenserID(Integer id) {
        String sql = "SELECT R " +
                "FROM DispenserReport R " +
                "WHERE R.dispenserStatusId=:id";
        return entityManager.createQuery(sql, DispenserReport.class).setParameter("id",id)
                .getResultList();
    }

    @Transactional
    public void createReport(DispenserReport dispenserReport) {
        EntityTransaction trans = entityManager.getTransaction();
        trans.begin();
        entityManager.persist(dispenserReport);
        trans.commit();
    }
}
