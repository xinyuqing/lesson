package com.lesson.orderentry.service;

import com.lesson.orderentry.model.Category;

import java.util.List;

/**
 * Created by JiZhi.Qian on 2017/8/3.
 */
public interface CategoryManager {
    public List<Category> getAllCategories();

    public Category getCategoryById(int cid);

    public int addCategory(String cname);

    public int updateCategoryById(int cid, String cname);

    public int deleteCategoryById(int cid);
}

