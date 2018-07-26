package com.telerikacademy.spirnghibernatedemo.data;

import com.telerikacademy.spirnghibernatedemo.data.base.AddressRepository;
import com.telerikacademy.spirnghibernatedemo.models.Address;
import com.telerikacademy.spirnghibernatedemo.models.Town;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AddressSQLRepository implements AddressRepository {
    public static final SessionFactory factory;

    static {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Town.class)
                .buildSessionFactory();
    }

    @Override
    public Address getById(int id) {
        Address a = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            a = session.get(Address.class, id);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @Override
    public List<Address> getAll() {
        List<Address> addresses = new ArrayList<>();
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            addresses = session.createQuery("from Address").list();
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return addresses;
    }
}
