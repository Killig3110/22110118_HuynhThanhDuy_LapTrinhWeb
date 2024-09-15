package thanhdi.demojdbc.demojdbc.dao.implement;

import thanhdi.demojdbc.demojdbc.configs.DBConnectMySQL;
import thanhdi.demojdbc.demojdbc.dao.IUsersDao;
import thanhdi.demojdbc.demojdbc.models.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UsersDaoImpl extends DBConnectMySQL implements IUsersDao {

    public Connection conn = null;
    public PreparedStatement preparedStatement = null;
    public ResultSet resultSet = null;

    @Override
    public List<UserModel> findAll() {
        String sql = "SELECT * FROM users";
        List<UserModel> users = new ArrayList<>();
        try {
            conn = super.getDatabaseConnection();
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UserModel user = new UserModel();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setImages(resultSet.getString("images"));
                user.setFullname(resultSet.getString("fullname"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setRoleid(resultSet.getInt("roleid"));
                user.setCreateDate(resultSet.getString("createDate"));

                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public UserModel findById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        UserModel user = new UserModel();
        try {
            conn = super.getDatabaseConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setImages(resultSet.getString("images"));
                user.setFullname(resultSet.getString("fullname"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setRoleid(resultSet.getInt("roleid"));
                user.setCreateDate(resultSet.getString("createDate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            }
        return user;
    }

    @Override
    public boolean findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        UserModel user = new UserModel();
        try {
            conn = super.getDatabaseConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setImages(resultSet.getString("images"));
                user.setFullname(resultSet.getString("fullname"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setRoleid(resultSet.getInt("roleid"));
                user.setCreateDate(resultSet.getString("createDate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user.getUsername() != null;
    }

    @Override
    public UserModel findByUsernames(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        UserModel user = new UserModel();
        try {
            conn = super.getDatabaseConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setImages(resultSet.getString("images"));
                user.setFullname(resultSet.getString("fullname"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setRoleid(resultSet.getInt("roleid"));
                user.setCreateDate(resultSet.getString("createDate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public void insert(UserModel user) {
        String sql = "INSERT INTO users(username, password, images, fullname, email, phone, roleid, createDate) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = super.getDatabaseConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getImages());
            preparedStatement.setString(4, user.getFullname());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getPhone());
            preparedStatement.setInt(7, user.getRoleid());
            preparedStatement.setString(8, user.getCreateDate());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(UserModel user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public boolean checkExistEmails(String email) {
       String sql = "SELECT * FROM users WHERE email = ?";
         UserModel user = new UserModel();
            try {
                conn = super.getDatabaseConnection();
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, email);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    user.setId(resultSet.getInt("id"));
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    user.setImages(resultSet.getString("images"));
                    user.setFullname(resultSet.getString("fullname"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPhone(resultSet.getString("phone"));
                    user.setRoleid(resultSet.getInt("roleid"));
                    user.setCreateDate(resultSet.getString("createDate"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return user.getEmail() != null;
    }

    @Override
    public boolean checkExistPhones(String phone) {
        String sql = "SELECT * FROM users WHERE phone = ?";
        UserModel user = new UserModel();
        try {
            conn = super.getDatabaseConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, phone);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setImages(resultSet.getString("images"));
                user.setFullname(resultSet.getString("fullname"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setRoleid(resultSet.getInt("roleid"));
                user.setCreateDate(resultSet.getString("createDate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user.getPhone() != null;
    }

    @Override
    public void updatePassword(String username, String password) {
        String sql = "UPDATE users SET password = ? WHERE username = ?";
        try {
            conn = super.getDatabaseConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UsersDaoImpl usersDao = new UsersDaoImpl();

        usersDao.insert(new UserModel("thanhdiii", "1234", "images", "Nguyen Thanh Di", "TD@", "01234", 1, "2021-09-01"));

        List<UserModel> users = usersDao.findAll();
        for (UserModel user : users) {
            System.out.println(user);
        }

        System.out.println(usersDao.findByUsername("thanhdii"));
        System.out.println(usersDao.checkExistEmails("TD@"));
        System.out.println(usersDao.checkExistPhones("01234"));
    }
}
