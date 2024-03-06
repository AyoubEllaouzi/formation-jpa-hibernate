package spark.kafka;

import spark.kafka.Dao.EmployeeDao;

public class Main {
    public static void main(String[] args) {
        EmployeeDao employee1 = new EmployeeDao("slah");
        EmployeeDao employee2 = new EmployeeDao("monir");
        EmployeeDao employee3 = new EmployeeDao("mohamed");
        employee1.saveEmployee();
        employee2.saveEmployee();
        employee3.saveEmployee();
    }
}
