package domain;

import javax.persistence.*;

@Entity
public class DependenciesInTheOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
@ManyToOne
    private Product product;
@ManyToOne
    private Order order;
    private int quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
