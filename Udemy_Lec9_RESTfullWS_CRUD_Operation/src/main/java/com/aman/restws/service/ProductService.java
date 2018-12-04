package com.aman.restws.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RestController;

import com.aman.crud.Product;


@Path("/productservice")
@Produces("application/json")
@Consumes("application/json")
@RestController
public interface ProductService {
	
	@GET
	@Path("/products")
	List<Product> getProducts();
	
	@GET
	@Path("/product/{id}")
	Product getProduct(@PathParam("id") int id);

	@POST
	@Path("/products")
	Response createProduct(Product product);
	
	@PUT
	@Path("/products")
	Response updateProduct(Product product);
}
