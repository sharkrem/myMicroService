package cn.mldn.mldncloud.security;				// 此包可以为服务扫描子包

import javax.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {	// 建立安全配置
	@Resource
	public void configGlobal(AuthenticationManagerBuilder auth)
			throws Exception {								// 配置用户名与密码
//		auth.inMemoryAuthentication().withUser("mldnjava").password("hello")
//				.roles("USER").and().withUser("admin").password("123")
//				.roles("USER", "ADMIN");
		auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("edmin").password("edmin").roles("USER")
		.and().withUser("admin").password("admin").roles("ADMIN");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 表示所有的访问都必须进行认证处理后才可以正常进行
		http.httpBasic().and().authorizeRequests().anyRequest()
				.fullyAuthenticated();
		// 所有的Restful服务一定要设置为无状态，以提升操作性能
		http.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.csrf().disable(); //关闭csrf
	}
	
	
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//       //设置登录,注销，表单登录不用拦截，其他请求要拦截
//        http.authorizeRequests().antMatchers("/").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .logout().permitAll()
//                .and()
//                .formLogin();
//        //关闭默认的csrf认证
//        http.csrf().disable();
//
//    }

	
    @Override
    public void configure(WebSecurity web) throws Exception {
        //设置静态资源不要拦截
        web.ignoring().antMatchers("/js/**","/cs/**","/images/**");
    }
	
}
