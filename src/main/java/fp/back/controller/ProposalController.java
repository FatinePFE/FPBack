package fp.back.controller;

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
import org.springframework.web.bind.annotation.RestController;

import fp.back.entities.Proposal;
import fp.back.entities.User;
import fp.back.services.ProposalService;
import fp.back.services.UserService;

@RestController
public class ProposalController {

	
	public static final Logger logger = LoggerFactory.getLogger(ProposalController.class);
	
	
	@Autowired
	ProposalService proposalService;
	
	@Autowired
	UserService userService;
	
	
	@CrossOrigin
    @PostMapping("/account/{userId}/proposal")
	public ResponseEntity<?> createProposal(@PathVariable (value = "userId") Long userId, 
			@RequestBody Proposal proposal) {
    	
		User user;
		user = userService.find(userId);
		proposal.setUser(user);
		
		return new ResponseEntity<Proposal>(proposalService.save(proposal), HttpStatus.CREATED);
	}
	
	
	// Shop Controllers
	@CrossOrigin
    @GetMapping("/account/{userId}/proposal")
    public Page<Proposal> getAllProposalByUserId(@PathVariable (value = "userId") Long userId, Pageable pageable) {
        return proposalService.findByUserId(userId, pageable);
    }
	
	
}
