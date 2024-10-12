package thanhdi.demo.demojpa.dao.Implement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import thanhdi.demo.demojpa.configs.JPAConfig;
import thanhdi.demo.demojpa.dao.IVideoDao;
import thanhdi.demo.demojpa.entities.Category;
import thanhdi.demo.demojpa.entities.Video;

import java.util.List;

public class VideoDaoImpl implements IVideoDao {
    @Override
    public void insert(Video video) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.persist(video); // insert into table
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
    public void update(Video video) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.merge(video); // update table
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
    public void delete(int videoId) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();

            Video video = enma.find(Video.class, videoId); // find by id
            if (video != null) {
                enma.remove(video); // delete from table
            } else {
                System.out.println("Video not found");
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
    public Video findById(int videoId) {
        EntityManager enma = JPAConfig.getEntityManager();
        Video video = enma.find(Video.class, videoId);
        return video;
    }

    @Override
    public List<Video> findAll() {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Video> query = enma.createNamedQuery("Video.findAll", Video.class);
        return query.getResultList();
    }

    @Override
    public List<Video> findByTitle(String videoTitle) {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Video> query = enma.createQuery("SELECT v FROM Video v WHERE v.title LIKE :videoTitle", Video.class);
        query.setParameter("videoTitle", "%" + videoTitle + "%");
        return query.getResultList();
    }

    @Override
    public List<Video> findAll(int page, int pageSize) {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Video> query = enma.createNamedQuery( "Video.findAll", Video.class);
        query.setFirstResult(page * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    @Override
    public int count() {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Long> query = enma.createQuery("SELECT COUNT(v) FROM Video v", Long.class);
        return query.getSingleResult().intValue();
    }

}
