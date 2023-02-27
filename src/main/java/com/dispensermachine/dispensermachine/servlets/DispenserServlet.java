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

@WebServlet(name = "DispenserServlet", value = "/home/DispenserServlet")
public class DispenserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("status");
        String tmp = request.getParameter("supply");
        Integer supply = 0;
        try {
            supply = Integer.parseInt(tmp);
        } catch (NumberFormatException e) {

        }
        ArrayList<Dispenser> dispensers;
        Client client = ClientBuilder.newClient();
        if(supply==1) dispensers = client.target("http://localhost:8080/DispenserMachine_war_exploded/api/dispensers/"+status+"/supply").request(MediaType.APPLICATION_JSON).get(new GenericType<ArrayList<Dispenser>>(){});
        else dispensers = client.target("http://localhost:8080/DispenserMachine_war_exploded/api/dispensers/"+status).request(MediaType.APPLICATION_JSON).get(new GenericType<ArrayList<Dispenser>>(){});

        request.setAttribute("data", dispensers);
        request.setAttribute("status", dispensers.get(0).getDispenserStatus().getOperatingStatus());
        request.setAttribute("supply", supply);
        request.setAttribute("weather", WeatherAPI.tempC);
        WeatherAPI.client.close();
        request.getRequestDispatcher("/DashboardPage/DispenserView.jsp").forward(request, response);
        client.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
