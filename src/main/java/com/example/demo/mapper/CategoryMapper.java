package com.example.demo.mapper;

import java.util.List;

import com.example.demo.domain.Category;
import com.example.demo.domain.Category1;
import org.apache.ibatis.annotations.*;


@Mapper
public interface CategoryMapper {

//    @Select("select * from category_1 ")
//    List<Category1> findAll();

    //List<Category1> findA();

    @Select("select * from category_ ")
    List<Category> findAll();

    @Insert(" insert into category_ ( name ) values (#{name}) ")
    int save(Category category);

    @Delete(" delete from category_ where id= #{id} ")
    void delete(int id);

    @Select("select * from category_ where id= #{id} ")
    Category get(int id);

    @Update("update category_ set name=#{name} where id=#{id} ")
    int update(Category category);

}