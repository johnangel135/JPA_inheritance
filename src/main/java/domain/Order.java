package domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Duong Truong on 4/17/2018.
 */
@Entity
@Table(name = "ORDERfix")
public class Order {
    @Id @GeneratedValue
    private int orderid;
    private Date date;

    @OneToMany
    private List<OrderLine> orderLines;

    public Order(Date date, List<OrderLine> orderLines) {
        this.date = date;
        this.orderLines = orderLines;
    }

    public Order(){

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
