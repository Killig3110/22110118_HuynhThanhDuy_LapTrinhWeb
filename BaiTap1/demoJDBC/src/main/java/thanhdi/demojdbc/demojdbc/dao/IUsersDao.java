package thanhdi.demojdbc.demojdbc.dao;

import java.util.List;

import thanhdi.demojdbc.demojdbc.models.UserModel;

public interface IUsersDao {
    List<UserModel> findAll();
    UserModel findById(int id);
    boolean findByUsername(String username);
    void insert(UserModel user);
    void update(UserModel user);
    void delete(int id);
}
