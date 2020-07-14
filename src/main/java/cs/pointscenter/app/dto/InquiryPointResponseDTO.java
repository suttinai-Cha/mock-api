package cs.pointscenter.app.dto;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class InquiryPointResponseDTO {
	@JsonProperty("returnCode")
	@Length(max = 5)
	String returnCode;
	
	@JsonProperty("returnDesc")
	@Length(max = 255)
	String returnDesc;
	
	@JsonProperty("returnDescTH")
	@Length(max = 255)
	String returnDescTH;
	
	@JsonProperty("rewards")
	@Valid
	List<Reward> rewards;
}
