package com.dispensermachine.dispensermachine.servlets;

import com.dispensermachine.dispensermachine.Model.Sales;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SalesByDispenserServlet", value = "/home/SalesByDispenserServlet")
public class SalesByDispenserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tmp = request.getParameter("id");
        Integer id = Integer.parseInt(tmp);
        Client client = ClientBuilder.newClient();
        ArrayList<Sales> sales = client.target("http://localhost:8080/DispenserMachine_war_exploded/api/sales/"+id).request(MediaType.APPLICATION_JSON).get(new GenericType<ArrayList<Sales>>(){});
        request.setAttribute("data", sales);
        request.getRequestDispatcher("/DashboardPage/Sales.jsp").forward(request, response);
        client.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
