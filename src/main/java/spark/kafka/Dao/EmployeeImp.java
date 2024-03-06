package spark.kafka.Dao;

import spark.kafka.Entity.Employee;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void update(Employee employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            entityManager.merge(employee);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Employee findById(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Employee employee = null;
        try {
            employee = entityManager.find(Employee.class, id);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        Query query = entityManager.createQuery("SELECT e FROM Employee e");
        return query.getResultList();
    }

    @Override
    public void delete(Employee employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.remove(employee);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
    }


    @Transactional
    public void saveE(Employee e) {
        entityManager.persist(e);
    }
}
