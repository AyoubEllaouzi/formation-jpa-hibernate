package spark.kafka.Dao;

import spark.kafka.Entity.Employee;

import java.util.List;

public interface IEmployee {
    public void save(Employee employee);
    public void update(Employee employee);
    public void delete(Employee employee);
    public List<Employee> findAll();
    public Employee findById(Long id);
}
