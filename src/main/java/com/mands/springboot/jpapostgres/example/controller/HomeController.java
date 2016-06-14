package com.mands.springboot.jpapostgres.example.controller;

import com.mands.springboot.jpapostgres.example.persistance.Order;
import com.mands.springboot.jpapostgres.example.domain.OrderEntity;
import com.mands.springboot.jpapostgres.example.persistance.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBException;
import java.io.StringWriter;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class HomeController {

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello there !";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public OrderEntity create(@RequestBody final Order order) throws JAXBException {
        StringWriter orderXml = new StringWriter();
        JAXB.marshal(order, orderXml);

        return orderRepository.save(new OrderEntity(order));
    }
}
