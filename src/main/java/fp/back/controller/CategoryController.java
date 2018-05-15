package fp.back.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fp.back.entities.Category;
import fp.back.services.CategoryService;
import fp.back.util.CustomErrorType;

@RestController
@RequestMapping("category")
public class CategoryController {

	
	public static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryService;


	
	@CrossOrigin
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	
	public ResponseEntity<?> create(@RequestBody Category category) {
		if (categoryService.find(category.getName()) != null) {
			logger.error("Category already exist " + category.getName());
			return new ResponseEntity(
					new CustomErrorType("category with name " + category.getName() + " already exist "),
					HttpStatus.CONFLICT);
		}

		
		return new ResponseEntity<Category>(categoryService.save(category), HttpStatus.CREATED);
	}
	
	
	@CrossOrigin
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List<Category> getObjects(){
		return  categoryService.findAll();
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Category getObject(@PathVariable Long id){
		return  categoryService.findById(id);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable Long id) {
		categoryService.deleteById(id);
		 return true;	
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public Category update(@PathVariable Long id , @RequestBody Category category) {
		
		category.setId(id);
		return categoryService.save(category);	
	}
	
	
}
