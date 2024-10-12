package thanhdi.demo.demojpa.services;

import thanhdi.demo.demojpa.entities.Video;

import java.util.List;

public interface IVideoServices {
    void insert(Video video);
    void update(Video video);
    void delete(int videoId);
    Video findById(int videoId);
    List<Video> findAll();
    List<Video> findByTitle(String videoTitle);
    List<Video> findAll(int page, int pageSize);
    int count();
}
