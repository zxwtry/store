package step31ORMOneToOne;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name="hobby")
public class ManyToManyHobby {
    @Id
    @GeneratedValue
    private int id;
    
    @ManyToMany
    @JoinTable(
            name="hobby_has_people",
            joinColumns = @JoinColumn(name="hobby_id"),
            inverseJoinColumns = @JoinColumn(name="people_id")
            )
    private Set<ManyToManyPeople> peoples = new HashSet<ManyToManyPeople>();
    
    public Set<ManyToManyPeople> getPeoples() {
        return peoples;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
}
