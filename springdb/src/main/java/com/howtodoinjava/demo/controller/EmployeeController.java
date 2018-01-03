package com.howtodoinjava.demo.controller;

import com.howtodoinjava.demo.model.EmployeeVO;
import com.howtodoinjava.demo.service.EmployeeManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;

@Controller //标识为controller
@RequestMapping("/empl") //标识Controller请求地址映射url
public class EmployeeController 
{
	@Autowired
    EmployeeManager manager;

    Logger logger = Logger.getLogger(EmployeeController.class);

    @RequestMapping(value = "/getAll", method = RequestMethod.GET) //标识Controller中的子方法请求地址映射url 以及请求方法
	public String getAllEmployees(Model model){
        logger.info("get all employees!");
		model.addAttribute("employees", manager.getAllEmployees());  //将服务实例返回的模型实例装载入model对象的属性中
		return "jsp/employeesListDisplay.jsp";
	}

    @RequestMapping(value = "/addOne", method = RequestMethod.GET) //添加employee,姓名随机
    public String addRandomEmployees(Model model){
        logger.info("add one employee!");
        manager.radomAddEmployee();
        model.addAttribute("employees", manager.getAllEmployees());  //将服务实例返回的模型实例装载入model对象的属性中
        return "jsp/employeesListDisplay.jsp";
    }

    @RequestMapping(value = "/removeAll", method = RequestMethod.GET) //删除全部emloyees
    public String removeAllEmployees(Model model){
        logger.info("remove all employees!");
        manager.removeAllEmployees();
        model.addAttribute("employees", manager.getAllEmployees());  //将服务实例返回的模型实例装载入model对象的属性中
        return "jsp/employeesListDisplay.jsp";
    }

    @RequestMapping(value = "/removeLast", method = RequestMethod.GET) //删除最后一个employee
    public String removeLastEmployees(Model model){
        logger.info("remove last employee!");
        List<EmployeeVO> employeeVOs = manager.getAllEmployees();

        if(employeeVOs != null) {
            int size = employeeVOs.size();
            if(size > 0) {
                EmployeeVO eml = employeeVOs.get(size - 1);
                manager.removeEmployeeByID(eml.getId().intValue());
            }
        }

        model.addAttribute("employees", manager.getAllEmployees());  //将服务实例返回的模型实例装载入model对象的属性中
        return "jsp/employeesListDisplay.jsp";
    }

    @RequestMapping(value = "/removerandom", method = RequestMethod.GET) //随机删除一个employee
    public String removeOneEmployeeRandomly(Model model){
        logger.info("remove one employee randomly!");
        List<EmployeeVO> employeeVOs = manager.getAllEmployees();

        if(employeeVOs != null) {
            int size = employeeVOs.size();

            if(size > 0) {
                int index = new Random().nextInt(size);  //随机获取一个下标
                EmployeeVO eml = employeeVOs.get(index);
                manager.removeEmployeeByID(eml.getId().intValue());
            }
        }

        model.addAttribute("employees", manager.getAllEmployees());  //将服务实例返回的模型实例装载入model对象的属性中
        return "jsp/employeesListDisplay.jsp";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET) //按照ID删除
    public String delbyId(Model model, @PathVariable String id){
        logger.info("del employ id = " + id);

        manager.removeEmployeeByID(new Integer(id).intValue());

        model.addAttribute("employees", manager.getAllEmployees());  //将服务实例返回的模型实例装载入model对象的属性中
        return "jsp/employeesListDisplay.jsp";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET) //按照ID随机更新更新
    public String updateById(Model model, @PathVariable String id){
        logger.info("update employ id = " + id);

        manager.updateEmployeeById(new Integer(id).intValue());

        model.addAttribute("employees", manager.getAllEmployees());  //将服务实例返回的模型实例装载入model对象的属性中
        return "jsp/employeesListDisplay.jsp";
    }

    @RequestMapping(value = "/display/{id}", method = RequestMethod.GET) //按照ID展示
    public String displayById(Model model, @PathVariable int id){
        logger.info("display employ id = " + id);

        model.addAttribute("employees", manager.getEmployeeById(id));  //将服务实例返回的模型实例装载入model对象的属性中

        return "jsp/employeeUpdate.jsp";
    }

    @RequestMapping(value = "/saveUpdate", method = RequestMethod.POST) //按照ID更新
    public String saveUpdateById(Model model, @RequestParam("id") int id,
                                 @RequestParam("firstName") String fname,
                                 @RequestParam("lastName") String lname){
        logger.info("employ id = " + id);
        logger.info("firstName = " + fname);
        logger.info("lastName = " + lname);

        //保存更新
        manager.updateEmployeeById(id,fname,lname);

        model.addAttribute("employees", manager.getAllEmployees());  //将服务实例返回的模型实例装载入model对象的属性中

        return "jsp/employeesListDisplay.jsp";
    }
}