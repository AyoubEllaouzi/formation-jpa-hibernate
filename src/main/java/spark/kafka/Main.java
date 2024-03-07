package spark.kafka;

import spark.kafka.Dao.EmployeeImp;
import spark.kafka.Entity.Employee;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeImp dao = new EmployeeImp();
        dao.save(new Employee("emp1"));
        dao.save(new Employee("emp2"));
        dao.save(new Employee("emp3"));

        List<Employee> employees = dao.findAll();
        System.out.println(employees.toString());

        Employee e1 = dao.findById(1L);
        dao.delete(e1);


        dao.update(new Employee(3L, "ayoub"));



    }
}
