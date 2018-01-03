package com.howtodoinjava.demo.controller;

import com.howtodoinjava.demo.model.MenuVO;
import com.howtodoinjava.demo.service.MenuManager;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by xueli.wei on 2017/8/3.
 */

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuManager manager;

    Logger logger = Logger.getLogger(MenuController.class);

    @RequestMapping(value = "/getAllMenu", method = RequestMethod.GET)
    public String getAllMenu(Model model){
        logger.info("Get All Menu");
        model.addAttribute("menus", manager.getAllMenuName());
        return "jsp/menuListDisplay.jsp";
    }

    @RequestMapping(value = "/addOneFood", method = RequestMethod.GET) //添加菜单
    public String addOneFood(Model model){
        logger.info("add one food");
        manager.randomAddOneFood();
        model.addAttribute("menus", manager.getAllMenuName()); //SQL注入
        return "jsp/menuListDisplay.jsp";
    }

    @RequestMapping(value = "/removeLastFood",method = RequestMethod.GET) //删除最后一个菜单
    public String removeTheLastFood(Model model){
        logger.info("remove the last food");
        List<MenuVO> menuVOs = manager.getAllMenuName();
        if(menuVOs != null){
            int size = menuVOs.size();
            if(size > 0){
                MenuVO menu = menuVOs.get(size -1);
                manager.removeTheLastFoodById(menu.getId());//SQL注入，自动删除最后一条数据
            }
        }
        model.addAttribute("menus", manager.getAllMenuName());//将服务实例返回的模型实例装载入model对象的属性中
        return "jsp/menuListDisplay.jsp";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET) //按照ID随机更新更新
    public String updateById(Model model, @PathVariable String id) {// PathVariable 传入的是浏览器中path的路径，找id用 http://localhost:8071/menu/update/12
        logger.info("udate menu id = " + id);
        manager.updateMenuById(new Integer(id).intValue());
        model.addAttribute("menus", manager.getAllMenuName());//将服务实例返回的模型实例装载入model对象的属性中
        return "jsp/menuListDisplay.jsp";
    }

}
