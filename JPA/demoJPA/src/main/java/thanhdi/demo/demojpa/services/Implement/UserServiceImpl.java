package thanhdi.demo.demojpa.services.Implement;

import thanhdi.demo.demojpa.dao.CheckLogin;
import thanhdi.demo.demojpa.dao.IUsersDao;
import thanhdi.demo.demojpa.dao.Implement.UsersDaoImpl;
import thanhdi.demo.demojpa.entities.User;
import thanhdi.demo.demojpa.services.IUserServices;

import java.util.List;

public class UserServiceImpl implements IUserServices{
    IUsersDao usersDao = new UsersDaoImpl();
    @Override
    public User checkLogin(String username, String password) {
        CheckLogin checkLogin = new CheckLogin();
        if (checkLogin.checkLogin(username, password)) {
            System.out.println("1");
            System.out.println(username);
            User user = usersDao.findByUsernames(username);
            System.out.println("2");
            return user;
        }
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return usersDao.findByUsernames(username);
    }

    @Override
    public void insertUser(User User) {
        usersDao.insert(User);
    }

    @Override
    public boolean registerUser(String username, String password, String email, String phone) {
        if ( checkExistUser(username) || checkExistEmail(email) || checkExistPhone(phone))
        {
            return false;
        }
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        usersDao.insert(new User(username, password, "null", "null",email, phone, 2, date.toString()));
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

    @Override
    public User getUserByFullName(String fullname) {
        return usersDao.getUserByFullName(fullname);
    }

    @Override
    public void updateAccount(String username, String fullname, String phone) {
        usersDao.updateAccount(username, fullname, phone);
    }

    @Override
    public void updateFile(String username, String images) {
        usersDao.updateFile(username, images);
    }

    public static void main(String[] args) {
        UsersDaoImpl usersDao = new UsersDaoImpl();
        User user = usersDao.findByUsernames("thanhdi");
        System.out.println(user);
    }
}
