package thanhdi.demo.demojpa.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT", nullable = false)
    private int id;

    @Column(name = "username", columnDefinition = "NVARCHAR(255)", nullable = false)
    private String username;

    @Column(name = "password", columnDefinition = "VARCHAR(255)", nullable = false)
    private String password;

    @Column(name = "email", columnDefinition = "NVARCHAR(255)", nullable = false)
    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email should not be empty")
    private String email;

    @JoinColumn(name = "roleid", referencedColumnName = "roleid")
    private int roleid;

    @Column(name = "fullname", length = 100, nullable = true)
    private String fullname;

    @Column(name = "phone", length = 10, nullable = false)
    @Pattern(regexp = "^\\d{8,10}$", message = "Phone should be valid from 8 to 10 digits")
    @NotEmpty(message = "Phone should not be empty")
    private String phone;

    @Column(name = "image", length = 1000, nullable = true)
    private String image;

    @Column(name = "createdDate", length = 10, nullable = true)
    private String createdDate;

    public User(String username, String password, String image, String fullname, String email, String phone, int roleid, String createdDate) {
        this.username = username;
        this.password = password;
        this.image = image;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.roleid = roleid;

    }
}
