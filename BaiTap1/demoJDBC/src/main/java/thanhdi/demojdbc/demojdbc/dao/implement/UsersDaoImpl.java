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
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setFullname(resultSet.getString("fullname"));
                user.setImage(resultSet.getString("images"));
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
                user.setEmail(resultSet.getString("email"));
                user.setFullname(resultSet.getString("fullname"));
                user.setImage(resultSet.getString("images"));
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
                user.setEmail(resultSet.getString("email"));
                user.setFullname(resultSet.getString("fullname"));
                user.setImage(resultSet.getString("images"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user.getUsername() != null;
    }

    @Override
    public void insert(UserModel user) {
        String sql = "INSERT INTO users(username, password, email, fullname, images) VALUES(?, ?, ?, ?, ?)";
        try {
            conn = super.getDatabaseConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getFullname());
            preparedStatement.setString(5, user.getImage());
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

    public static void main(String[] args) {
        UsersDaoImpl usersDao = new UsersDaoImpl();

        usersDao.insert(new UserModel("Van Phat", "1234", "none", "Le Van Phat", "none"));

        List<UserModel> users = usersDao.findAll();
        for (UserModel user : users) {
            System.out.println(user);
        }

//        UserModel user = usersDao.findById(1);
//        System.out.println(user);
    }
}
