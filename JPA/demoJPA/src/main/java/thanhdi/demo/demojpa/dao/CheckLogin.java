package thanhdi.demo.demojpa.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import thanhdi.demo.demojpa.configs.JPAConfig;
import thanhdi.demo.demojpa.dao.Implement.UsersDaoImpl;
import thanhdi.demo.demojpa.entities.User;

public class CheckLogin {
    public boolean checkLogin(String username, String password) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            UsersDaoImpl usersDao = new UsersDaoImpl();
            boolean user = usersDao.findByUsername(username);
            if (user == false) {
                trans.rollback();
                throw new Exception("User not found.");
            } else if (username == null || password == null) {
                trans.rollback();
                throw new Exception("Username or password is null.");
            }
            else if (username != null && password != null) {
                TypedQuery<User> query = enma.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class);
                query.setParameter("username", username);
                query.setParameter("password", password);
                User user1 = query.getSingleResult();
                if (user1 != null) {
                    return true;
                }
            }
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        } finally {
            enma.close();
        }
        return false;
    }
}
