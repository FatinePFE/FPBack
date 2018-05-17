package fp.back.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fp.back.entities.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>{

	public Shop findByName(String name);
	
	Page<Shop> findByCategoryId(Long id, Pageable pageable);
}
