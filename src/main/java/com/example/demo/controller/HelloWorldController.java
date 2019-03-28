package com.example.demo.controller;


import com.example.demo.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HelloWorldController {
    @RequestMapping("/hello")
    public String hello(Model m) throws Exception {
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        if(true){
            throw new Exception("some exception");
        }
        return "index";
    }

    @RequestMapping("/hello1")
    public String hello1(Model model){
        model.addAttribute("name","xwxwxw");

        return "hello";
    }

    @RequestMapping("/test")
    public String test(Model m){
        String htmlContent = "<p style='color:red'> 红色文字</p>";
        Product currentProduct =new Product(5,"product e", 200);

        List<Product> ps = new ArrayList<>();
        ps.add(new Product(1,"product a", 50));
        ps.add(new Product(2,"product b", 100));
        ps.add(new Product(3,"product c", 150));
        ps.add(new Product(4,"product d", 200));
        ps.add(currentProduct);
        ps.add(new Product(6,"product f", 200));
        ps.add(new Product(7,"product g", 200));

        m.addAttribute("ps", ps);


        m.addAttribute("htmlContent", htmlContent);
        m.addAttribute("currentProduct", currentProduct);
        m.addAttribute("testBoolean",true);
        return "test";
    }
}
