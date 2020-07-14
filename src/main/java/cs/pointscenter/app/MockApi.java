package cs.pointscenter.app;


import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.util.EC2MetadataUtils;

import cs.pointscenter.app.dto.CompleteAckDTO;
import cs.pointscenter.app.dto.Earn;
import cs.pointscenter.app.dto.InquiryPointRequestDTO;
import cs.pointscenter.app.dto.InquiryPointResponseDTO;
import cs.pointscenter.app.dto.ReverseDTO;

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
	@GetMapping("/InstanceId")    
	   public String getInstanceId(){
		
	   return EC2MetadataUtils.getInstanceId();
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
	@PostMapping(value = "/GetAccountBalance", consumes = "application/json; charset=utf-8", produces = "application/json; charset=utf-8")
	public String inquiryPoint(InquiryPointRequestDTO requestDTO) {
		
		  return "{\r\n" + 
		  		"    \"returnDescTH\": \"ทำรายการสำเร็จ\",\r\n" + 
		  		"    \"returnCode\": \"00000\",\r\n" + 
		  		"    \"returnDesc\": \"Success\",\r\n" + 
		  		"    \"rewards\": [\r\n" + 
		  		"        {\r\n" + 
		  		"            \"rewardId\": \"808\",\r\n" + 
		  		"            \"rewardName\": \"All Member Point\",\r\n" + 
		  		"            \"rewardQty\": \"2018\",\r\n" + 
		  		"            \"rewardType\": \"ACC\",\r\n" + 
		  		"            \"rewardExpDate\": \"2020-12-31\"\r\n" + 
		  		"        },\r\n" + 
		  		"        {\r\n" + 
		  		"            \"rewardId\": \"31020001\",\r\n" + 
		  		"            \"rewardName\": \"M-Stamp\",\r\n" + 
		  		"            \"rewardQty\": \"9898\",\r\n" + 
		  		"            \"rewardType\": \"ACC\",\r\n" + 
		  		"            \"rewardExpDate\": \"2020-03-31\"\r\n" + 
		  		"        },\r\n" + 
		  		"        {\r\n" + 
		  		"            \"rewardId\": \"31020015\",\r\n" + 
		  		"            \"rewardName\": \"เหรียญ\",\r\n" + 
		  		"            \"rewardQty\": \"26\",\r\n" + 
		  		"            \"rewardType\": \"ACC\",\r\n" + 
		  		"            \"rewardExpDate\": \"2020-05-23\"\r\n" + 
		  		"        },\r\n" + 
		  		"        {\r\n" + 
		  		"            \"rewardId\": \"9100903\",\r\n" + 
		  		"            \"rewardName\": \"สะสมยูนิฟ\",\r\n" + 
		  		"            \"rewardQty\": \"0\",\r\n" + 
		  		"            \"rewardType\": \"ACC\",\r\n" + 
		  		"            \"rewardExpDate\": \"2020-04-13\"\r\n" + 
		  		"        },\r\n" + 
		  		"        {\r\n" + 
		  		"            \"rewardId\": \"3700044\",\r\n" + 
		  		"            \"rewardName\": \"แสตมป์ 1บ.2019\",\r\n" + 
		  		"            \"rewardQty\": \"55\",\r\n" + 
		  		"            \"rewardType\": \"ACC\",\r\n" + 
		  		"            \"rewardExpDate\": \"2023-12-31\"\r\n" + 
		  		"        }\r\n" + 
		  		"    ]\r\n" + 
		  		"}";
	}
//	http://sescsmnqa01.cpall.co.th/AllMemberGatewayGetAccountBalance/GetAccountBalance
}
