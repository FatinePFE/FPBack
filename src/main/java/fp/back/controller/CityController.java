package fp.back.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fp.back.entities.City;
import fp.back.services.CityService;
import fp.back.util.CustomErrorType;

@RestController
public class CityController {

	
	public static final Logger logger = LoggerFactory.getLogger(CityController.class);
	
	@Autowired
	private CityService cityService;
	
	@CrossOrigin
    @PostMapping("/city")	
	public ResponseEntity<?> createCity(@RequestBody City city) {
		
		List<City> cityList = cityService.find(city.getName());
		
		if (!cityList.isEmpty()) {
			
			for( City ct : cityList) {
				if(ct.getCountry().equals(city.getCountry())) {
					logger.error("City already exist " + city.getName());
					return new ResponseEntity(
							new CustomErrorType("City with name " + city.getName() + " already exist "),
							HttpStatus.CONFLICT);
				}
			}
		}
		return new ResponseEntity<City>(cityService.save(city), HttpStatus.CREATED);
	}
	
	
	@CrossOrigin
	@GetMapping("/cities")
	public List<City> getCities(){
		return  cityService.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/city/{id}")
	public City getCity(@PathVariable Long id){
		return  cityService.findById(id);
	}
	
	@CrossOrigin
	@RequestMapping(value="/city/{id}", method=RequestMethod.DELETE)
	public boolean deleteCity(@PathVariable Long id) {
		cityService.deleteById(id);
		 return true;	
	}
	
	@CrossOrigin
	@RequestMapping(value="/city/{id}", method=RequestMethod.PUT)
	public City updateCity(@PathVariable Long id , @RequestBody City city) {
		
		city.setId(id);
		return cityService.save(city);	
	}
	
	
}
