package com.aman.restws.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aman.crud.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
