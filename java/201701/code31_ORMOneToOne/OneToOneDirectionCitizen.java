package step31ORMOneToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="citizen_direct")
public class OneToOneDirectionCitizen {
    @Id
    @GeneratedValue
    private int id;
    
    private String name;
    
    @OneToOne
    @JoinColumn(name="id_card_id")
    private OneToOneDirectionIdCard idCard;
    
    public void setIdCard(OneToOneDirectionIdCard idCard) {
        this.idCard = idCard;
    }
    
    public OneToOneDirectionIdCard getIdCard() {
        return idCard;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
}
