package spark.kafka.Dao;

import spark.kafka.Entity.Employee;

import java.util.List;

public interface IEmployee {
    public void save(Employee e);
    public void update(Employee e);
    public Employee findById(Long id);
    public List<Employee> findAll();
    public void delete(Employee employee);
}
