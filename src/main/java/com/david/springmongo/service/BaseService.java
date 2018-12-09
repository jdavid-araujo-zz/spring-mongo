package com.david.springmongo.service;

public interface BaseService<T> {

	T findById(String id);
	
	T save(T entity);
	
	T update(String id, T entity);
	
	void deleteById(String id);
	
	Iterable<T> findAll();
}
