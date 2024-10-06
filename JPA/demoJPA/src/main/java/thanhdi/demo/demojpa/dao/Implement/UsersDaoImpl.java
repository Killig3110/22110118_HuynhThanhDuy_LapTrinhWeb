package thanhdi.demo.demojpa.dao.Implement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import thanhdi.demo.demojpa.dao.IUsersDao;
import thanhdi.demo.demojpa.entities.Category;
import thanhdi.demo.demojpa.entities.User;
import thanhdi.demo.demojpa.configs.JPAConfig;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoImpl implements IUsersDao {
    @Override
    public List<User> findAll() {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<User> query = enma.createNamedQuery("User.findAll", User.class);
        return query.getResultList();
    }

    @Override
    public User findById(int id) {
        EntityManager enma = JPAConfig.getEntityManager();
        User user = enma.find(User.class, id);
        return user;
    }

    @Override
    public User findByUsernames(String username) {
        EntityManager enma = JPAConfig.getEntityManager();
        System.out.println("1");
        TypedQuery<User> query = enma.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
        System.out.println("2");
        query.setParameter("username", username);
        System.out.println("3");
        User user = query.getSingleResult();
        System.out.println("4");
        return user;
    }

    @Override
    public boolean findByUsername(String username) {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<User> query = enma.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
        query.setParameter("username", username);
        List<User> users = query.getResultList();
        return users.size() > 0; // true if user exists
    }

    @Override
    public void insert(User user) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.persist(user); // insert into table
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public void update(User user) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.merge(user); // update table
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public void delete(int id) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            User user = enma.find(User.class, id); // find by id
            if (user != null) {
                enma.remove(user); // delete from table
            } else {
                System.out.println("Category not found");
            }
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public boolean checkExistEmails(String email) {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<User> query = enma.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
        List<User> users = query.getResultList();
        return users.size() > 0;
    }

    @Override
    public boolean checkExistPhones(String phone) {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<User> query = enma.createQuery("SELECT u FROM User u WHERE u.phone = :phone", User.class);
        List<User> users = query.getResultList();
        return users.size() > 0;
    }

    @Override
    public void updatePassword(String username, String password) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try{
            trans.begin();
            User user = enma.find(User.class, username);
            if (user != null) {
                user.setPassword(password);
                enma.merge(user);
            } else {
                System.out.println("User not found");
            }
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public void updateAccount(String username, String fullname, String phone) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            User user = enma.find(User.class, username);
            if (user != null) {
                user.setFullname(fullname);
                user.setPhone(phone);
                enma.merge(user);
            } else {
                System.out.println("User not found");
            }
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public User getUserByFullName(String fullname) {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<User> query = enma.createQuery("SELECT u FROM User u WHERE u.fullname = :fullname", User.class);
        List<User> users = query.getResultList();
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public void updateFile(String username, String images) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {

        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

    public static void main(String[] args) {
        UsersDaoImpl usersDao = new UsersDaoImpl();
        List<User> users = usersDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
