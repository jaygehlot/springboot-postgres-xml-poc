package com.mands.springboot.jpapostgres.example.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class OrderItem {

    private String sku;

    private Double price;

    public OrderItem() {}

    public OrderItem(final String sku, final Double price) {
        this.sku = sku;
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public Double getPrice() {
        return price;
    }

}
