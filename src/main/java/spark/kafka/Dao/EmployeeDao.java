package spark.kafka.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import spark.kafka.Entity.Employee;
import spark.kafka.Util.HibernateUtil;

public class EmployeeDao {
    private String name;
    Employee employee;
    public EmployeeDao(String name) {
        this.name = name;
    }


    public void saveEmployee() {
        Session session = null;
        Transaction transaction = null;

        try {
            // Obtain a new Session
            session = HibernateUtil.getSession();

            // Begin a transaction
            transaction = session.beginTransaction();
            employee = new Employee();
            employee.setName(name);
            session.save(employee);
            transaction.commit();

            System.out.println("Employee saved successfully!");
        } catch (Exception e) {
            // Rollback the transaction in case of an error
            if (transaction != null) {
                transaction.rollback();
            }
            // Log the exception or handle it appropriately
            e.printStackTrace();
        } finally {
            // Close the Session when done
            HibernateUtil.closeSession(session);
        }
    }
}
