package com.dispensermachine.dispensermachine.servlets;

import com.dispensermachine.dispensermachine.Model.Dispenser;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ReportsInterventionsServlet", value = "/home/ReportsInterventionsServlet")
public class ReportsInterventionsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Client client = ClientBuilder.newClient();
        ArrayList<Dispenser> dispensers = client.target("http://localhost:8080/DispenserMachine_war_exploded/api/dispensers/all").request(MediaType.APPLICATION_JSON).get(new GenericType<ArrayList<Dispenser>>(){});;
        request.setAttribute("data", dispensers);
        request.getRequestDispatcher("/DashboardPage/Reports-and-Interventions.jsp").forward(request, response);
        client.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
