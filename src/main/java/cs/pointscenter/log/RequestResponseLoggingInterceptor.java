package cs.pointscenter.log;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.Charset;
/**
 * This class is user for log out bound Request and Response  
 * @author Mr suttinai
 *
 */
@Slf4j
public class RequestResponseLoggingInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		logRequest(request, body);
		ClientHttpResponse response = execution.execute(request, body);
		logResponse(response);
		return response;
	}

	private void logRequest(HttpRequest request, byte[] body) throws IOException {
		log.info("===========================request outbound api begin================================================");
		log.info("URI         :({}) {}",request.getMethod(), request.getURI());
		log.info("Request body: {}", new String(body, "UTF-8"));
//		log.info("==========================request end================================================");
	}

	private void logResponse(ClientHttpResponse response) throws IOException {
//		log.info("============================response begin==========================================");
		log.info("Response Status code  : {}", response.getStatusCode());
		log.info("Response body: (Status: {}){}",response.getStatusCode(),StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
	}
}