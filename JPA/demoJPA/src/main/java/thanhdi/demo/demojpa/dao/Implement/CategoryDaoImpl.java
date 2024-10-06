package thanhdi.demo.demojpa.dao.Implement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import thanhdi.demo.demojpa.configs.JPAConfig;
import thanhdi.demo.demojpa.dao.ICategoryDao;
import thanhdi.demo.demojpa.entities.Category;
import java.util.List;

public class CategoryDaoImpl implements ICategoryDao {
    @Override
    public void insert(Category category) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.persist(category); // insert into table
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
    public void update(Category category) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.merge(category); // update table
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
    public void delete(int categoryId) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();

            Category category = enma.find(Category.class, categoryId); // find by id
            if (category != null) {
                enma.remove(category); // delete from table
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
    public Category findById(int categoryId) {
        EntityManager enma = JPAConfig.getEntityManager();
        Category category = enma.find(Category.class, categoryId);
        return category;
    }

    @Override
    public List<Category> findAll() {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);
        return query.getResultList();
    }

    @Override
    public List<Category> findByName(String categoryName) {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Category> query = enma.createQuery("SELECT c FROM Category c WHERE c.categoryname LIKE :categoryname", Category.class);
        query.setParameter("categoryname", "%" + categoryName + "%");
        return query.getResultList();
    }

    @Override
    public List<Category> findAll(int page, int pageSize) {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Category> query = enma.createNamedQuery( "Category.findAll", Category.class);
        query.setFirstResult(page * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    @Override
    public int count() {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Long> query = enma.createQuery("SELECT COUNT(c) FROM Category c", Long.class);
        return query.getSingleResult().intValue();
    }
}
