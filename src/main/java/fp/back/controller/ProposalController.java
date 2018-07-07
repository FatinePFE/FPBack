package fp.back.controller;

import fp.back.entities.Proposal;
import fp.back.entities.User;
import fp.back.services.ProposalService;
import fp.back.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proposal")
public class ProposalController {

	
	public static final Logger logger = LoggerFactory.getLogger(ProposalController.class);
	
	
	@Autowired
	ProposalService proposalService;
	
	@Autowired
	UserService userService;


	

    @PostMapping("/create/{userId}")
	public ResponseEntity<?> createProposal(@PathVariable (value = "userId") Long userId, 
			@RequestBody Proposal proposal) {
    	
		User user;
		user = userService.find(userId);
		proposal.setUser(user);
		
		return new ResponseEntity<Proposal>(proposalService.save(proposal), HttpStatus.CREATED);
	}

    @CrossOrigin
    @GetMapping("/list")
    public List<Proposal> findAll() {
        return proposalService.findAll();
    }
	

	/*@CrossOrigin
    @GetMapping("/city/{cityId}/proposal")
    public Page<Proposal> getAllProposalByFromCityId(@PathVariable (value = "cityId") Long cityId, Pageable pageable) {
        return proposalService.findByFromCityId(cityId, pageable);
    }
	

	@CrossOrigin
    @GetMapping("/account/{userId}/proposal")
    public Page<Proposal> getAllProposalByUserId(@PathVariable (value = "userId") Long userId, Pageable pageable) {
        return proposalService.findByUserId(userId, pageable);
    }*/
	
}
