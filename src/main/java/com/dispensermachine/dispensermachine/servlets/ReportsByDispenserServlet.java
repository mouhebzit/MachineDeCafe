package com.dispensermachine.dispensermachine.servlets;

import com.dispensermachine.dispensermachine.Model.DispenserReport;
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

@WebServlet(name = "ReportsByDispenserServlet", value = "/home/ReportsByDispenserServlet")
public class ReportsByDispenserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tmp = request.getParameter("id");
        Integer id = Integer.parseInt(tmp);
        Client client = ClientBuilder.newClient();
        ArrayList<DispenserReport> reports = client.target("http://localhost:8080/DispenserMachine_war_exploded/api/reports/all/"+id).request(MediaType.APPLICATION_JSON).get(new GenericType<ArrayList<DispenserReport>>(){});
        request.setAttribute("data", reports);
        request.setAttribute("dispenserId", id);
        request.getRequestDispatcher("/DashboardPage/DispenserReport.jsp").forward(request, response);
        client.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
