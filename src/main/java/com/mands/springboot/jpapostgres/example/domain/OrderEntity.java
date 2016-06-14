package com.mands.springboot.jpapostgres.example.domain;

import com.mands.springboot.jpapostgres.example.persistance.Order;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@TypeDefs(value =  {
        @TypeDef(name="xml", typeClass = com.github.thealchemist.pg_hibernate.XMLType.class)
})
@Entity(name = "t_order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "customer", nullable = false)
    private String customer;

//    @Lob
//    @Column(name = "orderXml", nullable = false)
//    private String orderXml;

    @Type(type = "xml")
    @Column(name = "order_xml")
    private Order order;

    public OrderEntity(final Order order) {
        this.customer = order.getCustomer();
        this.order = order;
    }

    public Long getId() {
      return id;
    }

    public Order getOrder() {
        return order;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getCustomer() {
      return customer;
    }

    public void setCustomer(String customer) {
      this.customer = customer;
    }

//    public String getOrderXml() {
//      return orderXml;
//    }
//
//    public void setOrderXml(String orderXml) {
//      this.orderXml = orderXml;
//  }
}
