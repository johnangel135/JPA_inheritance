package domain;

import com.sun.istack.internal.Nullable;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Duong Truong on 4/17/2018.
 */
@Entity
@Table(name = "ORDERLINE")
public class OrderLine {
    @Id @GeneratedValue
    private int id;
    private int quantity;

    @OneToOne
    @JoinColumn(name = "Order_id")
    private Order order;

    @OneToOne
    @JoinColumn
    private Product products;

    public OrderLine(){

    }


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }


    public OrderLine(Product products, int quantity) {
        this.quantity = quantity;
        this.products = products;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }
}
