package domain;
import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int quantity;
    private int price;

    @OneToMany(mappedBy = "product")
    private List<DependenciesInTheOrder> dependenciesInTheOrderList;

    public List<DependenciesInTheOrder> getDependenciesInTheOrderList() {
        return dependenciesInTheOrderList;
    }
    public void setDependenciesInTheOrderList(List<DependenciesInTheOrder> dependenciesInTheOrderList) {
        this.dependenciesInTheOrderList = dependenciesInTheOrderList;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
