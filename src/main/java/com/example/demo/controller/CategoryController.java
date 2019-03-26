package com.example.demo.controller;

import com.example.demo.dao.CategoryDAO;
import com.example.demo.domain.Category;
import com.example.demo.domain.Category1;
import com.example.demo.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryDAO categoryDAO;
    @Autowired
    CategoryMapper categoryMapper;

    @RequestMapping("/listCategory")
    public String listCategory(Model m) {
        //dao 继承 JpaRepository 后便可使用 findAll()方法
//        List<Category> cs=categoryDAO.findAll();
        List<Category1> cs = categoryMapper.findAll();

        m.addAttribute("cs", cs);

        return "categoryList1";
    }

}
