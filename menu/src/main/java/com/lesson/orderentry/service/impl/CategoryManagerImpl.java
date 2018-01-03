package com.lesson.orderentry.service.impl;

import com.lesson.orderentry.dao.CategoryDAO;
import com.lesson.orderentry.model.Category;
import com.lesson.orderentry.service.CategoryManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JiZhi.Qian on 2017/8/3.
 */
@Service
public class CategoryManagerImpl implements CategoryManager {

    Logger logger = Logger.getLogger(CategoryManagerImpl.class);

    @Autowired
    CategoryDAO categoryDAO;

    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }

    public Category getCategoryById(int cid) {
        List<Category> categories = categoryDAO.getCategoriesById(cid);
        if (categories == null || categories.size() == 0 || categories.size() > 1) {
            return null;
        }

        return categories.get(0);
    }

    public int addCategory(String cname) {
        return categoryDAO.addCategory(cname);
    }

    public int updateCategoryById(int cid, String cname) {
        return categoryDAO.updateCategoryById(cid, cname);
    }

    public int deleteCategoryById(int cid) {
        return categoryDAO.deleteCategoryById(cid);
    }
}
