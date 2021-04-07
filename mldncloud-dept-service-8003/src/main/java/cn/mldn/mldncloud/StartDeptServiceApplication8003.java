package cn.mldn.mldncloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableJpaRepositories(basePackages="cn.mldn.mldncloud.dao")
public class StartDeptServiceApplication8003 {
	//@Value("${spring.datasource.type}")
	//private static String userName;
	public static void main(String[] args) {
		//System.out.println("################Username is:" + userName);
		SpringApplication.run(StartDeptServiceApplication8003.class, args);
	}
}
