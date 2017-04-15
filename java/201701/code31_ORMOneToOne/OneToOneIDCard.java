package step31ORMOneToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="id_card")
public class OneToOneIDCard {
    @Id
    @GeneratedValue
    private int id;
    
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
}
