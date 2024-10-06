package thanhdi.demo.demojpa.services;

import thanhdi.demo.demojpa.entities.Category;

import java.util.List;

public interface ICategoryServices {
    void insert(Category category);
    void update(Category category);
    void delete(int categoryId);
    Category findById(int categoryId);
    List<Category> findAll();
    List<Category> findByName(String categoryName);
    Category findByID(int id);
    List<Category> findAll(int page, int pageSize);
    int count();
}
