package org.fawry.rest;

import jakarta.ejb.Singleton;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fawry.model.Product;
import org.fawry.service.ProductService;

import java.util.List;

@Path("products")
@Singleton
public class ProductController {

    @Inject
    ProductService productService;

    @GET
    @Path("")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }

    @POST
    @Path("")
    @Produces({MediaType.APPLICATION_JSON})
    public Response createProduct(@Valid Product product) {
        productService.addProduct(product);
        return Response.status(201).entity(product).build();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Product getProduct(@PathParam("id") int id) {
        return productService.getProductById(id);
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product updateProduct(@PathParam("id") int id, Product product) {

        return productService.updateProduct(id, product);
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteProduct(@PathParam("id") int id) {
        productService.deleteProduct(id);
        return Response.status(204).build();
    }

    @GET
    @Path("/search")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getProductByName(@QueryParam("name") String name) {
        return Response.status(200).entity(productService.getProductByName(name)).build();
    }

}
