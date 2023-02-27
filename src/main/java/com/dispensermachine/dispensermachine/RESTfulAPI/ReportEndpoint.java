package com.dispensermachine.dispensermachine.RESTfulAPI;
import com.dispensermachine.dispensermachine.DAO.DispenserRepository;
import com.dispensermachine.dispensermachine.DAO.ReportRepository;
import com.dispensermachine.dispensermachine.Model.Dispenser;
import com.dispensermachine.dispensermachine.Model.DispenserReport;
import com.dispensermachine.dispensermachine.Model.DispenserStatus;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Objects;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

@Path("/reports")
@ApplicationScoped
public class ReportEndpoint {
    ReportRepository reportRepository = new ReportRepository();
    DispenserRepository dispenserRepository = new DispenserRepository();


    @GET
    @Path("/all/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DispenserReport> getAll(@PathParam("id") Integer id) {
     return reportRepository.findAllByDispenserID(id);
    }
    @GET
    @Path("/{id}/xml")
    @Produces(MediaType.APPLICATION_XML)
    public DispenserReport getAllXml(@PathParam("id") Integer id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        DispenserReport dispenserReports=  new DispenserReport(id,dtf.format(now),dispenserRepository.findDispenserById(id),"");
        return dispenserReports;
    }
    @GET
    @Path("/{id}/json")
    @Produces(MediaType.APPLICATION_JSON)
    public DispenserReport getAllJson(@PathParam("id") Integer id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        DispenserReport dispenserReports=  new DispenserReport(id,dtf.format(now),dispenserRepository.findDispenserById(id),"");
        return dispenserReports;
    }

    @POST
    @Path("/add/xml")
    @Consumes(MediaType.APPLICATION_XML)
    public void createReportXml(DispenserReport dispenserReport){
        //System.out.println(dispenserReport.toString());
        dispenserReport.setReportData(dispenserReport.toString());
        reportRepository.createReport(dispenserReport);
    }

    @POST
    @Path("/add/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createReportJson(DispenserReport dispenserReport){
        dispenserReport.setReportData(dispenserReport.toString());
        reportRepository.createReport(dispenserReport);
    }
}
