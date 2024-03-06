package spark.kafka.Dao;

import spark.kafka.Entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

public class EmployeeImp implements IEmployee{
    /* Déclaration de l’objet EntityManager qui permet de gérer les entités*/
    private EntityManager entityManager;

    /* Constructeur */
    public EmployeeImp() {
        /* Création de l’objet Entity Manager Factory */
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UP_CAT");
        /* Création de l’objet Entity Manager */
        entityManager = entityManagerFactory.createEntityManager();
    }

    //@Transactional
    @Override
    public void save(Employee employee) {
        /* Création d’une transaction */
        EntityTransaction transaction=entityManager.getTransaction(); /* Démarrer la transaction */
        transaction.begin();
        try {
            /* enregister le produit p dans la base de données */
            entityManager.persist(employee);
            /* Valider la transaction si tout se passe bien */
        transaction.commit();
        } catch (Exception e) {
        /* Annuler la transaction en cas d’exception  */
        transaction.rollback();
        e.printStackTrace();
    }
    }


    @Transactional
    public void saveE(Employee e) {
        entityManager.persist(e);
    }
}
