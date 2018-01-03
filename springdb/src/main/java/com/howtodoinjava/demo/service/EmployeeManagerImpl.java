package com.howtodoinjava.demo.service;

import java.util.List;

import com.howtodoinjava.demo.dao.EmployeeDAO;
import com.howtodoinjava.demo.util.Tool;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.howtodoinjava.demo.model.EmployeeVO;

/**
 * 员工模型实例化控制服务接口实现
 */
@Service //标注业务层组件 定义service层
public class EmployeeManagerImpl implements EmployeeManager{

	Logger logger = Logger.getLogger(EmployeeManagerImpl.class);

	@Autowired
	EmployeeDAO dao; //自动装载员工模型实例化对象
	
	public List<EmployeeVO> getAllEmployees(){
		return dao.getAllEmployees();
	}

	public List<EmployeeVO> getEmployeeById(int id){
		return dao.getEmployeeById(id);
	}

	public boolean radomAddEmployee() {
		boolean result = false;
		int addEmployeeNumber = dao.addEmployee(Tool.getRandomFirstName(),Tool.getRandomLastName());
		logger.info("Random add " + addEmployeeNumber + " users.");
		if(addEmployeeNumber == 1){
			result = true;
		}

		return  result;
	}

	public int removeAllEmployees() {
		int addEmployeeNumber = dao.removeAllEmployees();
		logger.info("Remove " + addEmployeeNumber + " users.");
		return addEmployeeNumber;
	}

	public int removeEmployeeByID(int id){
		int removeUserNumber = dao.removeEmployeeById(id);
		return removeUserNumber;
	}

	public int updateEmployeeById(int id){
		int affectNumber = dao.updateEmployeeById(Tool.getRandomFirstName(),Tool.getRandomLastName(), id);
		return affectNumber;
	}

	public int updateEmployeeById(int id, String fname, String lname){
		return dao.updateEmployeeById(fname,lname, id);
	}
}
