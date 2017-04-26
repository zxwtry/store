package step31ORMOneToOne;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Type;

@Entity(name="people")
public class ManyToManyPeople {
    @Id
    @GeneratedValue
    private long id;
    
    @Type(type="text")
    private String name;
    
    @ManyToMany
    @JoinTable(
            name="people_has_hobby", 
            joinColumns = @JoinColumn(name="people_id"),
            inverseJoinColumns= @JoinColumn(name="hobby_id")
            )
    private Set<ManyToManyHobby> hobbies = new HashSet<ManyToManyHobby>();
    
    public Set<ManyToManyHobby> getHobbies() {
        return hobbies;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
}
