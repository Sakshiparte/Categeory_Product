package com.product.Controller;
import java.util.Iterator;
import java.util.Locale.Category;

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
import com.product.Model.Categeory;
import com.product.Service.CategeoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")

public class CategeoryController {
	@Autowired
	CategeoryService categoryService;
	
	//1)to get all category product
	
	@GetMapping("")
	public ResponseEntity<?> getAllcategory()
	{
		Iterable<Categeory>data=categoryService.getall();
		Iterator<Categeory>getAllcategory=data.iterator();
		
		if(!getAllcategory.hasNext()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND," no record of category ");
		}
		else {
			ResponseWrapper crw=new ResponseWrapper();
			crw.setMessage("category found");
			crw.setData(getAllcategory);
			return new ResponseEntity<>(crw,HttpStatus.OK);
			
		}
	}
	
	//2)to get category Product based on id
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getcategoryById(@PathVariable int id) {
		Categeory category_data=categoryService.getById(id);
		ResponseWrapper crw= new ResponseWrapper();
		crw.setMessage("category found by id");
		crw.setData(category_data);
		return new ResponseEntity<>(crw,HttpStatus.FOUND);
	}
	
	//3)create new catProduct
	@PostMapping(" ")
	public ResponseEntity<?> createmnfProduct(@RequestBody @Valid Categeory category) {
		Categeory category_update=categoryService.create(category);
		ResponseWrapper crw=new ResponseWrapper();
		crw.setMessage(" added succuessfully");
		crw.setData(category_update);
		return new ResponseEntity<>(crw,HttpStatus.OK);
	}
	
	//4) to update category Product based on id;
	@PutMapping("/{id}")
	public ResponseEntity<?> updateMnfProduct(@PathVariable int id, @RequestBody @Valid Category category) {
		 Categeory category_update=categoryService.getById(id);
		 ResponseWrapper crw=new ResponseWrapper();
		 crw.setMessage("update succuessfully");
		 crw.setData(category_update);
		 return new ResponseEntity<>(crw,HttpStatus.OK);
		
	}
	
	//5)delete category product based on id
	@DeleteMapping("/{}")
	public ResponseEntity<?> deletemnfProduct(@PathVariable int id) {
		categoryService.getById(id);
		categoryService.delete(id);
		ResponseWrapper crw=new ResponseWrapper();
		crw.setMessage("delete succuesfully");
		return new ResponseEntity<>(crw,HttpStatus.NO_CONTENT);
	}

	

}
