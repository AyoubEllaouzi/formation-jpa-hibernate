package spark.kafka.Entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    public Employee() {

    }

    public Employee(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
