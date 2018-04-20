package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Duong Truong on 4/17/2018.
 */
@Entity
@Table(name = "ORDERfix")
public class Order {
    @Id @GeneratedValue
    private int id;
    private Date date;


    @OneToMany
    @JoinColumn
    private List<OrderLine> orderLines = new ArrayList<OrderLine>();

    public Order(Date date, List<OrderLine> orderLines) {
        this.date = date;
        this.orderLines = orderLines;
    }

    public Order(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
