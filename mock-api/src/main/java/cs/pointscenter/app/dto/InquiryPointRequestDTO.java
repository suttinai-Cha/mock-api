package cs.pointscenter.app.dto;




import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class InquiryPointRequestDTO {
	@JsonProperty("channelId")
	String channelId;
	
	@JsonProperty("identifyId")
	String identifyId;
	
	@JsonProperty("identifyValue")
	String identifyValue;
	
	@JsonProperty("storeId")
	String storeId;
	
	@JsonProperty("stationId")
	String stationId;
	
	@JsonProperty("requestTime")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy/MM/dd HH:mm:ss")
	private Date requestTime;
	
}
