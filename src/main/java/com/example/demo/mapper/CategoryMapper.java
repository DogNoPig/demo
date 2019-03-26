package com.example.demo.mapper;

import java.util.List;

import com.example.demo.domain.Category1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface CategoryMapper {

    @Select("select * from category_1 ")
    List<Category1> findAll();

}