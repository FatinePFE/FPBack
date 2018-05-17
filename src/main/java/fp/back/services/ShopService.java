package fp.back.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fp.back.dao.ShopRepository;
import fp.back.entities.Shop;


@Service
public class ShopService {

	
	@Autowired
	ShopRepository shopRepository;

	public Shop save(Shop shop) {
		return shopRepository.saveAndFlush(shop);
	}

	public Shop update(Shop shop) {
		return shopRepository.save(shop);
	}

	public Shop find(String name) {
		return shopRepository.findByName(name);
	}

	public Shop find(Long id) {
		return shopRepository.findOne(id);
	}
	
	public List<Shop> findAll() {
		return shopRepository.findAll();
	}
	
	public Shop findById(Long id) {
		return shopRepository.findOne(id);
	}
	
	public boolean deleteById(Long id) {
		shopRepository.delete(id);
		return true; 
	}

	public Page<Shop> findByCategoryId(Long categoryId, Pageable pageable) {
		
		return shopRepository.findByCategoryId(categoryId, pageable);
	}
}
