package com.howtodoinjava.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.howtodoinjava.demo.dao.EmployeeDAO;
import com.howtodoinjava.demo.model.EmployeeVO;

/**
 * 员工模型实例化控制服务接口实现
 */
@Service //标注业务层组件 定义service层
public class EmployeeManagerImpl implements EmployeeManager{


	@Autowired
	EmployeeDAO dao; //自动装载员工模型实例化对象
	
	public List<EmployeeVO> getAllEmployees(){
		return dao.getAllEmployees();
	}
}
