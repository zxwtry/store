package step31ORMOneToOne;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="employer2")
public class OneToManyEmployer {    
    @Id
    @GeneratedValue
    private int id;
    
    private String name;
    
    @OneToMany
    @JoinColumn(name="employee_id")
    private Set<OneToManyEmployee> employees = new HashSet<OneToManyEmployee>();

    public Set<OneToManyEmployee> getEmployees() {
        return employees;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
