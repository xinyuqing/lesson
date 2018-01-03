package com.howtodoinjava.demo.dao;

import com.howtodoinjava.demo.model.EmployeeVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by jizhi.qian on 17/7/10.
 */
public interface EmployeeDAO {
    @Select("SELECT * FROM employees;")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "fname", property = "firstName"),
            @Result(column = "lname", property = "lastName")
    })
    public List<EmployeeVO> getAllEmployees();

    @Select("SELECT * FROM employees where id = #{id};")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "fname", property = "firstName"),
            @Result(column = "lname", property = "lastName")
    })
    public List<EmployeeVO> getEmployeeById(@Param("id") int id);

    @Insert("insert into employees (fname, lname) values (#{firstName}, #{lastName});")
    @Result(javaType = int.class)
    public int addEmployee(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Delete("delete from employees;")
    @Result(javaType = int.class)
    public int removeAllEmployees();

    @Delete("delete from employees where id = #{id};")
    @Result(javaType = int.class)
    public int removeEmployeeById(@Param("id") int id);

    @Update("update employees set fname = #{fname}, lname = #{lname} where id = #{id}")
    @Result(javaType = int.class)
    public int updateEmployeeById(@Param("fname") String firstName, @Param("lname") String lastName, @Param("id") int id);
}