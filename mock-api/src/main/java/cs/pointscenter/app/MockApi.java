package cs.pointscenter.app;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockApi {
	@GetMapping("/getCustomerData/{id}")    
	public CustomerData getAllCosmetics(@PathVariable String id) {
		CustomerData  cosmetics = new CustomerData();
		cosmetics.setId(id);
		  int randomInt = (int)(1000.0 * Math.random());
		cosmetics.setPoint_balance(randomInt);
	    return cosmetics;
	}
	@GetMapping("/earn/{id}")    
	public Earn getAllEarn(@PathVariable String id) {
		Earn  earn_point = new Earn();
		earn_point.setId(id);
		  int randomInt = (int)(1000.0 * Math.random());
		  earn_point.setEarn_point(randomInt);
	    return earn_point;
	}
	@GetMapping("/completeAck/{id}")    
	public CompleteAckDTO completeAck(@PathVariable String id) {
		CompleteAckDTO  earn_point = new CompleteAckDTO();
		earn_point.setId(id);
		earn_point.setStatus("True");
	    return earn_point;
	}
	
	
	@GetMapping("/reversePoint/{id}")    
	public ReverseDTO reversePoint(@PathVariable String id) {
		ReverseDTO  earn_point = new ReverseDTO();
		earn_point.setId(id);
		earn_point.setStatus("True");
	    return earn_point;
	}
}
