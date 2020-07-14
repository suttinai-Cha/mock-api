package cs.pointscenter.log;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.WebUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
/**
 * This class is user for log in bound Request and Response  
 * @author Mr suttinai
 *
 */
@Slf4j
public class LoggableDispatcherServlet extends DispatcherServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2576700123715699104L;

	@Override
	protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!(request instanceof ContentCachingRequestWrapper)) {
			request = new ContentCachingRequestWrapper(request);
		}
		if (!(response instanceof ContentCachingResponseWrapper)) {
			response = new ContentCachingResponseWrapper(response);
		}
		HandlerExecutionChain handler = getHandler(request);

		try {
			super.doDispatch(request, response);
		} finally {
			log(request, response, handler);
			updateResponse(response);
		}
	}

	private void log(HttpServletRequest requestToCache, HttpServletResponse responseToCache,
			HandlerExecutionChain handler) {
		LogMessageDTO logMessageDTO = new LogMessageDTO();
		logMessageDTO.setHttpStatus(responseToCache.getStatus());
		logMessageDTO.setHttpMethod(requestToCache.getMethod());
		logMessageDTO.setPath(requestToCache.getRequestURL()+"?"+getParameter(requestToCache.getParameterMap()));
		logMessageDTO.setClientIp(requestToCache.getRemoteAddr());
		if(handler!=null) {
			logMessageDTO.setJavaMethod(handler.toString());
		}
		
		logMessageDTO.setResponse(compactJson(getResponsePayload(responseToCache)));
		logMessageDTO.setRequest(compactJson(getRequestPayload(requestToCache)));
		log.info(requestToCache.getRequestURI()+" SessionId: "+requestToCache.getSession().getId()+": Request: "+logMessageDTO.getRequest());
		log.info(requestToCache.getRequestURI()+" SessionId: "+requestToCache.getSession().getId()+": Respose: "+logMessageDTO.getResponse());
	}
	private String getParameter(Map<String, String[]> parameterMap) {
		StringBuffer param = new StringBuffer();
		try {
			for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
				 param.append(entry.getKey() + ":[");
				for (int i = 0; i < entry.getValue().length; i++) {
					param.append(entry.getValue()[i]);
					if(i+1!=entry.getValue().length) {
						param.append(",");
					}
				}
				param.append("],");
			   
			}
		} catch (Exception e) {
		}
		
		return param.toString();
	}

	private String compactJson (String jsonStr) {
	    ObjectMapper objectMapper = new ObjectMapper();
	    JsonNode jsonNode;
	    String returnJsonStr = jsonStr;
		try {
			jsonNode = objectMapper.readValue(jsonStr, JsonNode.class);
			returnJsonStr = jsonNode.toString();
		} catch (JsonMappingException e) {
			log.error("cannot mapping string to Json");
		} catch (JsonProcessingException e) {
			log.error("cannot mapping string to Json");
		}
	    return returnJsonStr;
	}


	private String getResponsePayload(HttpServletResponse response) {
		ContentCachingResponseWrapper wrapper = WebUtils.getNativeResponse(response,
				ContentCachingResponseWrapper.class);
		if (wrapper != null) {

			byte[] buf = wrapper.getContentAsByteArray();
			if (buf.length > 0) {
				int length = Math.min(buf.length, 5120);
				try {
					return new String(buf, 0, length, wrapper.getCharacterEncoding());
				} catch (UnsupportedEncodingException ex) {
					// NOOP
				}
			}
		}
		return "[unknown]";
	}

	private String getRequestPayload(HttpServletRequest request) {
		ContentCachingRequestWrapper wrapper = WebUtils.getNativeRequest(request, ContentCachingRequestWrapper.class);
		if (wrapper != null) {

			byte[] buf = wrapper.getContentAsByteArray();
			if (buf.length > 0) {
				int length = Math.min(buf.length, 5120);
				try {
					return new String(buf, 0, length, wrapper.getCharacterEncoding());
				} catch (UnsupportedEncodingException ex) {
					// NOOP
				}
			}
		}
		return "[unknown]";
	}

	private void updateResponse(HttpServletResponse response) throws IOException {
		ContentCachingResponseWrapper responseWrapper = WebUtils.getNativeResponse(response,
				ContentCachingResponseWrapper.class);
		responseWrapper.copyBodyToResponse();
	}

}