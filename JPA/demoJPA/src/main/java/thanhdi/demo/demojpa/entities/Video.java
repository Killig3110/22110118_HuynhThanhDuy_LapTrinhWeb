package thanhdi.demo.demojpa.entities;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "videos")
@NamedQuery(name = "Video.findAll", query = "SELECT v FROM Video v")
public class Video implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VideoId")
    private int videoid;
    @Column(name = "Description", columnDefinition = "NVARCHAR(500) NULL")
    private String description;
    @Column(name = "Poster", columnDefinition = "nvarchar(500) null")
    private String poster;
    @Column(name = "VideoUrl", columnDefinition = "nvarchar(500) null")
    private String videourl;
    @Column(name = "Title", columnDefinition = "nvarchar(500) null")
    private String title;
    @Column(name = "Views")
    private int views;
    @ManyToOne
    @JoinColumn(name="CategoryId")
    private Category category;

    public Video(String description, String poster, String videourl, String title, int views, Category category) {
        this.description = description;
        this.poster = poster;
        this.videourl = videourl;
        this.title = title;
        this.views = views;
        this.category = category;
    }
}
