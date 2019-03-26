package com.example.demo.dao;

import com.example.demo.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 使用jpa连接数据库 只需继承便可
 */
public interface CategoryDAO extends JpaRepository<Category, Integer> {

}
