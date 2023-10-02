package com.product.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.product.Model.Product;

public interface ProcuctRepository extends PagingAndSortingRepository<Product, Integer>,CrudRepository<Product, Integer> {

}
