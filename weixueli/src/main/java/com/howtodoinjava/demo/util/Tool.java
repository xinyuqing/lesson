package com.howtodoinjava.demo.util;

import java.util.Random;

/**
 * Created by jizhi.qian on 17/7/10.
 */
public class Tool {
    public static String getRandomFirstName(){
        String [] fnameArray = {"Tom","Jerry","Michael","Jack","Harry","James"};
        return fnameArray[new Random().nextInt(fnameArray.length)];
    }

    public static String getRandomLastName(){
        String [] lnameArray = {"Smith","Jones","Williams","Taylor","Brown","Davies"};
        return lnameArray[new Random().nextInt(lnameArray.length)];
    }

    public static String getMenuName(){
        String[] menuName = {"糖醋排骨","鱼香肉丝","毛血旺","蒜蓉粉丝","娃娃菜","饺子"};
        return  menuName[new Random().nextInt(menuName.length)];
    }

    public static double getPrice(){
        double[] prices = {15.0, 20.0, 30.0, 40.0, 50.0};
        return prices[new Random().nextInt(prices.length)];
    }

    public static String getCategories(){
        String[] category = {"中国菜","泰国菜","日本料理","韩国菜"};
        return  category[new Random().nextInt(category.length)];
    }
}
