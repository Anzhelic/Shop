package com.riabushenkp;
import domain.Product;
import domain.Order;
import ejb.OrdersManagerBean;
import ejb.ProductManagerBean;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Named
@SessionScoped
public class OrderBean implements Serializable {
    private Order order;
    private String name;
    private int quantity;
    private int price;

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

    @EJB
    private OrdersManagerBean ordersManagerBean;

    @EJB
    private ProductManagerBean productManagerBean;

    public void createOrder() {
        if (order == null) {
            order = ordersManagerBean.createOrder();
        }
    }
    public void createProduct() {
        productManagerBean.createProduct(name, quantity, price);
    }
    public List<Product> getProducts() {
        return productManagerBean.getProducts();
    }
    public void addProduct(Product product) {
        if (order == null) {
            return;
        }
        ordersManagerBean.addToOrder(product.getId(), order.getId(), 1);
    }
    public List<Product> getDependenciesInOrders() {
        if (order == null) {
            return Collections.emptyList();
        }
   return ordersManagerBean.getDependenciesInOrders(order.getId());
    }
}
