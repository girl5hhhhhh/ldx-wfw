package com.ldx.repository.info;

import javax.persistence.*;

@Entity
@Table(name = "order_info")
public class OrderInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oid")
    private int id;

    @Column(name = "onumber")
    private String number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
