package thanhdi.demojdbc.demojdbc.services;

import thanhdi.demojdbc.demojdbc.models.CategoryModel;
import thanhdi.demojdbc.demojdbc.models.UserModel;

import java.util.List;

public interface ICategoryServices {
    List<CategoryModel> findAll();
    CategoryModel findById(int id);
    void insert(CategoryModel category);
    void update(CategoryModel category);
    void delete(int id);
    List<CategoryModel> findName(String keyword);
}
