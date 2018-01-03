package com.howtodoinjava.demo.controller;

import com.howtodoinjava.demo.service.EmployeeManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //标识为controller
@RequestMapping("/employee-module") //标识Controller请求地址映射url
public class EmployeeController 
{
	@Autowired
	EmployeeManager manager;

    Logger logger = Logger.getLogger(EmployeeController.class);

    @RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET) //标识Controller中的子方法请求地址映射url 以及请求方法
	public String getAllEmployees(Model model){
        logger.info("Call getAllEmployees()!");
		model.addAttribute("employees", manager.getAllEmployees());  //将服务实例返回的模型实例装载入model对象的属性中
		return "jsp/employeesListDisplay.jsp";
	}

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String hello(Model model){
        logger.info("Call hello()!");
        return "hello.jsp";
    }
}