package cn.mldn.mldncloud.consumer.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cn.mldn.mldncloud.dto.DeptDTO;

@RestController 							// 为方便起见使用Restful风格展示
public class DeptController {
	public static final String DEPT_ADD_URL = "http://dept-8001.com:8001/dept/add";
	public static final String DEPT_GET_URL = "http://dept-8001.com:8001/dept/get";
	public static final String DEPT_LIST_URL = "http://dept-8001.com:8001/dept/list";
	@Resource
	private RestTemplate restTemplate; 		// 注入RestTemplate对象
	@Resource
	private HttpHeaders headers;

	@SuppressWarnings("unchecked")
	@GetMapping("/consumer/dept/list")
	public Object listDeptRest() {
		//return this.restTemplate.getForObject(DEPT_LIST_URL, List.class);
		List<DeptDTO> allDepts = this.restTemplate.exchange(DEPT_LIST_URL, HttpMethod.GET,
				new HttpEntity<Object>(this.headers), List.class).getBody();
		return allDepts;
	}

	@GetMapping("/consumer/dept/get")
	public Object getDeptRest(long deptno) {
		//DeptDTO dept = this.restTemplate.getForObject(DEPT_GET_URL + "/" + deptno, DeptDTO.class);
		DeptDTO dept = this.restTemplate.exchange(DEPT_GET_URL + "/" + deptno, HttpMethod.GET, 
				new HttpEntity<Object>(this.headers), DeptDTO.class).getBody();
		return dept;
	}

	@GetMapping("/consumer/dept/add")
	public Object addDeptRest(DeptDTO dept) {	// 传输DeptDTO对象
//		DeptDTO result = this.restTemplate.postForObject(DEPT_ADD_URL, dept, DeptDTO.class);
		DeptDTO result = this.restTemplate.exchange(DEPT_ADD_URL, HttpMethod.POST,
				new HttpEntity<Object>(dept, this.headers),DeptDTO.class).getBody();
		return result;
	}

}
