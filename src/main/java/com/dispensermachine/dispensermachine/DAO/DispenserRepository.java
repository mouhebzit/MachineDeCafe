package com.dispensermachine.dispensermachine.DAO;

import com.dispensermachine.dispensermachine.Model.Dispenser;
import com.dispensermachine.dispensermachine.Service.EntityMangerProducer;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.StringReader;
import java.util.List;

import jakarta.inject.Inject;
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
public class DispenserRepository {


    //final static private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("app");

    private EntityManager entityManager = EntityMangerProducer.createEntityManager();

    public List<Dispenser> findAll() {
        return entityManager.createNamedQuery("Dispenser.findAll", Dispenser.class)
                .getResultList();
    }
    public Dispenser findDispenserById(Integer id) {
        Dispenser dispenser = entityManager.find(Dispenser.class, id);
        if (dispenser == null) {
            throw new WebApplicationException("Dispenser with id of " + id + " does not exist.", 404);
        }
        return dispenser;
    }

    public List<Dispenser> findDispensersToSupply() {
        String weatherApi = "http://api.weatherapi.com/v1/current.json?key=a828157cf1dc4aa2bcb175000230202&q=Paris&aqi=no";
        Client client = ClientBuilder.newClient();
        Response res = client.target(weatherApi).request(MediaType.APPLICATION_JSON).get();
        JsonObject weatherInfo = Json.createReader(new StringReader(res.readEntity(String.class))).readObject();
        double tempC = weatherInfo.getJsonObject("current").getJsonNumber("temp_c").doubleValue();
        client.close();
        String sql="";
        if (tempC>=25){
                sql = "SELECT D " +
                "FROM Dispenser D " +
                "JOIN DispenserStatus DS ON D.id = DS.id " +
                "JOIN Article A ON DS.id = A.dispenserStatusId " +
                "WHERE (A.quantity < 30 and D.drinkType= :ColdDrink) or A.quantity<10";
                return entityManager.createQuery(sql, Dispenser.class).setParameter("ColdDrink", "ColdDrink")
                    .getResultList();
        }
        else if (tempC<5){
                sql = "SELECT D " +
                "FROM Dispenser D " +
                "JOIN DispenserStatus DS ON D.id = DS.id " +
                "JOIN Article A ON DS.id = A.dispenserStatusId " +
                "WHERE (A.quantity < 30 and D.drinkType=:HotDrink) or A.quantity<10";
            return entityManager.createQuery(sql, Dispenser.class).setParameter("HotDrink","HotDrink")
                    .getResultList();
        }
        else {
            sql = "SELECT D " +
                    "FROM Dispenser D " +
                    "JOIN DispenserStatus DS ON D.id = DS.id " +
                    "JOIN Article A ON DS.id = A.dispenserStatusId " +
                    "WHERE A.quantity<10";
            return entityManager.createQuery(sql, Dispenser.class)
                    .getResultList();

        }

    }

    @Transactional
    public void updateDispenser(Integer id, String installationAddress,  String location) {
        EntityTransaction trans = entityManager.getTransaction();
        trans.begin();
        Dispenser DispenserToUpdate = findDispenserById(id);
        DispenserToUpdate.setInstallationAddress(installationAddress);
        DispenserToUpdate.setLocation(location);
        entityManager.persist(DispenserToUpdate);
        trans.commit();

    }

    @Transactional
    public void createDispenser(Dispenser dispenser) {
        EntityTransaction trans = entityManager.getTransaction();
        trans.begin();
        entityManager.persist(dispenser);
        trans.commit();
    }
    @Transactional
    public void deleteDispenser(Integer dispenserId) {
        EntityTransaction trans = entityManager.getTransaction();
        trans.begin();
        Dispenser d = findDispenserById(dispenserId);
        entityManager.remove(d);
        trans.commit();
    }
}
