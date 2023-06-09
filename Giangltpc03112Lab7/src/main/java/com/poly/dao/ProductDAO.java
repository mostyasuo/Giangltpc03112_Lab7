package com.poly.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.poly.model.Product;
import com.poly.model.Report;


public interface ProductDAO extends JpaRepository<Product, Integer>{
	List<Product> findByPriceBetween(double minPrice, double maxPrice);

	Page<Product> findAllByNameLike(String keywords, Pageable pageable);

	@Query("SELECT new Report(o.category.id, sum(o.price), count(o)) " + "FROM Product o " + "GROUP BY o.category.id "
			+ "ORDER BY sum(o.price) DESC")
	List<Report> getInventoryByCategory();
}