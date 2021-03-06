package com.telerikacademy.spirnghibernatedemo.data;

import com.telerikacademy.spirnghibernatedemo.data.base.EmployeeRepository;
import com.telerikacademy.spirnghibernatedemo.models.Address;
import com.telerikacademy.spirnghibernatedemo.models.Employee;
import com.telerikacademy.spirnghibernatedemo.models.Town;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeSQLRepository implements EmployeeRepository {
    private static final SessionFactory factory;

    static {
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(Address.class)
                    .addAnnotatedClass(Town.class)
                    .buildSessionFactory();
    }


    @Override
    public Employee getById(int id) {
        Employee e = null;
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            e = session.get(Employee.class, id);
            session.getTransaction().commit();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return e;
    }

    @Override
    public List<Employee> listAll() {
        List<Employee> employees = new ArrayList<>();
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            employees = session.createQuery("from Employee", Employee.class).list();
            session.getTransaction().commit();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return employees;
    }
}
