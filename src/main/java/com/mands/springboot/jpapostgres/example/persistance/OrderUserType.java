package com.mands.springboot.jpapostgres.example.persistance;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.Serializable;
import java.io.StringWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.nio.charset.StandardCharsets.UTF_8;
import static javax.xml.bind.Marshaller.JAXB_ENCODING;


public class OrderUserType implements UserType {

    private static JAXBContext jaxbContext;
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;
    private final int[] sqlTypesSupported = new int[]{12};

    {
      jaxbContext = JAXBContext.newInstance(Order.class);
    }

    public OrderUserType() throws JAXBException{
        unmarshaller = jaxbContext.createUnmarshaller();
        marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(JAXB_ENCODING, UTF_8.name());
    }

    public int[] sqlTypes() {
        return this.sqlTypesSupported;
    }

    public Class returnedClass() {
        return Order.class;
    }

    public boolean equals(Object x, Object y) throws HibernateException {
        return (x != null) && x.equals(y);
    }

    public int hashCode(Object x) throws HibernateException {
        return (x != null) ? x.hashCode() : 0;
    }

    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner) throws HibernateException, SQLException {
        assert names.length == 1;

        String xmldoc = rs.getString(names[0]);
        return rs.wasNull() ? null : xmldoc;
    }

    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws HibernateException, SQLException {
        if(value == null) {
            st.setNull(index, 1111);
        } else {
            st.setObject(index, value, 1111);
        }
    }

    public Object deepCopy(Object value) {
        return value;
    }

    public boolean isMutable() {
        return true;
    }

    public Serializable disassemble(final Object value) {
        return (Serializable) value;
    }

    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return cached;
    }

    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }

    protected String jaxbToString(final Object value) throws JAXBException {
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(value, stringWriter);

        return stringWriter.toString();
    }
}

