package step31ORMOneToOne;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="employee")
public class ManyToOneEmployee {
    @Id
    @GeneratedValue
    private int id;
    
    private String name;
    
    private String title;
    
    private float salary;
    
    private Date birthDay;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="employer_id")
    private ManyToOneEmployer employer;
    
    public void setEmployer(ManyToOneEmployer employer) {
        this.employer = employer;
    }
    
    public ManyToOneEmployer getEmployer() {
        return employer;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
    
}
