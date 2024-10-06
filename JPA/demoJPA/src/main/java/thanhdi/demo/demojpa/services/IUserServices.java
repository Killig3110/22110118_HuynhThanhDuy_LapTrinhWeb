package thanhdi.demo.demojpa.services;

import thanhdi.demo.demojpa.entities.User;

public interface IUserServices {
    User checkLogin(String username, String password);
    User findByUsername(String username);
    void insertUser(User User);
    boolean registerUser(String username, String password, String email, String phone);
    boolean checkExistUser(String username);
    boolean checkExistEmail(String email);
    boolean checkExistPhone(String phone);
    void updatePassword(String username, String password);
    User getUserByFullName(String fullname);
    void updateAccount(String username, String fullname, String phone);
    void updateFile(String username, String images);
}
