package thanhdi.demo.demojpa.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
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

    @Column(name = "categoryname", columnDefinition = "NVARCHAR(255)")
    private String categoryname;

    @Column(name = "images", columnDefinition = "NVARCHAR(500)")
    private String images;

    @Column(name = "status")
    private int status;

    // Default constructor
    public Category(String categoryname, String images, int status) {
        this.categoryname = categoryname;
        this.images = images;
        this.status = status;
    }
}
