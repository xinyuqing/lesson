package com.howtodoinjava.demo.service;

import com.howtodoinjava.demo.model.MenuVO;

import java.util.List;

/**
 * Created by xueli.wei on 2017/8/3.
 */
public interface MenuManager {
    public List<MenuVO> getAllMenuName();

    public int addFood(String menuName, double price, String category);

    public boolean randomAddOneFood();

    public int removeTheLastFoodById(int id);

    public int updateMenuById(int id);
}
