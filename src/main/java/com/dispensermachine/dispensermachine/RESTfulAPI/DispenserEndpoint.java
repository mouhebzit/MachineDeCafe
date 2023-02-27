package com.dispensermachine.dispensermachine.RESTfulAPI;

import com.dispensermachine.dispensermachine.DAO.DispenserRepository;
import com.dispensermachine.dispensermachine.Model.Dispenser;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Objects;


@Path("/dispensers")
@ApplicationScoped
public class DispenserEndpoint {

    DispenserRepository dispenserRepository = new DispenserRepository();
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dispenser> getAll() {
        List<Dispenser> dispenserList=  dispenserRepository.findAll();
        return dispenserList;
    }

    @GET
    @Path("/{operatingStatus}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dispenser> getByStatus(@PathParam("operatingStatus") String status) {
        List<Dispenser> dispenserList=  dispenserRepository.findAll();
        dispenserList.removeIf(p -> !Objects.equals(p.getDispenserStatus().getOperatingStatus().replaceAll(" ", ""), status));
        return dispenserList;
    }

    @GET
    @Path("/{operatingStatus}/supply")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dispenser> getByStatusAndSupply(@PathParam("operatingStatus") String status) {
        List<Dispenser> dispenserList=  dispenserRepository.findDispensersToSupply();
        return dispenserList;
    }

}