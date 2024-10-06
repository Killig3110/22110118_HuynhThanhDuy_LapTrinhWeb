package thanhdi.demojdbc.demojdbc.services.implement;

import thanhdi.demojdbc.demojdbc.dao.ICategoryDao;
import thanhdi.demojdbc.demojdbc.dao.implement.CategoryDaoImpl;
import thanhdi.demojdbc.demojdbc.models.CategoryModel;
import thanhdi.demojdbc.demojdbc.services.ICategoryServices;

import java.util.List;

public class CategoryServicesImpl implements ICategoryServices {

    public ICategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<CategoryModel> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public CategoryModel findById(int id) {
        return categoryDao.findByID(id);
    }

    @Override
    public void insert(CategoryModel category) {
        categoryDao.insert(category);
    }

    @Override
    public void update(CategoryModel category) {
        categoryDao.update(category);
    }

    @Override
    public void delete(int id) {
        categoryDao.delete(id);
    }

    @Override
    public List<CategoryModel> findName(String keyword) {
        return categoryDao.findName(keyword);
    }

    public static void main(String[] args) {
        CategoryServicesImpl categoryServices = new CategoryServicesImpl();
        List<CategoryModel> list = categoryServices.findAll();
        for (CategoryModel categoryModel : list) {
            System.out.println(categoryModel.getCategoryname());
        }
    }
}
