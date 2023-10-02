package com.product.Service;

import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.product.Model.Categeory;
import com.product.Repository.CategeoryRepository;

@Service
public class CategeoryService {
	
	@Autowired
	CategeoryRepository categeoryRepository;
	
	//1)getting all category product
		public Iterable<Categeory> getall() 
		{
			return categeoryRepository.findAll();
		}
		
		//2)getting all product by id
		public Categeory getById(int id) {
			return categeoryRepository.findById(id).orElseThrow(()->{
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"id not exist");
			});
		}

		//3)insert /add new product
		public Categeory create(Categeory category) {
			categeoryRepository.save(category);
			return category;
		}
		
		//4)update manufacturing 
		public Categeory update(int id,Categeory category) {
		 Categeory get_catProduct= getById(id);
		 category.setId(get_catProduct.getId());
		 category.setCreatedAt(get_catProduct.getCreatedAt());
		 Categeory found_mnfProduct = categeoryRepository.save(category);
		  return found_mnfProduct;
		}
		//5) delete data
		public void delete(int id) {
			this.getById(id);
			categeoryRepository.deleteById(id);
		}
		
	

}
