package com.example.lab7_20215433.daos;

import com.example.lab7_20215433.beans.Employees;

import java.sql.*;
import java.util.ArrayList;

public class DaoEmployee {

    public ArrayList<Employees> listarEmployees() {
        ArrayList<Employees> lista = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";
        String username = "root";
        String password = "root";

        String sql = "SELECT employee_id, CONCAT(first_name, ' ', last_name) AS full_name, email, hire_date, job_id FROM employees;";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Employees employee = new Employees();
                employee.setEmployee_id(rs.getInt(1));
                employee.setFullNameEmployee(rs.getString(2));
                employee.setEmail(rs.getString(3));
                employee.setHireDate(rs.getString(4));
                employee.setJob_id(rs.getString(5));
                lista.add(employee);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    public Employees buscarPorId(int id) {
        Employees employee = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";
        String username = "root";
        String password = "root";

        String sql = "SELECT employee_id, CONCAT(first_name, ' ', last_name) AS full_name, email, hire_date, job_id FROM employees WHERE employee_id = ?;";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    employee = new Employees();
                    employee.setEmployee_id(rs.getInt(1));
                    employee.setFullNameEmployee(rs.getString(2));
                    employee.setEmail(rs.getString(3));
                    employee.setHireDate(rs.getString(4));
                    employee.setJob_id(rs.getString(5));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employee;
    }

    public void crear(int employee_id, String first_name, String last_name, String email, String hire_date, String job_id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";
        String username = "root";
        String password = "root";

        String sql = "INSERT INTO employees (employee_id, first_name, last_name, email, hire_date, job_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, employee_id);
            pstmt.setString(2, first_name);
            pstmt.setString(3, last_name);
            pstmt.setString(4, email);
            pstmt.setString(5, hire_date);
            pstmt.setString(6, job_id);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void actualizar(Employees employee) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";
        String username = "root";
        String password = "root";

        String sql = "UPDATE employees SET first_name = ?, last_name = ?, email = ?, hire_date = ?, job_id = ? WHERE employee_id = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            
            String[] partes = employee.getFullNameEmployee().split(" ");
            String firstName = partes.length > 0 ? partes[0] : "";
            String lastName = partes.length > 1 ? partes[1] : "";

            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, employee.getEmail());
            pstmt.setString(4, employee.getHireDate());
            pstmt.setString(5, employee.getJob_id());
            pstmt.setInt(6, employee.getEmployee_id());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void borrar(int employee_id) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";
        String username = "root";
        String password = "root";

        String sql = "DELETE FROM employees WHERE employee_id = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, employee_id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
