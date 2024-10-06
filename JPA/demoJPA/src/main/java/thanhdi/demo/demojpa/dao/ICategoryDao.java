package thanhdi.demo.demojpa.dao;

import thanhdi.demo.demojpa.entities.Category;

import java.util.List;

public interface ICategoryDao {
    void insert(Category category);
    void update(Category category);
    void delete(int categoryId);
    Category findById(int categoryId);
    List<Category> findAll();
    List<Category> findByName(String categoryName);
    List<Category> findAll(int page, int pageSize);
    int count();
}
