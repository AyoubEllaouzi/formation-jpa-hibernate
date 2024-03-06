package spark.kafka;

import spark.kafka.Dao.EmployeeImp;
import spark.kafka.Entity.Employee;

public class Main {
    public static void main(String[] args) {
        EmployeeImp dao = new EmployeeImp();

        dao.save(new Employee("khalid"));
        dao.save(new Employee("smar"));
        dao.save(new Employee("monir"));
    }
}
