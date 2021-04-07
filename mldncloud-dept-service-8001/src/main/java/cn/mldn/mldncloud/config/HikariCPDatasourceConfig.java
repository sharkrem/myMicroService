package cn.mldn.mldncloud.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;



@Configuration
public class HikariCPDatasourceConfig {
//	@Bean
//	@Primary
//	@ConfigurationProperties("spring.hikaridatasource")
//	public DataSourceProperties dataSourceProperties() {
//	    return new DataSourceProperties();
//	}
//	@Bean(name = "hikariDataSource")
//	@ConfigurationProperties("spring.hikaridatasource")
//	public DataSource dataSource(DataSourceProperties properties) {
//	    return properties.initializeDataSourceBuilder().build();
//	}	
	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")	// 定义资源导入前导标记
	public DataSource dataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}

}
