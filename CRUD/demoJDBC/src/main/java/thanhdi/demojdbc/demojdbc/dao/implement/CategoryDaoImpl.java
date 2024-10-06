package thanhdi.demojdbc.demojdbc.dao.implement;

import thanhdi.demojdbc.demojdbc.configs.DBConnectMySQL;
import thanhdi.demojdbc.demojdbc.dao.ICategoryDao;
import thanhdi.demojdbc.demojdbc.models.CategoryModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements ICategoryDao {

    public Connection conn = null;
    public PreparedStatement preparedStatement = null;
    public ResultSet resultSet = null;

    @Override
    public List<CategoryModel> findAll() {
        String sql = "SELECT * FROM categories";
        List<CategoryModel> categories = new ArrayList<>();
        try {
            conn = DBConnectMySQL.getDatabaseConnection();
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CategoryModel category = new CategoryModel();
                category.setCategoryid(resultSet.getInt("cate_id"));
                category.setCategoryname(resultSet.getString("cate_name"));
                category.setStatus(resultSet.getInt("status"));
                category.setImages(resultSet.getString("images"));
                categories.add(category);
            }
            return categories;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public CategoryModel findByID(int id) {
        String sql = "SELECT * FROM categories WHERE cate_id = ?";
        try {
            conn = DBConnectMySQL.getDatabaseConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CategoryModel category = new CategoryModel();
                category.setCategoryid(resultSet.getInt("cate_id"));
                category.setCategoryname(resultSet.getString("cate_name"));
                category.setStatus(resultSet.getInt("status"));
                category.setImages(resultSet.getString("images"));
                return category;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void insert(CategoryModel category) {
        String sql = "INSERT INTO categories(cate_name, status, images) VALUES(?, ?, ?)";
        try {
            conn = DBConnectMySQL.getDatabaseConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, category.getCategoryname());
            preparedStatement.setInt(2, category.getStatus());
            preparedStatement.setString(3, category.getImages());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(CategoryModel category) {
        String sql = "UPDATE categories SET cate_name = ?, status = ?, images = ? WHERE cate_id = ?";
        try {
            conn = DBConnectMySQL.getDatabaseConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, category.getCategoryname());
            preparedStatement.setInt(2, category.getStatus());
            preparedStatement.setString(3, category.getImages());
            preparedStatement.setInt(4, category.getCategoryid());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM categories WHERE cate_id = ?";
        try {
            conn = DBConnectMySQL.getDatabaseConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<CategoryModel> findName(String keyword) {
        String sql = "SELECT * FROM categories WHERE cate_name LIKE ?";
        List<CategoryModel> categories = new ArrayList<>();
        try {
            conn = DBConnectMySQL.getDatabaseConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, "%" + keyword + "%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CategoryModel category = new CategoryModel();
                category.setCategoryid(resultSet.getInt("cate_id"));
                category.setCategoryname(resultSet.getString("cate_name"));
                category.setStatus(resultSet.getInt("status"));
                category.setImages(resultSet.getString("images"));
                categories.add(category);
            }
            return categories;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void softDelete(CategoryModel category) {
        String sql = "UPDATE categories SET status = ? WHERE cate_id = ?";
        try {
            conn = DBConnectMySQL.getDatabaseConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, category.getStatus() == 1 ? 0 : 1);
            preparedStatement.setInt(2, category.getCategoryid());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
