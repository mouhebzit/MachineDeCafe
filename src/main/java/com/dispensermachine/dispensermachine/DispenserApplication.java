package com.dispensermachine.dispensermachine;

import com.dispensermachine.dispensermachine.Service.EntityMangerProducer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Application;

import java.util.List;

@ApplicationPath("/api")
public class DispenserApplication extends Application {
}