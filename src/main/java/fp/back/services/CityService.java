package fp.back.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fp.back.dao.CityRepository;
import fp.back.entities.City;

@Service
public class CityService {

	
	@Autowired
	CityRepository cityRepository;

	public City save(City city) {
		return cityRepository.saveAndFlush(city);
	}

	public City update(City city) {
		return cityRepository.save(city);
	}

	public List<City> find(String name) {
		return cityRepository.findByName(name);
	}

	public City find(Long id) {
		return cityRepository.findOne(id);
	}
	
	public List<City> findAll() {
		return cityRepository.findAll();
	}
	
	public City findById(Long id) {
		return cityRepository.findOne(id);
	}
	
	public boolean deleteById(Long id) {
		cityRepository.delete(id);
		return true; 
	}

}
