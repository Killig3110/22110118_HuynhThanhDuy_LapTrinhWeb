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
    int updateAccount(String username, String images, String fullname, String phone);
    String getUserByFullName(String fullname);
    boolean checkUpdateAccount(String username, String images, String fullname, String phone);
}
