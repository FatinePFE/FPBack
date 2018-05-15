package fp.back.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fp.back.dao.CategoryRepository;
import fp.back.entities.Category;


@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public Category save(Category category) {
		return categoryRepository.saveAndFlush(category);
	}

	public Category update(Category category) {
		return categoryRepository.save(category);
	}

	public Category find(String name) {
		return categoryRepository.findByName(name);
	}

	public Category find(Long id) {
		return categoryRepository.findOne(id);
	}
	
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
	public Category findById(Long id) {
		return categoryRepository.findOne(id);
	}
	
	public boolean deleteById(Long id) {
		categoryRepository.delete(id);
		return true; 
	}
	
	
}
