package fp.back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fp.back.entities.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	public Category findByName(String name);
	
}
