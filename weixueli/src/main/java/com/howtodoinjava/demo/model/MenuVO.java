package com.howtodoinjava.demo.model;

/**
 * Created by xueli.wei on 2017/8/3.
 */
public class MenuVO {

    private int id;
    private String menuName;
    private double price;
    private String category;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }



    public String toString(){
        return "MenuVO = [ menuName = " + menuName + ", price = " + price + ", category = " + category +"]";
    }
}
