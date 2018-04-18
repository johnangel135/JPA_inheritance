package domain;

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

    @Embedded
    private Product products;

    public OrderLine(){

    }

    public OrderLine( Product products, int quantity) {
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
