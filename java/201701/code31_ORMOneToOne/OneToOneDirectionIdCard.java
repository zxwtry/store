package step31ORMOneToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="id_card_direct")
public class OneToOneDirectionIdCard {
    @Id
    @GeneratedValue
    private int id;
    
    @OneToOne(mappedBy="idCard")   //OneToOneDirectionCitizen.idCard
    private OneToOneDirectionCitizen citizen;
    
    public void setCitizen(OneToOneDirectionCitizen citizen) {
        this.citizen = citizen;
    }
    
    public OneToOneDirectionCitizen getCitizen() {
        return citizen;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
}
