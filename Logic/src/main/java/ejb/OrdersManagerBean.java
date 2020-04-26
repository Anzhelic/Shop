package ejb;

import domain.DependenciesInTheOrder;
import domain.Order;
import domain.Product;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Stateless
@LocalBean
public class OrdersManagerBean {
    @PersistenceContext(unitName = "JPATest")
    private EntityManager entityManager;

    public  Order createOrder(){
        Order order = new Order();
        entityManager.persist(order);
        return order;
    }
    public boolean addToOrder(long productId, long orderId, int quantity) {
        Product product = entityManager.find(Product.class, productId);
        if (product == null) {
            return false;
        }
        Order order = entityManager.find(Order.class, orderId);
        if (order == null) {
            return false;
        }
        DependenciesInTheOrder dependenciesInTheOrder=new DependenciesInTheOrder();
        dependenciesInTheOrder.setProduct(product);
        dependenciesInTheOrder.setQuantity(quantity);
        dependenciesInTheOrder.setOrder(order);
        entityManager.persist(dependenciesInTheOrder);
        return true;
    }
    public List<Product> getDependenciesInOrders(long orderId) {
        Order order= new Order();
        if (order == null) {
            return Collections.emptyList();
        }
        List<DependenciesInTheOrder> dependenciesInOrders = order.getDependenciesInTheOrder();
        List<Product> result = new ArrayList<>();
        for (DependenciesInTheOrder dependenciesInTheOrder : dependenciesInOrders) {
            result.add(dependenciesInTheOrder.getProduct());
        }
        return result;
    }
}
