//package com.dispensermachine.dispensermachine;

import java.util.List;

import com.dispensermachine.dispensermachine.Model.Dispenser;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//public class ConsoleJPA {

    /*public static void main(String[] args) throws Exception {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("WebStore");
            entityManager = entityManagerFactory.createEntityManager();

            System.out.println( "- Lecture de tous les articles -----------" );

            List<Dispenser> dispensers = entityManager.createNamedQuery( "Dispenser.findAll", Dispenser.class )
                    .getResultList();
            for (Dispenser dispenser : dispensers) {
                System.out.println( dispenser );
            }
            /*
            System.out.println( "- Insertion d'un nouvel article ----------" );

            EntityTransaction trans = entityManager.getTransaction();
            trans.begin();

            Article newArticle = new Article( "DBS", "Aston Martin", 200000 );
            entityManager.persist( newArticle );

            List<Article> results = entityManager.createQuery("from Article", Article.class).getResultList();
            for( Article article : results) {
                System.out.println( article );
            }

            System.out.println( "- Modification d'un article --------------" );

            newArticle.setPrice( 40000 );
            entityManager.persist( newArticle );

            results = entityManager.createQuery("from Article", Article.class).getResultList();
            for( Article article : results) {
                System.out.println( article );
            }

            System.out.println( "- Suppression d'un article ---------------" );

            entityManager.remove( newArticle );

            results = entityManager.createQuery("from Dispenser ", Dispenser.class).getResultList();
            for( Dispenser dispenser : results) {
                System.out.println( dispenser );
            }*/

          /*  trans.commit();
        } finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
    }
}*/
