package cs.pointscenter.app.dto;


import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Reward {
	@JsonProperty("rewardId")
	@Length(max = 50)
	String rewardId;
	@JsonProperty("rewardName")
	@Length(max = 50)
	String rewardName;
	@JsonProperty("rewardQty")
	@Length(max = 50)
	String rewardQty;
	@JsonProperty("rewardType")
	@Length(max = 50)
	String rewardType;
	@JsonProperty("rewardExpDate")
	@Length(max = 50)
	String rewardExpDate;

}
