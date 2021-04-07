package cn.mldn.mldncloud.consumer.config;


import java.nio.charset.Charset;
import java.util.Base64;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestfulConfig {
	@Bean 
	public RestTemplate getRestTemplate() {
		return new RestTemplate() ;			// 实例化RestTemplate对象
	}
	@Bean
	public HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		String auth="mldnjava:hello";
		byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodedAuth);
		headers.set("Authorization", authHeader);
		return headers;
	}
}
