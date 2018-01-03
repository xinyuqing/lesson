package com.howtodoinjava.demo.dao;

import java.util.List;
import com.howtodoinjava.demo.model.EmployeeVO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 数据装载接口
 */
public interface EmployeeDAO {
	@Select("SELECT * FROM employees;;")
	@Results({
			@Result(column = "id", property = "id"),
			@Result(column = "fname", property = "firstName"),
			@Result(column = "lname", property = "lastName")
	})
	public List<EmployeeVO> getAllEmployees();
}