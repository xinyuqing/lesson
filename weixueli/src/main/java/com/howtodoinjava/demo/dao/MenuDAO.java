package com.howtodoinjava.demo.dao;
import com.howtodoinjava.demo.model.MenuVO;
import org.apache.ibatis.annotations.*;

import java.util.List;
/**
 * Created by xueli.wei on 2017/8/24.
 */
public interface MenuDAO {
    @Select("select * from menu;")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "menuName", property = "menuName"),
            @Result(column = "price", property = "price"),
            @Result(column = "category", property = "category")
    })
    public List<MenuVO> getAllMenuName();

    @Insert("insert into menu (menuName, price, category) values(#{menuName}, #{price}, #{category});")
    @Result(javaType =  int.class)
    public int addFood(@Param("menuName") String menuName, @Param("price") double price, @Param("category") String category);

    @Delete("delete from menu where id = #{id}")
    @Result(javaType = int.class)
    public int removeTheLastFoodById(@Param("id") int id);



    @Update("update menu set menuName = #{menuName}, price = #{price}, category = #{category} where id = #{id}")
    @Result(javaType = int.class)
    public int updateMenuListById(@Param("menuName") String menuName, @Param("price") double price, @Param("category") String category, @Param("id") int id);


}
