package cn.mldn.mldncloud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import cn.mldn.mldncloud.dto.DeptDTO;
import cn.mldn.mldncloud.service.IDeptService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
public class DeptRest {
	@Autowired
	private IDeptService deptService ;			// 注入部门业务
	@Autowired
	private DiscoveryClient client;			// 进行Eureka的发现服务
//	@Autowired
//	private SecurityUser securityUser;			
	
	@GetMapping("/dept/discover")
	@ResponseBody
	public Object discovery() {
		return this.client;
	}
	@ApiOperation(value="增加部门信息", notes="增加部门数据需要传入DTO对象（dname,loc)")
	@ApiImplicitParams({@ApiImplicitParam(name="dept",value="部门实体",required=true,dataType="DeptDTO")})
	@PostMapping("/dept/add")
	public Object get(@RequestBody DeptDTO dept) {
		return this.deptService.add(dept)  ;	// 增加部门信息
	}
	
	@ApiOperation(value="获取一个部门信息", notes="根据编号获取部门信息")
	@ApiImplicitParams({@ApiImplicitParam(name="deptno",value="部门编号",required=true,
	    paramType="path",dataType="Long")})
	//@GetMapping(value="/dept/get/{deptno}", produces = { "application/json;charset=UTF-8" })
	@GetMapping(value="/dept/get/{deptno}")
	public Object get(@PathVariable("deptno") long deptno) {
		return this.deptService.get(deptno)  ;	// 查询部门信息
	}
	
	@ApiOperation(value="获取所有部门列表", notes="部门信息详细列表")
	@GetMapping(value="/dept/list")
	//@GetMapping(value="/dept/list", produces = { "application/json;charset=UTF-8" })
	public Object list() {
		return this.deptService.list() ;		// 部门信息列表
	}
	 
//	@GetMapping("/dept/yml")
//	public Object getSecurityName() {
//		System.out.println("################Username is:" + securityUser.getName());
//		return securityUser ;		// 部门信息列表
//	}
}
