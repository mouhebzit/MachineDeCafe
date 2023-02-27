package com.dispensermachine.dispensermachine.servlets;

import com.dispensermachine.dispensermachine.Model.DispenserReport;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GenerateReportByDispenserIdServlet", value = "/home/GenerateReportByDispenserIdServlet")
public class GenerateReportByDispenserIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tmp = request.getParameter("id");
        Integer id = Integer.parseInt(tmp);
        Client client = ClientBuilder.newClient();
        Client clientPost = ClientBuilder.newClient();
        DispenserReport reports = client.target("http://localhost:8080/DispenserMachine_war_exploded/api/reports/"+id+"/json").request(MediaType.APPLICATION_JSON).get(new GenericType<DispenserReport>(){});
        clientPost.target("http://localhost:8080/DispenserMachine_war_exploded/api/reports/add/json").request().accept(MediaType.APPLICATION_JSON).post(Entity.json(reports));
        request.getRequestDispatcher("/home/ReportsByDispenserServlet").forward(request, response);
        client.close();
        clientPost.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
