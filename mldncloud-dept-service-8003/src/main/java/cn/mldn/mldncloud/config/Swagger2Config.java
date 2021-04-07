package cn.mldn.mldncloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
	@Bean
	public Docket getDocket() {
	    return new Docket(DocumentationType.SWAGGER_2)
	    		.apiInfo(this.getApiInfo()).select()
	    		.apis(RequestHandlerSelectors
	    		.basePackage("cn.mldn.mldncloud.rest"))
	    		.paths(PathSelectors.any()).build();
	}
	
	public ApiInfo getApiInfo() {
	    return new ApiInfoBuilder().title("部门业务微服务")
	    		.description("更多请关注www.mldn.cn")
	    		.termsOfServiceUrl("http://www.mldn.cn")
	    		.contact(new Contact("John","http://www.mldn.cn","12345@qq.com"))
	    		.license("John Huang")
	    		.version("1.0")
	    		.build();
	}	


}
