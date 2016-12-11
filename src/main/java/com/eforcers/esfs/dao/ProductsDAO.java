package com.eforcers.esfs.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.eforcers.esfs.models.Product;

/**
 * @author carlos
 * @version 1.0
 * @created 03-Dic-2016 08:43:45 p.m.
 */
public interface ProductsDAO extends CrudRepository<Product, Integer> {
	Product findOneByName(String name);
	List<Product> findAllByOrderByAmountSoldDesc();
	List<Product> findAllByOrderByAmountSoldAsc();
}