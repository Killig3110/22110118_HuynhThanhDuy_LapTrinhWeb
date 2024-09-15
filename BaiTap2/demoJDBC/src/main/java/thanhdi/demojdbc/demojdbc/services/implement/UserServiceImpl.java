package thanhdi.demojdbc.demojdbc.services.implement;

import thanhdi.demojdbc.demojdbc.configs.DBConnectMySQL;
import thanhdi.demojdbc.demojdbc.dao.CheckLogin;
import thanhdi.demojdbc.demojdbc.dao.implement.UsersDaoImpl;
import thanhdi.demojdbc.demojdbc.services.IUserServices;
import thanhdi.demojdbc.demojdbc.dao.IUsersDao;
import thanhdi.demojdbc.demojdbc.models.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl extends DBConnectMySQL implements IUserServices {
    public Connection conn = null;
    public PreparedStatement preparedStatement = null;
    public ResultSet resultSet = null;
    UsersDaoImpl usersDao = new UsersDaoImpl();

    @Override
    public UserModel checkLogin(String username, String password) {
        CheckLogin checkLogin = new CheckLogin();
        if (checkLogin.checkLogin(username, password)) {
            return usersDao.findByUsernames(username);
        }
        return null;
    }

    @Override
    public UserModel findByUsername(String username) {
        return usersDao.findByUsernames(username);
    }

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
    }

    @Override
    public void insertUser(UserModel userModel) {
        usersDao.insert(userModel);
    }

    @Override
    public boolean registerUser(String username, String password, String email, String phone) {
        if ( checkExistUser(username) || checkExistEmail(email) || checkExistPhone(phone))
        {
            return false;
        }
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        usersDao.insert(new UserModel(username, password, "null", "null",email, phone, 2, date.toString()));
        return true;

    }

    @Override
    public boolean checkExistUser(String username) {
        return usersDao.findByUsername(username);
    }

    @Override
    public boolean checkExistEmail(String email) {
        return usersDao.checkExistEmails(email);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return usersDao.checkExistPhones(phone);
    }

    @Override
    public void updatePassword(String username, String password) {
        usersDao.updatePassword(username, password);
    }
}
