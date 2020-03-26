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
}
