package spark.kafka;

import spark.kafka.Dao.EmployeeImp;
import spark.kafka.Entity.Employee;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeImp dao = new EmployeeImp();

        dao.save(new Employee("khalid"));
        dao.save(new Employee("smar"));
        dao.save(new Employee("monir"));
        List<Employee> employees = dao.findAll();
        System.out.println(employees.toString());
        dao.update(new Employee(1L, "mona"));
        Employee em1 = dao.findById(1L);
        Employee em3 = dao.findById(3L);
        dao.delete(em3);

        System.out.println(em1.toString());

    }
}
