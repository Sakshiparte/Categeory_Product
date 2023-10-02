package com.product.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.product.Model.Categeory;

public interface CategeoryRepository extends PagingAndSortingRepository<Categeory, Integer>,CrudRepository<Categeory, Integer>{

}
