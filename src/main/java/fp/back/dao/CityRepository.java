package fp.back.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fp.back.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

	public List<City> findByName(String name);
	
}
