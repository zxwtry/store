package step31ORMOneToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Value;

@Entity(name="citizen")
public class OneToOneCitizen {
    @Id
    @GeneratedValue
    private int id;
    
    private String name;
    
    @OneToOne
    @Value("my_id_card")
    private OneToOneIDCard idCard;
    
    public void setIdCard(OneToOneIDCard idCard) {
        this.idCard = idCard;
    }
    public OneToOneIDCard getIdCard() {
        return idCard;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
