package com.product.Controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.product.Hellper.ResponseWrapper;
import com.product.Model.Product;
import com.product.Service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProcuctController {

	@Autowired
	ProductService productservice;
	//1)to get all product
	@GetMapping("")
	public ResponseEntity<?> getAllProduct() {
		
		Iterable<Product>data=productservice.getall();
		Iterator<Product>all_product=data.iterator();
		
		if(!all_product.hasNext()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No records of product");
		}
		else {
			ResponseWrapper  prw=new ResponseWrapper();
			prw.setMessage("product found");
			prw.setData(all_product);
            return new ResponseEntity<>(prw,HttpStatus.OK);
		}
		
	}
	//2)to get all product based on id
	@GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id){
		Product product_data=productservice.getById(id);
		ResponseWrapper prw=new ResponseWrapper();
		prw.setMessage("Product found by id");
		prw.setData(product_data);
		return new ResponseEntity<>(prw,HttpStatus.FOUND);
	}
	
	//3) create new product data
	@PostMapping("")
	public ResponseEntity<?> Create(@RequestBody @Valid Product product) {
		Product product_create=productservice.create(product);
		ResponseWrapper prw=new ResponseWrapper();
		prw.setMessage("added successfully");
		prw.setData(product_create);
		return new ResponseEntity<>(prw,HttpStatus.CREATED);
	
	}
	//4)to update product based on id
	@PutMapping("/{id}")
	public ResponseEntity<?> Update(@PathVariable int id, @RequestBody @Valid Product product) {
		
		Product product_update=productservice.update(id, product);
		ResponseWrapper prw= new ResponseWrapper();
		prw.setMessage("update succssesfuly");
		prw.setData(product_update);
		return new ResponseEntity<>(prw,HttpStatus.OK);
	}
	
	//)to delete product based on id;
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		productservice.getById(id);
		productservice.delete(id);
		ResponseWrapper prw=new ResponseWrapper();
		prw.setMessage("data deleted successfuly");
		return new ResponseEntity<>(prw,HttpStatus.NO_CONTENT);
	}
	

}
