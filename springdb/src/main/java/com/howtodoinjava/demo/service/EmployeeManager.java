package com.howtodoinjava.demo.service;

import java.util.List;
import com.howtodoinjava.demo.model.EmployeeVO;

/**
 * 员工模型实例化控制服务接口
 */
public interface EmployeeManager 
{
	public List<EmployeeVO> getAllEmployees();

	public List<EmployeeVO> getEmployeeById(int id);

	public boolean radomAddEmployee();

	public int removeAllEmployees();

	public int removeEmployeeByID(int id);

	public int updateEmployeeById(int id);

	public int updateEmployeeById(int id, String fname, String lname);
}
