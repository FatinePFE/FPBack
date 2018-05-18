package fp.back.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fp.back.entities.Category;
import fp.back.entities.Proposal;
import fp.back.entities.Shop;
import fp.back.entities.User;
import fp.back.services.ProposalService;
import fp.back.services.UserService;
import fp.back.util.CustomErrorType;

@RestController
public class ProposalController {

	
	public static final Logger logger = LoggerFactory.getLogger(ProposalController.class);
	
	
	@Autowired
	ProposalService proposalService;
	
	@Autowired
	UserService userService;
	
	@CrossOrigin
    @PostMapping("/proposal")	
	public ResponseEntity<?> createProposal(@RequestBody Proposal proposal) {
			
		return new ResponseEntity<Proposal>(proposalService.save(proposal), HttpStatus.CREATED);
	}
	
	
	@CrossOrigin
    @PostMapping("/account/{userId}/proposal")
	public ResponseEntity<?> createProposal(@PathVariable (value = "userId") Long userId, 
			@RequestBody Proposal proposal) {
    	
		
		User user;
		user = userService.find(userId);
		proposal.setUser(user);
		
		return new ResponseEntity<Proposal>(proposalService.save(proposal), HttpStatus.CREATED);
	}
}
