package com.howtodoinjava.demo.service;

import com.howtodoinjava.demo.dao.MenuDAO;
import com.howtodoinjava.demo.model.MenuVO;
import com.howtodoinjava.demo.util.Tool;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by xueli.wei on 2017/8/3.
 */
@Service
public class MenuManagerImpl implements MenuManager {

    Logger logger = Logger.getLogger(MenuManagerImpl.class);

    @Autowired
    MenuDAO dao;
    public List<MenuVO> getAllMenuName() {
        return dao.getAllMenuName();
    }

    public int addFood(String menuName, double price, String category){
        int addFoodOne = dao.addFood(Tool.getMenuName(), Tool.getPrice(), Tool.getCategories());
        logger.info("add one food list" + addFoodOne + "lists");
        return  addFoodOne;
    }

    public boolean randomAddOneFood(){
        boolean result = false;
        int addFoodOne = dao.addFood(Tool.getMenuName(), Tool.getPrice(), Tool.getCategories());
        logger.info("add one food list" + addFoodOne + "lists");
        if(addFoodOne == 1){
            result = true;
        }
        return result;
    }

    public int removeTheLastFoodById(int id) {
        int lastFood = dao.removeTheLastFoodById(id);
        logger.info("remove the last food" + lastFood );
        return lastFood;
    }

    public int updateMenuById(int id) {
        int updateOne = dao.updateMenuListById(Tool.getMenuName(), Tool.getPrice(), Tool.getCategories(),id);
        logger.info("update the list food" + updateOne);
        return updateOne;
    }
}
