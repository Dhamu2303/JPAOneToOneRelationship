package com.xyz.JPAOneToOneRelastionship;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App{
    public static void main(String[] args) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Collection_Type");
        EntityManager em = emf.createEntityManager();
        
        
        try {
        	em.getTransaction().begin();

            // Create a new Student and LibraryCard
            Student student = new Student();
            student.setName("Jane Doe");

            LibraryCard libraryCard = new LibraryCard();
            libraryCard.setNumber("LC12345678");

            // Set the relationships
            student.setLibraryCard(libraryCard);
            libraryCard.setStudent(student);

            // Save the entities
            em.persist(student);
            em.persist(libraryCard);
            
            em.getTransaction().commit();
            
        } finally {
        	em.close();
            emf.close();
        }
    }
}
