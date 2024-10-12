package thanhdi.demo.demojpa.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "categories")
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId")
    private int categoryid;

    @Column(name = "categoryname", columnDefinition = "NVARCHAR(255) NOT NULL")
    @NotEmpty(message = "Category name is required")
    private String categoryname;

    @Column(name = "images", columnDefinition = "NVARCHAR(500) null")
    private String images;

    @Column(name = "status")
    private int status;

    // Default constructor
    public Category(String categoryname, String images, int status) {
        this.categoryname = categoryname;
        this.images = images;
        this.status = status;
    }

    @OneToMany(mappedBy = "category")
    private List<Video> videos;

    public Video addVideo(Video video) {
        getVideos().add(video);
        video.setCategory(this);
        return video;
    }
    
    public Video removeVideo(Video video) {
        getVideos().remove(video);
        video.setCategory(null);
        return video;
    }
}
