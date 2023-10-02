package com.product.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.product.Model.Product;
import com.product.Repository.ProcuctRepository;

@Service
public class ProductService {

	@Autowired
	ProcuctRepository productrepository;
	
	//1)getting all product
	public Iterable<Product> getall()
	{
		return productrepository.findAll();
	}
	
	
	//2)getting product by id
    public Product getById(int id)
    {
    	return productrepository.findById(id).orElseThrow(
    			()->{
    			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"id is not exist");
    			});
       }
    
   
    
    //3)insert product /add new product
    public Product create(Product product)
    {
    	return productrepository.save(product);
   
    }
   
   
    //4)update Product
    public Product update(int id,Product product) 
    {
    	Product get_product = getById(id);
    	product.setId(get_product.getId());
    	product.setCreatedAt(get_product.getCreatedAt());
    	Product found_product = productrepository.save(product);
    	return found_product;
    	
    }
  
    
    //5)delete product
    public void delete(int id) {
    	this.getById(id);
    	productrepository.deleteById(id);
    	
    }


}
