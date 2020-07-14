package cs.pointscenter.log;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LogMessageDTO {
	private int httpStatus;
	private String HttpMethod;
	private String path;
	private String clientIp;
	private String javaMethod;
	private String response;
	private String request;
}
