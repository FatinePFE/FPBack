package fp.back.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fp.back.entities.Proposal;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long>{

	public Proposal findByName(String name);
	
	Page<Proposal> findByUserId(Long id, Pageable pageable);
	
	Page<Proposal> findByFromcityId(Long id, Pageable pageable);
	
}
