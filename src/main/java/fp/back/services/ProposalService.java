package fp.back.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fp.back.dao.ProposalRepository;
import fp.back.entities.Proposal;


@Service
public class ProposalService {

	
	@Autowired
	ProposalRepository proposalRepository;

	public Proposal save(Proposal proposal) {
		return proposalRepository.saveAndFlush(proposal);
	}

	public Proposal update(Proposal proposal) {
		return proposalRepository.save(proposal);
	}

	public Proposal find(String name) {
		return proposalRepository.findByName(name);
	}

	public Proposal find(Long id) {
		return proposalRepository.findOne(id);
	}
	
	public List<Proposal> findAll() {
		return proposalRepository.findAll();
	}
	
	public Proposal findById(Long id) {
		return proposalRepository.findOne(id);
	}
	
	public boolean deleteById(Long id) {
		proposalRepository.delete(id);
		return true; 
	}

}
