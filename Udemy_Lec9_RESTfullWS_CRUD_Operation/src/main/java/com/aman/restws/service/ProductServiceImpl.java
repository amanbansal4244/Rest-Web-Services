package com.aman.restws.service;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.aman.crud.Product;
import com.aman.restws.repos.ProductRepository;


public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> getProducts() {
		return (List<Product>) productRepository.findAll();
	}

	
	@Override
	public Product getProduct(int id) {
		return productRepository.findById(id).get();
	}

	@Override
	public Response createProduct(Product product) {
		Product savedProduct = productRepository.save(product);
		return Response.ok(savedProduct).build();
	}

	@Override
	public Response updateProduct(Product product) {
		Product updatedProduct = productRepository.save(product);
		return Response.ok(updatedProduct).build();
	}
}
