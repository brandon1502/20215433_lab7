package com.example.lab7_20215433.servlets;

import com.example.lab7_20215433.beans.Employees;
import com.example.lab7_20215433.daos.DaoEmployee;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "EmployeeServlet", value = "")
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action") == null ? "listaEmployee" : request.getParameter("action");

        DaoEmployee daoEmployee = new DaoEmployee();

        switch (action) {
            case "listaEmployee":
                ArrayList<Employees> list = daoEmployee.listarEmployees();
                request.setAttribute("lista", list);
                RequestDispatcher rd = request.getRequestDispatcher("employee/listaEmployee.jsp");
                rd.forward(request, response);
                break;
            case "new":
                request.getRequestDispatcher("employee/form_new.jsp").forward(request, response);
                break;
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                Employees employee = daoEmployee.buscarPorId(id);
                if(employee != null){
                    request.setAttribute("employee", employee);
                    request.getRequestDispatcher("employee/form_edit.jsp").forward(request,response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/");
                }
                break;

            case "del":
                int idd = Integer.parseInt(request.getParameter("id"));
                Employees employeeToDelete = daoEmployee.buscarPorId(idd);

                if (employeeToDelete != null) {
                    try {
                        daoEmployee.borrar(idd);
                    } catch (SQLException e) {
                        System.out.println("Log: excepcion: " + e.getMessage());
                    }
                }
                response.sendRedirect(request.getContextPath() + "/");
                break;


        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoEmployee daoEmployee = new DaoEmployee();
        String action = request.getParameter("action") == null ? "crear" : request.getParameter("action");

        switch (action) {
            case "crear":
                String employee_id = request.getParameter("employee_id");
                String first_name = request.getParameter("first_name");
                String last_name = request.getParameter("last_name");
                String email = request.getParameter("email");
                String hire_date = request.getParameter("hire_date");
                String job_id = request.getParameter("job_id");

                Employees employee = daoEmployee.buscarPorId(Integer.parseInt(employee_id));
                if (employee == null) {
                    daoEmployee.crear(Integer.parseInt(employee_id), first_name, last_name, email, hire_date, job_id);
                    response.sendRedirect(request.getContextPath() + "/");
                } else {
                    request.getRequestDispatcher("employee/form_new.jsp").forward(request, response);
                }
                break;

            case "e":
                int employee_id2 = Integer.parseInt(request.getParameter("employee_id"));
                String full_name2 = request.getParameter("full_name");
                String email2 = request.getParameter("email");
                String hire_date2 = request.getParameter("hire_date");
                String job_id2 = request.getParameter("job_id");

                Employees employee2 = new Employees();
                employee2.setEmployee_id(employee_id2);
                employee2.setFullNameEmployee(full_name2);
                employee2.setEmail(email2);
                employee2.setHireDate(hire_date2);
                employee2.setJob_id(job_id2);

                daoEmployee.actualizar(employee2);
                response.sendRedirect(request.getContextPath() + "/");
                break;
        }
    }
}
