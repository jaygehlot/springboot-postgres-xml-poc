package com.mands.springboot.jpapostgres.example.persistance;

import com.mands.springboot.jpapostgres.example.domain.OrderItem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {

    private String customer;

    @XmlElement(name = "orderItem")
    public List<OrderItem> orderItems = new ArrayList<>();

    Order() {
        //for JAXB
    }

    public Order(final String customer) {
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }

    public void addOrderItem(final OrderItem orderItem) {
      this.orderItems.add(orderItem);
    }

    public void setOrderItem(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public List<OrderItem> getOrderItem() {
        return orderItems;
    }

}
