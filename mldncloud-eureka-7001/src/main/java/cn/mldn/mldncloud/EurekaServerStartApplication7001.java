package cn.mldn.mldncloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer					// 启用Eureka服务
public class EurekaServerStartApplication7001 {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerStartApplication7001.class, args);
	}
}
