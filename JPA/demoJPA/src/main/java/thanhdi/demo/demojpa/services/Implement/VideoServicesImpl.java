package thanhdi.demo.demojpa.services.Implement;

import thanhdi.demo.demojpa.dao.IVideoDao;
import thanhdi.demo.demojpa.dao.Implement.VideoDaoImpl;
import thanhdi.demo.demojpa.entities.Video;
import thanhdi.demo.demojpa.services.IVideoServices;

import java.util.List;

public class VideoServicesImpl implements IVideoServices {
    IVideoDao videoDao = new VideoDaoImpl();
    @Override
    public void insert(Video video) {
        videoDao.insert(video);
    }

    @Override
    public void update(Video video) {
        videoDao.update(video);
    }

    @Override
    public void delete(int videoId) {
        videoDao.delete(videoId);
    }

    @Override
    public Video findById(int videoId) {
        return videoDao.findById(videoId);
    }

    @Override
    public List<Video> findAll() {
        return videoDao.findAll();
    }

    @Override
    public List<Video> findByTitle(String videoTitle) {
        return videoDao.findByTitle(videoTitle);
    }

    @Override
    public List<Video> findAll(int page, int pageSize) {
        return videoDao.findAll(page, pageSize);
    }

    @Override
    public int count() {
        return videoDao.count();
    }
}
