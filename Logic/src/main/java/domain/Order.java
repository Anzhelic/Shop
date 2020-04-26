package domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToMany(mappedBy = "order")
    private List<DependenciesInTheOrder> dependenciesInTheOrder;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<DependenciesInTheOrder> getDependenciesInTheOrder() {
        return dependenciesInTheOrder;
    }
    public void setDependenciesInTheOrder(List<DependenciesInTheOrder> dependenciesInTheOrder) {
        this.dependenciesInTheOrder = dependenciesInTheOrder;
    }
}
