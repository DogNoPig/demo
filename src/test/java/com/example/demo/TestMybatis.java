package com.example.demo;


import com.example.demo.dao.CategoryDAO;
import com.example.demo.domain.Category;
import com.example.demo.domain.Category1;
import com.example.demo.mapper.CategoryMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class TestMybatis {

    @Autowired
    CategoryMapper dao;

    @Test
    public void test() {
        List<Category> cs=  dao.findAll();
        for (Category c : cs) {
            System.out.println("c.getName():"+ c.getName());
        }

    }
}
