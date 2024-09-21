package thanhdi.demojdbc.demojdbc.dao;

import java.util.List;

import thanhdi.demojdbc.demojdbc.models.UserModel;

public interface IUsersDao {
    List<UserModel> findAll();
    UserModel findById(int id);
    UserModel findByUsernames(String username);
    boolean findByUsername(String username);
    void insert(UserModel user);
    void update(UserModel user);
    void delete(int id);
    boolean checkExistEmails(String email);
    boolean checkExistPhones(String phone);
    void updatePassword(String username, String password);
    void updateAccount(String username, String fullname, String phone);
    UserModel getUserByFullName(String fullname);
    void updateFile(String username, String images);
}
