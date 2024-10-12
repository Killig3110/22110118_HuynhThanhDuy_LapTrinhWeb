package thanhdi.demo.demojpa.dao;

import thanhdi.demo.demojpa.entities.Category;
import thanhdi.demo.demojpa.entities.Video;

import java.util.List;

public interface IVideoDao {
    void insert(Video video);
    void update(Video video);
    void delete(int videoId);
    Video findById(int videoId);
    List<Video> findAll();
    List<Video> findByTitle(String videoTitle);
    List<Video> findAll(int page, int pageSize);
    int count();
}
