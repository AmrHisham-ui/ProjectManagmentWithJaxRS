package Controller;

import Model.Product;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.ProductService;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    private ProductService productService = new ProductService();

    // Get all products
    @GET
    public Collection<Product> getAllProducts() {
        return productService.findAll().values();
    }

    // Get a product by ID
    @GET
    @Path("/{id}")
    public Product getProduct(@PathParam("id") int id) {
        return productService.findById(id);
    }

    // Add a new product
    @POST
    public Response addProduct(Product product) {
        productService.save(product);
        return Response.status(Response.Status.CREATED)
                .entity("Product added.")
                .build();
    }

    // Delete a product
    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") int id) {
        productService.delete(id);
        return Response.status(Response.Status.OK)
                .entity("Product deleted.")
                .build();
    }

    // Update a product
    @PUT
    @Path("/{id}")
    public Response updateProduct(@PathParam("id") int id, Product product) {
        if (productService.findById(id) == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Product not found.")
                    .build();
        }

        product.setId(id);  // Ensure the product ID matches the path parameter
        productService.update(product);
        return Response.status(Response.Status.OK)
                .entity("Product updated successfully.")
                .build();
    }
}
