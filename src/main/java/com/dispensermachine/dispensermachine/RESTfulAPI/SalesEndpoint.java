package com.dispensermachine.dispensermachine.RESTfulAPI;
import com.dispensermachine.dispensermachine.Model.Sales;
import com.dispensermachine.dispensermachine.DAO.SalesRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;


@Path("/sales")
@ApplicationScoped
public class SalesEndpoint {
    SalesRepository salesRepository = new SalesRepository();
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sales> getAll() {
        List<Sales> saleList=  salesRepository.findAll();
        return saleList;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sales> getById(@PathParam("id") String id) {
        List<Sales> saleList=  salesRepository.findSalesById(Integer.parseInt(id));
        return saleList;
    }
}
