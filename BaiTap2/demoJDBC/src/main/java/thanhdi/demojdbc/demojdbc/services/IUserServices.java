package thanhdi.demojdbc.demojdbc.services;

import thanhdi.demojdbc.demojdbc.models.UserModel;

public interface IUserServices {
    UserModel checkLogin(String username, String password);
    UserModel findByUsername(String username);
    void insertUser(UserModel userModel);
    boolean registerUser(String username, String password, String email, String phone);
    boolean checkExistUser(String username);
    boolean checkExistEmail(String email);
    boolean checkExistPhone(String phone);
    void updatePassword(String username, String password);

}
