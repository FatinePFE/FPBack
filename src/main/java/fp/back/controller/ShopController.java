package fp.back.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fp.back.entities.Category;
import fp.back.entities.Shop;
import fp.back.services.CategoryService;
import fp.back.services.ShopService;
import fp.back.util.CustomErrorType;

@RestController
public class ShopController {

	
	public static final Logger logger = LoggerFactory.getLogger(ShopController.class);

	@Autowired
	private ShopService shopService;
	
	@Autowired
	private CategoryService categoryService;
	

	@CrossOrigin
    @GetMapping("/category/{categoryId}/shops")
    public Page<Shop> getAllShopsByCategoryId(@PathVariable (value = "categoryId") Long categoryId,
                                                Pageable pageable) {
        return shopService.findByCategoryId(categoryId, pageable);
    }
    
	
	@CrossOrigin
    @PostMapping("/category/{categoryId}/shops")
	public ResponseEntity<?> create(@PathVariable (value = "categoryId") Long categoryId, 
			@RequestBody Shop shop) {
    	
		if (shopService.find(shop.getName()) != null) {
			logger.error("Shop already exist " + shop.getName());
			return new ResponseEntity(
					new CustomErrorType("shop with name " + shop.getName() + " already exist "),
					HttpStatus.CONFLICT);
		}
		
		Category category;
		category = categoryService.findById(categoryId);
		shop.setCategory(category);
		
		return new ResponseEntity<Shop>(shopService.save(shop), HttpStatus.CREATED);
	}
	
	
	@CrossOrigin
	@RequestMapping(value="/shops/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable Long id) {
		shopService.deleteById(id);
		 return true;	
	}
	
  
}
