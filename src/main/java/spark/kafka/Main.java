package spark.kafka;

import spark.kafka.Dao.EmployeeDao;
import spark.kafka.Entity.Employee;

public class Main {
    public static void main(String[] args) {
        EmployeeDao dao = new EmployeeDao();
        dao.saveEmployee(new Employee("emp1"));
        dao.saveEmployee(new Employee("emp2"));
        dao.saveEmployee(new Employee("emp3"));
    }
}
