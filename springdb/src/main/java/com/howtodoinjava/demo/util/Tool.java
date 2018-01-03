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
}
