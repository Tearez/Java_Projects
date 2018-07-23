package com.telerikacademy.springjdbcdemo.data;

import com.telerikacademy.springjdbcdemo.models.Employee;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


@Repository
public class EmployeeSQLRepository implements EmployeeRepository {
    private static final String CONFIG_FILE = "C:\\Users\\Martin\\Desktop\\Java Projects\\springjdbcdemo\\src\\main\\resources\\application.properties";
    private String dbUrl;
    private String dbUser;
    private String dbPass;

    public EmployeeSQLRepository() {
        dbUrl = dbUser = dbPass = "";
    }

    @Override
    public List<Employee> getAll() {
        loadDbConfig();

        List<Employee> employees = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             Statement stmt = connection.createStatement()) {

            System.out.println("Connection successful");

            String sql = "select FirstName, LastName, JobTitle from employees";
            ResultSet rs = stmt.executeQuery(sql);
            readEmployeesData(employees, rs);
        } catch (SQLException e) {
            System.out.println("Connection failed");
        }
        return employees;
    }

    @Override
    public List<Employee> findByName(String name) {
        loadDbConfig();

        String query = "select `FirstName`, `LastName`, `JobTitle` " +
                "from employees " +
                "where firstname = ? ;";
        List<Employee> employeesList = new ArrayList<>();


        try (
                Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
                PreparedStatement statement = connection.prepareStatement(query);

        ) {
            System.out.println("Connection created.");
            // set param for prepared statement
            statement.setString(1, name);

            ResultSet result = statement.executeQuery();
            readEmployeesData(employeesList, result);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed :( .");
        }

        return employeesList;
    }

    private void loadDbConfig() {
        Properties dbConfig = new Properties();

        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            dbConfig.load(fis);
        } catch (FileNotFoundException f) {
            System.out.println("Properties file not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to read properties file");
        }

        dbUrl = dbConfig.getProperty("dbUrl");
        dbUser = dbConfig.getProperty("username");
        dbPass = dbConfig.getProperty("password");
    }

    private void readEmployeesData(List<Employee> employeesList, ResultSet result) throws SQLException {
        while (result.next()) {
            Employee e = new Employee(
                    result.getString("FirstName"),
                    result.getString("LastName"),
                    result.getString("JobTitle")
            );

            employeesList.add(e);
        }
    }
}
