package thanhdi.demo.demojpa.services.Implement;

import thanhdi.demo.demojpa.dao.Implement.CategoryDaoImpl;
import thanhdi.demo.demojpa.entities.Category;
import thanhdi.demo.demojpa.services.ICategoryServices;

import java.util.List;

public class CategoryServicesImpl implements ICategoryServices {
    CategoryDaoImpl categoryDaoImpl = new CategoryDaoImpl();
    @Override
    public void insert(Category category) {
        categoryDaoImpl.insert(category);
    }

    @Override
    public void update(Category category) {
        categoryDaoImpl.update(category);
    }

    @Override
    public void delete(int categoryId) {
        categoryDaoImpl.delete(categoryId);
    }

    @Override
    public Category findById(int categoryId) {
        return categoryDaoImpl.findById(categoryId);
    }

    @Override
    public List<Category> findAll() {
        return categoryDaoImpl.findAll();
    }

    @Override
    public List<Category> findByName(String categoryName) {
        return categoryDaoImpl.findByName(categoryName);
    }

    @Override
    public List<Category> findAll(int page, int pageSize) {
        return categoryDaoImpl.findAll(page, pageSize);
    }

    @Override
    public int count() {
        return categoryDaoImpl.count();
    }

    @Override
    public Category findByID(int id) {
        return categoryDaoImpl.findById(id);
    }
}
