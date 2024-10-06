package thanhdi.demo.demojpa.dao;

import thanhdi.demo.demojpa.entities.User;

import java.util.List;

public interface IUsersDao {
    List<User> findAll();
    User findById(int id);
    User findByUsernames(String username);
    boolean findByUsername(String username);
    void insert(User user);
    void update(User user);
    void delete(int id);
    boolean checkExistEmails(String email);
    boolean checkExistPhones(String phone);
    void updatePassword(String username, String password);
    void updateAccount(String username, String fullname, String phone);
    User getUserByFullName(String fullname);
    void updateFile(String username, String images);
}
