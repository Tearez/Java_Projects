package com.telerikacademy.spirnghibernatedemo;

import com.telerikacademy.spirnghibernatedemo.models.Employee;
import com.telerikacademy.spirnghibernatedemo.models.Town;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateDemoApplication {
    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Town.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();
        System.out.println("something");

//        Employee employee = session.get(Employee.class, 1);
//
//        System.out.println(employee.getId()+" "+ employee.getFirstName() +" "+ employee.getLastName()+" "+ employee.getJobTitle());
//        Town town = new Town("Sofia");
//        session.save(town);
//        System.out.println(town.getId() + " "+ town.getName());
        Query query = session.createQuery("From Employee E");

        List<Employee> employees = query.list();

        for (Employee emp:employees) {
            System.out.println(emp.getId()+" "+emp.getFirstName());
        }

        session.getTransaction().commit();
        session.close();
    }
}
